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
        <title>EMPRESAS</title>
    </head>
    <body>
        <c:if test= "${empty usuario}"><c:redirect url="/view/login.jsp"/></c:if>
        <h1>Empresas</h1>
        <a href="/finalCliente/EmpresaController?action=formAdicionarEmpresa">Adicionar nova</a><br>
        <table>
            <thead>
                <tr>
                    <th>Código</th>
                    <th>Cnpj</th>
                    <th>Razão Social</th>
                    <th>Endereço</th>
                    <th>E-mail</th>
                    <th>Ação</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${empresas}" var="empresa">
                    <tr>
                        <td>${empresa.codigo}</td>
                        <td>${empresa.cnpj}</td>
                        <td>${empresa.razaoSocial}</td>
                        <td>${empresa.endereco}</td>
                        <td>${empresa.email}</td>
                        <td><a href="/finalCliente/EmpresaController?action=formEditarEmpresa&codigo=${empresa.codigo}">Editar</a>
                            <a href="/finalCliente/EmpresaController?action=excluirEmpresa&codigo=${empresa.codigo}">Excluir</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table><br>
        <a href="/finalCliente/view/inicial.jsp">VOLTAR</a>
    </body>
</html>
