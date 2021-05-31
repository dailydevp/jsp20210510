<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags/ch16/textbook" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags/ch16/lecture" %>

<% request.setCharacterEncoding("utf-8"); %>

<!DOCTYPE html>
<html>
<head>

<%@ include file="/WEB-INF/subModules/bootstrapHeader.jsp" %>

<title>Insert title here</title>
</head>
<body>
<div class="container">

	<h1>Add Employees</h1>
	<form action="${pageContext.request.contextPath }/Exam1" method="post">
		LastName : <input type = "text" name="lastName"> <br>
		FirstName : <input type = "text" name = "firstName"> <br>
		birthDate : <input type = "date" name = "birthDate"> <br>
		Photo : <input type = "text" name = "photo"> <br>
		Notes : <br>
		<textarea name="notes" rows="3"></textarea>
		 <br>
		<input type = "submit">
		
	</form>
</div>
</body>
</html>