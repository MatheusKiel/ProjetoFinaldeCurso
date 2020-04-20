/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Dao.UsuarioDAO;
import Modelo.PerfilAcesso;
import Modelo.Sexo;
import Modelo.Usuario;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author matheus.kiel
 */

public class ServletUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            
            String acao = request.getParameter("acao");
            if (acao.equals("Cadastrar")) {
                
                
                Usuario usuario = new Usuario();
                
                usuario.setMatricula(Integer.parseInt(request.getParameter("matricula")));
                usuario.setLogin(request.getParameter("login"));
                usuario.setNome(request.getParameter("nome"));
                usuario.setSenha1(request.getParameter("senha1"));
                usuario.setSenha2(request.getParameter("senha2"));
                usuario.setCpf(request.getParameter("cpf"));
                usuario.setNascimento(Date.valueOf(request.getParameter("dtNascimento")));
                usuario.setTelefone(request.getParameter("telefone"));
                
                
                //Senha e confirmação 
                if (usuario.getSenha1().equals(usuario.getSenha2())){
                    usuario.setSenha(request.getParameter("senha1"));
                }
                else{
                    RequestDispatcher rd = request.getRequestDispatcher("sys_admin/ger_usuario.jsp");
                    request.setAttribute("msg", "As senhas não coincidem!");
                    rd.forward(request, response);
                }
                
                //Selecionando o perfil de ACesso
                String perfil = request.getParameter("opPerfil");
                if (perfil.equalsIgnoreCase("administrador")) {                    
                    usuario.setPerfil(PerfilAcesso.ADMINISTRADOR);
                }
                else if(perfil.equalsIgnoreCase("servicedesk")) {
                    usuario.setPerfil(PerfilAcesso.SERVICEDESK);
                }
                else{
                    usuario.setPerfil(PerfilAcesso.PADRAO);
                }
                
                //Selecionando o Sexo
                String sexo = request.getParameter("opSexo");
                if(sexo.equalsIgnoreCase("masculino")){
                    usuario.setSexo(Sexo.MASCULINO);
                }
                else{
                    usuario.setSexo(Sexo.FEMININO);
                }
                
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                usuarioDAO.cadastraNovoUsuario(usuario);
                request.setAttribute("msg", "cadastrado com sucesso");
                RequestDispatcher rd = request.getRequestDispatcher("sys_admin/ger_usuario.jsp");
                rd.forward(request, response);
            }
        } 
        catch (Exception erro) {
            RequestDispatcher rd = request.getRequestDispatcher("/erro.jsp");
            request.setAttribute("erro", erro);
            rd.forward(request, response);
        }
    }
    
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    processRequest(request, response);
}
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    processRequest(request, response);
    }
}
