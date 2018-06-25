/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel;

import entity.Module;
import frame.MainFrameApp;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Pablo
 */
public class ModulePanel extends JPanel {

    private ArrayList<Module> modules;
    private JLabel title;
    private TopicPanel topicPanel;
    private SouthPanel southPanel;

    public ModulePanel(MainFrameApp mainFrame) {
        title.setText("MODULOS");
        title.setBackground(Color.BLUE);
        this.modules = mainFrame.getModules();
        this.southPanel = mainFrame.getSouthPanel();
        topicPanel = mainFrame.getTopicPanel();
        GridLayout grid = new GridLayout(this.modules.size() + 1, 1);
        setLayout(grid);
        add(title);
        for (Module m : this.modules) {

            JButton b = new JButton(m.getName());
            b.addActionListener(topicPanel);
            add(b);

        }

    }

}
