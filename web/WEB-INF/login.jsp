<%-- 
    Document   : login
    Created on : Oct 18, 2020, 5:40:29 PM
    Author     : 553582
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <form method="POST"> 
        <h1>Login</h1>
        <label>Username: </label>
        <input type="text" name="username" value="${username}">
        <br>
        <label>Password: </label>
        <input type="password" name="password" value="${password}">
        <br>
        <input type="submit" value="Log in">
        <br>
        ${message}
        </form>
    </body>
</html>
