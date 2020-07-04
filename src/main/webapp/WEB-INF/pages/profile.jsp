<%-- 
    Document   : profile
    Created on : 02-Jul-2020, 17:10:56
    Author     : davej
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="true"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<c:url value="/resources/css/style.css" />"
	type="text/css" media="screen" />
        <title>Your Profile Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp">
		<jsp:param name="page" value="profile" />
	</jsp:include>
    <div class="main">
        <form:form class="form-style" action="profile"
			modelAttribute="user" method="POST">
            <label>Username: </label>
                    <br />
                    <p>${user.username}</p>
                            
                            
                            <br />            
            <label>Password: </label>
                    <br />
                        <form:hidden path="username" value="${user.username}" />
                            <form:password path="password" value="${user.password}"></form:password>
                            
                            <form:errors path="password" />
                            <br />
                            <label>Email: </label>
                            <br />
                            <form:input path="email" value="${user.email}"></form:input>
                            
                            <form:errors path="email" />
                            <br />  
        <input type="submit" value="Save" />
			<br />
                        <p>${msg}</p>
	</form:form>  
        
    </div>
    
    </body>
</html>
