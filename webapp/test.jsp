<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello!</title>
</head>
<body>
<c:choose>
    <c:when test="${fromServlet==null}">
        No attribute by name fromServlet could be found, so we assume you directly contacted the jsp.
        <br />
    </c:when>    
    <c:otherwise>
        The fromServlet attribute could be found, so we assume you come here from a servlet.
        <br />
    </c:otherwise>
</c:choose>

<br />

Hello <b><%= request.getAttribute("fromServlet") == null ? "JSP" : "Servlet" %></b>!

</body>
</html>