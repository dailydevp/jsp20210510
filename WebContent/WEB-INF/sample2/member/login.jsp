<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="s2" tagdir="/WEB-INF/tags/sample2"%>


<% request.setCharacterEncoding("utf-8"); %>

<!DOCTYPE html>
<html>
<head>

<%@ include file="/WEB-INF/subModules/bootstrapHeader.jsp" %>

<title>Insert title here</title>
</head>
<body>
<s2:navbar/>
<div class="container">
	<h1>로그인</h1>
	<form method="post" action="${pageContext.request.contextPath }/sample2/member/login">
	<div class="form-group">
		id <br>
		<input type="text" name="id"> <br>
	</div>
		pw <br>
		<input type="password" name="password"> <br>
		<input type="submit" value="로그인">
	</form>
	
	<s2:message></s2:message>
</div>
</body>
</html>