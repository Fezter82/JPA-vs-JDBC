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
		<div class="jpaBox">
		<h3>Make a JPA-wish!</h3>
				
				<!-- Form for making a JPA-wish  -->
				
			<form action="MakeAWish" method="post" id="eventform">
				First name: <input type="text" name="firstName"><br/>
				Last name: <input type="text" name="lastName"><br/>
				Age: <input type="text" name="age"><br/>
				Toy 1: <input type="text" name="toy1"><br/>
				Toy 2: <input type="text" name="toy2"><br/>
				Toy 3: <input type="text" name="toy3"><br/>
				How good have you been this year? (1-10)<br/>
				<input type="text" name="howGood"><br/>
				<br/>
				<input type="submit">
			</form>
		</div>
		
		<div class="jdbcBox">
		<h3>Make a JDBC-wish!</h3>
				
				<!-- Form for making a JDBC-wish  -->
				
			<form action="makeAJDBCWish" method="post" id="jdbcForm">
				First name: <input type="text" name="firstName"><br/>
				Last name: <input type="text" name="lastName"><br/>
				Age: <input type="text" name="age"><br/>
				Toy 1: <input type="text" name="toy1"><br/>
				Toy 2: <input type="text" name="toy2"><br/>
				Toy 3: <input type="text" name="toy3"><br/>
				How good have you been this year? (1-10)<br/>
				<input type="text" name="howGood"><br/>
				<br/>
				<input type="submit">
			</form>
		</div>
	
	</div>
	
	<div id="wishes">
	
	<!-- Display all earlier wishes by reading them in from database by using JPA  -->
	
		<div class="jpaBox">
			<c:choose>
			    <c:when test="${kids==null}">
			        <h3>No wishes have been made yet!</h3>
			    </c:when>    
			    <c:otherwise>
			    	<h3>Earlier wishes:</h3>
			        <c:forEach items="${kids}" var="kid">
			        	<div class="kids">
			        	 	<h5>Name: <c:out value="${kid.toString()}"/></h5>
							<h5>Age: <c:out value="${kid.getAge()}"/></h5>
			                <c:forEach items="${kid.getToyList()}" var="toy">
								<ul>
									<li><c:out value="${toy.toString()}"/></li>
								</ul>
				            </c:forEach>
			        	</div>
			        </c:forEach>
			    </c:otherwise>
			</c:choose>
		</div>
		
		<!-- Display all earlier wishes by reading them in from database by using JDBC  -->
		
		<div class="jdbcBox">
			<c:choose>
			    <c:when test="${jdbcKids==null}">
			        <h3>No wishes have been made yet!</h3>
			    </c:when>    
			    <c:otherwise>
			    	<h3>Earlier wishes:</h3>
			        <c:forEach items="${jdbcKids}" var="kid">
			        	<div class="kids">
			        	 	<h5>Name: <c:out value="${kid.toString()}"/></h5>
							<h5>Age: <c:out value="${kid.getAge()}"/></h5>
			                <c:forEach items="${kid.getToyList()}" var="toy">
								<ul>
									<li><c:out value="${toy.toString()}"/></li>
								</ul>
				            </c:forEach>
			        	</div>
			        </c:forEach>
			    </c:otherwise>
			</c:choose>
		</div>
	</div>
	
</body>
</html>