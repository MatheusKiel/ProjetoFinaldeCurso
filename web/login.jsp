<%-- 
    Document   : login
    Created on : 09/03/2020, 20:30:31
    Author     : matheus.kiel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="CSS/fonts.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/login.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PFC - Umc Insight</title>
    </head>
    <body>        
            <div id="centro">
                <div id="centro2">
                    
                    <form action="ControleAcesso" method="POST">
                        <img id="imguser" src="imagens/usuario_imagem.png" alt=""/>
                        <input style="margin-top: 180px;" class="font-placeholder-login txtBoxPos txtBoxPos1"
                               placeholder="Login" autocomplete="off" type="text" name="txtLogin">
                            <br>
                            <br>
                        <input style="margin-top: 10px;" class="font-placeholder-login txtBoxPos txtBoxPos1"
                               placeholder="Password" autocomplete="off"  type="password" name="txtSenha">
                            <br>
                            <br>
                        <input class="btnLogin btnLogin1" type="submit" value="Login" name="acao">
                    </form>
                </div>
            </div> 
        <%
            String msg = (String)request.getAttribute("msg");
            if(msg!=null){
        %>
        <form id="msgvalida"> <%=msg%> </form>
                        <%}%>
         
    </body>
</html>
