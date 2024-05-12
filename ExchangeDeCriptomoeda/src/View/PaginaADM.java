
package View;


public class PaginaADM extends javax.swing.JFrame {

    
    public PaginaADM() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        btExcluirInvest = new javax.swing.JButton();
        btCadsCripto = new javax.swing.JButton();
        btExcluirCripto = new javax.swing.JButton();
        btCadsInvest = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btConsulInvest = new javax.swing.JButton();
        btConsulExtra = new javax.swing.JButton();
        btAtualizarCota = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));

        btExcluirInvest.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btExcluirInvest.setText("Excluir Investidor");

        btCadsCripto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btCadsCripto.setText("Cadastrar Criptomoeda");
        btCadsCripto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadsCriptoActionPerformed(evt);
            }
        });

        btExcluirCripto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btExcluirCripto.setText("Excluir Criptomoeda");
        btExcluirCripto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirCriptoActionPerformed(evt);
            }
        });

        btCadsInvest.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btCadsInvest.setText("Cadastrar Investidor");
        btCadsInvest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadsInvestActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Menu Administrador");

        btConsulInvest.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btConsulInvest.setText("Consultar Saldo ");
        btConsulInvest.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btConsulInvest.setOpaque(true);
        btConsulInvest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsulInvestActionPerformed(evt);
            }
        });

        btConsulExtra.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btConsulExtra.setText("Consultar Extrato");

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

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 38)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Exchange de Criptomoedas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btCadsInvest, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btExcluirInvest, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCadsCripto)
                    .addComponent(btExcluirCripto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btConsulExtra, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btConsulInvest, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAtualizarCota, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(107, 107, 107))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btConsulInvest, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCadsInvest, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btExcluirInvest, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btConsulExtra, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAtualizarCota, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCadsCripto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btExcluirCripto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );

        jMenuBar1.setBackground(new java.awt.Color(51, 51, 51));
        jMenuBar1.setForeground(new java.awt.Color(0, 0, 0));

        jMenu1.setText("Login ");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setText("Voltar Login");
        jMenuItem1.setActionCommand("LoginADM");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenuItem1.getAccessibleContext().setAccessibleName("Voltar LoginADM");

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        LoginADM LogADM = new LoginADM();
        
        LogADM.setVisible(true);
        LogADM.setLocationRelativeTo(null);
        dispose();
                
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btConsulInvestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsulInvestActionPerformed
        ConsultaSaldoADM CSA = new ConsultaSaldoADM();
        
        CSA.setVisible(true);
        dispose();
    }//GEN-LAST:event_btConsulInvestActionPerformed

    private void btCadsInvestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadsInvestActionPerformed
        CadastroInvest CI = new CadastroInvest();

        CI.setVisible(true);
        dispose();
    }//GEN-LAST:event_btCadsInvestActionPerformed

    private void btExcluirCriptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirCriptoActionPerformed
        DeletarCripto DP = new DeletarCripto();

        DP.setVisible(true);
        dispose();
    }//GEN-LAST:event_btExcluirCriptoActionPerformed

    private void btCadsCriptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadsCriptoActionPerformed
        CadastroCripto CC = new CadastroCripto();

        CC.setVisible(true);
        dispose();
    }//GEN-LAST:event_btCadsCriptoActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        Login lu = new Login();
        
        lu.setVisible(true);
        lu.setLocationRelativeTo(null);
        dispose();
    }//GEN-LAST:event_btSairActionPerformed

    private void btAtualizarCotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarCotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btAtualizarCotaActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtualizarCota;
    private javax.swing.JButton btCadsCripto;
    private javax.swing.JButton btCadsInvest;
    private javax.swing.JButton btConsulExtra;
    private javax.swing.JButton btConsulInvest;
    private javax.swing.JButton btExcluirCripto;
    private javax.swing.JButton btExcluirInvest;
    private javax.swing.JButton btSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSplitPane jSplitPane1;
    // End of variables declaration//GEN-END:variables
}
