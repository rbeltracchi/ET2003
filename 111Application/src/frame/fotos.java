package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author Mariano
 */
public class fotos extends javax.swing.JFrame {

    private ImageIcon imagen[] = new ImageIcon[10];
    private int contador = 1;
    private Icon icono[] = new Icon[10];
    private frameprincipal f;
    private Timer timer;
    private boolean t;

    public fotos(frameprincipal f) {
        initComponents();
        this.setBounds(500, 200, 700, 600);
        this.f = f;
        for (int i = 1; i < 10; i++) {
            imagen[i] = new ImageIcon(getClass().getResource("/images/" + i + ".jpg"));
            icono[i] = new ImageIcon(imagen[i].getImage().getScaledInstance(jlvisor.getWidth(), jlvisor.getHeight(), 1));
        }
        jlvisor.setIcon(icono[1]);
        this.setResizable(false);
        getContentPane().setBackground(new java.awt.Color(51, 102, 150));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        banterior = new javax.swing.JButton();
        bsiguiente = new javax.swing.JButton();
        jlvisor = new javax.swing.JLabel();
        bauto = new javax.swing.JButton();
        bvolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 102, 255));

        banterior.setText("Anterior");
        banterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                banteriorActionPerformed(evt);
            }
        });

        bsiguiente.setText("Siguiente");
        bsiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsiguienteActionPerformed(evt);
            }
        });

        jlvisor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bauto.setText("Presentación Automática");
        bauto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bautoActionPerformed(evt);
            }
        });

        bvolver.setText("Volver");
        bvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bvolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bvolver)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jlvisor, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(banterior)
                .addGap(113, 113, 113)
                .addComponent(bauto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bsiguiente)
                .addGap(67, 67, 67))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bvolver)
                .addGap(18, 18, 18)
                .addComponent(jlvisor, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(banterior)
                    .addComponent(bauto)
                    .addComponent(bsiguiente))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void banteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_banteriorActionPerformed

        try {
            if (contador == 1) {
                contador = 10;
            }
            contador--;
            jlvisor.setIcon(icono[contador]);
            if (t == true) {
                timer.stop();
                t = false;
            }

    }//GEN-LAST:event_banteriorActionPerformed
            catch (Exception e) {
        }
    }
    private void bautoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bautoActionPerformed
        timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlvisor.setIcon(icono[contador]);
                contador++;
                if (contador == 10) {
                    contador = 1;
                }
            }
        });
        timer.start();
        t = true;
    }//GEN-LAST:event_bautoActionPerformed

    private void bsiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsiguienteActionPerformed
        try {
            if (contador == 9) {
                contador = 0;
            }
            contador++;
            jlvisor.setIcon(icono[contador]);
            if (t == true) {
                timer.stop();
                t = false;
            }
    }//GEN-LAST:event_bsiguienteActionPerformed
        catch (Exception e) {

        }
    }
    private void bvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bvolverActionPerformed

        this.dispose();
        f.setVisible(true);

    }//GEN-LAST:event_bvolverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton banterior;
    private javax.swing.JButton bauto;
    private javax.swing.JButton bsiguiente;
    private javax.swing.JButton bvolver;
    private javax.swing.JLabel jlvisor;
    // End of variables declaration//GEN-END:variables
}
