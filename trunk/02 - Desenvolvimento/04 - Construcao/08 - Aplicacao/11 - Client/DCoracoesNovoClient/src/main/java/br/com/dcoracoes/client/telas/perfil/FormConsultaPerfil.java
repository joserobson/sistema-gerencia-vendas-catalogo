/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FormConsultaPerfil.java
 *
 * Created on 17/04/2012, 21:44:03
 */
package br.com.dcoracoes.client.telas.perfil;

import br.com.dcoracoes.client.interfaces.InterfaceConsultaSimples;
import br.com.dcoracoes.client.swingworker.SwingWorkerPerfil;
import br.com.dcoracoes.client.util.MensagensUtil;
import br.com.dcoracoes.client.util.MetodosUtil;
import br.com.dcoracoes.client.util.message.MessagePerfil;
import br.com.dcoracoes.servico.service.Perfil;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
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
public class FormConsultaPerfil extends javax.swing.JDialog implements InterfaceConsultaSimples {

    private Perfil perfil;
    private List<Perfil> list;
    private FormPerfil formPerfil;

    /** Creates new form FormConsultaPerfil */
    public FormConsultaPerfil(boolean modal, FormPerfil formPerfil) {
        initComponents();
        this.formPerfil = formPerfil;
        setLocationRelativeTo(null);
        setModal(modal);   
        setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage("src/main/resources/imagens/outras/icon_SGC.gif"));     
        tableResult.addMouseListener(new DoubleClickMouseAdapter(tableResult));
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
        btnEditar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblConsultor = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jtxtCodigo = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableResult = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Perfil");

        panelSuperButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, new java.awt.Color(43, 115, 186)));

        btnEditar.setFont(new java.awt.Font("Tahoma", 1, 14));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/32x32/system-search.png"))); // NOI18N
        btnEditar.setText("BUSCAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
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
            .addGap(0, 208, Short.MAX_VALUE)
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
            .addGap(0, 94, Short.MAX_VALUE)
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
            .addGap(0, 93, Short.MAX_VALUE)
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
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelSuperButtonLayout.setVerticalGroup(
            panelSuperButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSuperButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEditar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        lblConsultor.setText("NOME:");

        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeKeyReleased(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CÓDIGO:");

        jtxtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtCodigoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lblConsultor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jtxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblConsultor)
                .addComponent(jLabel1))
        );

        tableResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Descrição"
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
        tableResult.getColumnModel().getColumn(0).setMinWidth(100);
        tableResult.getColumnModel().getColumn(0).setPreferredWidth(100);
        tableResult.getColumnModel().getColumn(0).setMaxWidth(100);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
                    .addComponent(panelSuperButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        search();
}//GEN-LAST:event_btnEditarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
        close();
}//GEN-LAST:event_btnSairActionPerformed

    private void txtNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyReleased
        // TODO add your handling code here:
        MetodosUtil.defineSizeMax(50, txtNome);
    }//GEN-LAST:event_txtNomeKeyReleased

    private void jtxtCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtCodigoKeyReleased
        MetodosUtil.validNumeric(jtxtCodigo);
        MetodosUtil.defineSizeMax(6, jtxtCodigo);
}//GEN-LAST:event_jtxtCodigoKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField jtxtCodigo;
    private javax.swing.JLabel lblConsultor;
    private javax.swing.JPanel panelSuperButton;
    private javax.swing.JTable tableResult;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables

    @Override
    public void close() {
        this.dispose();
    }

    @Override
    public void initialize() {
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
            limparGrid();
            pushToModel();
            bucarPerfil(perfil);
        } catch (Exception ex) {
            Logger.getLogger(FormConsultaPerfil.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, MessagePerfil.ERRO_CONSULTA_PERFIL, MensagensUtil.ERRO, 0);
        }
    }

    /**
     * recupera os filtros dá tela
     */
    private void pushToModel() {
        perfil = new Perfil();

        //Codigo
        if (!jtxtCodigo.getText().isEmpty()) {
            perfil.setId(Long.parseLong(jtxtCodigo.getText()));
        }

        //Nome
        if (!txtNome.getText().isEmpty()) {
            perfil.setNomePerfil(txtNome.getText());
        }

    }

    /**
     * faz a busca de perfil no server
     * @return 
     */
    private void bucarPerfil(Perfil perfil) throws Exception {
        try {             
            SwingWorkerPerfil<Perfil> work = new SwingWorkerPerfil<Perfil>(perfil);
            work.setFormConsultaPerfil(this);
            work.workRecPerfil.execute();
        } catch (Exception ex) {
            throw ex;
        }
    }

    /**
     * popula a lista na tela
     * @param list 
     */
    public void popularTela(List<Perfil> list) {
        
        if(list.isEmpty())
            JOptionPane.showMessageDialog(this, MensagensUtil.MENSAGEM_NENHUM_REGISTRO, MensagensUtil.ATENCAO, 1);
        else{
            this.list = list;
            for (Perfil perfil : list) {
                popularTela(perfil);
            }
        }
    }

    /**
     * Popula o objeto Perfil na tela
     * @param perfil 
     */
    private void popularTela(Perfil perfil) {
        DefaultTableModel dtm = (DefaultTableModel) tableResult.getModel();

        dtm.addRow(new Object[]{
                    perfil.getId().toString(),
                    perfil.getNomePerfil(),
                    perfil.getDescricao()
                });

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
        setLocationRelativeTo(null);        
        setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage("src/main/resources/imagens/outras/icon_SGC.gif"));
        tableResult.addMouseListener(new DoubleClickMouseAdapter(tableResult));   
        initialize();
        this.setVisible(true);
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

                formPerfil.setPerfil(list.get(row));
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
            search();
        }
    }
}
