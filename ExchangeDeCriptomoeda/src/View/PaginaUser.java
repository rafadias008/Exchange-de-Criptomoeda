/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.Controller;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

/**
 *
 * @author rafae
 */
public class PaginaUser extends javax.swing.JFrame {

    /**
     * Creates new form PaginaUser
     */
    public PaginaUser() {
        initComponents();
        
        control = new Controller(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btConsulSaldo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btComprarCripto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        inforUser = new javax.swing.JTextPane();
        btVenderCripto = new javax.swing.JButton();
        btAtualizarCota = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btConsulExtrato = new javax.swing.JButton();
        btDepositar = new javax.swing.JButton();
        btSacar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Usuário");

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));

        btConsulSaldo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btConsulSaldo.setText("Consultar Saldo");
        btConsulSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsulSaldoActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 102, 0));
        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MENU DE OPERAÇÕES");

        btComprarCripto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btComprarCripto.setLabel("Comprar Cripto");
        btComprarCripto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btComprarCriptoActionPerformed(evt);
            }
        });

        inforUser.setEditable(false);
        inforUser.setBackground(new java.awt.Color(51, 51, 51));
        inforUser.setBorder(null);
        inforUser.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        inforUser.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(inforUser);

        btVenderCripto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btVenderCripto.setText("Vender Criptomoeda");
        btVenderCripto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVenderCriptoActionPerformed(evt);
            }
        });

        btAtualizarCota.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btAtualizarCota.setText("Atualizar Cotação");
        btAtualizarCota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarCotaActionPerformed(evt);
            }
        });

        btSair.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 102, 51));
        jLabel4.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 38)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Exchange de Criptomoedas");
        jLabel4.setToolTipText("");

        btConsulExtrato.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btConsulExtrato.setText("Consultar Extrato");
        btConsulExtrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsulExtratoActionPerformed(evt);
            }
        });

        btDepositar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btDepositar.setText("Depositar");
        btDepositar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDepositarActionPerformed(evt);
            }
        });

        btSacar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btSacar.setText("Sacar");
        btSacar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSacarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE))
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btConsulSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btDepositar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btConsulExtrato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btSacar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btAtualizarCota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btVenderCripto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btComprarCripto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btComprarCripto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btConsulSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btConsulExtrato, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btVenderCripto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAtualizarCota, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDepositar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSacar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jLabel4.getAccessibleContext().setAccessibleName("Menu Usuario");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSacarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSacarActionPerformed
        SaqueUsuario saque = new SaqueUsuario();

        saque.setVisible(true);
    }//GEN-LAST:event_btSacarActionPerformed

    private void btDepositarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDepositarActionPerformed
        DepositoUsuario deposito = new DepositoUsuario();

        deposito.setVisible(true);
    }//GEN-LAST:event_btDepositarActionPerformed

    private void btConsulExtratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsulExtratoActionPerformed
        ConsultaExtrato extrato = new ConsultaExtrato();

        extrato.setVisible(true);
    }//GEN-LAST:event_btConsulExtratoActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        Login lu = new Login();
        lu.setVisible(true);
        dispose();
    }//GEN-LAST:event_btSairActionPerformed

    private void btConsulSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsulSaldoActionPerformed
        ConsultaSaldo consulta = new ConsultaSaldo();

        consulta.setVisible(true);
    }//GEN-LAST:event_btConsulSaldoActionPerformed

    private void btComprarCriptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btComprarCriptoActionPerformed
       CompraCripto comprar =  new CompraCripto();
       
       comprar.setVisible(true);
        
    }//GEN-LAST:event_btComprarCriptoActionPerformed

    private void btAtualizarCotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarCotaActionPerformed
        control.atualizarCotacao();
    }//GEN-LAST:event_btAtualizarCotaActionPerformed

    private void btVenderCriptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVenderCriptoActionPerformed
        venderCripto venderCripto = new venderCripto();
        
        venderCripto.setVisible(true);
    }//GEN-LAST:event_btVenderCriptoActionPerformed

    

    public JButton getBtAtualizarCota() {
        return btAtualizarCota;
    }

    public void setBtAtualizarCota(JButton btAtualizarCota) {
        this.btAtualizarCota = btAtualizarCota;
    }

    public JButton getBtComprarCripto() {
        return btComprarCripto;
    }

    public void setBtComprarCripto(JButton btComprarCripto) {
        this.btComprarCripto = btComprarCripto;
    }

    public JButton getBtConsulExtrato() {
        return btConsulExtrato;
    }

    public void setBtConsulExtrato(JButton btConsulExtrato) {
        this.btConsulExtrato = btConsulExtrato;
    }

    public JButton getBtConsulSaldo() {
        return btConsulSaldo;
    }

    public void setBtConsulSaldo(JButton btConsulSaldo) {
        this.btConsulSaldo = btConsulSaldo;
    }

    public JButton getBtDepositar() {
        return btDepositar;
    }

    public void setBtDepositar(JButton btDepositar) {
        this.btDepositar = btDepositar;
    }

    public JButton getBtSacar() {
        return btSacar;
    }

    public void setBtSacar(JButton btSacar) {
        this.btSacar = btSacar;
    }

    public JButton getBtSair() {
        return btSair;
    }

    public void setBtSair(JButton btSair) {
        this.btSair = btSair;
    }

    public JButton getBtVenderCripto() {
        return btVenderCripto;
    }

    public void setBtVenderCripto(JButton btVenderCripto) {
        this.btVenderCripto = btVenderCripto;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    

    public JTextPane getInforUser() {
        return inforUser;
    }

    public void setInforUser(JTextPane inforUser) {
        this.inforUser = inforUser;
    }
    
    private Controller control;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtualizarCota;
    private javax.swing.JButton btComprarCripto;
    private javax.swing.JButton btConsulExtrato;
    private javax.swing.JButton btConsulSaldo;
    private javax.swing.JButton btDepositar;
    private javax.swing.JButton btSacar;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btVenderCripto;
    private javax.swing.JTextPane inforUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
