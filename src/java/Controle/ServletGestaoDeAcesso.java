/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Dao.UsuarioDAO;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author matheus.kiel
 */
public class ServletGestaoDeAcesso extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            try {
                String acao = request.getParameter("acao");
                if (acao.equals("Login")) {
                    Usuario usuario = new Usuario();
                    usuario.setLogin(request.getParameter("txtLogin"));
                    usuario.setSenha(request.getParameter("txtSenha"));
                    UsuarioDAO usuarioDAO = new UsuarioDAO();
                    Usuario usuarioAutenticado = usuarioDAO.autenticaUsuario(usuario);
                    //se o usuario existe no banco de dados
                    if (usuarioAutenticado != null) {
                        //cria uma sessao para o usuario
                        HttpSession sessaoUsuario = request.getSession();
                        sessaoUsuario.setAttribute("usuarioAutenticado", usuarioAutenticado);
                        //redireciona para a pagina princiapal
                        response.sendRedirect("index.jsp");
                    } 
                    else {
                        RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
                        request.setAttribute("msg", "Login ou Senha Incorreto!");
                        rd.forward(request, response);
                    }
                }
                else if(acao.equals("Sair")){
                    HttpSession sessaoUsuario = request.getSession();
                    sessaoUsuario.removeAttribute("usuarioAutenticado");
                    response.sendRedirect("logout.jsp");
                }
            } 
            catch (Exception erro) {
                RequestDispatcher rd = request.getRequestDispatcher("/erro.jsp");
                request.setAttribute("erro", erro);
                rd.forward(request, response);
            }
        }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
