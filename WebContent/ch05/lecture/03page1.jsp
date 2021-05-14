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
	<h1>page 1 jsp</h1>
	
	<%
	pageContext.setAttribute("page-attr3", "page-value3"); // 서로 다른거(1번에서 꺼냄)
	request.setAttribute("req-attr3", "req-value3"); // 같은것
	%>
	
	<jsp:include page ="03page2.jsp"></jsp:include>
	
	<hr>
	
	<%=pageContext.getAttribute("page-attr3")%> //2번에서 꺼낸것.
</div>
</body>
</html>