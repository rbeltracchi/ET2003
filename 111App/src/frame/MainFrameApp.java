/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import dataBase.MySQLConnection;
import entity.Module;
import entity.Practice;
import entity.Topic;
import entity.User;
import java.awt.CardLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import panel.MainPanel;
import panel.ModulePanel;
import panel.NorthPanel;
import panel.PracticePanel;
import panel.SouthPanel;
import panel.TheoryPanel;
import panel.TopicPanel;

/**
 *
 * @author Pablo
 */
public class MainFrameApp extends JFrame implements ActionListener {

    MySQLConnection connection;
    MainPanel mainPanel;
    PracticePanel practicePanel;
    SouthPanel southPanel;
    NorthPanel northPanel;
    TopicPanel topicPanel;
    ModulePanel modulePanel;
    TheoryPanel theoryPanel;
    ArrayList<Module> modules;
    LogInFrame log;
    User user;
    CardLayout card;

    public MainFrameApp() {

        setUndecorated(true);//para que el usuario solo utilice el boton de cerrar sesion.
        setLocationRelativeTo(null);
        connection = new MySQLConnection("jdbc:mysql://localhost:3306/bd111app?autoReconnect=true&useSSL=false&serverTimeZone=UTC", "root", "root");
        card = new CardLayout();
        setLayout(card);
        setLocationRelativeTo(null);
        log = new LogInFrame(this);
        log.setVisible(true);

    }

    public MySQLConnection getConnection() {

        return connection;

    }

    public User getUser() {

        return user;

    }

    public PracticePanel getPracticePanel() {
        return practicePanel;
    }

    public SouthPanel getSouthPanel() {
        return southPanel;
    }

    public TopicPanel getTopicPanel() {
        return topicPanel;
    }

    public ModulePanel getModulePanel() {
        return modulePanel;
    }

    public TheoryPanel getTheoryPanel() {

        return theoryPanel;

    }
    
    public NorthPanel getNorthPanel(){
    
        return northPanel;
        
    }
    
    public LogInFrame getLog(){
    
        return log;
        
    }

    public ArrayList<Module> getModules() {
        return modules;
    }
//////////En los metodos que siguen "cargo" todo desde la base de datos/////////////////////
    private void loadModules() {

        try {
            String query = "select * from modulo;";
            connection.executeQuery(query);
            ResultSet res = connection.getResultSet();
            while (res.next()) {
                ArrayList<Topic> topicList = loadTopics(res.getInt("pk_id_modulo"));
                modules.add(new Module(res.getInt("pk_id_modulo"), res.getString("nombre"), topicList, res.getString("descripcion"), res.getInt("orden")));

            }
        } catch (SQLException ex) {
            Logger.getLogger(MainFrameApp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private ArrayList<Topic> loadTopics(int idModule) {

        ArrayList<Topic> topicList = new ArrayList<Topic>();
        String query = "select * from tema where fk_id_modulo=" + idModule;
        connection.executeQuery(query);
        ResultSet res = connection.getResultSet();
        try {
            while (res.next()) {
                ArrayList<Practice> practiceList = loadPractices(res.getInt("pk_id_tema"));
                topicList.add(new Topic(res.getInt("pk_id_tema"), res.getString("nombre"), res.getInt("fk_id_modulo"), res.getString("descripcion"),
                        res.getInt("orden"), res.getString("teoria"), practiceList));

            }
        } catch (SQLException ex) {
            Logger.getLogger(MainFrameApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return topicList;
    }

    private ArrayList<Practice> loadPractices(int idTopic) {

        ArrayList<Practice> practiceList = new ArrayList<Practice>();
        String query = "select * from ejercicio where fk_id_tema=" + idTopic;
        connection.executeQuery(query);
        ResultSet res = connection.getResultSet();
        try {

            while (res.next()) {

                practiceList.add(new Practice(res.getInt("pk_id_ejercicio"), res.getInt("fk_id_tema"), res.getString("enunciado"),
                        (Image) res.getObject("imagen"), res.getInt("solucion"), res.getInt("puntaje"), res.getString("opcion1"),
                        res.getString("opcion2"), res.getString("opcion3"), user));

            }

        } catch (SQLException ex) {

            ex.printStackTrace();

        }
        return practiceList;
    }
//////////////////////////////////////////////////////////////////////////////////////////////
    private void setUser() {
    //asigno la instancia de usuario generada en loginframe a la referencia de esta clase.
        this.user = log.getUser();

    }

    private void start() {
    //una vez que el usuario esta logueado (instancia creada y valor booleano de loginframe
    //'loggedUser' se vuelve true) se ejecuta este metodo que arrastra otras funciones.
    //Se ubica en actionPerformed y se ejecuta una vez que se aprieta el boton de inicio de sesion
    //si es que la instancia de usuario fue creada.
        setUser();
        loadModules();
        modulePanel = new ModulePanel(this);//a travez de la instancia de esta clase seteo las referencias en las demas clases. 
        topicPanel = new TopicPanel(this);
        southPanel = new SouthPanel(this);
        mainPanel = new MainPanel(this);
        practicePanel = new PracticePanel(this);
        theoryPanel = new TheoryPanel(this);
        northPanel = new NorthPanel(this);
        add(mainPanel, "firstPanel");//forma de añadir los contenedores al cardlayout.
        add(practicePanel, "secondPanel");
        this.setVisible(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        if (b == southPanel.getPracticeButton()) {
            card.show(this, "secondPanel");
        } else if (b == practicePanel.getButtonFinalize()) {
            card.show(this, "firstPanel");
        } else if (b == log.getSingInButton()) {

            if (log.getLoggedUser()) {
                start();
            }

        } else if (b == practicePanel.getButtonExit()) {

            int answer = JOptionPane.showConfirmDialog(b, "¿Está seguro que quiere salir? Se perderán soluciones no chequeadas.",
                    "Confirmar acción 'Salir'", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (answer == JOptionPane.YES_OPTION) {
                card.show(this, "firstPanel");
            }
        }
    }
}
