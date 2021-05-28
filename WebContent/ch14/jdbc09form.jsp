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
<!--앞에 request.contextpath 적어줘야 /jsp/같은애들. 모두가 다 다르니까  -->
	<form action="${pageContext.request.contextPath }/JDBC09Servlet" method="post">
		id : <input type = "text" name="id">
		<br>
		<input type = "submit">
	</form>
</div>
</body>
</html>