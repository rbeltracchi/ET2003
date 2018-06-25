/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel;

import entity.Practice;
import entity.User;
import frame.MainFrameApp;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Pablo
 */
public class PracticePanel extends JPanel implements ActionListener {

    private ArrayList<Activity> activities;
    private ArrayList<Practice> practices;
    private SouthPanel southPanel;
    private User user;
    private JButton buttonNext;//se deshabilita cuando se llega al final del arraylist<Activity>
    private JButton buttonBack;//este se habilita una vez pasado el primer panel Activity.
    private JButton buttonFinalize;//este tendria que estar deshabilitado hasta que no haya mas elementos en el arraylist.
    private JButton buttonExit;
    private CardLayout cd;//para el panel activity container.
    private GridLayout grid;//para este panel.
    private FlowLayout flow;//para el panel controlBuutons.
    private JPanel activityContainer;// a este marterle el card layout.
    private JPanel controlButtons; //contiene los botones next, back, finalize,exit
    private boolean onPractice;//cambia a true cuando este panel se muestra al pulsar en practicar.
    private MainFrameApp mainFrame;

    public PracticePanel(MainFrameApp mainFrame) {
        this.southPanel = mainFrame.getSouthPanel();
        this.practices = southPanel.getPracticeList();
        this.user = mainFrame.getUser();
        this.mainFrame = mainFrame;
        onPractice = false;
        buttonNext=new JButton("Siguiente");
        buttonBack=new JButton("Atras");
        buttonFinalize=new JButton("Finalizar");
        buttonExit=new JButton("Salir");
        buttonNext.addActionListener(this);
        buttonBack.addActionListener(this);
        buttonFinalize.addActionListener(this);//aca se deshabilita o se habilita.
        buttonFinalize.addActionListener(this.mainFrame);//aca se vuelve al panel principal.
        buttonExit.addActionListener(this.mainFrame);
        cd = new CardLayout();
        grid = new GridLayout(2, 1);
        flow = new FlowLayout(FlowLayout.TRAILING);
        setLayout(grid);
        activityContainer = new JPanel();
        activityContainer.setLayout(cd);
        controlButtons = new JPanel();
        controlButtons.setLayout(flow);
        controlButtons.add(buttonFinalize);
        controlButtons.add(buttonNext);
        controlButtons.add(buttonBack);
        controlButtons.add(buttonExit);
    }

    public JButton getButtonFinalize() {

        return buttonFinalize;

    }
    
    public JButton getButtonExit(){
    
        return buttonExit;
        
    }

    private int loadActivityPanels() {
        int numberOfPanels = 0;
        for (Practice p : practices) {

            activities.add(new Activity(p, user, southPanel));

        }
        for (Activity a : activities) {

            add(a, "actividad numero" + a.getPanelNumber());
            numberOfPanels++;

        }
        return numberOfPanels;
    }

    private void showPanel(int panelNumber) {

        cd.show(activityContainer, "actividad numero" + panelNumber);

    }

    @Override
    public void actionPerformed(ActionEvent e) {//revisar aca que este todo bien:
        JButton b = (JButton) e.getSource();
        if (b == southPanel.getPracticeButton()) {
            int numberOfPanels = loadActivityPanels();
            int panelCount=0;
            buttonFinalize.setEnabled(false);
            if (!onPractice) {
                buttonBack.setEnabled(false);
                showPanel(1);
                panelCount=1;
                onPractice = true;
            } else {
                buttonBack.setEnabled(true);
                if (numberOfPanels == panelCount) {

                    onPractice=false;
                    buttonBack.setEnabled(false);
                    buttonNext.setEnabled(false);
                    buttonFinalize.setEnabled(true);

                } else {
                    if (b == buttonNext) {

                        panelCount++;
                        showPanel(panelCount);
                        

                    } else if ((b == buttonBack) && (panelCount>1)) {
                        panelCount--;
                        showPanel(panelCount);
                    }

                }
            }

        }
    }

}
