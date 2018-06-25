/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel;

import dataBase.MySQLConnection;
import entity.Module;
import frame.MainFrameApp;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Pablo
 */
public class MainPanel extends JPanel {

    //este va a ser uno de los dos paneles del frame principal.
    //este va a tener borderlayout.
    ModulePanel modulePanel;
    TopicPanel topicPanel;
    TheoryPanel theoryPanel;
    SouthPanel southPanel;
    NorthPanel northPanel;
    MySQLConnection connection;
    ArrayList<Module> modules;
    PracticePanel practicePanel;
    MainFrameApp mainFrame;

    public MainPanel(MainFrameApp mainFrame) {
        BorderLayout border = new BorderLayout();
        setLayout(border);
        this.modules = mainFrame.getModules();
        this.practicePanel = mainFrame.getPracticePanel();
        this.mainFrame = mainFrame;
        this.modulePanel = mainFrame.getModulePanel();
        this.topicPanel = mainFrame.getTopicPanel();
        this.theoryPanel = mainFrame.getTheoryPanel();
        this.southPanel = mainFrame.getSouthPanel();
        northPanel = new NorthPanel(mainFrame);

        this.connection = mainFrame.getConnection();
        add(this.modulePanel, BorderLayout.WEST);
        add(this.topicPanel, BorderLayout.CENTER);
        add(this.theoryPanel, BorderLayout.EAST);
        add(this.northPanel, BorderLayout.NORTH);
        add(this.southPanel, BorderLayout.SOUTH);
    }

}
