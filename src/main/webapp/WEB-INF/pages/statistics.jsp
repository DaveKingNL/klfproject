<%-- 
    Document   : statistics
    Created on : 03-Jul-2020, 18:50:10
    Author     : davej
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@ page import="java.util.Date"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<c:url value="/resources/css/style.css" />"
              type="text/css" media="screen" />
        <title>Statistics</title>
    </head>
    <body>
        <jsp:include page="header.jsp">
            <jsp:param name="page" value="home" />
        </jsp:include>
        <div class="main">
            <h1>Activity Report</h1>
            <c:if test="${!empty activities}">
                <jsp:useBean id="now" class="java.util.Date" />

                <table>
                    <tr>
                        <th>Name</th>
                        <th>Activity</th>
                        <th>Amount</th>
                        <th>First Occurrence</th>
                        <th>Last Occurrence</th>
                    </tr>
                    <c:forEach items="${activities}" var="activity">
                        <tr>
                            <td>${activity.username}</td>
                            <td>${activity.activityName}</td>
                            <td>${activity.amount}</td>
                            <td><fmt:formatDate type = "both" dateStyle = "short" timeStyle = "short" value = "${activity.firstOccurrence}" /></td>
                            <td><fmt:formatDate type = "both" dateStyle = "short" timeStyle = "short" value = "${activity.lastOccurrence}" /></td>
                        </tr>
                    </c:forEach>
                </table>
                <sec:authorize access="isAuthenticated()">
                    <form:form class="form-style" action="pressing-button" method="POST">

                        <input type="submit" value="Submit" />
                    </form:form>
                </sec:authorize>
            </c:if>

        </div>
    </body>
</html>
