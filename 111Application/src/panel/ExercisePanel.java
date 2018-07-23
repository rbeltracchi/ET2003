/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel;

import entity.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Automata
 */
public class ExercisePanel extends JPanel implements ActionListener {

    private Exercise ex;
    private String moduleName, temeName;
    private JLabel tituloL, imgExerciseL;
    private JPanel titlePanel, optionPanel, imagePanel;
    private JRadioButton opt1, opt2, opt3;
    private ButtonGroup grupo;
    private JTextArea enounceText, opt1T, opt2T, opt3T;
    private Color colorin = new Color(29, 193, 220);
    private Color violet = new Color(92, 59, 148);
    private Color violetLow = new Color(156, 125, 208);

    public ExercisePanel(Exercise ex, String moduleName, String temeName) {
        this.temeName = temeName;
        this.ex = ex;
        this.moduleName = moduleName;
        this.setLayout(new BorderLayout());
        createTitlePanel();
        createOptionPanel();
        createImagePanel();
        this.add(titlePanel, BorderLayout.NORTH);
        this.add(optionPanel, BorderLayout.CENTER);
        this.add(imagePanel, BorderLayout.EAST);
    }

    private void createImagePanel() {
        imagePanel = new JPanel();
        imagePanel.setBackground(colorin);
        imagePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        imagePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        ImageIcon img = new ImageIcon(getClass().getResource(ex.getImage()));
        JLabel titulo = new JLabel(img);
        imagePanel.add(titulo, BorderLayout.CENTER);
    }

//    Instancia e inicializa el titlePanel
    private void createTitlePanel() {
        Font typeDef = new Font(Font.MONOSPACED, Font.BOLD, 16);
        titlePanel = new JPanel();
        titlePanel.setBackground(violet);
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        tituloL = new JLabel("Modulo : " + moduleName + " - Tema: " + temeName);
        tituloL.setFont(typeDef);
        tituloL.setForeground(Color.WHITE);
        titlePanel.setBorder(BorderFactory.createBevelBorder(2));
        titlePanel.add(tituloL);
    }
//    Instancia e inicializa el optionPanel

    private void createOptionPanel() {
        optionPanel = new JPanel(new BorderLayout());
        optionPanel.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, violetLow));

        JPanel radioText = new JPanel();
        radioText.setBackground(violetLow);
        radioText.setLayout(new BoxLayout(radioText, BoxLayout.Y_AXIS));

//        Para que el texto responda correctamente dentro del cuadro
        JPanel optText1 = new JPanel(new BorderLayout());
        optText1.setBackground(violetLow);
        JPanel optText2 = new JPanel(new BorderLayout());
        optText2.setBackground(violetLow);
        JPanel optText3 = new JPanel(new BorderLayout());
        optText3.setBackground(violetLow);

        enounceText = new JTextArea(ex.getTask());
        enounceText.setEditable(false);
        enounceText.setLineWrap(true);
        enounceText.setWrapStyleWord(true);
        enounceText.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(violet), "Enunciado", TitledBorder.CENTER, TitledBorder.DEFAULT_JUSTIFICATION));

        opt1T = new JTextArea(ex.getOption1());
        opt1T.setEditable(false);
        opt1T.setLineWrap(true);
        opt1T.setWrapStyleWord(true);

        opt2T = new JTextArea(ex.getOption2());
        opt2T.setEditable(false);
        opt2T.setLineWrap(true);
        opt2T.setWrapStyleWord(true);

        opt3T = new JTextArea(ex.getOption3());
        opt3T.setEditable(false);
        opt3T.setLineWrap(true);
        opt3T.setWrapStyleWord(true);

        loadRadios();

        optText1.add(opt1, BorderLayout.WEST);
        optText1.add(opt1T, BorderLayout.CENTER);
        optText2.add(opt2, BorderLayout.WEST);
        optText2.add(opt2T, BorderLayout.CENTER);
        optText3.add(opt3, BorderLayout.WEST);
        optText3.add(opt3T, BorderLayout.CENTER);

        optText1.setBorder(BorderFactory.createTitledBorder("Opcion 1"));
        optText2.setBorder(BorderFactory.createTitledBorder("Opcion 2"));
        optText3.setBorder(BorderFactory.createTitledBorder("Opcion 3"));

        radioText.add(optText1);
        radioText.add(optText2);
        radioText.add(optText3);

        optionPanel.add(enounceText, BorderLayout.NORTH);
        optionPanel.add(radioText, BorderLayout.CENTER);
    }
//    Instancia e inicializa los radiobutton del optionPanel

    private void loadRadios() {
        opt1 = new JRadioButton();
        opt2 = new JRadioButton();
        opt3 = new JRadioButton();
        opt1.addActionListener(this);
        opt2.addActionListener(this);
        opt3.addActionListener(this);
        grupo = new ButtonGroup();
        grupo.add(opt1);
        grupo.add(opt2);
        grupo.add(opt3);
    }

    public void actionPerformed(ActionEvent e) {
        Object seleccion = e.getSource();
        if (seleccion == opt1) {
            ex.setUserAnswer(1);
        } else if (seleccion == opt2) {
            ex.setUserAnswer(2);
        } else if (seleccion == opt3) {
            ex.setUserAnswer(3);
        }
    }

}
