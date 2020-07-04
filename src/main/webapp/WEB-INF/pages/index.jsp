<%-- 
    Document   : index
    Created on : 02-Jul-2020, 16:16:54
    Author     : davej
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<c:url value="/resources/css/style.css" />"
	type="text/css" media="screen" />
        <title>My Project Home</title>
    </head>
    <body>
        <jsp:include page="header.jsp">
		<jsp:param name="page" value="home" />
	</jsp:include>
        <div class="main">
        <h1>My project, your project, everybody's project!</h1>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis elementum vulputate metus eget congue. Integer iaculis lectus at sollicitudin semper. Fusce sit amet lobortis libero. Interdum et malesuada fames ac ante ipsum primis in faucibus. Aenean eu hendrerit magna, in porttitor sem. Ut ornare blandit nibh.</p>
        <p>Maecenas aliquam pellentesque magna. Integer porttitor enim a tellus placerat aliquet. Nunc eget porta lectus, nec molestie massa. Maecenas efficitur venenatis elit sed sagittis. Nam malesuada nisi ut libero dictum blandit. Maecenas blandit posuere elit id eleifend. Nunc viverra elit ut dui sollicitudin, non efficitur ligula dapibus. Aliquam imperdiet dignissim vehicula. </p>
        </div>
        
    </body>
</html>
