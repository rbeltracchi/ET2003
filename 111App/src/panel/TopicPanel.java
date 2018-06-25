/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel;

import entity.Module;
import entity.Topic;
import frame.MainFrameApp;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

/**
 *
 * @author Pablo
 */
public class TopicPanel extends JPanel implements ActionListener {

    private JComboBox<Topic> cb;
    private SouthPanel southPanel;
    private TheoryPanel theoryPanel;
    private ArrayList<Module> modules;
    private ArrayList<Topic> topics;

    public TopicPanel(MainFrameApp mainFrame) {
        this.southPanel = mainFrame.getSouthPanel();
        this.theoryPanel = mainFrame.getTheoryPanel();
        cb = new JComboBox<Topic>();
        this.modules = mainFrame.getModules();

        GridLayout grid = new GridLayout(1, 1);
        setLayout(grid);

    }

    private int getIDModule(String nombreModulo) {

        int idModule = 0;
        for (Module m : modules) {

            if (m.getName().equals(nombreModulo)) {

                idModule = m.getIdModule();
                break;

            }

        }
        return idModule;
    }
    
    public ArrayList<Topic> getArrayTopics(){
    
        return topics;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        String buttonName = b.getText();
        int idModule = getIDModule(buttonName);
        for (Module m : modules) {

            if (m.getIdModule() == idModule) {

                this.topics = m.getTopics();//obtengo el array de temas del objeto modulo correspondiente.
                for (Topic t : topics) {
                    cb.addItem(t);

                }

            }

        }
        cb.addItemListener(theoryPanel);
        cb.addItemListener(southPanel);
        this.add(cb);
    }

}
