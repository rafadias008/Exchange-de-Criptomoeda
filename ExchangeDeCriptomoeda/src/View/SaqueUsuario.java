
package View;

import Controller.Controller;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class SaqueUsuario extends javax.swing.JFrame {

   
    public SaqueUsuario() {
        initComponents();
        
        control = new Controller(this);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtValorSaque = new javax.swing.JTextField();
        btDeposito = new javax.swing.JButton();
        txtCPF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblUsuario1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SAQUE");

        btDeposito.setText("Confirmar");
        btDeposito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDepositoActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Saque");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblUsuario.setBackground(new java.awt.Color(255, 255, 255));
        lblUsuario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario.setText("Valor (R$):");

        lblUsuario1.setBackground(new java.awt.Color(255, 255, 255));
        lblUsuario1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblUsuario1.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario1.setText("CPF:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtValorSaque, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsuario)
                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsuario1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(btDeposito)))
                .addGap(70, 70, 70))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtValorSaque, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(new java.awt.Color(51, 51, 51));
        jMenuBar1.setForeground(new java.awt.Color(0, 0, 0));

        jMenu1.setText("Menu");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setText("Menu Principal");
        jMenuItem1.setActionCommand("Menu");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btDepositoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDepositoActionPerformed
        control.btSaque();
    }//GEN-LAST:event_btDepositoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        PaginaUser PU = new PaginaUser();
        PU.setVisible(true);
        PU.setLocationRelativeTo(null);
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    public Controller getControl() {
        return control;
    }

    public void setControl(Controller control) {
        this.control = control;
    }

    public JButton getBtDeposito() {
        return btDeposito;
    }

    public void setBtDeposito(JButton btDeposito) {
        this.btDeposito = btDeposito;
    }

    public JTextField getTxtCPF() {
        return txtCPF;
    }

    public void setTxtCPF(JTextField txtCPF) {
        this.txtCPF = txtCPF;
    }

    public JTextField getTxtValorSaque() {
        return txtValorSaque;
    }

    public void setTxtValorSaque(JTextField txtValorSaque) {
        this.txtValorSaque = txtValorSaque;
    }
    
    
    
    private Controller control;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDeposito;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblUsuario1;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JTextField txtValorSaque;
    // End of variables declaration//GEN-END:variables
}
