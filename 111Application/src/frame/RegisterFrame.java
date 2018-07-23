package frame;

import entity.User;
import java.awt.*;
import javax.swing.*;
import control.Manager;
import java.awt.event.*;

/**
 *
 * @author Automata
 */
public class RegisterFrame extends JFrame implements ActionListener {

    private final Manager manager = new Manager();
    private final JFrame logFrame;
    private final User userReg = new User();
    private JTextField nameT, surnameT, tellT, emailT;
    private JPasswordField passT, passConfirmT;
    private JButton back, register;
    private JRadioButton isAlumnR, isNotAlumnR;
    private ButtonGroup group;
    private boolean isAlumnT;
    private JLabel nameL, surnameL, emailL, passL, tellL, passConfirmL, isAlumnL;
    private JPanel panelInf, panelTitle, panelLabel, panelField;

    public RegisterFrame(JFrame logFrame) {
        super("Registro");
        isAlumnT = false;
        this.logFrame = logFrame;
        this.setBounds(500, 200, 350, 540);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        loadPanelButton();
        loadPanelTitle();
        loadPanelLabel();
        loadPanelField();
        this.add(panelTitle, BorderLayout.NORTH);
        this.add(panelLabel, BorderLayout.WEST);
        this.add(panelField, BorderLayout.CENTER);
        this.add(panelInf, BorderLayout.SOUTH);
        JPanel espacio = new JPanel();
        espacio.setBackground(Color.WHITE);
        this.add(espacio, BorderLayout.EAST);
        this.setVisible(true);
    }

    private void loadPanelTitle() {
        panelTitle = new JPanel();
        panelTitle.setBackground(Color.WHITE);
        panelTitle.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));
        ImageIcon imagenTit = new ImageIcon(getClass().getResource("/images/portadaReg2.jpg"));
        JLabel titulo = new JLabel(imagenTit);
        panelTitle.add(titulo);
    }

    private void loadPanelLabel() {
        panelLabel = new JPanel();
        panelLabel.setBackground(Color.WHITE);
        panelLabel.setLayout(new GridLayout(7, 1));
        nameL = new JLabel("   Nombre:");
        surnameL = new JLabel("   Apellido:");
        tellL = new JLabel("   Telefono:");
        emailL = new JLabel("   E-Mail:");
        passL = new JLabel("   Contraseña:");
        passConfirmL = new JLabel("   Confirmar contraseña:   ");
        isAlumnL = new JLabel("   ¿Alumno de 111-MIL?");
        panelLabel.add(nameL);
        panelLabel.add(surnameL);
        panelLabel.add(tellL);
        panelLabel.add(emailL);
        panelLabel.add(passL);
        panelLabel.add(passConfirmL);
        panelLabel.add(isAlumnL);
    }

    private void loadPanelField() {
        panelField = new JPanel();
        panelField.setBackground(Color.WHITE);
        panelField.setLayout(new GridLayout(7, 1, 20, 10));
//        Instancio los campos
        nameT = new JTextField("");
        surnameT = new JTextField("");
        tellT = new JTextField("");
        emailT = new JTextField("");
        passT = new JPasswordField("");
        passConfirmT = new JPasswordField("");
//        Instancio los RadioButton y les pongo un listener para setear el isAlumnT
        isAlumnR = new JRadioButton("Si", false);
        isNotAlumnR = new JRadioButton("No", true);
        isAlumnR.addActionListener((ActionEvent e) -> {
            isAlumnT = true;
        });
        isNotAlumnR.addActionListener((ActionEvent e) -> {
            isAlumnT = false;
        });
//        Agrupo(para que compartan el tilde) y encierro(panel) los botones para que queden en 1 casilla del grid
        JPanel radios = new JPanel();
        radios.setBackground(Color.WHITE);
        isAlumnR.setBackground(Color.WHITE);
        isNotAlumnR.setBackground(Color.WHITE);
        radios.add(isAlumnR);
        radios.add(isNotAlumnR);
        group = new ButtonGroup();
        group.add(isAlumnR);
        group.add(isNotAlumnR);
//        Agrego los campos al frame 
        panelField.add(nameT);
        panelField.add(surnameT);
        panelField.add(tellT);
        panelField.add(emailT);
        panelField.add(passT);
        panelField.add(passConfirmT);
        panelField.add(radios);
    }

    private void loadPanelButton() {
        panelInf = new JPanel();
        panelInf.setBackground(Color.LIGHT_GRAY);
        panelInf.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));
        back = new JButton("Atras");
        register = new JButton("Registrarse");
        back.addActionListener(this);
        register.addActionListener(this);
        panelInf.add(back);
        panelInf.add(register);
    }

    //------------------------------//modificado
    
    
    private boolean loadValidUserReg() {
        boolean validUser = false;

        userReg.setName(nameT.getText());
        userReg.setSurname(surnameT.getText());
        userReg.seteMail(emailT.getText());
        userReg.setTelephoneNumber(tellT.getText());

        if ((passT.getPassword().length != 0) & (passConfirmT.getPassword().length != 0)) {
            if (checkPass()) {
                userReg.setPassword(getPass(passT.getPassword()));

                userReg.setProgress(0);
                userReg.setIs111Student(isAlumnT);
                return true;
            } else {
                System.out.println(passT.getPassword());
                System.out.println(passConfirmT.getPassword());
                JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden!");
                return false;
            }

        }
        return true;
    }

    /*      
        try {
            
            if (nameT.getText().length() != 0) {
                userReg.setName(nameT.getText());
            } else {
                JOptionPane.showMessageDialog(this, "Debes ingresar un nombre");
                return false;
            }
            if (surnameT.getText().length() != 0) {
                userReg.setSurname(surnameT.getText());
            } else {
                JOptionPane.showMessageDialog(this, "Debes ingresar un Apellido");
                return false;
            }
            if (emailT.getText().length() != 0) {
                userReg.seteMail(emailT.getText());
            } else {
                JOptionPane.showMessageDialog(this, "Debes ingresar un Email");
                return false;
            }
            if ((passT.getPassword().length != 0) & (passConfirmT.getPassword().length != 0)) {
                if (checkPass()) {
                    userReg.setPassword(getPass(passT.getPassword()));
                } else {
                    System.out.println(passT.getPassword());
                    System.out.println(passConfirmT.getPassword());
                    JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden!");
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(this, "Debes ingresar una Contraseña");
                return false;
            }
            if (tellT.getText().length() != 0) {
                userReg.setTelephoneNumber(tellT.getText());

            } else {
                JOptionPane.showMessageDialog(this, "Debes ingresar un Telefono");
                return false;
            }
            userReg.setProgress(0);
            userReg.setIs111Student(isAlumnT);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Datos Incorrectos - Revisa los campos");
            return false;
        }
    }
     */

    private String getPass(char[] pass) {
        String pw = "";
        for (int i = 0; i < pass.length; i++) {
            pw = pw + pass[i];
        }
        return pw;
    }

    private boolean checkPass() {
        boolean ok = false;
        char[] pass = passT.getPassword();
        char[] passConfirm = passConfirmT.getPassword();
        if (pass.length == passConfirm.length) {
            ok = true;
            for (int i = 0; i < pass.length; i++) {
                if (pass[i] != passConfirm[i]) {
                    ok = false;
                }
            }
        }
        return ok;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object selection = e.getSource();
        if (selection == back) {
            new LoginFrame();
            this.dispose();
            
        } else if (selection == register) {
            if (loadValidUserReg() && manager.insert(userReg)) {   //le agrege un return al insert, asi cuando sea true se ejecuta el registro final
                manager.insert(userReg);
                JOptionPane.showMessageDialog(this, "Felicitaciones!! Te has registrado correctamente. \n               Inicia secion para continuar!");
                this.dispose();
                logFrame.setVisible(true);
            }
        }
    }

}
