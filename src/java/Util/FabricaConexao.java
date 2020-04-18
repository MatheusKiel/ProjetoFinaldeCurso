/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author matheus.kiel
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {

    public static Connection getConexao(){
        Connection con = null;
        
        try{
            //driver de conexão
            Class.forName("org.postgresql.Driver");
            
            //cria um objeto de conexao com um banco especificado no caminho...
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BD_UmcInsight", "postgres", "Connection");
        }
        catch (ClassNotFoundException erro1) {
            throw new RuntimeException(erro1);
        } 
        catch (SQLException erro2) {
            throw new RuntimeException(erro2);
        }
        return con;
    }
}
