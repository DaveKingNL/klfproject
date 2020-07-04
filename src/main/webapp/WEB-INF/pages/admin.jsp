<%-- 
    Document   : admin
    Created on : 02-Jul-2020, 17:08:53
    Author     : davej
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin landing page</title>
    </head>
    <body>
        <div class="main">
            <h1>Hello Admin!</h1>
            <p>${userName}</p>
        </div>
    </body>
</html>
