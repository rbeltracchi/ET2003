/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import control.Manager;
import entity.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.swing.*;

/**
 *
 * @author Automata
 */
public class UserMainFrame extends JFrame implements ActionListener {

    private User userLog;
    private Module actualModule;
    private Topic actualTopic;
    private JPanel namePanel, optionPanel, topicPanel;
    private JButton update, updateUser, logOut, practiceButton;
    private JLabel userL, progressL;
    private JComboBox selectModule, selectTopic;
    private JTextArea areaTopic, areaDesc;
    private OptionPanelListen optListen;
    private JScrollPane scroll, scroll2;
    private UpdateProfile upf;
    private Color colorin = new Color(29, 193, 220);
    private Color violet = new Color(92, 59, 148);
    private Color violetLow = new Color(156, 125, 208);

    private List<Module> modLis;
    private ArrayList<Module> modules = null;
    private ArrayList<Topic> topics = null;
    private Manager manager = new Manager();
    // private List<Module> modules = manager.getModules();

    public UserMainFrame(User userLog) {
        super("111-Mil");
        modules = new ArrayList<Module>();
        topics = new ArrayList<Topic>();
        optListen = new OptionPanelListen();
        loadModules();
        this.userLog = userLog;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setBounds(200, 150, 680, 600);
        this.setBounds(200, 150, 950, 600);

//        this.setResizable(false);
        this.setLayout(new BorderLayout());
        loadNamePanel();
        loadOptionPanel();
        loadTopicPanel();
        this.add(namePanel, BorderLayout.NORTH);
        this.add(optionPanel, BorderLayout.WEST);
        this.add(topicPanel, BorderLayout.CENTER);
        this.setVisible(true);
    }

    private void loadNamePanel() {
        Font typebold = new Font(Font.MONOSPACED, Font.BOLD, 16);
        JPanel right, lefth;
        namePanel = new JPanel(new BorderLayout());
        right = new JPanel(new GridLayout(1, 2, 5, 0));
        right.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
//        lefth = new JPanel(new GridLayout(1, 2, 0, 0));
        lefth = new JPanel();
        lefth.setLayout(new BoxLayout(lefth,BoxLayout.X_AXIS));
        right.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 20));
        namePanel.setBackground(colorin);
        namePanel.setBorder(BorderFactory.createEtchedBorder());
        right.setBackground(colorin);
        lefth.setBackground(colorin);
        userL = new JLabel("Usuario: " + userLog.getName() + " " + userLog.getSurname()+"  ");
        userL.setFont(typebold);
        userL.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 0));
        progressL = new JLabel("Progreso: %" + userLog.getProgress()+"  ");
        progressL.setFont(typebold);
        updateUser = new JButton("Actualizar Datos");
        update = new JButton("Actualizar Progreso");
        logOut = new JButton("Cerrar Secion");
        update.addActionListener(this);
        updateUser.addActionListener(this);
        logOut.addActionListener(this);
        //AGREGAR LOS ACTIONLISTENER PARA ESTOS BOTONES
        lefth.add(userL);
        lefth.add(progressL);
        right.add(updateUser);
        right.add(update);
        right.add(logOut);
        namePanel.add(lefth, BorderLayout.WEST);
        namePanel.add(right, BorderLayout.CENTER);

    }

    private void loadOptionPanel() {
        optionPanel = new JPanel(new BorderLayout());
        optionPanel.setBackground(violetLow);
        optionPanel.setBorder(BorderFactory.createEtchedBorder());
        JPanel selectOpt = new JPanel();
        selectOpt.setBackground(violetLow);
        JPanel practImage = new JPanel(new BorderLayout());
        practImage.setBackground(colorin);
        ImageIcon imagenRe = new ImageIcon(getClass().getResource("/images/-r.jpg"));
        JLabel labelImagenR = new JLabel(imagenRe);

        JPanel descPanel = new JPanel(new GridLayout());
        descPanel.setBackground(violetLow);
        areaDesc = new JTextArea();
        areaDesc.setLineWrap(true);
        areaDesc.setWrapStyleWord(true);
        areaDesc.setEditable(false);
        scroll2 = new JScrollPane(areaDesc);
        scroll2.setMaximumSize(new Dimension(60, 1000));
        descPanel.setBorder(BorderFactory.createTitledBorder("Descripcion Tema: "));
        descPanel.add(scroll2);

        selectOpt.setLayout(new BoxLayout(selectOpt, BoxLayout.Y_AXIS));
        selectOpt.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        practiceButton = new JButton("Practicar");
        selectModule = new JComboBox();
        selectModule.setBackground(violetLow);
        selectModule.setBorder(BorderFactory.createTitledBorder("Modulo"));
        selectModule.addItem("");
        selectTopic = new JComboBox();
        selectTopic.setBackground(violetLow);
        selectTopic.setBorder(BorderFactory.createTitledBorder("Tema"));
        selectTopic.addItem("");
        for (Module m : modules) {
            selectModule.addItem(m);
        }
        selectModule.addActionListener(optListen);
        selectTopic.addActionListener(optListen);
        practiceButton.addActionListener(optListen);
        practImage.add(labelImagenR, BorderLayout.CENTER);
        practImage.add(practiceButton, BorderLayout.SOUTH);
        selectOpt.add(selectModule);
        selectOpt.add(selectTopic);
        optionPanel.add(selectOpt, BorderLayout.NORTH);
        optionPanel.add(descPanel, BorderLayout.CENTER);
        optionPanel.add(practImage, BorderLayout.SOUTH);
    }

    private void loadTopicPanel() {
        topicPanel = new JPanel();
//        Font textType = new Font(Font.ITALIC,Font.null,16);
        Font typeDef = new Font(Font.SANS_SERIF, Font.PLAIN, 16);
        topicPanel.setLayout(new GridLayout());
        topicPanel.setBorder(BorderFactory.createLoweredBevelBorder());
        areaTopic = new JTextArea();
        areaTopic.setFont(typeDef);
        areaTopic.setLineWrap(true);
        areaTopic.setWrapStyleWord(true);
        areaTopic.setEditable(false);
        scroll = new JScrollPane(areaTopic);
        scroll.setMaximumSize(new Dimension(60, 1000));
        topicPanel.add(scroll);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object selection = e.getSource();
        if (selection == logOut) {
            new LoginFrame();
            this.dispose();
        } else if (selection == update) {
            updateUserProgress(userLog);
            progressL.setText("Progreso: % " + userLog.getProgress());
        } else if (selection == updateUser) {
            upf = new UpdateProfile(userLog, this);
            this.dispose();
        }
    }

    private class OptionPanelListen implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object selection = e.getSource();
            Object item;

            if (selection == selectModule) {
                item = selectModule.getSelectedItem();
                areaDesc.setText("");
                if ((item != "") & (item != null)) {
                    actualModule = (Module) item;
                    topics = loadTopics(actualModule.getTopics());
                    updateBoxTopics();
                } else {
                    selectTopic.removeAllItems();
                }

            } else if (selection == selectTopic) {
                item = selectTopic.getSelectedItem();
                if ((item != "") & (item != null)) {
                    actualTopic = (Topic) item;
                    areaTopic.setText(actualTopic.getTheory());
                    areaDesc.setText(actualTopic.getDescription());
                } else {
                    areaTopic.setText("");
                }
            } else if (selection == practiceButton) {
                if ((actualTopic != null) && (!actualTopic.getExercises().isEmpty())) {
                    PracticeFrame ej = new PracticeFrame(userLog, actualTopic, actualModule.getName());
                }else{
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "No hay ejercicios para este tema.", "Practica", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }

    }

    private void updateBoxTopics() {
        selectTopic.removeAllItems();
        selectTopic.addItem("");
        for (Topic t : topics) {
            selectTopic.addItem(t);
        }
    }

    private void loadModules() {
        modLis = manager.getModules(true);
        Iterator<Module> iter = modLis.iterator();
        while (iter.hasNext()) {
            modules.add(iter.next());
        }
    }

    private ArrayList<Topic> loadTopics(Set topicSet) {
        ArrayList<Topic> top = new ArrayList<Topic>();
        if (topicSet != null) {
            Iterator<Topic> iter = topicSet.iterator();
            while (iter.hasNext()) {
                top.add(iter.next());
            }
        }
        return top;
    }

    private void updateUserProgress(User userLog) {
        manager.update(userLog);

    }

}
