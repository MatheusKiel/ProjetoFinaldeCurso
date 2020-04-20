/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.text.DateFormat;
import java.util.Date;

/**
 *
 * @author matheus.kiel
 */
public class Usuario {
    
    private String login;
    private String senha1;
    private String senha2;
    private String senha;
    private PerfilAcesso perfil;
    private String nome;
    private int matricula;
    private String cpf;
    private Date nascimento;
    private Sexo sexo;
    private String telefone;
    private String criacaoUsuario;

    public String getCriacaoUsuario() {
        Date d = new Date();
        DateFormat dtHora = DateFormat.getDateTimeInstance();     
        criacaoUsuario = dtHora.format(d);
        return criacaoUsuario;
    }

    public void setCriacaoUsuario(String criacaoUsuario) {
        this.criacaoUsuario = criacaoUsuario;
    }

    
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }    

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
    public String getSenha1() {
        return senha1;
    }

    public void setSenha1(String senha1) {
        this.senha1 = senha1;
    }

    public String getSenha2() {
        return senha2;
    }

    public void setSenha2(String senha2) {
        this.senha2 = senha2;
    }

    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public PerfilAcesso getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilAcesso perfil) {
        this.perfil = perfil;
    }
}
