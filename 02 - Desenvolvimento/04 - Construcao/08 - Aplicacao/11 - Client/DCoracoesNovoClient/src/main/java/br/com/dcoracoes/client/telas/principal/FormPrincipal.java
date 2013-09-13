/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FormPrincipal.java
 *
 * Created on 25/02/2012, 12:53:20
 */
package br.com.dcoracoes.client.telas.principal;

import br.com.dcoracoes.client.App;
import br.com.dcoracoes.client.ControleAcesso;
import br.com.dcoracoes.client.classes.serverimpl.PerfilServerImpl;
import br.com.dcoracoes.client.classes.serverimpl.PermissaoServerImpl;
import br.com.dcoracoes.client.classes.serverimpl.RevendedorServerImpl;
import br.com.dcoracoes.client.swingworker.BaseSwingWorker;
import br.com.dcoracoes.client.telas.compra.FormCompra;

import br.com.dcoracoes.client.telas.login.FormLogin;
import br.com.dcoracoes.client.telas.perfil.FormPerfil;
import br.com.dcoracoes.client.telas.produto.FormProduto;
import br.com.dcoracoes.client.telas.prospeccoes.FormProspeccoes;
import br.com.dcoracoes.client.telas.relatorio.FormRelatorioProduto;
import br.com.dcoracoes.client.telas.relatorio.FormRelatorioVendaPorRevendedor;
import br.com.dcoracoes.client.telas.revendedor.FormRevendedor;
import br.com.dcoracoes.client.telas.revendedor.FormFiltroGerarEtiquetas;
import br.com.dcoracoes.client.telas.usuario.FormUsuario;
import br.com.dcoracoes.client.telas.venda.FormVenda;
import br.com.dcoracoes.client.util.LogUtil;
import br.com.dcoracoes.client.util.MensagensUtil;
import br.com.dcoracoes.servico.service.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.Exception;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author Cleberson
 */
public class FormPrincipal extends javax.swing.JFrame {

    private BaseSwingWorker workTelaAguarde;
    //Formularios
    private FormRevendedor formRevendedor = null;
    private FormProduto formProduto = null;
    private FormPerfil formPerfil = null;
    private FormUsuario formUsuario = null;
    private FormVenda formVenda = null;
    private FormCompra formCompra = null;
    private FormProspeccoes formProspeccoes = null;
    private FormFiltroGerarEtiquetas formEtiqueta = null;
    private FormRelatorioVendaPorRevendedor formRelatorioVenda = null;
    private FormRelatorioProduto formRelatorioProduto = null;

    public FormProspeccoes getFormProspeccoes() {
        return formProspeccoes;
    }

    public void setFormProspeccoes(FormProspeccoes formProspeccoes) {
        this.formProspeccoes = formProspeccoes;
    }

    public void setFormRevendedor(FormRevendedor formRevendedor) {
        this.formRevendedor = formRevendedor;
    }

    public FormRevendedor getFormRevendedor() {
        return formRevendedor;
    }    
    
    public FormPerfil getFormPerfil() {
        return formPerfil;
    }

    public void setFormPerfil(FormPerfil formPerfil) {
        this.formPerfil = formPerfil;
    }

    public FormProduto getFormProduto() {
        return formProduto;
    }

    public void setFormProduto(FormProduto formProduto) {
        this.formProduto = formProduto;
    }

    public FormUsuario getFormUsuario() {
        return formUsuario;
    }

    public void setFormUsuario(FormUsuario formUsuario) {
        this.formUsuario = formUsuario;
    }

    public FormVenda getFormVenda() {
        return formVenda;
    }

    public void setFormVenda(FormVenda formVenda) {
        this.formVenda = formVenda;
    }

    public FormCompra getFormCompra() {
        return formCompra;
    }

    public void setFormCompra(FormCompra formCompra) {
        this.formCompra = formCompra;
    }

    /**
     * Creates new form FormPrincipal
     */
    public FormPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH);
        initialize();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnrevendedor = new javax.swing.JButton();
        btnProduto = new javax.swing.JButton();
        btnVenda = new javax.swing.JButton();
        btnCompra = new javax.swing.JButton();
        btnProspeccoes = new javax.swing.JButton();
        btnPerfil = new javax.swing.JButton();
        btnUsuario = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbUser = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        jMenu_Arquivo = new javax.swing.JMenu();
        jMenuItem_Logout = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem_Sair = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem_Etiqueta = new javax.swing.JMenuItem();
        jMenuItem_VendaRevendedor = new javax.swing.JMenuItem();
        jMenuItem_Produto = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("D'Corações");
        setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage("src/main/resources/imagens/outras/icon_SGC.gif"));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btnrevendedor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnrevendedor.setText("Revendedores");
        btnrevendedor.setAlignmentX(0.5F);
        btnrevendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrevendedorActionPerformed(evt);
            }
        });

        btnProduto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnProduto.setText("Produtos");
        btnProduto.setAlignmentX(0.5F);
        btnProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdutoActionPerformed(evt);
            }
        });

        btnVenda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnVenda.setText("Vendas");
        btnVenda.setAlignmentX(0.5F);
        btnVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVendaActionPerformed(evt);
            }
        });

        btnCompra.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCompra.setText("Compras");
        btnCompra.setAlignmentX(0.5F);
        btnCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompraActionPerformed(evt);
            }
        });

        btnProspeccoes.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnProspeccoes.setText("Prospecções");
        btnProspeccoes.setAlignmentX(0.5F);
        btnProspeccoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProspeccoesActionPerformed(evt);
            }
        });

        btnPerfil.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnPerfil.setText("Perfis de Usuário");
        btnPerfil.setAlignmentX(0.5F);
        btnPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerfilActionPerformed(evt);
            }
        });

        btnUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUsuario.setText("Usuários");
        btnUsuario.setAlignmentX(0.5F);
        btnUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnrevendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProspeccoes, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPerfil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(btnrevendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProspeccoes, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(444, 444, 444))
        );

        jPanel3.setBackground(new java.awt.Color(247, 247, 246));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Papyrus", 1, 14)); // NOI18N
        jLabel2.setText("Usuário:");

        lbUser.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbUser, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(613, 613, 613))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        jMenuBar.setBackground(new java.awt.Color(43, 116, 185));

        jMenu_Arquivo.setBackground(new java.awt.Color(43, 116, 185));
        jMenu_Arquivo.setForeground(new java.awt.Color(255, 255, 255));
        jMenu_Arquivo.setText("D'Corações");
        jMenu_Arquivo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jMenuItem_Logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/16x16/system-log-out.png"))); // NOI18N
        jMenuItem_Logout.setText("Logout");
        jMenuItem_Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_LogoutActionPerformed(evt);
            }
        });
        jMenu_Arquivo.add(jMenuItem_Logout);
        jMenu_Arquivo.add(jSeparator1);

        jMenuItem_Sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/32x32/close.png"))); // NOI18N
        jMenuItem_Sair.setText("Sair");
        jMenuItem_Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_SairActionPerformed(evt);
            }
        });
        jMenu_Arquivo.add(jMenuItem_Sair);

        jMenuBar.add(jMenu_Arquivo);

        jMenu1.setBackground(new java.awt.Color(43, 116, 185));
        jMenu1.setForeground(new java.awt.Color(255, 255, 255));
        jMenu1.setText("Relatórios");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jMenuItem_Etiqueta.setText("Etiquetas de Endereço de Revendedores");
        jMenuItem_Etiqueta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_EtiquetaActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem_Etiqueta);

        jMenuItem_VendaRevendedor.setText("Relatório de Venda por Revendedor");
        jMenuItem_VendaRevendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_VendaRevendedorActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem_VendaRevendedor);

        jMenuItem_Produto.setText("Relatório de Produto e Estoque");
        jMenuItem_Produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_ProdutoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem_Produto);

        jMenuBar.add(jMenu1);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnrevendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrevendedorActionPerformed
        
        SwingWorker<Object, Void> worker = new SwingWorker<Object, Void>() {

            @Override
            protected Object doInBackground() throws Exception {
                try {
                    workTelaAguarde.habilitaTelaAguarde(getFramePrincipal());                    
                    return new RevendedorServerImpl().recUltimoRevendedorCadastro();
                } catch (Exception ex) {
                    workTelaAguarde.desabilitaTelaAguarde(getFramePrincipal());
                    throw ex;
                }
            }

            @Override
            protected void done() {
                try {
                    if (formRevendedor == null) {
                        formRevendedor = new FormRevendedor((FormPrincipal)getFramePrincipal());
                    }

                    if (get() != null) {
                        formRevendedor.setRevendedor((ViewRevendedor)get());
                    } else
                        formRevendedor.createNew();
                    
                    workTelaAguarde.desabilitaTelaAguarde(getFramePrincipal());
                    formRevendedor.showFrame();                    

                } catch (Exception ex) {
                    LogUtil.logDescricaoErro(this.getClass(), ex);
                    JOptionPane.showMessageDialog(formPerfil, MensagensUtil.MENSAGEM_ERRO_ABRIR_TELA, MensagensUtil.ERRO, 0);
                }
            }
        };

        worker.execute();
    }//GEN-LAST:event_btnrevendedorActionPerformed

    private void btnProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdutoActionPerformed
        // TODO add your handling code here:
        try {
            if (formProduto == null) {
                formProduto = new FormProduto();
            }
            formProduto.showFrame();
        } catch (Exception ex) {
            LogUtil.logDescricaoErro(this.getClass(), ex);
            JOptionPane.showMessageDialog(this, MensagensUtil.MENSAGEM_ERRO_ABRIR_TELA, MensagensUtil.ERRO, 0);
        }
    }//GEN-LAST:event_btnProdutoActionPerformed

    private void btnPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerfilActionPerformed

        SwingWorker<Object, Void> worker = new SwingWorker<Object, Void>() {

            @Override
            protected Object doInBackground() throws Exception {
                try {
                    workTelaAguarde.habilitaTelaAguarde(getFramePrincipal());
                    return new PermissaoServerImpl<Permissao>().recTodasPemissoes();
                } catch (Exception ex) {
                    workTelaAguarde.desabilitaTelaAguarde(getFramePrincipal());
                    throw ex;
                }
            }

            @Override
            protected void done() {
                try {
                    List<Permissao> permissoes = (List<Permissao>) get();
                    if (formPerfil == null) {
                        formPerfil = new FormPerfil();
                        formPerfil.setTodasPermissoes(permissoes);
                    }
                    
                    workTelaAguarde.desabilitaTelaAguarde(getFramePrincipal());
                    formPerfil.showFrame();

                } catch (Exception ex) {
                    LogUtil.logDescricaoErro(this.getClass(), ex);
                    JOptionPane.showMessageDialog(formPerfil, MensagensUtil.MENSAGEM_ERRO_ABRIR_TELA, MensagensUtil.ERRO, 0);
                }
            }
        };

        worker.execute();
    }//GEN-LAST:event_btnPerfilActionPerformed

    private JFrame getFramePrincipal() {
        return this;
    }

    private void btnUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioActionPerformed

        SwingWorker<Object, Void> worker = new SwingWorker<Object, Void>() {

            @Override
            protected Object doInBackground() throws Exception {
                try {
                    workTelaAguarde.habilitaTelaAguarde(getFramePrincipal());
                    return new PerfilServerImpl<Perfil>().recTodos(new Perfil());
                } catch (Exception ex) {
                    workTelaAguarde.desabilitaTelaAguarde(getFramePrincipal());
                    throw ex;
                }
            }

            @Override
            protected void done() {
                try {
                    List<Perfil> perfis = (List<Perfil>) get();
                    if (formUsuario == null) {
                        formUsuario = new FormUsuario();
                    }

                    formUsuario.setListPerfil(perfis);
                    workTelaAguarde.desabilitaTelaAguarde(getFramePrincipal());
                    formUsuario.showFrame();

                } catch (Exception ex) {
                    LogUtil.logDescricaoErro(this.getClass(), ex);
                    JOptionPane.showMessageDialog(formUsuario, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        };

        worker.execute();
    }//GEN-LAST:event_btnUsuarioActionPerformed

    private void btnVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVendaActionPerformed
         try{
            if(formVenda == null){
                formVenda = new FormVenda(this);
            }
            formVenda.showFrame();
        }catch(Exception ex){
            LogUtil.logDescricaoErro(this.getClass(), ex);
            JOptionPane.showMessageDialog(this, MensagensUtil.MENSAGEM_ERRO_ABRIR_TELA, MensagensUtil.ERRO, 0);
        }
    }//GEN-LAST:event_btnVendaActionPerformed

    private void btnProspeccoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProspeccoesActionPerformed
        try{
            if(formProspeccoes == null){
                formProspeccoes = new FormProspeccoes(null, false, this);
            }
            formProspeccoes.setVisible(true);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, MensagensUtil.MENSAGEM_ERRO_ABRIR_TELA, MensagensUtil.ERRO, 0);
        }
    }//GEN-LAST:event_btnProspeccoesActionPerformed

    private void btnCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompraActionPerformed
        try {
            if (formCompra == null) {
                formCompra = new FormCompra(this);
            }
            formCompra.showFrame();
        } catch (Exception ex) {
            LogUtil.logDescricaoErro(this.getClass(), ex);
            JOptionPane.showMessageDialog(this, MensagensUtil.MENSAGEM_ERRO_ABRIR_TELA, MensagensUtil.ERRO, 0);
        }
    }//GEN-LAST:event_btnCompraActionPerformed

    /**
     * Chama tela de login
     *
     * @param evt
     */
    private void jMenuItem_LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_LogoutActionPerformed
        this.dispose();

        App.setUserLog(null);
        FormLogin form = new FormLogin();
        form.setVisible(true);
    }//GEN-LAST:event_jMenuItem_LogoutActionPerformed

    /**
     * Fecha o sistema
     *
     * @param evt
     */
    private void jMenuItem_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_SairActionPerformed

        close();
    }//GEN-LAST:event_jMenuItem_SairActionPerformed

    private void jMenuItem_EtiquetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_EtiquetaActionPerformed
        try{
            if(formEtiqueta == null){
                formEtiqueta = new FormFiltroGerarEtiquetas();
            }
            formEtiqueta.setVisible(true);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, MensagensUtil.MENSAGEM_ERRO_ABRIR_TELA, MensagensUtil.ERRO, 0);
        }
    }//GEN-LAST:event_jMenuItem_EtiquetaActionPerformed

    private void jMenuItem_VendaRevendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_VendaRevendedorActionPerformed
        try{
            if(formRelatorioVenda == null){
                formRelatorioVenda = new FormRelatorioVendaPorRevendedor();
            }
            formRelatorioVenda.setVisible(true);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, MensagensUtil.MENSAGEM_ERRO_ABRIR_TELA, MensagensUtil.ERRO, 0);
        }
    }//GEN-LAST:event_jMenuItem_VendaRevendedorActionPerformed

    private void jMenuItem_ProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_ProdutoActionPerformed
        try{
            if(formRelatorioProduto == null){
                formRelatorioProduto = new FormRelatorioProduto();
            }
            formRelatorioProduto.setVisible(true);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, MensagensUtil.MENSAGEM_ERRO_ABRIR_TELA, MensagensUtil.ERRO, 0);
        }
    }//GEN-LAST:event_jMenuItem_ProdutoActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCompra;
    private javax.swing.JButton btnPerfil;
    private javax.swing.JButton btnProduto;
    private javax.swing.JButton btnProspeccoes;
    private javax.swing.JButton btnUsuario;
    private javax.swing.JButton btnVenda;
    private javax.swing.JButton btnrevendedor;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuItem_Etiqueta;
    private javax.swing.JMenuItem jMenuItem_Logout;
    private javax.swing.JMenuItem jMenuItem_Produto;
    private javax.swing.JMenuItem jMenuItem_Sair;
    private javax.swing.JMenuItem jMenuItem_VendaRevendedor;
    private javax.swing.JMenu jMenu_Arquivo;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel lbUser;
    // End of variables declaration//GEN-END:variables

    /**
     * carrega configuração de usuario na pagina
     */
    private void initialize() {
        Usuario user = App.getUserLog();
        lbUser.setText(user.getPessoa().getNome());

        //Logica para fechar tela pela botao do frame
        addListenerParaExibirMgsFecharTela();

        //acesso
        inicializaAcessoPorPerfil();

        //tela de aguarde
        this.workTelaAguarde = new BaseSwingWorker();
    }

    private void inicializaAcessoPorPerfil() {
        if (!ControleAcesso.ATIVA_BTN_CADASTRAR_REVENDEDOR && !ControleAcesso.ATIVA_BTN_CONSULTAR_REVENDEDOR) {
            this.btnrevendedor.setVisible(false);
        }
        if (!ControleAcesso.ATIVA_BTN_CADASTRAR_PEDIDO_COMPRA && !ControleAcesso.ATIVA_BTN_CONSULTAR_PEDIDO_COMPRA) {
            this.btnCompra.setVisible(false);
        }
        if (!ControleAcesso.ATIVA_BTN_CADASTRAR_PERFIL && !ControleAcesso.ATIVA_BTN_CONSULTAR_PERFIL) {
            this.btnPerfil.setVisible(ControleAcesso.ATIVA_BTN_CADASTRAR_PERFIL);
        }
        if (!ControleAcesso.ATIVA_BTN_CADASTRAR_PRODUTO && !ControleAcesso.ATIVA_BTN_CONSULTAR_PRODUTO) {
            this.btnProduto.setVisible(ControleAcesso.ATIVA_BTN_CADASTRAR_PRODUTO);
        }
        if (!ControleAcesso.ATIVA_BTN_CADASTRAR_USUARIO && !ControleAcesso.ATIVA_BTN_CONSULTAR_USUARIO) {
            this.btnUsuario.setVisible(ControleAcesso.ATIVA_BTN_CADASTRAR_USUARIO);
        }
        if (!ControleAcesso.ATIVA_BTN_CADASTRAR_PEDIDO_VENDA && !ControleAcesso.ATIVA_BTN_CONSULTAR_PEDIDO_VENDA) {
            this.btnVenda.setVisible(ControleAcesso.ATIVA_BTN_CADASTRAR_PEDIDO_VENDA);
        }
        if (!ControleAcesso.ATIVA_BTN_CADASTRAR_PROSPECCAO && !ControleAcesso.ATIVA_BTN_CONSULTAR_PROSPECCAO) {
            this.btnProspeccoes.setVisible(ControleAcesso.ATIVA_BTN_CADASTRAR_PROSPECCAO);
        }

    }

    /**
     * Logica para quando o usuario clicar no botao fechar do frame exibir a
     * tela de confirmação
     */
    private void addListenerParaExibirMgsFecharTela() {
        //cancela acao do botao fechar
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        //add windowsListener sobrescrevendo o metodo windowClosing
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                if (e.getID() == WindowEvent.WINDOW_CLOSING) {
                    close();
                }
            }
        });
    }

    public void close() {
        if (JOptionPane.YES_OPTION == JOptionPane.showOptionDialog(rootPane, MensagensUtil.MENSAGEM_CONFIRMAR_FECHAR_PROGRAMA, MensagensUtil.ATENCAO,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, new String[]{"Sim", "Não"}, "Não")) {
            System.exit(0);
        }
    }
}
