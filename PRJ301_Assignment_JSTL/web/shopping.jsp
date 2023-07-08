<%-- 
    Document   : shopping
    Created on : Jun 15, 2023, 10:15:32 AM
    Author     : moneymaker
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome to my shop</h1>
        <form action="MainController" method="POST">
            <select name="cmbTea">
                <option value="T01- Vai Tea-30">Trà Vải</option>
                <option value="T02- Green Tea-30">Trà Thái Xanh</option>
                <option value="T03- Peach Tea-30">Trà Đào</option>
                <option value="T04- Daisy Tea-30">Trà Hoa Cúc</option>
            </select>
            <select name="cmbQuantity">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="10">10</option>
            </select>
            <input type="submit" value="addCart" name="action" />
        </form>
        <a href="view.jsp">View Cart</a><br/>
        <a href="login.html">Back to Login</a>
        <c:out value="${requestScope.MESSAGE}" />
    </body>
</html>
