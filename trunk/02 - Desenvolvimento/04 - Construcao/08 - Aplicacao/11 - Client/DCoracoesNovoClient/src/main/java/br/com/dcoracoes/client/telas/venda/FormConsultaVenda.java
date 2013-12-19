/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FormConsultaRevendedor.java
 *
 * Created on 17/04/2012, 21:44:03
 */
package br.com.dcoracoes.client.telas.venda;

import br.com.dcoracoes.client.interfaces.InterfaceConsultaSimples;
import br.com.dcoracoes.client.swingworker.SwingWorkerPedidoVenda;
import br.com.dcoracoes.client.util.DataUtil;
import br.com.dcoracoes.client.util.MensagensUtil;
import br.com.dcoracoes.client.util.MetodosUtil;
import br.com.dcoracoes.servico.service.PedidoVenda;
import br.com.dcoracoes.servico.service.PessoaFisica;
import br.com.dcoracoes.servico.service.Revendedor;
import br.com.wedesenv.common.date.DateUtil;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cleberson
 */
public class FormConsultaVenda extends javax.swing.JDialog implements InterfaceConsultaSimples {

    private PedidoVenda pedido;
    private List<PedidoVenda> listPedidoVenda;
    private FormVenda formVenda;

    /**
     * Creates new form FormConsultaVenda
     */
    public FormConsultaVenda(boolean modal, FormVenda formVenda) {
        initComponents();
        this.formVenda = formVenda;
        setLocationRelativeTo(null);
        setModal(modal);
        setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage("src/main/resources/imagens/outras/icon_SGC.gif"));

        tableResult.addMouseListener(new DoubleClickMouseAdapter(tableResult));

        lblCodigoRevendedor.setVisible(false);
        jtxtCodigoRevendedor.setVisible(false);
        this.initialize();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSuperButton = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblConsultor = new javax.swing.JLabel();
        txtRevendedor = new javax.swing.JTextField();
        lblCodigoRevendedor = new javax.swing.JLabel();
        jtxtCodigoRevendedor = new javax.swing.JFormattedTextField();
        lblNOrcamento = new javax.swing.JLabel();
        jtxtNumeroOrcamento = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableResult = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Venda");

        panelSuperButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, new java.awt.Color(43, 115, 186)));

        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 14));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/32x32/system-search.png"))); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnSair.setFont(new java.awt.Font("Tahoma", 1, 14));
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/32x32/sair32x32.png"))); // NOI18N
        btnSair.setText("SAIR");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jPanel2.setPreferredSize(new java.awt.Dimension(40, 60));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 206, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );

        jPanel3.setPreferredSize(new java.awt.Dimension(40, 60));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 92, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );

        jPanel5.setPreferredSize(new java.awt.Dimension(40, 60));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 91, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelSuperButtonLayout = new javax.swing.GroupLayout(panelSuperButton);
        panelSuperButton.setLayout(panelSuperButtonLayout);
        panelSuperButtonLayout.setHorizontalGroup(
            panelSuperButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSuperButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelSuperButtonLayout.setVerticalGroup(
            panelSuperButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSuperButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelSuperButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panelSuperButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                            .addComponent(btnSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(panelSuperButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(43, 115, 186))); // NOI18N

        lblConsultor.setText("NOME REVENDEDOR(A):");

        txtRevendedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRevendedorKeyReleased(evt);
            }
        });

        lblCodigoRevendedor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCodigoRevendedor.setText("CÓDIGO REVENDEDOR(A):");

        jtxtCodigoRevendedor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxtCodigoRevendedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtCodigoRevendedorKeyReleased(evt);
            }
        });

        lblNOrcamento.setText("Nº ORÇAMENTO:");

        jtxtNumeroOrcamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtNumeroOrcamentoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblConsultor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRevendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblNOrcamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtNumeroOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(lblCodigoRevendedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtCodigoRevendedor, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                        .addGap(153, 153, 153))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtNumeroOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNOrcamento)
                    .addComponent(lblCodigoRevendedor)
                    .addComponent(jtxtCodigoRevendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblConsultor))
                    .addComponent(txtRevendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tableResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº Orçamento", "Data", "Código Revendedor", "Nome Revendedor", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableResult);
        tableResult.getColumnModel().getColumn(0).setMinWidth(100);
        tableResult.getColumnModel().getColumn(0).setPreferredWidth(100);
        tableResult.getColumnModel().getColumn(0).setMaxWidth(100);
        tableResult.getColumnModel().getColumn(1).setMinWidth(100);
        tableResult.getColumnModel().getColumn(1).setPreferredWidth(100);
        tableResult.getColumnModel().getColumn(1).setMaxWidth(100);
        tableResult.getColumnModel().getColumn(2).setMinWidth(150);
        tableResult.getColumnModel().getColumn(2).setPreferredWidth(150);
        tableResult.getColumnModel().getColumn(2).setMaxWidth(150);
        tableResult.getColumnModel().getColumn(4).setMinWidth(100);
        tableResult.getColumnModel().getColumn(4).setPreferredWidth(100);
        tableResult.getColumnModel().getColumn(4).setMaxWidth(100);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelSuperButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelSuperButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        search();
}//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
        close();
}//GEN-LAST:event_btnSairActionPerformed

    private void jtxtCodigoRevendedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtCodigoRevendedorKeyReleased
        MetodosUtil.validNumeric(jtxtCodigoRevendedor);
        MetodosUtil.defineSizeMax(6, jtxtCodigoRevendedor);
}//GEN-LAST:event_jtxtCodigoRevendedorKeyReleased

    private void txtRevendedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRevendedorKeyReleased
        // TODO add your handling code here:
        MetodosUtil.defineSizeMax(150, txtRevendedor);
    }//GEN-LAST:event_txtRevendedorKeyReleased

    private void jtxtNumeroOrcamentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtNumeroOrcamentoKeyReleased
        // TODO add your handling code here:
        MetodosUtil.defineSizeMax(6, jtxtNumeroOrcamento);
        MetodosUtil.validNumeric(jtxtNumeroOrcamento);
    }//GEN-LAST:event_jtxtNumeroOrcamentoKeyReleased
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSair;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField jtxtCodigoRevendedor;
    private javax.swing.JFormattedTextField jtxtNumeroOrcamento;
    private javax.swing.JLabel lblCodigoRevendedor;
    private javax.swing.JLabel lblConsultor;
    private javax.swing.JLabel lblNOrcamento;
    private javax.swing.JPanel panelSuperButton;
    private javax.swing.JTable tableResult;
    private javax.swing.JTextField txtRevendedor;
    // End of variables declaration//GEN-END:variables

    @Override
    public void close() {
        this.dispose();
    }

    @Override
    public void initialize() {
        //pular de campo com enter
        MetodosUtil.enterPularCampos(this);
        //define letras maiusculas
        MetodosUtil.letrasMaiusculas(this.getContentPane());

        createAtalhos();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void search() {
        limparGrid();
        pushToModel();
        SwingWorkerPedidoVenda work = new SwingWorkerPedidoVenda();
        work.setFormConsultaVenda(this);
        work.setPedido(pedido);
        work.workSearchPedidos.execute();
    }

    /**
     * recupera os filtros dá tela
     */
    private void pushToModel() {
        pedido = new PedidoVenda();

        pedido.setRevendedor(new Revendedor());
        //Codigo
        if (!jtxtCodigoRevendedor.getText().isEmpty()) {
            pedido.getRevendedor().setCodigo(Integer.parseInt(jtxtCodigoRevendedor.getText()));
        }

        pedido.getRevendedor().setPessoa(new PessoaFisica());
        //Nome
        if (!txtRevendedor.getText().isEmpty()) {
            ((PessoaFisica) pedido.getRevendedor().getPessoa()).setNome(txtRevendedor.getText());
        }

        //Numero orçamento
        if (!jtxtNumeroOrcamento.getText().isEmpty()) {
            pedido.setCodigo(jtxtNumeroOrcamento.getText());
        }

    }

    /**
     * popula a lista na tela
     *
     * @param list
     */
    public void popularTela(List<PedidoVenda> list) {
        this.listPedidoVenda = list;
        if (list.size() > 0) {
            for (PedidoVenda itemPedido : listPedidoVenda) {
                popularTela(itemPedido);
            }
        } else {
            JOptionPane.showMessageDialog(this, MensagensUtil.MENSAGEM_NENHUM_REGISTRO, MensagensUtil.ATENCAO, 1);
        }
    }

    /**
     * Popula o objeto Pedido na tela
     *
     * @param pedido
     */
    private void popularTela(PedidoVenda pedido) {
        DefaultTableModel dtm = (DefaultTableModel) tableResult.getModel();              
        dtm.addRow(new Object[]{
                    pedido.getCodigo(),
                    DateUtil.asString(pedido.getDataPedido()),
                    MetodosUtil.gerarCodigoFormatoPadrao(pedido.getRevendedor().getCodigo()),
                    pedido.getRevendedor().getPessoa().getNome(),
                    pedido.getTotal()
                });

    }

    /**
     * limpa os dados da grid
     */
    private void limparGrid() {
        DefaultTableModel dtm = (DefaultTableModel) tableResult.getModel();
        int x = dtm.getRowCount();
        for (int a = 0; a < x; a++) {
            dtm.removeRow(0);
        }
    }

    @Override
    public void showFrame() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Criando ação do doubleClickMouse para tableResult
     */
    private class DoubleClickMouseAdapter extends MouseAdapter {

        JTable table;

        public DoubleClickMouseAdapter(JTable table) {
            this.table = table;
        }

        public void mouseClicked(java.awt.event.MouseEvent e) {
            if (e.getClickCount() == 2) {

                int row = table.getSelectedRow();
                formVenda.refreshPedido(listPedidoVenda.get(row));

                close();
            }
        }
    }

    /**
     * ******************************************************************************
     * monta os atalhos da tela
     */
    private void createAtalhos() {
        InputMap imap = rootPane.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        imap.put(KeyStroke.getKeyStroke("ENTER"), "buttonEnterPress");
        ActionMap amap = rootPane.getActionMap();
        amap.put("buttonEnterPress", new EnterKey());

    }

    /**
     * tratamento do atalho para tecla ENTER
     */
    private class EnterKey extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            search();
        }
    }
}
