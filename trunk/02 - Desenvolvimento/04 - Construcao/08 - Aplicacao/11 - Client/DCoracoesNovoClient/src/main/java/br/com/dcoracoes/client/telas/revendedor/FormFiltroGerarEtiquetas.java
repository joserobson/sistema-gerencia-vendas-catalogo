/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FormConsultaPerfil.java
 *
 * Created on 17/04/2012, 21:44:03
 */
package br.com.dcoracoes.client.telas.revendedor;

import br.com.dcoracoes.client.enuns.Enum_Situacao;
import br.com.dcoracoes.client.interfaces.InterfaceConsultaSimples;
import br.com.dcoracoes.client.relatorios.GerarRelatorio;
import br.com.dcoracoes.client.swingworker.SwingWorkerRevendedor;
import br.com.dcoracoes.client.util.MensagensUtil;
import br.com.dcoracoes.client.util.MetodosUtil;
import br.com.dcoracoes.client.util.componentes.ComboBoxEstado;
import br.com.dcoracoes.client.util.message.MessageRevendedor;
import br.com.dcoracoes.servico.service.Pessoa;
import br.com.dcoracoes.servico.service.ViewRevendedor;
import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author Cleberson
 */
public class FormFiltroGerarEtiquetas extends javax.swing.JFrame implements InterfaceConsultaSimples {

    private HashMap<String, Object> parameter;

    /** Creates new form FormConsultaPerfil */
    public FormFiltroGerarEtiquetas() {
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
        btnGerar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        cbSituacao = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        cbUF = new ComboBoxEstado();
        lbUF = new javax.swing.JLabel();
        lblDataNascimento = new javax.swing.JLabel();
        jtxtDataNascimentoInicio = new javax.swing.JFormattedTextField();
        lblDataNascimento1 = new javax.swing.JLabel();
        jtxtDataNascimentoFim = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerar Etiquetas");
        setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage("src/main/resources/imagens/outras/icon_SGC.gif"));

        panelSuperButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, new java.awt.Color(43, 115, 186)));

        btnGerar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/32x32/accessories-text-editor.png"))); // NOI18N
        btnGerar.setText("GERAR");
        btnGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarActionPerformed(evt);
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
            .addGap(0, 118, Short.MAX_VALUE)
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
            .addGap(0, 6, Short.MAX_VALUE)
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
            .addGap(0, 5, Short.MAX_VALUE)
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
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 6, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGerar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 5, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelSuperButtonLayout.setVerticalGroup(
            panelSuperButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSuperButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGerar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        cbSituacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ativo", "Inativo", "Todos" }));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("SITUAÇÃO:");

        lbUF.setText("UF:");

        lblDataNascimento.setText("ANIVERSÁRIO: de");

        try {
            jtxtDataNascimentoInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jtxtDataNascimentoInicio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtDataNascimentoInicioFocusLost(evt);
            }
        });

        lblDataNascimento1.setText("até");

        try {
            jtxtDataNascimentoFim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jtxtDataNascimentoFim.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtDataNascimentoFimFocusLost(evt);
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
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(lbUF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbUF, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(363, 363, 363))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblDataNascimento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtDataNascimentoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDataNascimento1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtDataNascimentoFim, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(lbUF)
                    .addComponent(cbUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDataNascimento)
                    .addComponent(jtxtDataNascimentoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDataNascimento1)
                    .addComponent(jtxtDataNascimentoFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                    .addComponent(panelSuperButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelSuperButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("Etiquetas de Endereço de Revendedora");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarActionPerformed
        search();
}//GEN-LAST:event_btnGerarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
        close();
}//GEN-LAST:event_btnSairActionPerformed

    private void jtxtDataNascimentoInicioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtDataNascimentoInicioFocusLost
        // TODO add your handling code here:
        if (!MetodosUtil.validData(jtxtDataNascimentoInicio.getText())) {
            JOptionPane.showMessageDialog(this, MensagensUtil.MENSAGEM_ERRO_DATA_INVALIDA, MensagensUtil.ATENCAO, 2);
            
            jtxtDataNascimentoInicio.setValue(null);
            jtxtDataNascimentoInicio.requestFocus();
        }
}//GEN-LAST:event_jtxtDataNascimentoInicioFocusLost

    private void jtxtDataNascimentoFimFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtDataNascimentoFimFocusLost
        // TODO add your handling code here:
        if (!MetodosUtil.validData(jtxtDataNascimentoFim.getText())) {
            JOptionPane.showMessageDialog(this, MensagensUtil.MENSAGEM_ERRO_DATA_INVALIDA, MensagensUtil.ATENCAO, 2);
            
            jtxtDataNascimentoFim.setValue(null);
            jtxtDataNascimentoFim.requestFocus();
        }
    }//GEN-LAST:event_jtxtDataNascimentoFimFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGerar;
    private javax.swing.JButton btnSair;
    private javax.swing.JComboBox cbSituacao;
    private javax.swing.JComboBox cbUF;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JFormattedTextField jtxtDataNascimentoFim;
    private javax.swing.JFormattedTextField jtxtDataNascimentoInicio;
    private javax.swing.JLabel lbUF;
    private javax.swing.JLabel lblDataNascimento;
    private javax.swing.JLabel lblDataNascimento1;
    private javax.swing.JPanel panelSuperButton;
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
        
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void search() {
        try {
            if(validarTela()){
                pushToModel();
                gerarEtiquetas(parameter);
            }               
            
        } catch (Exception ex) {
            Logger.getLogger(FormRevendedor.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "erro", MensagensUtil.ERRO, 0);
        }
    }
    
    private boolean validarTela(){
        
        StringBuilder stringError = new StringBuilder();
        
        if((jtxtDataNascimentoInicio.getText().replace("/", "").trim().isEmpty() && 
                !jtxtDataNascimentoFim.getText().replace("/", "").trim().isEmpty())
                || (!jtxtDataNascimentoInicio.getText().replace("/", "").trim().isEmpty() && 
                jtxtDataNascimentoFim.getText().replace("/", "").trim().isEmpty())){
            
            stringError.append(MessageRevendedor.CAMPO_INTERVALO_ANIVERSARIO_INCOMPLETO);
         
            if(jtxtDataNascimentoInicio.getText().replace("/", "").trim().isEmpty())
                jtxtDataNascimentoInicio.requestFocus();
            
            if(jtxtDataNascimentoFim.getText().replace("/", "").trim().isEmpty())
                jtxtDataNascimentoFim.requestFocus();
        }
        
        if (!stringError.toString().isEmpty()) {
            JOptionPane.showMessageDialog(this, stringError, MensagensUtil.ATENCAO, 2);
        }

        return stringError.toString().isEmpty();
    }
    
    private void pushToModel() {
        parameter = new HashMap<String, Object>();
        
        if(cbSituacao.getSelectedIndex() != 2)
            parameter.put("situacao", returnEnumSituacao().getCodigo());
        
        if(cbUF.getSelectedIndex() != 0)
            parameter.put("uf", cbUF.getSelectedItem().toString());
        
        if (!jtxtDataNascimentoInicio.getText().replace("/", "").trim().isEmpty()) {
            String[] dateAux = jtxtDataNascimentoInicio.getText().split("/");
            GregorianCalendar c = new GregorianCalendar();
            c.set(Integer.parseInt(dateAux[2]), Integer.parseInt(dateAux[1]) - 1, Integer.parseInt(dateAux[0]));            
            parameter.put("dataNascimentoInicio", c.getTime());
        }
        
        if (!jtxtDataNascimentoFim.getText().replace("/", "").trim().isEmpty()) {
            String[] dateAux = jtxtDataNascimentoFim.getText().split("/");
            GregorianCalendar c = new GregorianCalendar();
            c.set(Integer.parseInt(dateAux[2]), Integer.parseInt(dateAux[1]) - 1, Integer.parseInt(dateAux[0]));            
            parameter.put("dataNascimentoFim", c.getTime());
        }
        
    }
    
    /**
     * recupera a situacao informada
     * @return 
     */
    private Enum_Situacao returnEnumSituacao() {
        if (cbSituacao.getSelectedIndex() == 0) {
            return Enum_Situacao.ATIVO;
        } else {
            return Enum_Situacao.INATIVO;
        }
    }
    
    /**
     * Gerar Etiqueta
     * @param parameter 
     */
    private void gerarEtiquetas(HashMap<String, Object> parameter) {
        SwingWorkerRevendedor<ViewRevendedor> workRevendedor = new SwingWorkerRevendedor<ViewRevendedor> (parameter);
        workRevendedor.setFormFiltroGerarEtiqueta(this);
        workRevendedor.workRecRevendedorEtiqueta.execute(); 
    }
    
    public void processaEtiquetas(List<Pessoa> lstPessoa){
        try {
            if(!lstPessoa.isEmpty()){                  
                int opcao = JOptionPane.showOptionDialog(rootPane, MessageRevendedor.OPCAO_TIPO_ETIQUETA, MensagensUtil.ATENCAO,  
                    JOptionPane.YES_NO_OPTION,  
                    JOptionPane.QUESTION_MESSAGE, null, new String[]{"PDF", "EXCEL"}, "EXCEL"); 
                if (opcao == JOptionPane.YES_OPTION) {
                    gerarPDF(lstPessoa);
                } else 
                    if (opcao == JOptionPane.NO_OPTION){
                        gerarXLS(lstPessoa);
                    }
            } else 
            JOptionPane.showMessageDialog(this, MensagensUtil.MENSAGEM_NENHUM_REGISTRO, MensagensUtil.ATENCAO, 1);
        } catch (Exception ex) {
            Logger.getLogger(FormFiltroGerarEtiquetas.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, MessageRevendedor.ERRO_GERAR_ETIQUETA, MensagensUtil.ERRO, 0);
        }
    }

    private void gerarPDF(List<Pessoa> lstPessoa) throws JRException{        
        GerarRelatorio func = new GerarRelatorio();
        func.gerarRelatorioEtiqueta(lstPessoa);
    }
    
    /**
     * Gerar planilha Excel
     * @param parameter 
     */
    private void gerarXLS(List<Pessoa> lstPessoa) throws Exception{
        String diretorio = selecionaDiretorio();
        if(diretorio != null){
            StringBuilder conteudo = gerarDadosXLS(lstPessoa); 

            SimpleDateFormat simple = new SimpleDateFormat("dd_MM_yyyy_H_mm_ss");
            String nameFile = "EtiquetasRevendedores_" + simple.format(new Date(System.currentTimeMillis())) + ".xls";
            //agora, salvando o StringBuilder no arquivo
            File file = new File(diretorio, nameFile);

            FileWriter excelFile = new FileWriter(file); // nome do arquivo
            excelFile.write(new String(conteudo)); //aqui ele passa a String para salvar
            excelFile.close(); //Fechando e salvando o arquivo 

            //Abrindo arquivo
            Desktop.getDesktop().open(file);   
        }
    } 
    
    /**
     * Abre janela para seleção do diretorio
     * @return 
     */
    private String selecionaDiretorio(){
            String diretorio = null;
         
            JFileChooser fc = new JFileChooser();  

            // restringe a amostra a diretorios apenas  
            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);  
            fc.setDialogTitle("Selecione o diretório");
            fc.setApproveButtonText("Selecionar");
            
            int res = fc.showOpenDialog(null);  

            if(res == JFileChooser.APPROVE_OPTION){  
               diretorio = fc.getSelectedFile().getAbsolutePath();  
            }  
            else  
               JOptionPane.showMessageDialog(this, "Voce nao selecionou nenhum diretorio.", MensagensUtil.ATENCAO, 1);  
               
            return diretorio;
    }
    
    /**
     * Monta dados da planilha do Excel
     * @param lstPessoa
     * @return 
     */
    private StringBuilder gerarDadosXLS(List<Pessoa> lstPessoa){
        StringBuilder conteudo = new StringBuilder("");
        for (Pessoa pessoa : lstPessoa) {

            //******NOME******
            conteudo.append(pessoa.getNome().trim()).append("\n");

            //******ENDERECO******
            //Rua
            conteudo.append(pessoa.getEndereco().getRua().trim());
            //Numero
            if(pessoa.getEndereco().getNumero() != null)
                if(!pessoa.getEndereco().getNumero().trim().isEmpty())
                    conteudo.append(", ").append(pessoa.getEndereco().getNumero().trim());
            //Bairro
                if(pessoa.getEndereco().getBairro() != null)
                    if(!pessoa.getEndereco().getBairro().trim().isEmpty())
                        conteudo.append(" - ").append(pessoa.getEndereco().getBairro().trim());
            //Complemento
            if(pessoa.getEndereco().getComplemento() != null)
                if(!pessoa.getEndereco().getComplemento().trim().isEmpty())
                    conteudo.append(" - ").append(pessoa.getEndereco().getComplemento().trim());
            conteudo.append("\n");
            //Cidade
            conteudo.append(pessoa.getEndereco().getCidade().trim());
            //Estado
            conteudo.append(" - ").append(pessoa.getEndereco().getEstado().trim());
            //CEP
            if(pessoa.getEndereco().getCep() != null)
                if(!pessoa.getEndereco().getCep().trim().isEmpty())
                    conteudo.append(" - CEP: ").append(pessoa.getEndereco().getCep().trim());
            conteudo.append("\n");
            //Ponto de Referencia
                if(pessoa.getEndereco().getReferencia() != null)
                    if(!pessoa.getEndereco().getReferencia().trim().isEmpty())
                        conteudo.append("REFERÊNCIA: ").append(pessoa.getEndereco().getReferencia().trim());
            conteudo.append("\n");

        }
        return conteudo;
    }

    @Override
    public void showFrame() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
