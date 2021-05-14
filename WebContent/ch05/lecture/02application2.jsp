<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*" %>

<% request.setCharacterEncoding("utf-8"); %>

<!DOCTYPE html>
<html>
<head>

<%@ include file="/WEB-INF/subModules/bootstrapHeader.jsp" %>

<title>Insert title here</title>
</head>
<body>
<div class="container">
	<h1>attribute 꺼내보기</h1>
	<h3><%= request.getAttribute("req-attr1") %></h3> // 다른 request
	<h3><%= session.getAttribute("session-attr1") %></h3> // 같은 session
	<h3><%= application.getAttribute("app-attr1") %></h3> //session보다 넓은 영역
</div>
</body>
</html>