/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel;

import entity.Topic;
import frame.MainFrameApp;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Pablo
 */
public class TheoryPanel extends JPanel implements ItemListener {

    private JTextArea textArea; 
    private TopicPanel topicPanel;

    public TheoryPanel(MainFrameApp mainFrame) {

        this.topicPanel=mainFrame.getTopicPanel();
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setEditable(false);//revisar esto por las dudas. La idea que es no se puede modificar el texto.
        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        GridLayout grid = new GridLayout(1, 1);
        setLayout(grid);
        add(scroll);

    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        Topic topicSelected=(Topic) e.getItem();
        textArea.setText("");
        textArea.setText(topicSelected.getTheory());
        
    }

}
