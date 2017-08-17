<%-- 
    Document   : listar
    Created on : Jun 9, 2017, 7:43:49 PM
    Author     : Fornalha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FUNCIONÁRIOS</title>
    </head>
    <body>
        <c:if test= "${empty usuario}"><c:redirect url="/view/login.jsp"/></c:if>
        <h1>Funcionarios</h1>
        <a href="/finalCliente/FuncionarioController?action=formAdicionarFuncionario">Adicionar novo</a><br>
        <table>
            <thead>
                <tr>
                    <th>Código</th>
                    <th>Cpf</th>
                    <th>Nome</th>
                    <th>Endereço</th>
                    <th>E-mail</th>
                    <th>Celular</th>
                    <th>Código empresa</th>
                    <th>Ação</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${funcionarios}" var="funcionario">
                    <tr>
                        <td>${funcionario.codigo}</td>
                        <td>${funcionario.cpf}</td>
                        <td>${funcionario.nome}</td>
                        <td>${funcionario.endereco}</td>
                        <td>${funcionario.email}</td>
                        <td>${funcionario.celular}</td>
                        <td>${funcionario.empresa_codigo}</td>
                        <td><a href="/finalCliente/FuncionarioController?action=formEditarFuncionario&codigo=${funcionario.codigo}">Editar</a>
                            <a href="/finalCliente/FuncionarioController?action=excluirFuncionario&codigo=${funcionario.codigo}">Excluir</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table><br>
        <a href="/finalCliente/view/inicial.jsp">VOLTAR</a>
    </body>
</html>
