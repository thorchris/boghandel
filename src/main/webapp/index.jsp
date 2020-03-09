<%-- 
    Document   : index
    Created on : Aug 22, 2017, 2:01:06 PM
    Author     : kasper
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles.css">
        <title>Welcome page</title>
    </head>
    <body>
        <h1>2sem webstack</h1>
        <div class="login" >
                <br>
                    <form name="login" action="FrontController" method="POST">
                        <input type="hidden" name="taget" value="login">
                        <h2>LOGIN</h2>
                        <input type="text" name="email" placeholder="EMAIL">
                        <br>
                        <input type="password" name="password" placeholder="PASSWORD">
                        <br>
                        <button type="submit" class="btn btn-primary btn-block btn-large"> Login </button>
                    </form>
        </div>
        <div class="register">
                <br>
                    <form name="register" action="FrontController" method="POST">
                        <input type="hidden" name="taget" value="register">
                        <h2>REGISTER</h2>
                        <input type="text" name="email" placeholder="EMAIL">
                        <br>
                        <input type="password" name="password1" placeholder="PASSWORD">
                        <br>
                        <input type="password" name="password2" placeholder="RETYPE PASSWORD">
                        <br>
                        <button type="submit" class="btn btn-primary btn-block btn-large"> Register </button>
                    </form>
            </div>




        <%--        Bare lige se I har en ide om hvad vi forslå I ikke gør ! det hedder scpript lets --%>
<%--        <% String error = (String) request.getAttribute( "error");--%>
<%--           if ( error != null) { --%>
<%--               out.println("<H2>Error!!</h2>");--%>
<%--               out.println(error);--%>
<%--           }--%>
<%--        %>--%>
        <div class="login-error">
        <c:if test = "${requestScope.error!= null}" >

            Error!
            <br>
            ${requestScope.error}

        </c:if>
        </div>
    </body>
</html>
