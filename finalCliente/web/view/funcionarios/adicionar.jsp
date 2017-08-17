<%-- 
    Document   : adicionar
    Created on : Jun 9, 2017, 7:58:18 PM
    Author     : Fornalha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ADICIONAR FUNCIONÁRIO</title>
    </head>
    <body>
        <c:if test= "${empty usuario}"><c:redirect url="/view/login.jsp"/></c:if>
        <h1>Adicionar funcionário</h1>
        <form action="/finalCliente/FuncionarioController?action=adicionarFuncionario" method="POST">
            CPF<input type="text" name="cpf"><br>
            Nome<input type="text" name="nome"><br>
            Endereço<input type="text" name="endereco"><br>
            Email<input type="text" name="email"><br>
            Celular<input type="text" name="celular"><br>
            Código empresa<input type="text" name="empresa_codigo"><br>
            <input type="submit" value="ADICIONAR">
        </form>
        <a href="/finalCliente/PortalController?action=listarFuncionarios">VOLTAR</a>
    </body>
</html>
