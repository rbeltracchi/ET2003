/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel;

import dataBase.MySQLConnection;
import entity.User;
import frame.LogInFrame;
import frame.MainFrameApp;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Pablo
 */
public class NorthPanel extends JPanel implements ActionListener {

    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JLabel progressLabel;
    private JButton closeSessionButton;
    private JButton updateUserInfo;
    private LogInFrame logInFrame;
    private MySQLConnection connection;
    private User user;
    private FlowLayout flow;

    public NorthPanel(MainFrameApp mainFrame) {

        nameLabel = new JLabel();
        surnameLabel = new JLabel();
        progressLabel = new JLabel();
        logInFrame = mainFrame.getLog();
        connection = mainFrame.getConnection();
        user = mainFrame.getUser();
        closeSessionButton = new JButton("Cerrar sesión");
        closeSessionButton.addActionListener(logInFrame);
        updateUserInfo = new JButton("Actualizar información");
        updateUserInfo.addActionListener(this);
        flow = new FlowLayout(FlowLayout.TRAILING);
        setLayout(flow);
        add(closeSessionButton);
        add(updateUserInfo);
        add(progressLabel);
        add(surnameLabel);
        add(nameLabel);

    }

    public JButton getCloseSessionButton() {

        return closeSessionButton;

    }

    private void updateUserProfile(User user) {
        int idUser = user.getIdUser();
        String query = "select nombre,apellido,progreso from usuario where pk_id_usuario=" + idUser;
        connection.executeQuery(query);
        ResultSet res = connection.getResultSet();
        try {
            nameLabel.setText(res.getString("nombre"));
            surnameLabel.setText(res.getString("apellido"));
            String progressValue = "" + res.getInt("progreso");
            progressLabel.setText(progressValue);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        updateUserProfile(user);

    }
}
