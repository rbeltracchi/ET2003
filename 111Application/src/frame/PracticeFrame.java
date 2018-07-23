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
import java.util.Set;
import javax.swing.*;
import panel.*;

/**
 *
 * @author Automata
 */
public class PracticeFrame extends JFrame implements ActionListener {

    private final Topic topi;
    private final String nameModule;
    private JButton back, next, finalize;
    private JPanel cardsPanel, buttonsPanel;
    private ArrayList<Exercise> exercises = new ArrayList<Exercise>();
    private int i, cantExercises;
    private User user;
    private Manager manager = new Manager();

    public PracticeFrame(User user, Topic topi, String nameModule) {
        i = 1;
        exercises = loadExercises(topi.getExercises());
        this.user = user;
        cantExercises = exercises.size();
        this.nameModule = nameModule;
        this.topi = topi;
        this.setBounds(200, 200, 600, 450);
        this.setLayout(new BorderLayout());
        createCardsPanel();
        createButtonPanel();
        this.add(cardsPanel, BorderLayout.CENTER);
        this.add(buttonsPanel, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

    }

    private ArrayList<Exercise> loadExercises(Set exercs) {
        ArrayList<Exercise> exe = new ArrayList<Exercise>();
        if (exercs != null) {
            Iterator<Exercise> iter = exercs.iterator();
            while (iter.hasNext()) {
                exe.add(iter.next());
            }
        }
        return exe;
    }
//    Agrega a cardsPanel tantas cartas como ejercicios tiene el tema(topic)

    private void createCardsPanel() {
        cardsPanel = new JPanel();
        cardsPanel.setLayout(new CardLayout());
        if (exercises != null) {
            for (int i = 0; i < exercises.size(); i++) {
                cardsPanel.add(new ExercisePanel(exercises.get(i), nameModule, topi.getName()), "ejercicio " + i);
            }
        }
    }

    private void createButtonPanel() {
        back = new JButton("Atras");
        back.setEnabled(false);
        next = new JButton("Siguiente");
        next.setEnabled(true);
        finalize = new JButton("Finalizar");
        finalize.setEnabled(false);

        back.addActionListener(this);
        next.addActionListener(this);
        finalize.addActionListener(this);

        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 3)); //1Fila 3Columnas
        buttonsPanel.add(back);
        buttonsPanel.add(next);
        buttonsPanel.add(finalize);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object selection = e.getSource();
        CardLayout cl = (CardLayout) cardsPanel.getLayout();
        if (selection == next) {
            i++;
            if (i == cantExercises) {
                next.setEnabled(false);
                finalize.setEnabled(true);
            }
            back.setEnabled(true);
            cl.next(cardsPanel);

        } else if (selection == back) {
            i--;
            if (i == 1) {
                back.setEnabled(false);
            }
            next.setEnabled(true);
            finalize.setEnabled(false);
            cl.previous(cardsPanel);

        } else if (selection == finalize) {
            for (int x = 0; x < exercises.size(); x++) {
                Exercise ex = exercises.get(x);
                if (ex.getUserAnswer() == ex.getCorrectAnswer()) {
                    addCorrectExercise(ex);
                }
            }
            manager.update(user);
            this.dispose();
        }
    }
    
    private void addCorrectExercise(Exercise ex){
        int prog = user.getProgress() + ex.getScore();
        if(ex != null){
            if(isNotFinished(ex)){
                user.setProgress(prog);
                user.setExercise(ex);
            }
        }
    }
    
    private boolean isNotFinished(Exercise ex){
        boolean is = true;
        Iterator<Exercise> iter = user.getCompletedExercises().iterator();
        if( iter!= null ){
            while(iter.hasNext()){
                if(iter.next().equals(ex)){
                    return false;
                }
            }
        }
        return is;
    }

}
