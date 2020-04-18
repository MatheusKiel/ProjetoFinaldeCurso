/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.PerfilAcesso;
import Modelo.Usuario;
import Util.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author matheus.kiel
 */
public class UsuarioDAO {
    
    private static final String CADASTRA_NOVO_USUARIO = "INSERT INTO usuario (login, senha, perfilacesso) VALUES (?,?,?)";
    
    private static final String AUTENTICA_USUARIO = "SELECT * FROM usuario WHERE login=? AND senha=?";
    
    public void cadastraNovoUsuario(Usuario usuario) {
    Connection conexao = null;
    PreparedStatement pstmt = null;
    try {
        conexao = FabricaConexao.getConexao();
        pstmt = conexao.prepareStatement(CADASTRA_NOVO_USUARIO);
        pstmt.setString(1, usuario.getLogin());
        pstmt.setString(2, usuario.getSenha());
        pstmt.setString(3, usuario.getPerfil().toString());
        pstmt.execute();
    } 
    
    catch (SQLException sqlErro) {
        throw new RuntimeException(sqlErro);
        } 
    finally {
        if (conexao != null) {
            try {
                conexao.close();
            } 
            catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
public Usuario autenticaUsuario(Usuario usuario) {
    Usuario usuarioAutenticado = null;
    Connection conexao = null;
    PreparedStatement pstmt = null;
    ResultSet rsUsuario = null;
        try {
            conexao = FabricaConexao.getConexao();
            pstmt = conexao.prepareStatement(AUTENTICA_USUARIO);
            pstmt.setString(1, usuario.getLogin());
            pstmt.setString(2, usuario.getSenha());
            rsUsuario = pstmt.executeQuery();
            if (rsUsuario.next()) {
                usuarioAutenticado = new Usuario();
                usuarioAutenticado.setLogin(rsUsuario.getString("login"));
                usuarioAutenticado.setSenha(rsUsuario.getString("senha"));
                usuarioAutenticado.setPerfil(PerfilAcesso.valueOf(rsUsuario.getString("perfilacesso")));
            }
        }
        catch (SQLException sqlErro) {
            throw new RuntimeException(sqlErro);
        } 
        finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } 
                catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        return usuarioAutenticado;
    }
}
