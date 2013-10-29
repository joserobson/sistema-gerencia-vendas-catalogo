/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FormConsultaRevendedor.java
 *
 * Created on 17/04/2012, 21:44:03
 */
package br.com.dcoracoes.client.telas.revendedor;

import br.com.dcoracoes.client.interfaces.InterfaceConsultaSimples;
import br.com.dcoracoes.client.swingworker.SwingWorkerRevendedor;
import br.com.dcoracoes.client.telas.prospeccoes.FormProspeccoes;
import br.com.dcoracoes.client.util.MensagensUtil;
import br.com.dcoracoes.client.util.MetodosUtil;
import br.com.dcoracoes.client.util.message.MessageRevendedor;
import br.com.dcoracoes.servico.service.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.lang.Exception;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cleberson
 */
public class FormConsultaRevendedor extends javax.swing.JDialog implements InterfaceConsultaSimples {

    private Revendedor revendedor;
    private List<ViewRevendedor> list;
    private FormRevendedor formRevendedor;
    private FormProspeccoes formProspeccoes;

    /** Creates new form FormConsultaRevendedor */
    public FormConsultaRevendedor(boolean modal, FormRevendedor formRevendedorm) {
        initComponents();
        this.formRevendedor = formRevendedorm;
        setLocationRelativeTo(null);
        setModal(modal);
        setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage("src/main/resources/imagens/outras/icon_SGC.gif"));
        tableResult.addMouseListener(new DoubleClickMouseAdapter(tableResult));
        initialize();
    }

    public FormConsultaRevendedor(boolean modal, FormProspeccoes formProspeccoes) {
        initComponents();
        this.formProspeccoes = formProspeccoes;
        setLocationRelativeTo(null);
        setModal(modal);
        tableResult.addMouseListener(new DoubleClickMouseAdapter(tableResult));
        initialize();
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
        jPanel1 = new javax.swing.JPanel();
        lblConsultor = new javax.swing.JLabel();
        txtRevendedor = new javax.swing.JTextField();
        lblCPF = new javax.swing.JLabel();
        jtxtCPF = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jtxtCodigoRevendedor = new javax.swing.JFormattedTextField();
        lblCidade = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        lblCEP = new javax.swing.JLabel();
        jtxtCEP = new javax.swing.JFormattedTextField();
        lblBairro = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        jtxtTelefone = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableResult = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Revendedor");
        setIconImage(null);

        panelSuperButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, new java.awt.Color(43, 115, 186)));

        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/32x32/system-search.png"))); // NOI18N
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
            .addGap(0, 0, Short.MAX_VALUE)
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
            .addGap(0, 0, Short.MAX_VALUE)
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
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
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

        lblCPF.setText("CPF:");

        try {
            jtxtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CÓDIGO REVENDEDOR(A):");

        jtxtCodigoRevendedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtCodigoRevendedorKeyReleased(evt);
            }
        });

        lblCidade.setText("CIDADE:");

        txtCidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCidadeKeyReleased(evt);
            }
        });

        lblCEP.setText("CEP:");

        try {
            jtxtCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jtxtCEP.setPreferredSize(new java.awt.Dimension(50, 20));
        jtxtCEP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtCEPKeyReleased(evt);
            }
        });

        lblBairro.setText("BAIRRO:");

        txtBairro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBairroKeyReleased(evt);
            }
        });

        try {
            jtxtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("## ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel11.setText("TELEFONE:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblConsultor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRevendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtxtCodigoRevendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblCPF)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtxtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblCidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCEP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblBairro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtxtCodigoRevendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCPF))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblConsultor))
                    .addComponent(txtRevendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCEP)
                        .addComponent(jtxtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblCidade)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(jtxtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblBairro)))
                .addGap(19, 19, 19))
        );

        tableResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código Revendedor", "Nome Revendedor", "CPF", "Cidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableResult);
        tableResult.getColumnModel().getColumn(0).setMinWidth(150);
        tableResult.getColumnModel().getColumn(0).setPreferredWidth(150);
        tableResult.getColumnModel().getColumn(0).setMaxWidth(150);
        tableResult.getColumnModel().getColumn(2).setMinWidth(100);
        tableResult.getColumnModel().getColumn(2).setPreferredWidth(100);
        tableResult.getColumnModel().getColumn(2).setMaxWidth(100);
        tableResult.getColumnModel().getColumn(3).setMinWidth(150);
        tableResult.getColumnModel().getColumn(3).setPreferredWidth(150);
        tableResult.getColumnModel().getColumn(3).setMaxWidth(150);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if(validCamposInformados()){
            limparGrid();
            search();
        }
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

    private void txtCidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCidadeKeyReleased
        MetodosUtil.defineSizeMax(150, txtCidade);
    }//GEN-LAST:event_txtCidadeKeyReleased

    private void jtxtCEPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtCEPKeyReleased
        MetodosUtil.defineSizeMax(20, jtxtCEP);
    }//GEN-LAST:event_jtxtCEPKeyReleased

    private void txtBairroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBairroKeyReleased
        MetodosUtil.defineSizeMax(50, txtBairro);
    }//GEN-LAST:event_txtBairroKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField jtxtCEP;
    private javax.swing.JFormattedTextField jtxtCPF;
    private javax.swing.JFormattedTextField jtxtCodigoRevendedor;
    private javax.swing.JFormattedTextField jtxtTelefone;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCEP;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblConsultor;
    private javax.swing.JPanel panelSuperButton;
    private javax.swing.JTable tableResult;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCidade;
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
        try {
            pushToModel();
            bucarRevendedor(revendedor);
        } catch (Exception ex) {
            Logger.getLogger(FormConsultaRevendedor.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, MessageRevendedor.ERRO_CONSULTAR_REVENDEDOR, MensagensUtil.ERRO, 0);
        }
    }
    
    public void populaTela(List<ViewRevendedor> lstViewRevendedor){
        list = lstViewRevendedor;
        if (list.size() > 0) {
            popularTela(list);
        } else {
            JOptionPane.showMessageDialog(this, MensagensUtil.MENSAGEM_NENHUM_REGISTRO, MensagensUtil.ATENCAO, 1);
        }
    }

    /**
     * recupera os filtros dá tela
     */
    private void pushToModel() {
        revendedor = new Revendedor();

        //Codigo
        if (!jtxtCodigoRevendedor.getText().isEmpty()) {
            revendedor.setCodigo(Integer.parseInt(jtxtCodigoRevendedor.getText()));
        }

        PessoaFisica pessoa = new PessoaFisica();
        revendedor.setPessoa(pessoa);
        //CPF
        if (!jtxtCPF.getText().replace(".", "").replace("-", "").trim().isEmpty()) {
            ((PessoaFisica) revendedor.getPessoa()).setCpf(jtxtCPF.getText());
        }

        //Nome
        if (!txtRevendedor.getText().isEmpty()) {
            ((PessoaFisica) revendedor.getPessoa()).setNome(txtRevendedor.getText());
        }
    
        Endereco endereco = null;
        //Cidade
        if (!txtCidade.getText().trim().isEmpty()) {
            if(endereco == null)
                endereco = new Endereco();
            
            endereco.setCidade(txtCidade.getText());
        }
        
        //CEP
        if (!jtxtCEP.getText().trim().replace("-", "").isEmpty()) {
            if(endereco == null)
                endereco = new Endereco();
            
            endereco.setCep(jtxtCEP.getText());
        }
        
        //Bairro
        if (!txtBairro.getText().trim().isEmpty()) {
            if(endereco == null)
                endereco = new Endereco();
            
            endereco.setBairro(txtBairro.getText());
        }
        
        if(endereco != null)
            revendedor.getPessoa().setEndereco(endereco);
        
        //Telefone
        if (!jtxtTelefone.getText().replace("-", "").trim().isEmpty()) {
            Telefone telefone = new Telefone();
            
            revendedor.getPessoa().getTelefones().add(telefone);
        }
    }

    /**
     * faz a busca de revendedor no server
     * @return 
     */
    private void bucarRevendedor(Revendedor revendedor) {
        SwingWorkerRevendedor<ViewRevendedor> workRevendedor = new SwingWorkerRevendedor<ViewRevendedor> (revendedor);
        workRevendedor.setFormConsultaRevendedor(this);
        workRevendedor.workSearchViewRevendedor.execute(); 
    }

    /**
     * popula a lista na tela
     * @param list 
     */
    private void popularTela(List<ViewRevendedor> list) {
        for (ViewRevendedor viewRevendedor : list) {
            popularTela(viewRevendedor);
        }
    }

    /**
     * Popula o objeto Revendedor na tela
     * @param viewRevendedor 
     */
    private void popularTela(ViewRevendedor viewRevendedor) {
        DefaultTableModel dtm = (DefaultTableModel) tableResult.getModel();

        dtm.addRow(new Object[]{
                    MetodosUtil.gerarCodigoFormatoPadrao(viewRevendedor.getRevendedor().getCodigo()),
                    ((PessoaFisica) viewRevendedor.getRevendedor().getPessoa()).getNome(),
                    ((PessoaFisica) viewRevendedor.getRevendedor().getPessoa()).getCpf(),
                    ((PessoaFisica) viewRevendedor.getRevendedor().getPessoa()).getEndereco().getCidade()
                });

    }

    /**
     * valida se foi informado ao menos um filtro para consulta
     * @return 
     */
    private boolean  validCamposInformados(){
        boolean value = true;
        if(jtxtCodigoRevendedor.getText().trim().isEmpty()
                && jtxtCPF.getText().replace(".", "").replace("-", "").trim().isEmpty()
                && txtRevendedor.getText().trim().isEmpty()
                && txtCidade.getText().trim().isEmpty()
                && jtxtCEP.getText().replace("-", "").trim().isEmpty()
                && txtBairro.getText().trim().isEmpty()
                && jtxtTelefone.getText().replace("-", "").trim().isEmpty()){
            value = false;
            JOptionPane.showMessageDialog(this, MensagensUtil.INFORMAR_PARAMETROS_CONSULTA, MensagensUtil.ATENCAO, 1);
        }
        
        return value;
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
                if (formRevendedor != null) {
                    formRevendedor.setRevendedor(list.get(row));
                } else {
                    if (formProspeccoes != null) {
                        formProspeccoes.setRevendedor(list.get(row).getRevendedor());
                    }
                }
                close();
            }
        }
    }
    
    /********************************************************************************
     * monta os atalhos da tela
     */
    private void createAtalhos(){
        InputMap imap = rootPane.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);  
        imap.put(KeyStroke.getKeyStroke("ENTER"), "buttonEnterPress");   
        ActionMap amap = rootPane.getActionMap();  
        amap.put("buttonEnterPress", new EnterKey());        
        
    }    
    
    /**
     * tratamento do atalho para tecla ENTER
     */
    private class EnterKey extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            btnBuscarActionPerformed(e);
        }
    }
}
