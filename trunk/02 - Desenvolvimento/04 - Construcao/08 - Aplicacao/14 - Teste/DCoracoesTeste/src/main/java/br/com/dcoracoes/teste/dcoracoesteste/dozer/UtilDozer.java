/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dcoracoes.teste.dcoracoesteste.dozer;

import br.com.dcoracoes.teste.dcoracoes.beans.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jose Robson
 */
public class UtilDozer {

    public static PessoaFisica getPessoaFisicaBean() {

        PessoaFisica pessoaBean = new PessoaFisica();

        pessoaBean.setId(Long.MIN_VALUE);
        pessoaBean.setNome("JOSE");
        pessoaBean.setCpf("123456789");
        pessoaBean.setDataNascimento(new Date());
        pessoaBean.setEstadoCivil(1);
        pessoaBean.setIdentidade("123");

        Endereco enderecoBean = new Endereco();
        enderecoBean.setId(Long.MAX_VALUE);
        enderecoBean.setCep("354645646");
        enderecoBean.setRua("123");
        enderecoBean.setCidade("123123");
        enderecoBean.setComplemento("123123");
        enderecoBean.setEstado("we");
        enderecoBean.setNumero("123");
        enderecoBean.setPessoa(pessoaBean);
        enderecoBean.setReferencia("123123");
        pessoaBean.setEndereco(enderecoBean);

        Email email1 = new Email();
        email1.setEnderecoEmail("123123123");
        email1.setId(Long.MIN_VALUE);
        email1.setPessoa(pessoaBean);
        List<Email> lstEmail = new ArrayList<Email>();
        lstEmail.add(email1);
        pessoaBean.setEmails(lstEmail);

        Telefone tel1 = new Telefone();
        tel1.setId(Long.MIN_VALUE);
        tel1.setNumero("21123123");
        tel1.setOperadora("123123123");
        tel1.setTipoTelefone(1);
        tel1.setPessoa(pessoaBean);
        List<Telefone> lstTelefones = new ArrayList<Telefone>();
        lstTelefones.add(tel1);
        pessoaBean.setTelefones(lstTelefones);


        return pessoaBean;
    }

    public static Usuario getUsuarioBean() {
        Usuario usuario = new Usuario();
        usuario.setId(Long.MIN_VALUE);
        usuario.setLogin("123");
        usuario.setSenha("213");
        usuario.setPessoa(getPessoaFisicaBean());
        usuario.setPerfil(getPerfilBean());
        return usuario;
    }

     static Perfil getPerfilBean() {
        Perfil perfil = new Perfil();
        perfil.setId(Long.MIN_VALUE);
        perfil.setDescricao("12312312");
        perfil.setNomePerfil("123123");
        return perfil;
    }

    static br.com.dcoracoes.server.model.cadastro.Pessoa getPessoaFisicaModel() {

        br.com.dcoracoes.server.model.cadastro.PessoaFisica pessoaModel =
                new br.com.dcoracoes.server.model.cadastro.PessoaFisica();

        pessoaModel.setId(Long.MIN_VALUE);
        pessoaModel.setNome("JOSE");
        pessoaModel.setCpf("123456789");
        pessoaModel.setDataNascimento(new Date());
        pessoaModel.setEstadoCivil(1);
        pessoaModel.setIdentidade("123");

        br.com.dcoracoes.server.model.cadastro.Endereco enderecoModel =
                new br.com.dcoracoes.server.model.cadastro.Endereco();
        enderecoModel.setId(Long.MAX_VALUE);
        enderecoModel.setCep("354645646");
        enderecoModel.setRua("123");
        enderecoModel.setCidade("123123");
        enderecoModel.setComplemento("123123");
        enderecoModel.setEstado("we");
        enderecoModel.setNumero("123");
        enderecoModel.setPessoa(pessoaModel);
        enderecoModel.setReferencia("123123");
        pessoaModel.setEndereco(enderecoModel);

        br.com.dcoracoes.server.model.cadastro.Email email1 =
                new br.com.dcoracoes.server.model.cadastro.Email();
        email1.setEnderecoEmail("123123123");
        email1.setId(Long.MIN_VALUE);
        email1.setPessoa(pessoaModel);
        List<br.com.dcoracoes.server.model.cadastro.Email> lstEmail = new ArrayList<br.com.dcoracoes.server.model.cadastro.Email>();
        lstEmail.add(email1);
        pessoaModel.setEmails(lstEmail);

        br.com.dcoracoes.server.model.cadastro.Telefone tel1 =
                new br.com.dcoracoes.server.model.cadastro.Telefone();
        tel1.setId(Long.MIN_VALUE);
        tel1.setNumero("21123123");
        tel1.setOperadora("123123123");
        tel1.setTipoTelefone(1);
        tel1.setPessoa(pessoaModel);
        List<br.com.dcoracoes.server.model.cadastro.Telefone> lstTelefones = new ArrayList<br.com.dcoracoes.server.model.cadastro.Telefone>();
        lstTelefones.add(tel1);
        pessoaModel.setTelefones(lstTelefones);


        return pessoaModel;
    }

    static br.com.dcoracoes.server.model.canalacesso.Usuario getUsuarioModel() {
        br.com.dcoracoes.server.model.canalacesso.Usuario usuario =
                new br.com.dcoracoes.server.model.canalacesso.Usuario();
        usuario.setId(Long.MIN_VALUE);
        usuario.setLogin("123");
        usuario.setSenha("213");
        usuario.setPessoa(getPessoaFisicaModel());
        usuario.setPerfil(getPerfilModel());
        return usuario;
    }

     static br.com.dcoracoes.server.model.canalacesso.Perfil getPerfilModel() {
        br.com.dcoracoes.server.model.canalacesso.Perfil perfil =
                new br.com.dcoracoes.server.model.canalacesso.Perfil();
        perfil.setId(Long.MIN_VALUE);
        perfil.setDescricao("12312312");
        perfil.setNomePerfil("123123");
        return perfil;
    }
}
