package frame;

import entity.User;
import java.awt.*;
import javax.swing.*;
import control.Manager;
import java.awt.event.*;

public class UpdateProfile extends JFrame implements ActionListener {

    private final Manager manager = new Manager();
    private JFrame umframe;
    private User userlog, useraux;
    private JTextField nameT, surnameT, tellT, emailT;
    private JPasswordField passT, passConfirmT;
    private JButton back, update;
    private JRadioButton isAlumnR, isNotAlumnR;
    private ButtonGroup group;
    private boolean isAlumnT, aux;
    private JLabel nameL, surnameL, emailL, passL, tellL, passConfirmL, isAlumnL;
    private JPanel panelInf, panelTitle, panelLabel, panelField;

    public UpdateProfile(User u, UserMainFrame umFrame) {

        super("Registro");
        userlog = u;
        umframe = umFrame;
        isAlumnT = false;
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

    ;
    
    private void loadPanelTitle() {
        panelTitle = new JPanel();
        panelTitle.setBackground(Color.WHITE);
        panelTitle.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));
        ImageIcon imagenTit = new ImageIcon(getClass().getResource("/images/portadaupdate.jpg"));
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
        panelLabel.add(isAlumnL);
    }

    private void loadPanelField() {
        panelField = new JPanel();
        panelField.setBackground(Color.WHITE);
        panelField.setLayout(new GridLayout(7, 1, 20, 10));
//        Instancio los campos
        nameT = new JTextField(userlog.getName());
        surnameT = new JTextField(userlog.getSurname());
        tellT = new JTextField(userlog.getTelephoneNumber());
        emailT = new JTextField(userlog.geteMail());
        passT = new JPasswordField(userlog.getPassword());
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
        panelField.add(radios);
    }

    private void loadPanelButton() {
        panelInf = new JPanel();
        panelInf.setBackground(Color.LIGHT_GRAY);
        panelInf.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));
        back = new JButton("Atras");
        update = new JButton("Actualizar");
        back.addActionListener(this);
        update.addActionListener(this);
        panelInf.add(back);
        panelInf.add(update);
    }

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
            umframe = new UserMainFrame(userlog);
            this.dispose();

        }
        if (selection == update) {

            useraux = manager.getUser(userlog.getId(), false);
            useraux.setId(userlog.getId());
            useraux.setName(nameT.getText());
            useraux.setSurname(surnameT.getText());
            useraux.setPassword(this.getPass(passT.getPassword()));
            useraux.setTelephoneNumber(tellT.getText());
            useraux.seteMail(emailT.getText());
            useraux.setIs111Student(isAlumnT);
            useraux.setProgress(userlog.getProgress());
            aux = manager.update(useraux);
            userlog = useraux;
            if (aux) {
                JOptionPane.showMessageDialog(null, "Datos de perfil actualizados");
                umframe = new UserMainFrame(userlog);
                this.dispose();
            }

        }

    }

}
