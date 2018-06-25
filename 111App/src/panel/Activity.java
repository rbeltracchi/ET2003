/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel;

import entity.Practice;
import entity.User;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Pablo
 */
public class Activity extends JPanel implements ActionListener {

    JPanel leftPanel;
    JPanel radioBPanel;
    JPanel rightPanel; //donde ubico la imagen del objeto practice si es que la tiene (Ver como hacer esta parte).
    JButton checkButton;
    JRadioButton option1;
    JRadioButton option2;
    JRadioButton option3;
    JLabel task;
    Practice practice; //para ir seteando.
    User user;
    SouthPanel southPanel;
    private static int panelNumber=0;//esto lo necesito para ir agregando los paneles de este tipo
    //(que se encontrarian en un arraylist) al gestor del correspondiente container. Se agregan mediante
    //la instancia y un string para identificar cual panel se va a mostrar. Este atributo se concatenaria al string.

    public Activity(Practice practice, User user, SouthPanel southPanel) {

        GridLayout grid=new GridLayout(1,2);
        setLayout(grid);
        panelNumber++;
        this.practice = practice;
        this.user = user;
        this.southPanel = southPanel;
        checkButton.setText("CORREGIR");
        checkButton.addActionListener(this);
        leftPanel = new JPanel(new GridLayout(3, 1));
        rightPanel = new JPanel(new GridLayout(1, 1));
        radioBPanel = new JPanel(new GridLayout(3, 1));//estaria ubicado en lo que seria la segunda fila del leftPanel
        task.setText(this.practice.getTask());
        option1.setText(this.practice.getOption1());
        option2.setText(this.practice.getOption2());
        option3.setText(this.practice.getOption3());
        //listeners para los radiobotones:
        option1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getPractice().setUserAnswer(1);
            }
        });
        option2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getPractice().setUserAnswer(2);
            }
        });
        option3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getPractice().setUserAnswer(3);
            }
        });

        //configurar rightpanel para que setee la imagen de la actividad.
        //luego irian los add para los dos paneles left y right.
        loadLeftPanel();
        loadRightPanel();//falta el cuerpo de este metodo.
        add(leftPanel);
        add(rightPanel);
    }

    public int getPanelNumber(){
    
        return panelNumber;
        
    }
    
    private void loadLeftPanel() {

        task.setText(practice.getTask());
        leftPanel.add(task);
        option1.setText(practice.getOption1());
        option2.setText(practice.getOption2());
        option3.setText(practice.getOption3());
        ButtonGroup group = new ButtonGroup();
        group.add(option1);
        group.add(option2);
        group.add(option3);
        radioBPanel.add(option1);
        radioBPanel.add(option2);
        radioBPanel.add(option3);
        leftPanel.add(radioBPanel);
        leftPanel.add(checkButton);

    }
    
    private void loadRightPanel(){}//falta el cuerpo de este metodo.

    private boolean checkResult() {

        int correctAnswer = getPractice().getCorrectAnswer();//obtengo la respuesta correcta del objeto practice.
        int userAnswer = getPractice().getUserAnswer();//obtengo la respuesta elegida por el usuario.
        if (correctAnswer == userAnswer) {

            return true;

        }

        return false;

    }

    public void checkPracticeDone() {

        if (checkResult()) {

            //if:aca preguntaria si no hay registro en la tabla ejercicios realizados.
            //si no lo hay:
            updatePractice();
            JOptionPane.showMessageDialog(null, "Respuesta correcta! Su progreso ha sido actualizado!");
            //else:
            //JOptionPane.showMessageDialog(null, "La respuesta es correcta!");

        } else {
            JOptionPane.showMessageDialog(null, "Respuesta incorrecta");
        }
    }

    private void updatePractice() {

        try {
            this.user.updateProgress(practice.getScore(), practice.getIdPractice());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public Practice getPractice() {

        return practice;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        if (b == checkButton) {
            checkPracticeDone();
        }

    }
}
