<%-- 
    Document   : index
    Created on : 18/04/2020, 13:57:11
    Author     : matheus.kiel
--%>

<%@page import="Modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PFC - Umc Insight</title>
    </head>
    <body>
        <%
        //recupera o usuario da sessao
        Usuario usuario = (Usuario)session.getAttribute("usuarioAutenticado");
        if(usuario !=null){
        %>
        <h1>Bem vindo ao Sistema!</h1>
        <h4> <%=usuario.getNome() %> <br> <%=usuario.getPerfil()%></h4><%}%>
        
       
        <hr>
        <br>
        <a href="sys_admin/ger_usuario.jsp">Gerenciamento de usuários</a><br>
        <a href="ServletGestaoDeAcesso?acao=Sair">Sair</a>
    </body>
</html>
