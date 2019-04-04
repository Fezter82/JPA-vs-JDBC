<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Merry Christmas!</title>
<style>
     <%@ include file="main.css"%>
</style>
</head>
<body>

	<div id="wishBox">
		<h3>Message from Santa!</h3><br/>
		<c:choose>
			<c:when test="${message==null}">
		        <h3>You have not sent any wish list yet!</h3>
		    </c:when>    
		    <c:otherwise>
		    	<c:out value="${message}"/>
		    </c:otherwise>
		</c:choose>
		
		<br/>
		<br/>
		
		<form action="loadWishes" method="post">
			<input type="submit" value="...tillbaka till start">
		</form>	
	</div>

	
</body>
</html>