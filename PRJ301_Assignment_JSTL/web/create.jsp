<%-- 
    Document   : create
    Created on : Jun 9, 2023, 10:29:49 AM
    Author     : user
--%>

<%@page import="anhddp.user.UserError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Page</title>
    </head>
    <body>
        <% 
            UserError userError = (UserError)request.getAttribute("USER_ERROR");
            if(userError==null) userError = new UserError();
        %>
        
        Create new user:
        <form action="MainController" method="POST">
            User ID <input type="text" name="userID" required="" /> ${requestScope.USER_ERROR.userIDError} </br>
            Full Name <input type="text" name="fullName" required="" />  ${requestScope.USER_ERROR.userIDError}  </br>
            Role ID <input type="text" name="roleID" value="US" readonly="" /> </br>
            Password <input type="password" name="password" required="" /> </br>
            Confirm <input type="password" name="confirm" required="" />  ${requestScope.USER_ERROR.confirmError} </br>
            <input type="submit" value="Create" name="action" /> 
            <input type="reset" value="Reset" />
             ${requestScope.ERROR}
        </form>
    </body>
</html>
