<%-- 
    Document   : createUserForm
    Created on : 02-Jul-2020, 19:51:13
    Author     : davej
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <link rel="stylesheet" href="<c:url value="/resources/css/style.css" />"
              type="text/css" media="screen" />
        <title>Register</title>
    </head>
    <body>
        <jsp:include page="header.jsp">
            <jsp:param name="page" value="create-user" />
        </jsp:include>
        <div class="main">
            <form:form class="form-style" action="creating-user" modelAttribute="user" method="POST">
                <label>Name: </label>
                <br />
                <form:input path="username"></form:input>

                <form:errors path="username" />
                <br />
                <label>Email: </label>
                <br />
                <form:input path="email"></form:input>

                <form:errors path="email" />
                <br />
                <label>Password: </label>
                <br />
                <form:password path="password"></form:password>

                <form:errors path="password" />
                <br />
                <input type="submit" value="Submit" />
                <br />
                <p>${msg}</p>

            </form:form>
        </div>
    </body>
</html>