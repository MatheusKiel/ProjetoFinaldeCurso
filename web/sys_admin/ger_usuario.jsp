<%-- 
    Document   : Ger_Usuario
    Created on : 15/04/2020, 13:33:40
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
        <form action="/ServletUsuario" method="POST">
            <table>
                <tr>
                    <td>Matricula:</td>
                    <td><input name="matricula" type="text" /></td>
                </tr>
                <tr>
                    <td>Nome Completo:</td>
                    <td><input name="nome" type="text" /></td>
                </tr>
                <tr>
                    <td>CPF:</td>
                    <td><input name="cpf" type="text" /></td>
                </tr>
                <tr>
                    <td>Data de Nascimento:</td>
                    <td><input name="dtNascimento" type="date" /></td>
                </tr>
                <tr>
                    <td>Sexo:</td>
                    <td>
                        <select name="opSexo">
                            <option>MASCULINO</option>
                            <option>FEMININO</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Telefone:</td>
                    <td><input name="telefone" type="text" /></td>
                </tr>
                <tr>
                    <td>Login:</td>
                    <td><input name="login" type="text" /></td>
                </tr>
                <tr>
                    <td>Senha:</td>
                    <td><input name="senha" type="password" /></td>
                </tr>
<%--               <tr>
                    <td>Confirmar Senha:</td>
                    <td><input name="" type="password" /></td>
                </tr>
                <tr>    --%>
                    <td>Perfil de Acesso:</td>
                    <td><select name="opPerfil">
                            <option>PADRAO</option>
                            <option>SERVICEDESK</option>
                            <option>ADMINISTRADOR</option>
                        </select>
                    </td>
                </tr>          
                <tr>
                    <td>
                    <td><input type="submit" name="acao" value="Cadastrar"/></td>
                </tr>
            </table>
        </form>        
    </body>
</html>
