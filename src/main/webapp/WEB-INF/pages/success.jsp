<%-- 
    Document   : success
    Created on : 03-Jul-2020, 16:03:55
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
        <title>Success!</title>
    </head>
    <body>
        <jsp:include page="header.jsp">
            <jsp:param name="page" value="success" />
        </jsp:include>
        <div class='main'>
            <h1>${successMsg}</h1>
        </div>
    </body>
</html>
