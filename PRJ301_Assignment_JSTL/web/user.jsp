<%-- 
    Document   : user
    Created on : Jun 1, 2023, 8:49:07 AM
    Author     : moneymaker
--%>

<%@page import="anhddp.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>User Information</h1>
    <c:if test="${sessionScope.LOGIN_USER == null || sessionScope.LOGIN_USER.roleID ne 'US'}">
        <c:redirect url="login.html"></c:redirect>
    </c:if>

    User ID${sessionScope.LOGIN_USER.userID}
    Full Name${sessionScope.LOGIN_USER.fullName}
    Password${sessionScope.LOGIN_USER.password}
    Role ID${sessionScope.LOGIN_USER.roleID}
</body>
</html>
