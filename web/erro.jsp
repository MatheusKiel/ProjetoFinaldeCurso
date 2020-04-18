<%-- 
    Document   : erro
    Created on : 18/04/2020, 17:14:01
    Author     : matheus.kiel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PFC - Umc Insight</title>
    </head>
    <body>
        <h1>ERRO</h1>
        <hr>
        <br>
        <%= ((Exception)request.getAttribute("erro")).getMessage() %>
    </body>
</html>
