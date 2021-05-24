<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ tag dynamic-attributes="optionMap" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ attribute name="name" required="true" %>

<%-- <select name="abc" a = "b" c = "d"></select> --%>
<select name = "${name }">
	<c:forEach items = "${optionMap }" var="option">
		<option value="${option.key }"> ${option.value }</option>
	</c:forEach>
</select>



