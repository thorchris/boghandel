<%-- 
    Document   : employeepage.jsp
    Created on : Aug 24, 2017, 6:31:57 AM
    Author     : kasper
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee home page</title>
    </head>
    <body>
        <h1>Hello ${sessionScope.email} </h1>
        <br>
        You are now logged in as a EMPLOYEE of our wonderful site.
        <br>
        <br>
        <form>
        <input type="hidden" name="taget" value="costumerList">
        <input type="submit" name="submit" value="Kunde Info">
        </form>
        <br>
        <br>
        <h3>Opret medarbejder</h3>
        <br>
        <form name="register" action="FrontController" method="POST">
            <input type="hidden" name="taget" value="NewEmployee">
            Email:<br>
            <input type="text" name="email" placeholder="someone@nowhere.com">
            <br>
            Password:<br>
            <input type="password" name="password1" placeholder="password">
            <br>
            Retype Password:<br>
            <input type="password" name="password2" placeholder="password">
            <br>
            <input type="submit" value="Register">
        </form>

    <br>
        <h2>Logout</h2>
        <form name="Logout" action="FrontController" method="POST">
            <input type="hidden" name="taget" value="Logout">
            <input type="submit" value="Logout">
        </form>
    </body>
</html>
