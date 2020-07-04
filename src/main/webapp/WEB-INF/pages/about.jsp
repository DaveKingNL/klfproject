<%-- 
    Document   : company
    Created on : 03-Jul-2020, 09:17:26
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
        <title>About Me</title>
    </head>
    <body>
        
        <jsp:include page="header.jsp">
		<jsp:param name="page" value="about" />
	</jsp:include>
        
        <div class="main">
            <h1>Let's get into business together!</h1>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eget lectus libero. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus sit amet ipsum magna. Proin sagittis consequat enim ac euismod. Suspendisse arcu enim, posuere lobortis lectus at, placerat venenatis mauris. Integer posuere, ipsum sed tempus fermentum, lorem eros efficitur nunc, id accumsan metus neque et erat. Donec consectetur, risus ac rutrum pretium, urna sapien ornare lacus, ac efficitur nulla metus nec sapien.</p>

            <p>Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Phasellus sed nibh mauris. Donec aliquam accumsan elit. Sed vel mauris nisi. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Quisque laoreet, odio at convallis mollis, lectus turpis maximus metus, id finibus nibh purus nec turpis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Aenean tempor pulvinar dolor eu bibendum. Sed facilisis nunc vitae odio dignissim varius.</p> 
        </div>
    </body>
</html>
