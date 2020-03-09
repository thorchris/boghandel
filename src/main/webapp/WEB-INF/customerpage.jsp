<%--
  Created by IntelliJ IDEA.
  User: josef
  Date: 08-03-2020
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search page</title>
</head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<body>

<h1>Hello ${sessionScope.email} </h1>




You are now logged in as a customer of our wonderful site.
<br>
<br>
<h2>Logout</h2>
<form name="Logout" action="FrontController" method="POST">
    <input type="hidden" name="taget" value="Logout">
    <input type="submit" value="Logout">
</form>


<br>
<br>





<div class="container">
    <h2>Bordered Table</h2>
    <p>The .table-bordered class adds borders on all sides of the table and the cells:</p>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Titel</th>
            <th>Forfatter</th>
            <th>Pris</th>
            <th>Antal</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${sessionScope.booklist}" var="element" >
        <tr>
            <td>hej</td>
            <td>${element.title}</td>
            <td>${element.author}</td>
            <td>${element.price}</td>
            <td>${element.qty}</td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>







<br>
<br>




<form name="searchbook" action="FrontController" method="POST">
    <input type="hidden" name="taget" value="searchbook">
    Søger efter bog:<br>
    <input type="text" name="title" value="title">
    <input type="submit" value="Søg">
    <br>

    <h1>Fandt bogen: </h1>
    <c:forEach items="${sessionScope.newBookList}" var="element" >

        ${element}
    <br>
    </c:forEach>

</body>
</html>
