<%-- 
    Document   : contactForm
    Created on : 03-Jul-2020, 09:18:09
    Author     : davej
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<c:url value="/resources/css/style.css" />"
              type="text/css" media="screen" />
        <title>Contact Me</title>
    </head>
    <body>
        <jsp:include page="header.jsp">
            <jsp:param name="page" value="contact-form" />
        </jsp:include>
        <div class="main">
            <h1>Contact Me</h1>
            <p>${model.succesMsg}</p>

            <p>Do you have any questions? Send me a message!</p>
            <form:form class="form-style" action="send-mail" modelAttribute="user" method="POST">
                <label>Name: </label>
                <br />
                <form:input path="username"></form:input>
                    <br />
                <form:errors path="username" />
                <br />
                <label>Email: </label>
                <br />
                <form:input path="email"></form:input>
                    <br />
                <form:errors path="email" />
                <br />
                <label>Message: </label>
                <br />
                <form:textarea path="message" rows="10" cols="50"></form:textarea>
                    <br />
                <form:errors path="message" />
                <br />
                <input type="submit" value="Submit" />
                <br />

            </form:form>
        </div>
    </body>
</html>
