package frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Mariano
 */
public class frameprincipal extends JFrame implements ActionListener {

    private JButton blink, bintegrantes, bfotos, bpf, volver;
    private JPanel panelsup, panelinf;
    private JLabel left, right;
    private LoginFrame f;

    public frameprincipal(LoginFrame f) {
        super("");
        this.setBounds(500, 200, 465, 650);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.f = f;
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        panelsup();
        panelinf();
        this.add(panelinf, BorderLayout.SOUTH);
        this.add(panelsup, BorderLayout.NORTH);

    }

    private void panelsup() {
        panelsup = new JPanel();
        panelsup.setLayout(new BorderLayout());
        ImageIcon logo = new ImageIcon(getClass().getResource("/images/logo.jpg"));
        JLabel left = new JLabel(logo);
        JPanel middle = new JPanel();
        middle.setBackground(Color.LIGHT_GRAY);
        panelsup.add(middle, BorderLayout.CENTER);
        ImageIcon titulo = new ImageIcon(getClass().getResource("/images/titulo.jpg"));
        panelsup.add(left, BorderLayout.CENTER);
        JLabel right = new JLabel(titulo);
        panelsup.add(right, BorderLayout.SOUTH);
        volver = new JButton("Volver");
        volver.addActionListener(this);
        panelsup.add(volver, BorderLayout.NORTH);

    }

    private void panelinf() {

        panelinf = new JPanel();
        panelinf.setBackground(Color.LIGHT_GRAY);
        panelinf.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 1));
        bfotos = new JButton("Fotos");
        blink = new JButton("Links");
        bintegrantes = new JButton("Integrantes");
        bpf = new JButton("Proyecto Final");

        blink.addActionListener(this);
        bintegrantes.addActionListener(this);
        bpf.addActionListener(this);
        bfotos.addActionListener(this);

        panelinf.add(bpf);
        panelinf.add(bintegrantes);

        panelinf.add(bfotos);
        panelinf.add(blink);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bfotos) {
            this.setVisible(false);
            fotos framefoto = new fotos(this);
            framefoto.setVisible(true);
        }

        if (e.getSource() == bpf) {
            this.setVisible(false);
            pf framepf = new pf(this);
            framepf.setVisible(true);
        }

        if (e.getSource() == bintegrantes) {
            this.setVisible(false);
            integrantes framepi = new integrantes(this);
            framepi.setVisible(true);
        }

        if (e.getSource() == blink) {
            this.setVisible(false);
            links frameli = new links(this);
            frameli.setVisible(true);
        }

        if (e.getSource() == volver) {
            f.setVisible(true);
            this.dispose();
        }
    }

}
