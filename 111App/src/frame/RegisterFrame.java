/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import dataBase.MySQLConnection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Pablo
 */
public class RegisterFrame extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form RegisterFrame
     */
    public RegisterFrame(LogInFrame log) {
        initComponents();
        setLocationRelativeTo(null);
        this.log = log;
        this.connection = log.getConnection();
        registerButton.addActionListener(this);
        cancelButton.addActionListener(this);
        yesRadioB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                student = true;
            }

        });
        noRadioB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                student = false;
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        notificationLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        surnameLabel = new javax.swing.JLabel();
        eMailLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        confirmPasswordLabel = new javax.swing.JLabel();
        telephoneLabel = new javax.swing.JLabel();
        studentLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        surnameTextField = new javax.swing.JTextField();
        eMailTextField = new javax.swing.JTextField();
        telephoneTextField = new javax.swing.JTextField();
        registerButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        yesRadioB = new javax.swing.JRadioButton();
        noRadioB = new javax.swing.JRadioButton();
        registerPasswordField = new javax.swing.JPasswordField();
        confirmRegisterPasswordField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        notificationLabel.setText("Todos los campos son obligatorios.");

        nameLabel.setText("Nombre:");

        surnameLabel.setText("Apellido:");

        eMailLabel.setText("E-Mail:");

        passwordLabel.setText("Contraseña:");

        confirmPasswordLabel.setText("Confirmar contraseña:");

        telephoneLabel.setText("Teléfono:");

        studentLabel.setText("¿Es alumno del Plan 111Mil?");

        eMailTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eMailTextFieldActionPerformed(evt);
            }
        });

        telephoneTextField.setText("jTextField1");

        registerButton.setText("Registrar");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancelar");

        buttonGroup1.add(yesRadioB);
        yesRadioB.setText("Si");

        buttonGroup1.add(noRadioB);
        noRadioB.setText("No");

        registerPasswordField.setText("jPasswordField1");

        confirmRegisterPasswordField.setText("jPasswordField2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(notificationLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(studentLabel)
                        .addGap(24, 24, 24)
                        .addComponent(yesRadioB)
                        .addGap(18, 18, 18)
                        .addComponent(noRadioB))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(registerButton)
                        .addGap(29, 29, 29)
                        .addComponent(cancelButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(telephoneLabel)
                    .addComponent(confirmPasswordLabel)
                    .addComponent(passwordLabel)
                    .addComponent(eMailLabel)
                    .addComponent(surnameLabel)
                    .addComponent(nameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addComponent(surnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(registerPasswordField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                        .addComponent(eMailTextField, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(confirmRegisterPasswordField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                        .addComponent(telephoneTextField, javax.swing.GroupLayout.Alignment.LEADING))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(notificationLabel)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(nameLabel))
                                        .addGap(27, 27, 27)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(surnameLabel)
                                            .addComponent(surnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(28, 28, 28)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(eMailLabel)
                                            .addComponent(eMailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(50, 50, 50))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(passwordLabel)
                                        .addComponent(registerPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(49, 49, 49))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(confirmPasswordLabel)
                                .addComponent(confirmRegisterPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(45, 45, 45))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(telephoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(telephoneLabel)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentLabel)
                    .addComponent(yesRadioB)
                    .addComponent(noRadioB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerButton)
                    .addComponent(cancelButton))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void eMailTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eMailTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eMailTextFieldActionPerformed

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        this.setVisible(true);
        
    }//GEN-LAST:event_registerButtonActionPerformed

    private boolean validateRegisterData() {

        //Capturo los datos ingresados por el usuario:
        String name = nameTextField.getText();
        String surname = surnameTextField.getText();
        String email = eMailTextField.getText();
        char[] password = registerPasswordField.getPassword();
        String passwordString = null;
        for (Character c : password) {

            passwordString += c;

        }
        char[] passwordConfirm = confirmRegisterPasswordField.getPassword();
        String confirmPasswordString = null;
        for (Character c : password) {

            confirmPasswordString += c;

        }
        String telephone = telephoneTextField.getText();

        //Nos aseguramos primero que todos los campos esten con datos:
        if (!"".equals(name) && !"".equals(surname) && !"".equals(email) && !"".equals(passwordString) && !"".equals(confirmPasswordString) && !"".equals(telephone) && (student == true || student == false)) {
            //Luego nos aseguramos de que coincida lo ingresado en contraseña y confirmar contraseña:
            if (passwordString.equals(confirmPasswordString)) {
                //Luego nos aseguramos que el email y la contraseña sean inexistentes en la tabla usuario:    
                if ((!connection.checkExistingValue(email, "email", "usuario") && (!connection.checkExistingValue(passwordString, "contraseña", "usuario")))) {
                    //Armo la instruccion de este modo porque me marca error si armo toda la cadena directamente en la viariable.
                    String[] arrayInstruction = {"insert into usuario (nombre,apellido,email,contraseña,telefono,alumno_111mil) values('",
                        name, "','", surname, "','", email, "','", passwordString, "','", telephone, "','", student + ");"};
                    String instruction = null;
                    for (String t : arrayInstruction) {

                        instruction += t;

                    }

                    //(ver si lo que sigue es necesario. Lo incluí porque quizas pueda haber un error en la conexion justo al 
                    //momento de hacer el insert)
                    int rows = connection.executeInstruction(instruction);//el metodo me devuelve el numero de filas afectadas.
                    switch (rows) {

                        case 0:
                            JOptionPane.showMessageDialog(null, "No se realizó el registro.");
                        case 1:
                            JOptionPane.showMessageDialog(null, "Registro exitoso!");

                    }
                    return true;
                }

            } else {

                JOptionPane.showMessageDialog(null, "No coinciden los datos ingresados en los campos 'Contraseña' y 'Confirmar contraseña'");

            }
            return false;
        } else {

            JOptionPane.showMessageDialog(null, "Han quedado campos sin completar");
            return false;
        }
    }

    private LogInFrame log;
    private MySQLConnection connection;//aca el IDE me sugiere declarar la conexion y el log como final (pero no se...XD)
    private boolean student;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel confirmPasswordLabel;
    private javax.swing.JPasswordField confirmRegisterPasswordField;
    private javax.swing.JLabel eMailLabel;
    private javax.swing.JTextField eMailTextField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JRadioButton noRadioB;
    private javax.swing.JLabel notificationLabel;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JButton registerButton;
    private javax.swing.JPasswordField registerPasswordField;
    private javax.swing.JLabel studentLabel;
    private javax.swing.JLabel surnameLabel;
    private javax.swing.JTextField surnameTextField;
    private javax.swing.JLabel telephoneLabel;
    private javax.swing.JTextField telephoneTextField;
    private javax.swing.JRadioButton yesRadioB;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        if (b == log.getRegisterButton()) {

            this.setVisible(true);

        } else if (b == registerButton) {

            validateRegisterData();
        } else if (b == cancelButton) {

            this.dispose();

        }

    }
}