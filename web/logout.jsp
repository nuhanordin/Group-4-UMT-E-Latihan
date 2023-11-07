<%-- 
    Document   : logout
    Created on : 11 Jun 2023, 10:45:36 pm
    Author     : nuha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            // Invalidate the session
            session.invalidate();
            // Redirect the user to the login page
            response.sendRedirect("login.jsp");
        %>
    </body>
</html>
