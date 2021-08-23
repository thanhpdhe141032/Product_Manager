<%-- 
    Document   : login
    Created on : Jul 12, 2021, 10:32:13 PM
    Author     : Thanh Dang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Login Page</h1>
        <h3>${mess}</h3>
        <form action="Login" method="post">
            User Name <input type="text" name="username" value="${cookie['username'].getValue()}" placeholder="Username">
            <br>
            <br>
            Password <input type="password" name="password" value="${cookie['password'].getValue()}" placeholder="Password">
            <br>
            <br>
            <input type="submit" value="Login">
            <input type="checkbox" name="remember"> Remember Account
        </form>            
    </body>
</html>
