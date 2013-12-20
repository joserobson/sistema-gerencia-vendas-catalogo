/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FormRelatorioVendaPorRevendedor.java
 *
 * Created on 17/10/2012, 00:26:29
 */
package br.com.dcoracoes.client.telas.relatorio;

import br.com.dcoracoes.client.interfaces.InterfaceConsultaSimples;
import br.com.dcoracoes.client.relatorios.GerarRelatorio;
import br.com.dcoracoes.client.swingworker.SwingWorkerPedidoVenda;
import br.com.dcoracoes.client.util.MensagensUtil;
import br.com.dcoracoes.client.util.MetodosUtil;
import br.com.dcoracoes.client.util.message.MessageVenda;
import br.com.dcoracoes.servico.service.ModelRelatorioPedidoRevendedor;
import br.com.dcoracoes.servico.service.PedidoVenda;
import br.com.wedesenv.common.date.DateUtil;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author Cléberson
 */
public class FormRelatorioVendaPorRevendedor extends javax.swing.JFrame implements InterfaceConsultaSimples{

    private ModelRelatorioPedidoRevendedor parameter;
    private List<PedidoVenda> result;
    
    /** Creates new form FormRelatorioVendaPorRevendedor */
    public FormRelatorioVendaPorRevendedor() {
        initComponents();
        setLocationRelativeTo(null);
        this.initialize();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
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
        btnImprimir = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblDataNascimento = new javax.swing.JLabel();
        jtxtPeriodoInicio = new javax.swing.JFormattedTextField();
        lblDataNascimento1 = new javax.swing.JLabel();
        jtxtPeriodoFim = new javax.swing.JFormattedTextField();
        jtxtCodigoRevendedor = new javax.swing.JFormattedTextField();
        lblCodigoRevendedor = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableResult = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblValorTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório de Venda por Revendedor");
        setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage("src/main/resources/imagens/outras/icon_SGC.gif"));
        setResizable(false);

        panelSuperButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, new java.awt.Color(43, 115, 186)));

        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/32x32/accessories-text-editor.png"))); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnSair.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
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
            .addGap(0, 140, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.setPreferredSize(new java.awt.Dimension(40, 60));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
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
            .addGap(0, 62, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btnImprimir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/32x32/printer_48.png"))); // NOI18N
        btnImprimir.setText("IMPRIMIR");
        btnImprimir.setEnabled(false);
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        jPanel4.setPreferredSize(new java.awt.Dimension(40, 60));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelSuperButtonLayout = new javax.swing.GroupLayout(panelSuperButton);
        panelSuperButton.setLayout(panelSuperButtonLayout);
        panelSuperButtonLayout.setHorizontalGroup(
            panelSuperButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnImprimir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelSuperButtonLayout.setVerticalGroup(
            panelSuperButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSuperButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSuperButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(btnImprimir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSair, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(43, 115, 186))); // NOI18N

        lblDataNascimento.setText("PERÍODO DE VENDA:  de");

        try {
            jtxtPeriodoInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jtxtPeriodoInicio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtPeriodoInicioFocusLost(evt);
            }
        });

        lblDataNascimento1.setText("até");

        try {
            jtxtPeriodoFim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jtxtPeriodoFim.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtPeriodoFimFocusLost(evt);
            }
        });

        jtxtCodigoRevendedor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxtCodigoRevendedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtCodigoRevendedorKeyReleased(evt);
            }
        });

        lblCodigoRevendedor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCodigoRevendedor.setText("CÓDIGO REVENDEDOR(A):");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDataNascimento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtxtPeriodoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDataNascimento1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtxtPeriodoFim, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(lblCodigoRevendedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtxtCodigoRevendedor, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                .addGap(76, 76, 76))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDataNascimento)
                    .addComponent(jtxtPeriodoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDataNascimento1)
                    .addComponent(jtxtPeriodoFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodigoRevendedor)
                    .addComponent(jtxtCodigoRevendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tableResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código Revendedor", "Nome Revendedor", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableResult);
        tableResult.getColumnModel().getColumn(0).setMinWidth(120);
        tableResult.getColumnModel().getColumn(0).setPreferredWidth(120);
        tableResult.getColumnModel().getColumn(0).setMaxWidth(120);
        tableResult.getColumnModel().getColumn(2).setMinWidth(120);
        tableResult.getColumnModel().getColumn(2).setPreferredWidth(120);
        tableResult.getColumnModel().getColumn(2).setMaxWidth(120);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Total:");

        lblValorTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblValorTotal.setForeground(java.awt.Color.red);
        lblValorTotal.setText("R$0,00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 863, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelSuperButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelSuperButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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

    private void jtxtPeriodoInicioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtPeriodoInicioFocusLost
        // TODO add your handling code here:
        if (!MetodosUtil.validData(jtxtPeriodoInicio.getText())) {
            JOptionPane.showMessageDialog(this, MensagensUtil.MENSAGEM_ERRO_DATA_INVALIDA, MensagensUtil.ATENCAO, 2);
            
            jtxtPeriodoInicio.setValue(null);
            jtxtPeriodoInicio.requestFocus();
        }
}//GEN-LAST:event_jtxtPeriodoInicioFocusLost

    private void jtxtPeriodoFimFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtPeriodoFimFocusLost
        // TODO add your handling code here:
        if (!MetodosUtil.validData(jtxtPeriodoFim.getText())) {
            JOptionPane.showMessageDialog(this, MensagensUtil.MENSAGEM_ERRO_DATA_INVALIDA, MensagensUtil.ATENCAO, 2);
            
            jtxtPeriodoFim.setValue(null);
            jtxtPeriodoFim.requestFocus();
        }
}//GEN-LAST:event_jtxtPeriodoFimFocusLost

    private void jtxtCodigoRevendedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtCodigoRevendedorKeyReleased
        MetodosUtil.validNumeric(jtxtCodigoRevendedor);
        MetodosUtil.defineSizeMax(6, jtxtCodigoRevendedor);
}//GEN-LAST:event_jtxtCodigoRevendedorKeyReleased

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        // TODO add your handling code here:
        try {
            if(result != null)
                if(!result.isEmpty()){

                    GerarRelatorio func = new GerarRelatorio();
                    func.gerarRelatorioVendaPorRevendedor(result, lblValorTotal.getText());

                }
        } catch (JRException ex) {
            Logger.getLogger(FormRelatorioVendaPorRevendedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnImprimirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField jtxtCodigoRevendedor;
    private javax.swing.JFormattedTextField jtxtPeriodoFim;
    private javax.swing.JFormattedTextField jtxtPeriodoInicio;
    private javax.swing.JLabel lblCodigoRevendedor;
    private javax.swing.JLabel lblDataNascimento;
    private javax.swing.JLabel lblDataNascimento1;
    private javax.swing.JLabel lblValorTotal;
    private javax.swing.JPanel panelSuperButton;
    private javax.swing.JTable tableResult;
    // End of variables declaration//GEN-END:variables

    @Override
    public void search() {
        try {
            if(validarTela()){
                
                limparGrid();
                pushToModel();
                
                buscar();
            }   
            
            
        } catch (Exception ex) {
            Logger.getLogger(FormRelatorioVendaPorRevendedor.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "erro", MensagensUtil.ERRO, 0);
        }
    }
    
    private boolean validarTela(){
        
        StringBuilder stringError = new StringBuilder();
        
        if(jtxtPeriodoInicio.getText().replace("/", "").trim().isEmpty()
                && jtxtPeriodoFim.getText().replace("/", "").trim().isEmpty()){
            
            stringError.append(MessageVenda.CAMPO_PERIODO_DE_VENDA_OBRIGATORIO);
        }
            
        
        if((jtxtPeriodoInicio.getText().replace("/", "").trim().isEmpty() && 
                !jtxtPeriodoFim.getText().replace("/", "").trim().isEmpty())
                || (!jtxtPeriodoInicio.getText().replace("/", "").trim().isEmpty() && 
                jtxtPeriodoFim.getText().replace("/", "").trim().isEmpty())){
            
            stringError.append(MessageVenda.CAMPO_PERIODO_DE_VENDA_INCOMPLETO);
         
            if(jtxtPeriodoInicio.getText().replace("/", "").trim().isEmpty())
                jtxtPeriodoInicio.requestFocus();
            
            if(jtxtPeriodoFim.getText().replace("/", "").trim().isEmpty())
                jtxtPeriodoFim.requestFocus();
        }
        
        if (!stringError.toString().isEmpty()) {
            JOptionPane.showMessageDialog(this, stringError, MensagensUtil.ATENCAO, 2);
        }

        return stringError.toString().isEmpty();
    }
    
    private void pushToModel() {
        parameter = new ModelRelatorioPedidoRevendedor();
        
        if (!jtxtPeriodoInicio.getText().replace("/", "").trim().isEmpty()) {
            String[] dateAux = jtxtPeriodoInicio.getText().split("/");
            GregorianCalendar c = new GregorianCalendar();
            c.set(Integer.parseInt(dateAux[2]), Integer.parseInt(dateAux[1]) - 1, Integer.parseInt(dateAux[0]));            
            parameter.setDataPedidoInicio(DateUtil.dateAsXMLGregorianCalendar(c.getTime()));
        }
        
        if (!jtxtPeriodoFim.getText().replace("/", "").trim().isEmpty()) {
            String[] dateAux = jtxtPeriodoFim.getText().split("/");
            GregorianCalendar c = new GregorianCalendar();
            c.set(Integer.parseInt(dateAux[2]), Integer.parseInt(dateAux[1]) - 1, Integer.parseInt(dateAux[0]));            
            parameter.setDataPedidoFim(DateUtil.dateAsXMLGregorianCalendar(c.getTime()));
        }
        
        if(!jtxtCodigoRevendedor.getText().trim().isEmpty())
            parameter.setCodigoRevendedor(jtxtCodigoRevendedor.getText().trim().toString());
    }
    
    private void buscar() {
        
        SwingWorkerPedidoVenda<PedidoVenda> work = new SwingWorkerPedidoVenda<PedidoVenda>();
        work.setFormRelatorioVendaPorRevendedor(this);
        work.setModelRelatorioPedidoRevendedor(parameter);
        work.workRecRelatorioPedidosPorRevendedor.execute(); 
        
    }
    
    public void processaList(List<PedidoVenda> list){
        result = list;
            
        if(result.size() > 0){
            popularTela(result);
            btnImprimir.setEnabled(true);
        }
        else {
            JOptionPane.showMessageDialog(this, MensagensUtil.MENSAGEM_NENHUM_REGISTRO, MensagensUtil.ATENCAO, 1);
            btnImprimir.setEnabled(false);
        }
    }

    @Override
    public void close() {
        this.dispose();
    }

    @Override
    public void initialize() {
        MetodosUtil.enterPularCampos(this);
        //define letras maiusculas
        MetodosUtil.letrasMaiusculas(this.getContentPane()); 
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //Popular dados na tela
    private void popularTela(List<PedidoVenda> result) {
        float valorTotal = 0;
        for (PedidoVenda pedidoVenda : result) {
            DefaultTableModel dtm = (DefaultTableModel) tableResult.getModel();

            dtm.addRow(new Object[]{
                        pedidoVenda.getRevendedor().getCodigo(),
                        pedidoVenda.getRevendedor().getPessoa().getNome(),
                        pedidoVenda.getTotal()
                    });
            
            //soma valor total
            valorTotal = valorTotal + pedidoVenda.getTotal();
        }
        
        lblValorTotal.setText("R$" + MetodosUtil.formatarValorDinheiro(valorTotal));
    }
    
    /**
     * limpa os dados da grid
     */
    private void limparGrid(){
        DefaultTableModel dtm = (DefaultTableModel) tableResult.getModel();
        int x = dtm.getRowCount();  
        for(int a = 0; a < x; a++)  
        {  
            dtm.removeRow(0);  
        }  
    }

    @Override
    public void showFrame() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
