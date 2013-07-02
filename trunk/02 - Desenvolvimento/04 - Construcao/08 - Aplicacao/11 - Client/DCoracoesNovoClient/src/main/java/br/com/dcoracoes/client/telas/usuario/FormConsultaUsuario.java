/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FormConsultaUsuario.java
 *
 * Created on 17/04/2012, 21:44:03
 */
package br.com.dcoracoes.client.telas.usuario;

import br.com.dcoracoes.client.interfaces.InterfaceConsultaSimples;
import br.com.dcoracoes.client.swingworker.SwingWorkerPerfil;
import br.com.dcoracoes.client.swingworker.SwingWorkerUsuario;
import br.com.dcoracoes.client.util.LogUtil;
import br.com.dcoracoes.client.util.MensagensUtil;
import br.com.dcoracoes.client.util.MetodosUtil;
import br.com.dcoracoes.client.util.message.MessageUsuario;
import br.com.dcoracoes.servico.service.Perfil;
import br.com.dcoracoes.servico.service.Pessoa;
import br.com.dcoracoes.servico.service.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cleberson
 */
public class FormConsultaUsuario extends javax.swing.JDialog implements InterfaceConsultaSimples {

    private Usuario usuario;
    private List<Usuario> listUsuarios;
    private FormUsuario formUsuario;
    private List<Perfil> listPerfil;

    /**
     * Creates new form FormConsultaUsuario
     */
    public FormConsultaUsuario(boolean modal, FormUsuario formUsuario) {
        initComponents();
        recPerfis();  
        setModal(modal);
        this.formUsuario = formUsuario;        
    }

    public List<Perfil> getListPerfil() {
        return listPerfil;
    }

    public void setListPerfil(List<Perfil> listPerfil) {
        this.listPerfil = listPerfil;
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
        jLabel1 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbPerfil = new javax.swing.JComboBox();
        lblConsultor = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableResult = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Usuário");

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
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jLabel1.setText("LOGIN:");

        txtLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLoginKeyReleased(evt);
            }
        });

        jLabel5.setText("PERFIL:");

        lblConsultor.setText("NOME:");

        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeKeyReleased(evt);
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
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblConsultor)
                        .addGap(4, 4, 4)
                        .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblConsultor))
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        tableResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Login", "Nome", "Perfil"
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
        tableResult.getColumnModel().getColumn(0).setMinWidth(100);
        tableResult.getColumnModel().getColumn(0).setPreferredWidth(100);
        tableResult.getColumnModel().getColumn(0).setMaxWidth(100);
        tableResult.getColumnModel().getColumn(1).setMinWidth(100);
        tableResult.getColumnModel().getColumn(1).setPreferredWidth(100);
        tableResult.getColumnModel().getColumn(1).setMaxWidth(100);
        tableResult.getColumnModel().getColumn(3).setMinWidth(150);
        tableResult.getColumnModel().getColumn(3).setPreferredWidth(150);
        tableResult.getColumnModel().getColumn(3).setMaxWidth(150);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
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

    private void txtLoginKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLoginKeyReleased
        MetodosUtil.defineSizeMax(10, txtLogin);
}//GEN-LAST:event_txtLoginKeyReleased

    private void txtNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyReleased
        MetodosUtil.defineSizeMax(150, txtNome);
}//GEN-LAST:event_txtNomeKeyReleased
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSair;
    private javax.swing.JComboBox cbPerfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblConsultor;
    private javax.swing.JPanel panelSuperButton;
    private javax.swing.JTable tableResult;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables

    @Override
    public void close() {
        this.dispose();
    }

    @Override
    public void initialize() {                
        
        populaComboPerfil();
        
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
            SwingWorkerUsuario<Usuario> workUsuario = new SwingWorkerUsuario<Usuario>(usuario);
            workUsuario.setFormConsultaUsuario(this);
            workUsuario.workSearchUsuarios.execute();            

        } catch (Exception ex) {
            LogUtil.logDescricaoErro(this.getClass(), ex);
            JOptionPane.showMessageDialog(this, MessageUsuario.ERRO_CONSULTAR_USUARIO, MensagensUtil.ERRO, 0);
        }
    }

    /**
     * popula telas
     * @param lstUsuarios 
     */
    public void populaTela(List<Usuario> lstUsuarios) {        
        this.listUsuarios = lstUsuarios;
        if (listUsuarios.size() > 0) {
            popularTela(listUsuarios);
        } else {
            JOptionPane.showMessageDialog(this, MensagensUtil.MENSAGEM_NENHUM_REGISTRO, MensagensUtil.ATENCAO, 1);
        }
    }

    /**
     * recupera os filtros dá tela
     */
    private void pushToModel() {
        usuario = new Usuario();

        //Logon
        if (!txtLogin.getText().isEmpty()) {
            usuario.setLogin(txtLogin.getText());
        }

        //Perfil
        if (cbPerfil.getSelectedIndex() != 0) {
            usuario.setPerfil(listPerfil.get(cbPerfil.getSelectedIndex() - 1));
        }

        //Nome
        if (!txtNome.getText().isEmpty()) {
            usuario.setPessoa(new Pessoa());
            usuario.getPessoa().setNome(txtNome.getText());
        }

    }


    /**
     * popula a lista na tela
     *
     * @param list
     */
    private void popularTela(List<Usuario> list) {
        for (Usuario usuario : list) {
            popularTela(usuario);
        }
    }

    /**
     * Popula o objeto Usuario na tela
     *
     * @param usuario
     */
    private void popularTela(Usuario usuario) {
        DefaultTableModel dtm = (DefaultTableModel) tableResult.getModel();

        dtm.addRow(new Object[]{
                    usuario.getId().toString(),
                    usuario.getLogin(),
                    usuario.getPessoa().getNome(),
                    usuario.getPerfil().getNomePerfil()
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

                formUsuario.setUsuario(listUsuarios.get(row));
                close();
            }
        }
    }

    /**
     * Buscar perfis
     */
    private void recPerfis() {
         SwingWorkerPerfil work = new SwingWorkerPerfil(new Perfil());
         work.setFormConsultaUsuario(this);
         work.workRecPerfil.execute();
    }

    public void populaComboPerfil() {        
        cbPerfil.removeAllItems();
        cbPerfil.addItem("selecione");
        for (Perfil perfil : listPerfil) {
            cbPerfil.addItem(perfil.getNomePerfil());
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
            btnBuscarActionPerformed(e);
        }
    }
}
