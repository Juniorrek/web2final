<%-- 
    Document   : inicial
    Created on : Jun 9, 2017, 7:37:50 PM
    Author     : Fornalha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>INICIAL</title>
    </head>
    <body>
        <c:if test= "${empty usuario}"><c:redirect url="/view/login.jsp"/></c:if>
        <h1>Inicial - Bem vindo ${usuario.nome}</h1>
        <a href="/finalCliente/PortalController?action=listarEmpresas">Empresas</a><br>
        <a href="/finalCliente/PortalController?action=listarFuncionarios">Funcionários</a><br>
        <a href="/finalCliente/RelatorioController">Relatório</a><br>
        <a href="/finalCliente/LoginController?action=logout">LOGOUT</a>
    </body>
</html>
