<%--
  Created by IntelliJ IDEA.
  User: thorc
  Date: 04-03-2020
  Time: 08:43
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Antal Kunder</title>
</head>
<body>

<h1>Kundeliste</h1>
<br>

<c:forEach var="element" items="${sessionScope.customerList}">
    ${element}
    <br>
</c:forEach>
<h2>Antal kunder: ${sessionScope.antalKunder}</h2>
<br>
<h3>Slet kunde:</h3>
<form name="remove" action="FrontController" method="POST">
    <input type="hidden" name="taget" value="RemoveCustomer">
    Email:<br>
    <input type="text" name="remove" placeholder="someone@nowhere.com">
    <br>
    <input type="submit" value="Slet kunde">
</form>

<h3>Ændre kundes password:</h3>
<form name="EditPassword" action="FrontController" method="POST">
    <input type="hidden" name="taget" value="EditPassword">
    Email:<br>
    <input type="text" name="email" placeholder="someone@nowhere.com"><br>
    Nyt password:<br>
    <input type="text" name="password" placeholder="password">
    <br>
    <input type="submit" value="Ændre password">
</form>
<br>
<h2>Logout</h2>
<form name="Logout" action="FrontController" method="POST">
    <input type="hidden" name="taget" value="Logout">
    <input type="submit" value="Logout">
</form>

</body>
</html>
