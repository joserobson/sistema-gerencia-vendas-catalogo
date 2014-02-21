/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.client.telas.venda;

import br.com.dcoracoes.client.enuns.Enum_Forma_Pagamento;
import br.com.dcoracoes.client.enuns.Enum_Situacao_Parcela;
import br.com.dcoracoes.client.swingworker.SwingWorkerPedidoVenda;
import br.com.dcoracoes.client.util.MensagensUtil;
import br.com.dcoracoes.client.util.MetodosUtil;
import br.com.dcoracoes.client.util.componentes.JFormattedDate;
import br.com.dcoracoes.client.util.componentes.JFormattedMoeda;
import br.com.dcoracoes.client.util.message.MessageVenda;
import br.com.dcoracoes.servico.service.Pagamento;
import br.com.dcoracoes.servico.service.Parcela;
import br.com.dcoracoes.servico.service.PedidoVenda;
import br.com.dcoracoes.servico.service.Revendedor;
import br.com.wedesenv.common.date.DateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author rerum
 */
public class FormFormaPagamento extends javax.swing.JDialog {

    public final String VALOR_ZERO = "0";
    private Revendedor revendedor;
    private PedidoVenda pedidoVenda;
    private FormVenda formVenda;

    /**
     * Creates new form FormFormaPagamento
     */
    public FormFormaPagamento() {
        initComponents();
    }

    public FormFormaPagamento(FormVenda pFormVenda) {
        initComponents();
        setLocationRelativeTo(null);
        setModal(true);
        initAtributos(pFormVenda);
        initCampos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jtxtValorEmDinheiro = new JFormattedMoeda();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jtxtValorBonus = new JFormattedMoeda();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jtxtValorCheque1 = new JFormattedMoeda();
        jtxtValorCheque2 = new JFormattedMoeda();
        jtxtDataLiberacaoCheque1 = new JFormattedDate();
        jtxtDataLiberacaoCheque2 = new JFormattedDate();
        jComboBoxFormaPagamento = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnAprovar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Forma Pagamento");
        setPreferredSize(new java.awt.Dimension(520, 270));
        setResizable(false);

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jtxtValorEmDinheiro.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtValorEmDinheiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtValorEmDinheiroActionPerformed(evt);
            }
        });
        jtxtValorEmDinheiro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtValorEmDinheiroKeyPressed(evt);
            }
        });

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("VALOR EM DINHEIRO:");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("BÔNUS:");

        jtxtValorBonus.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("VALOR 1º CHEQUE:");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("VALOR 2º CHEQUE:");

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("DATA LIBERAÇÃO 1º CHEQUE:");

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("DATA LIBERAÇÃO 2º CHEQUE:");

        jtxtValorCheque1.setFormatterFactory(null);
        jtxtValorCheque1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jtxtValorCheque2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jtxtDataLiberacaoCheque1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtDataLiberacaoCheque1FocusLost(evt);
            }
        });

        jtxtDataLiberacaoCheque2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtDataLiberacaoCheque2FocusLost(evt);
            }
        });

        jComboBoxFormaPagamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "À VISTA", "À PRAZO" }));
        jComboBoxFormaPagamento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxFormaPagamentoItemStateChanged(evt);
            }
        });

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("FORMA DE PAGAMENTO:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtValorEmDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtValorBonus, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jtxtValorCheque1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel14)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jtxtDataLiberacaoCheque1))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jtxtValorCheque2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel15)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jtxtDataLiberacaoCheque2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtValorEmDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jtxtValorBonus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtValorCheque1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jtxtDataLiberacaoCheque1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtValorCheque2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15)
                    .addComponent(jtxtDataLiberacaoCheque2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnAprovar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAprovar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/32x32/img_edit_32x32.png"))); // NOI18N
        btnAprovar.setText("APROVAR");
        btnAprovar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAprovarActionPerformed(evt);
            }
        });

        jPanel5.setPreferredSize(new java.awt.Dimension(40, 60));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel6.setPreferredSize(new java.awt.Dimension(40, 60));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 13, Short.MAX_VALUE)
                .addGap(58, 58, 58)
                .addComponent(btnAprovar)
                .addGap(27, 27, 27)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 13, Short.MAX_VALUE)
                .addGap(140, 140, 140))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAprovar))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void isEnableValorEmDinheiro(String valor) {
        if (valor.isEmpty()) {
            if (jtxtValorCheque1.getText().isEmpty()
                    & jtxtValorCheque2.getText().isEmpty()
                    & jtxtDataLiberacaoCheque1.getText().replace("/", "").trim().isEmpty()
                    & jtxtDataLiberacaoCheque2.getText().replace("/", "").trim().isEmpty()) {
                jtxtValorEmDinheiro.setEnabled(true);
            }
        } else {
            jtxtValorEmDinheiro.setEnabled(false);
        }
    }

    private void jtxtDataLiberacaoCheque1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtDataLiberacaoCheque1FocusLost
        // TODO add your handling code here:
        if (!MetodosUtil.validData(jtxtDataLiberacaoCheque1.getText())) {
            JOptionPane.showMessageDialog(this, MensagensUtil.MENSAGEM_ERRO_DATA_INVALIDA, MensagensUtil.ATENCAO, 2);

            jtxtDataLiberacaoCheque1.setValue(null);
            jtxtDataLiberacaoCheque1.requestFocus();
        }
    }//GEN-LAST:event_jtxtDataLiberacaoCheque1FocusLost

    private void jtxtDataLiberacaoCheque2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtDataLiberacaoCheque2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtDataLiberacaoCheque2FocusLost

    private void btnAprovarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAprovarActionPerformed
        // TODO add your handling code here: 
        if (validateForm()) {
            aprovarVenda();
        }
    }//GEN-LAST:event_btnAprovarActionPerformed

    private void jtxtValorEmDinheiroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtValorEmDinheiroKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtValorEmDinheiroKeyPressed

    private void jtxtValorEmDinheiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtValorEmDinheiroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtValorEmDinheiroActionPerformed

    private void jComboBoxFormaPagamentoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxFormaPagamentoItemStateChanged

        if (this.jComboBoxFormaPagamento.getSelectedIndex() == 0) {
            //habilitar campos a vista
            habilitaCamposPagVista();

        } else {
            habilitaCamposPagPrazo();
        }
    }//GEN-LAST:event_jComboBoxFormaPagamentoItemStateChanged

    /**
     * Faz a validação do credito do cliente e do valor dá compra e confirma se
     * cliente pode efetuar a compra
     */
    private void aprovarVenda() {
        if (revendedor != null && pedidoVenda != null) {

            Pagamento pagamentoVenda = pushToModelFormaPagamento();
            pedidoVenda.setPagamento(pagamentoVenda);
            if (validaValorPedidoPagamento(pedidoVenda)) {
                if (pagamentoVenda.getFormaPagamento() == Enum_Forma_Pagamento.APRAZO.getTipo()) //só vou no server aprovar se o pagamento for a prazo
                {
                    SwingWorkerPedidoVenda work = new SwingWorkerPedidoVenda();
                    work.setPedido(pedidoVenda);
                    work.setFormFormaPagamento(this);
                    work.workAprovarPedidoVenda.execute();
                }
            } else {
                JOptionPane.showMessageDialog(this, "O valor do pagamento configurado não bate com o valor do pedido escrito.", MensagensUtil.ATENCAO, 1);
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormFormaPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormFormaPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormFormaPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormFormaPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FormFormaPagamento().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAprovar;
    private javax.swing.JComboBox jComboBoxFormaPagamento;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JFormattedTextField jtxtDataLiberacaoCheque1;
    private javax.swing.JFormattedTextField jtxtDataLiberacaoCheque2;
    private javax.swing.JFormattedTextField jtxtValorBonus;
    private javax.swing.JFormattedTextField jtxtValorCheque1;
    private javax.swing.JFormattedTextField jtxtValorCheque2;
    private javax.swing.JFormattedTextField jtxtValorEmDinheiro;
    // End of variables declaration//GEN-END:variables

    private Pagamento pushToModelFormaPagamento() {

        // passos para criar o pagamento
        Pagamento pagamentoVenda = new Pagamento();
        
        //1. pego o bonus
        if (!jtxtValorBonus.getText().isEmpty()) {
            pagamentoVenda.setBonus(MetodosUtil.convertStringToFloat(jtxtValorBonus.getText()));
        }
        //2.pego o valor em dinheiro
        if (!jtxtValorEmDinheiro.getText().isEmpty())
            pagamentoVenda.setValorDinheiro(MetodosUtil.convertStringToFloat(jtxtValorEmDinheiro.getText()));

        //2. verifico se avista ou prazo
        if (jComboBoxFormaPagamento.getSelectedIndex() == 0) {
            //pagamento a vista
            pagamentoVenda.setFormaPagamento(Enum_Forma_Pagamento.AVISTA.getTipo());   
            pagamentoVenda.setValor(pagamentoVenda.getValorDinheiro());
        } else {
            //pagamento a prazo
            pagamentoVenda.setFormaPagamento(Enum_Forma_Pagamento.APRAZO.getTipo());
            pagamentoVenda.getListaParcelas().addAll(addParcelas());
            pagamentoVenda.setValor(somarValorParcelasPagamento(pagamentoVenda.getListaParcelas()));
        }

        return pagamentoVenda;
    }

    /**
     * *
     *
     * @param isAprovada
     */
    public void afterAprovarVenda(Boolean isAprovada) {
        if (isAprovada) {
            JOptionPane.showMessageDialog(this, MessageVenda.MSG_VENDA_APROVADA, MensagensUtil.ATENCAO, 1);
            this.formVenda.disableAbaItemsPedido(true);
            this.formVenda.getTxtAprovacao().setText("APROVADO");
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, MessageVenda.MSG_VENDA_REPROVADA, MensagensUtil.ATENCAO, 1);
            this.formVenda.getTxtAprovacao().setText("REPROVADO");
            this.formVenda.disableAbaItemsPedido(false);
        }
    }

    /**
     * add parcelas do pagamento
     *
     * @return
     */
    private List<Parcela> addParcelas() {

        List<Parcela> parcelas = new ArrayList<Parcela>();

        //add parcela 1
        if (!jtxtValorCheque1.getText().isEmpty()) {
            Parcela parcelaCheque1 = new Parcela();
            parcelaCheque1.setValor(MetodosUtil.convertStringToFloat(jtxtValorCheque1.getText()));

            if (!jtxtDataLiberacaoCheque1.getText().isEmpty()) {
                parcelaCheque1.setDataVencimento(DateUtil.formatFromString(jtxtDataLiberacaoCheque1.getText()));
            }
            parcelaCheque1.setStatus(Enum_Situacao_Parcela.PENDENTE.getCodigo());
            parcelas.add(parcelaCheque1);
        }

        //add parcela 2
        if (!jtxtValorCheque2.getText().isEmpty()) {
            Parcela parcelaCheque2 = new Parcela();
            parcelaCheque2.setValor(MetodosUtil.convertStringToFloat(jtxtValorCheque2.getText()));

            if (!jtxtDataLiberacaoCheque2.getText().isEmpty()) {
                parcelaCheque2.setDataVencimento(DateUtil.formatFromString(jtxtDataLiberacaoCheque2.getText()));
            }
            
            parcelaCheque2.setStatus(Enum_Situacao_Parcela.PENDENTE.getCodigo());
            parcelas.add(parcelaCheque2);
        }

        return parcelas;
    }

    /**
     * valida se todos os campos estão populados
     *
     * @return
     */
    private boolean validateForm() {

        //valido se alguma forma de pagamento foi passada
        if (jComboBoxFormaPagamento.getSelectedIndex() == 0
                & jtxtValorEmDinheiro.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Campo valor vazio!!!", MensagensUtil.ATENCAO, 1);
            return false;
        } else {
            if (jComboBoxFormaPagamento.getSelectedIndex() == 1
                    & jtxtValorCheque1.getText().isEmpty()
                    & jtxtValorCheque2.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Campo valor para os cheques 1º e 2º estão vazios!!!", MensagensUtil.ATENCAO, 1);
                return false;
            }
        }


        //valido somente para os campos da forma de pagamento a prazo
        //os campos de cheque
        //cheque 1
        if (!jtxtValorCheque1.getText().isEmpty()
                && MetodosUtil.isDataEmpty(jtxtDataLiberacaoCheque1.getText())
                && jtxtDataLiberacaoCheque1.isEnabled()) {
            JOptionPane.showMessageDialog(this, "Campo Data Liberação para o 1º está vazio!!!", MensagensUtil.ATENCAO, 1);
            return false;
        }

        //cheque 2
        if (!jtxtValorCheque2.getText().isEmpty()
                && MetodosUtil.isDataEmpty(jtxtDataLiberacaoCheque2.getText())
                && jtxtDataLiberacaoCheque2.isEnabled()) {
            JOptionPane.showMessageDialog(this, "Campo Data Liberação para o 2º está vazio!!!", MensagensUtil.ATENCAO, 1);
            return false;
        }

        return true;
    }

    /**
     *
     * @param pFormVenda
     */
    private void initAtributos(FormVenda pFormVenda) {
        this.formVenda = pFormVenda;
        this.revendedor = pFormVenda.getRevendedor();

        if (pFormVenda.getPedido() == null) {
            this.formVenda.setPedidoVenda(new PedidoVenda());
        }

        pedidoVenda = pFormVenda.getPedido();
        pedidoVenda.setRevendedor(revendedor);
        pedidoVenda.setValorPedidoEscrito(MetodosUtil.convertStringToFloat(pFormVenda.getJtxtValorPedidoEscrito().getText()));
    }

    private void initCampos() {

        this.jtxtValorBonus.setText(VALOR_ZERO);
        this.jtxtValorCheque1.setText(VALOR_ZERO);
        this.jtxtValorCheque2.setText(VALOR_ZERO);
        this.jtxtValorEmDinheiro.setText(VALOR_ZERO);
        this.jComboBoxFormaPagamento.setSelectedIndex(0);
        habilitaCamposPagVista();

        if (pedidoVenda.getPagamento() != null) {
            populaDadosPagamento(pedidoVenda.getPagamento());
        }
    }

    private void populaDadosPagamento(Pagamento pagamento) {

        this.jtxtValorBonus.setText(MetodosUtil.formatarValorDinheiro(pagamento.getBonus()));
        this.jtxtValorEmDinheiro.setText(MetodosUtil.formatarValorDinheiro(pagamento.getValorDinheiro()));
        
        if (pagamento.getFormaPagamento() == Enum_Forma_Pagamento.AVISTA.getTipo()) {
            this.jComboBoxFormaPagamento.setSelectedIndex(0);
            habilitaCamposPagVista();            
            this.jtxtDataLiberacaoCheque1.setEnabled(false);
            this.jtxtDataLiberacaoCheque2.setEnabled(false);
            this.jtxtValorCheque1.setEnabled(false);
            this.jtxtValorCheque2.setEnabled(false);
        } else {
            this.jComboBoxFormaPagamento.setSelectedIndex(1);
            habilitaCamposPagPrazo();

            if (pagamento.getListaParcelas() != null && pagamento.getListaParcelas().size() > 0) {

                Parcela parcela1 = pagamento.getListaParcelas().get(0);
                jtxtDataLiberacaoCheque1.setText(DateUtil.asString(parcela1.getDataVencimento()));
                jtxtValorCheque1.setText(MetodosUtil.formatarValorDinheiro(parcela1.getValor()));

                if (pagamento.getListaParcelas().size() > 1) {
                    Parcela parcela2 = pagamento.getListaParcelas().get(1);
                    jtxtDataLiberacaoCheque2.setText(DateUtil.asString(parcela2.getDataVencimento()));
                    jtxtValorCheque2.setText(MetodosUtil.formatarValorDinheiro(parcela2.getValor()));
                }                
            }
        }
    }

    /**
     * Verifica se o valor do pagamento passado pelo usuário bate com o valor do
     * pedido escrito
     *
     * @param pedidoVenda
     * @return
     */
    private boolean validaValorPedidoPagamento(PedidoVenda pedidoVenda) {

        float valorPedidoEscrito = pedidoVenda.getValorPedidoEscrito();
        Pagamento pagamentoPedido = pedidoVenda.getPagamento();
    
        float valorPedidoPagamento = 0;
        if (pagamentoPedido.getFormaPagamento() == Enum_Forma_Pagamento.APRAZO.getTipo())
            valorPedidoPagamento = pagamentoPedido.getBonus() + pagamentoPedido.getValor() + pagamentoPedido.getValorDinheiro();
        else
            if (pagamentoPedido.getFormaPagamento() == Enum_Forma_Pagamento.AVISTA.getTipo())
                valorPedidoPagamento = pagamentoPedido.getBonus() + pagamentoPedido.getValor();
                        
        return valorPedidoEscrito == valorPedidoPagamento;
    }
    

    /**
     * somar o valor das paracelas
     *
     * @param listaParcelas
     * @return
     */
    private float somarValorParcelasPagamento(List<Parcela> listaParcelas) {

        float somaParcelas = 0;

        if (listaParcelas != null
                && listaParcelas.size() > 0) {
            for (Parcela parcela : listaParcelas) {
                somaParcelas += parcela.getValor();
            }

        }

        return somaParcelas;
    }

    /**
     *
     */
    private void habilitaCamposPagVista() {
        jtxtValorEmDinheiro.setEnabled(true);        
        jtxtDataLiberacaoCheque1.setEnabled(false);
        jtxtDataLiberacaoCheque1.setText("");

        jtxtDataLiberacaoCheque2.setEnabled(false);
        jtxtDataLiberacaoCheque2.setText("");

        jtxtValorCheque1.setEnabled(false);
        jtxtValorCheque1.setText(VALOR_ZERO);

        jtxtValorCheque2.setEnabled(false);
        jtxtValorCheque2.setText(VALOR_ZERO);
    }

    /**
     *
     */
    private void habilitaCamposPagPrazo() {
        //habilita os campos para prazo
        jtxtValorEmDinheiro.setEnabled(true);        
        jtxtDataLiberacaoCheque1.setEnabled(true);
        jtxtDataLiberacaoCheque2.setEnabled(true);
        jtxtValorCheque1.setEnabled(true);
        jtxtValorCheque2.setEnabled(true);
    }
}
