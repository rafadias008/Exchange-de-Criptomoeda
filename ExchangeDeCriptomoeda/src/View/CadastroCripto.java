
package View;

import Controller.ControllerADM;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class CadastroCripto extends javax.swing.JFrame {

    
    public CadastroCripto() {
        initComponents();
        
        controlADM = new ControllerADM(this);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtNomeCripto = new javax.swing.JTextField();
        btCriarCripto = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtValorMoeda = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTaxaCompra = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTaxaVenda = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Menu = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));

        txtNomeCripto.setBackground(new java.awt.Color(222, 222, 225));
        txtNomeCripto.setForeground(new java.awt.Color(0, 0, 0));

        btCriarCripto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btCriarCripto.setText("Criar criptomoeda");
        btCriarCripto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCriarCriptoActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("NOME DA MOEDA:");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 29)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Adicionar Criptomoeda");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("VALOR DA MOEDA:");

        txtValorMoeda.setBackground(new java.awt.Color(222, 222, 225));
        txtValorMoeda.setForeground(new java.awt.Color(0, 0, 0));
        txtValorMoeda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorMoedaActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("TAXA DE COMPRA(**%):");

        txtTaxaCompra.setBackground(new java.awt.Color(222, 222, 225));
        txtTaxaCompra.setForeground(new java.awt.Color(0, 0, 0));
        txtTaxaCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTaxaCompraActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("TAXA DE VENDA(**%):");

        txtTaxaVenda.setBackground(new java.awt.Color(222, 222, 225));
        txtTaxaVenda.setForeground(new java.awt.Color(0, 0, 0));
        txtTaxaVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTaxaVendaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(62, 62, 62))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(btCriarCripto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTaxaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtTaxaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtValorMoeda, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(txtNomeCripto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(86, 86, 86))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNomeCripto, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtValorMoeda, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTaxaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTaxaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(btCriarCripto)
                .addGap(49, 49, 49))
        );

        jMenuBar1.setBackground(new java.awt.Color(51, 51, 51));
        jMenuBar1.setForeground(new java.awt.Color(0, 0, 0));

        jMenu1.setBackground(new java.awt.Color(255, 255, 255));
        jMenu1.setForeground(new java.awt.Color(255, 255, 255));
        jMenu1.setText("Menu");

        Menu.setText("Menu");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setText("Menu Principal");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        Menu.add(jMenuItem2);

        jMenu2.setText("Investidor");

        jMenuItem1.setText("Deletar investidor");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem9.setText("Cadastrar Investidor");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem9);

        jMenuItem12.setText("Consultar Saldo");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem12);

        jMenuItem13.setText("Consultar Extrato");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem13);

        Menu.add(jMenu2);

        jMenu3.setText("Criptomoeda");

        jMenuItem10.setText("Deletar Cripto");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem10);

        jMenuItem11.setText("Cadastrar Cripto");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem11);

        jMenuItem14.setText("Atualizar Cotação da Cripto");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem14);

        Menu.add(jMenu3);

        jMenu1.add(Menu);

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

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        PaginaADM pgADM = new PaginaADM();

        pgADM.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        Extrato consultaExtrato = new Extrato();

        consultaExtrato.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        DeletaInvest DelInvest = new DeletaInvest();

        DelInvest.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        CadastroInvest cadInvest = new CadastroInvest();

        cadInvest.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        ConsultaSaldoADM consultaSaldo = new ConsultaSaldoADM();

        consultaSaldo.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        DeletarCripto deletaCrip = new DeletarCripto();
        
        deletaCrip.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        CadastroCripto cadastroCrip = new CadastroCripto();
        
        cadastroCrip.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        AtualizarCotCripto cotacaoCripto = new AtualizarCotCripto();
        
        cotacaoCripto.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void btCriarCriptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCriarCriptoActionPerformed
        controlADM.btCadastrarCripto();
    }//GEN-LAST:event_btCriarCriptoActionPerformed

    private void txtValorMoedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorMoedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorMoedaActionPerformed

    private void txtTaxaCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTaxaCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTaxaCompraActionPerformed

    private void txtTaxaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTaxaVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTaxaVendaActionPerformed

    public ControllerADM getControlADM() {
        return controlADM;
    }

    public void setControlADM(ControllerADM controlADM) {
        this.controlADM = controlADM;
    }

    public JButton getBtCriarCripto() {
        return btCriarCripto;
    }

    public void setBtCriarCripto(JButton btCriarCripto) {
        this.btCriarCripto = btCriarCripto;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JTextField getTxtNomeCripto() {
        return txtNomeCripto;
    }

    public void setTxtNomeCripto(JTextField txtNomeCripto) {
        this.txtNomeCripto = txtNomeCripto;
    }

    public JTextField getTxtValorMoeda() {
        return txtValorMoeda;
    }

    public void setTxtValorMoeda(JTextField txtValorMoeda) {
        this.txtValorMoeda = txtValorMoeda;
    }

    public JTextField getTxtTaxaCompra() {
        return txtTaxaCompra;
    }

    public void setTxtTaxaCompra(JTextField txtTaxaCompra) {
        this.txtTaxaCompra = txtTaxaCompra;
    }

    public JTextField getTxtTaxaVenda() {
        return txtTaxaVenda;
    }

    public void setTxtTaxaVenda(JTextField txtTaxaVenda) {
        this.txtTaxaVenda = txtTaxaVenda;
    }

    
    
    private ControllerADM controlADM;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Menu;
    private javax.swing.JButton btCriarCripto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtNomeCripto;
    private javax.swing.JTextField txtTaxaCompra;
    private javax.swing.JTextField txtTaxaVenda;
    private javax.swing.JTextField txtValorMoeda;
    // End of variables declaration//GEN-END:variables
}
