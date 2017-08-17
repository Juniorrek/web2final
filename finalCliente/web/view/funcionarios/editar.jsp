<%-- 
    Document   : editar
    Created on : Jun 9, 2017, 8:01:15 PM
    Author     : Fornalha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EDITAR FUNCIONÁRIO</title>
    </head>
    <body>
        <c:if test= "${empty usuario}"><c:redirect url="/view/login.jsp"/></c:if>
        <h1>Editar funcionário</h1>
        <form action="/finalCliente/FuncionarioController?action=editarFuncionario" method="POST">
            <input type="text" name="codigo" value="${funcionario.codigo}" hidden>
            CPF<input type="text" name="cpf" value="${funcionario.cpf}"><br>
            Nome<input type="text" name="nome" value="${funcionario.nome}"><br>
            Endereço<input type="text" name="endereco" value="${funcionario.endereco}"><br>
            Email<input type="text" name="email" value="${funcionario.email}"><br>
            Celular<input type="text" name="celular" value="${funcionario.celular}"><br>
            Código empresa<input type="text" name="empresa_codigo" value="${funcionario.empresa_codigo}"><br>
            <input type="submit" value="EDITAR">
        </form>
        
        <a href="/finalCliente/PortalController?action=listarFuncionarios">VOLTAR</a>
    </body>
</html>
