<%-- 
    Document   : login
    Created on : Jun 9, 2017, 7:31:38 PM
    Author     : Fornalha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LOGIN</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="/finalCliente/LoginController?action=login" method="POST">
            <input type="text" name="login"><br>
            <input type="text" name="senha"><br>
            <input type="submit"value="LOGAR">
        </form>
    </body>
</html>
