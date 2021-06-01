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
	<form action="" method="post">
		id : <input type ="text" value ="${employee.id }" readonly> <br>
		Last Name : <input type= "text" value ="${employee.lastName }"> <br>
		First Name : <input type="text" value="${employee.firstName }"> <br>
		Notes : <br>
		<textarea rows = "5"><c:out value = "${employee.notes }"/></textarea>
		<br>
		<input type="submit" value ="수정">
	</form>
</div>
</body>
</html>