package br.com.dcoracoes.client.interfaces;

/**
 * @author Administrador
 * @version 1.0
 * @created 01-set-2011 21:12:14
 */
public interface InterfaceCadastroCompleto extends InterfaceCadastroSimples {

    public void createNew();
    
    public void edit();
    
    public void search();
    
    public void print();

    public boolean validarTela();

    public void pushToModel();
    
    public void popularTela();
}
