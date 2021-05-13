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
<%--
("같은 request에서 꺼낼때 쓸 이름" , )
 --%>
	<%
	String[] str = {"java", "jsp", "spring" , "servlet" , "css" };
	request.setAttribute("list", str);
	
	
	
	%>
	
	<jsp:forward page="11forward-attribute-b.jsp"></jsp:forward>
</div>
</body>
</html>