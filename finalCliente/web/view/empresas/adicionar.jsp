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
        <title>ADICIONAR EMPRESA</title>
    </head>
    <body>
        <c:if test= "${empty usuario}"><c:redirect url="/view/login.jsp"/></c:if>
        <h1>Adicionar Empresa</h1>
        <form action="/finalCliente/EmpresaController?action=adicionarEmpresa" method="POST">
            CNPJ<input type="text" name="cnpj"><br>
            Razão social<input type="text" name="razaoSocial"><br>
            Endereço<input type="text" name="endereco"><br>
            Email<input type="text" name="email"><br>
            <input type="submit" value="ADICIONAR">
        </form>
        <a href="/finalCliente/PortalController?action=listarEmpresas">VOLTAR</a>
    </body>
</html>
