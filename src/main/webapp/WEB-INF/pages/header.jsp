<%-- 
    Document   : header
    Created on : 03-Jul-2020, 11:51:52
    Author     : davej
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="true"%>

<div id="header">
    <c:if test="${param.page == 'home'}">
	<c:set var="homeClass" value="nav-active" />
    </c:if>
    <c:if test="${param.page != 'home'}">
	<c:set var="homeClass" value="nav-inactive" />
    </c:if>
    <a href="${pageContext.request.contextPath}" id="home" class="${homeClass}">My Project</a>
	
    <c:if test="${param.page == 'about'}">
	<a href="${pageContext.request.contextPath}/about" class="nav-active">About Me</a>
    </c:if>
    <c:if test="${param.page != 'about'}">
	<a href="${pageContext.request.contextPath}/about" class="nav-inactive">About Me</a>
    </c:if>
        
    <c:if test="${param.page == 'contact-form'}">
        <a href="${pageContext.request.contextPath}/contact-form" class="nav-active">Contact Me</a>
    </c:if>
    <c:if test="${param.page != 'contact-form'}">
        <a href="${pageContext.request.contextPath}/contact-form" class="nav-inactive">Contact Me</a>
    </c:if>
    <c:if test="${param.page == 'stats'}">
	<a href="${pageContext.request.contextPath}/statistics" class="nav-active">Statistics</a>
    </c:if>
    <c:if test="${param.page != 'stats'}">
        <a href="${pageContext.request.contextPath}/statistics"	class="nav-inactive">Statistics</a>
    </c:if>
</div>

	<div id="subHeader">
            <sec:authorize access="!isAuthenticated()">
                <a href="${pageContext.request.contextPath}/login">Login</a>
                <a href="${pageContext.request.contextPath}/create-user">Sign Up</a>
              </sec:authorize>
              <sec:authorize access="isAuthenticated()">
                <a href="${pageContext.request.contextPath}/user/profile">Profile</a>
                <a href="${pageContext.request.contextPath}/logout">Logout</a>
              </sec:authorize>
        </div>
