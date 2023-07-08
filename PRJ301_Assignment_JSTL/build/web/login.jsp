<%-- 
    Document   : login
    Created on : Jun 1, 2023, 8:48:04 AM
    Author     : moneymaker
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         INPUT YOUR INFORMATION
        <form action="MainController" method="POST">
            User ID <input type="text" name="userID" value="" required/><br/>
            Password <input type="password" name="password" value="" required/><br/>
            <input type="submit" value="Login" name="action" />
            <input type="reset" value="Reset" name="action" />
        </form>
         <a href="create.html">Create user</a>
        <c:set var="error" value="${requestScope.ERROR}" />
        <c:if test="${empty error}">
            <c:set var="error" value="" />
        </c:if>
        ${error}
    </body>
</html>
