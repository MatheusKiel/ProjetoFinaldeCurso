/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author matheus.kiel
 */
public class Usuario {
    
    private String login;
    private String senha;
    private int nivel;
    private String nome;
    
    // metodo para teste do login
    public boolean verificarUsuario(){
        if (this.login != null && this.senha != null){
            if (this.login.equals("kiel") && this.senha.equals("123")){
                return true;
            }        
        }
        return false;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
        
}
