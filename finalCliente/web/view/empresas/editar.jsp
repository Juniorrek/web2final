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
        <title>EDITAR EMPRESA</title>
    </head>
    <body>
        <c:if test= "${empty usuario}"><c:redirect url="/view/login.jsp"/></c:if>
        <h1>Editar empresa</h1>
        <form action="/finalCliente/EmpresaController?action=editarEmpresa" method="POST">
            <input type="text" name="codigo" value="${empresa.codigo}" hidden>
            CNPJ<input type="text" name="cnpj" value="${empresa.cnpj}"><br>
            Razão social<input type="text" name="razaoSocial" value="${empresa.razaoSocial}"><br>
            Endereço<input type="text" name="endereco" value="${empresa.endereco}"><br>
            Email<input type="text" name="email" value="${empresa.email}"><br>
            <input type="submit" value="EDITAR">
        </form>
        <h3>Funcionários relacionados</h3>
        <table>
            <thead>
                <tr>
                    <th>Codigo</th>
                    <th>CPF</th>
                    <th>Nome</th>
                    <th>Endereço</th>
                    <th>Email</th>
                    <th>Celular</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${empresa.funcionarios}" var="funcionario">
                <tr>
                    <td>${funcionario.codigo}</td>
                    <td>${funcionario.cpf}</td>
                    <td>${funcionario.nome}</td>
                    <td>${funcionario.endereco}</td>
                    <td>${funcionario.email}</td>
                    <td>${funcionario.celular}</td>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
            
        
        <a href="/finalCliente/PortalController?action=listarEmpresas">VOLTAR</a>
    </body>
</html>
