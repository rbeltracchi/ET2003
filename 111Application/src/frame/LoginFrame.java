package frame;

import control.Manager;
import entity.User;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.List;
import java.util.Iterator;
import java.util.Set;
import javax.swing.*;

/**
 *
 * @author Automata
 */
public class LoginFrame extends JFrame implements ActionListener {

    private JTextField userText;
    private JPasswordField passT;
    private JPanel panelTit, panelField, panelButton;
    private JLabel userL, passL;
    private JButton ingresar, registro, about;
    private User userLog = new User();
    private Manager manager = new Manager();
    private frameprincipal aboutFrame;

    public LoginFrame() {
        super("LogIn");
        this.setBounds(500, 300, 300, 360);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        loadPanelTit();
        loadPanelField();
        loadPanelButton();
        this.add(panelTit, BorderLayout.NORTH);
        this.add(panelField, BorderLayout.CENTER);
        this.add(panelButton, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    private void loadPanelTit() {
        panelTit = new JPanel();
        panelTit.setBorder(BorderFactory.createEtchedBorder());
        panelTit.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        ImageIcon imagenTit = new ImageIcon(getClass().getResource("/images/portada.jpg"));
        JLabel titulo = new JLabel(imagenTit);
        panelTit.add(titulo);
    }

    private void loadPanelField() {
        panelField = new JPanel();
        panelField.setBackground(Color.WHITE);
        panelField.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
        userL = new JLabel("E-mail:");
        userText = new JTextField(23);
        passL = new JLabel("Contraseña:");
        passT = new JPasswordField(23);
        panelField.add(userL);
        panelField.add(userText);
        panelField.add(passL);
        panelField.add(passT);
    }

    private void loadPanelButton() {
        panelButton = new JPanel();
        panelButton.setBorder(BorderFactory.createEtchedBorder());
        panelButton.setBackground(Color.LIGHT_GRAY);
        panelButton.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));
        ingresar = new JButton("Ingresar");
        registro = new JButton("Registrarse");
        about = new JButton("?");
        ingresar.addActionListener(this);
        registro.addActionListener(this);
        about.addActionListener(this);
        panelButton.add(ingresar);
        panelButton.add(registro);
        panelButton.add(about);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object selection = e.getSource();
        if (selection == ingresar) {
            if (checkUser()) {
                UserMainFrame userFrame = new UserMainFrame(userLog);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Usuario y/o contraseña incorrecto");
            }
        } else if (selection == registro) {
            new RegisterFrame(this);
            this.dispose();
        } else if (selection == about) {
            aboutFrame = new frameprincipal(this);
            aboutFrame.setVisible(true);
            this.setVisible(false);
        }

    }

    private boolean checkUser() {
        boolean es = false;
        List<User> usersNoLog = manager.getUsers();
        for (User us : usersNoLog) {
            if (us.geteMail().equals(userText.getText())) {
                if (checkPass(us.getPassword())) {
                    es = true;
                    userLog = us;
                }
            }
        }
        return es;
    }

    private boolean checkPass(String pwBD) {
        boolean ok = false;
        char[] pass = passT.getPassword();
        String cadena = "";
        for (int i = 0; i < pass.length; i++) {
            cadena += pass[i];
        }
        if (cadena.equals(pwBD)) {
            ok = true;
        }
        return ok;
    }
}
