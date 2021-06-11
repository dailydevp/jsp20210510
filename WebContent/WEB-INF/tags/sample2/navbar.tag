<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

  
  
    
		   
		<c:if test="${empty sessionScope.userLogined }">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">
    <i class="fab fa-java"></i>
  </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

      
				<ul class="nav nav-tabs">
			 <img src="<%= request.getContextPath() %>/pic/circle.jpeg" alt="" width="50" height="50">
			 
			      <li class="nav-item active">
			        <a class="nav-link active" aria-current="page" href="<%= request.getContextPath() %>/sample2/main"><i class="fas fa-home"></i>HOME <span class="sr-only">(current)</span></a>
			      </li>
      		</ul>
      		
      		<ul class="nav justify-content-end">
			  <li class="nav-item">
			    <a class="nav-link" href="<%= request.getContextPath() %>/sample2/member/signup">
			    <i class="fas fa-user-plus"></i>회원가입</a>
			  </li>
			  
			  <li class="nav-item">
			    <a class="nav-link " href="<%= request.getContextPath() %>/sample2/member/login">로그인</a>
			  </li>
		 	    <li class="nav-item">
			    <a class="nav-link" href="<%= request.getContextPath() %>/sample2/board/list">글 목록 보기</a>
			  </li>
			  </ul>
		</c:if>
		
		<c:if test="${not empty sessionScope.userLogined }">
		
		<ul class="nav nav-tabs">
			  <li class="nav-item">
			    <a class="nav-link" href="<%= request.getContextPath() %>/sample2/member/info">정보보기</a>
			  </li>
			    <li class="nav-item">
			    <a class="nav-link" href="<%= request.getContextPath() %>/sample2/member/logout">로그아웃</a>
			  </li>
			    <li class="nav-item">
			    <a class="nav-link" href="<%= request.getContextPath() %>/sample2/board/write">글쓰기</a>
			  </li>
			    <li class="nav-item">
			    <a class="nav-link" href="<%= request.getContextPath() %>/sample2/member/list">회원 목록 보기</a>
			  </li>
			    <li class="nav-item">
			    <a class="nav-link" href="<%= request.getContextPath() %>/sample2/board/list">글 목록 보기</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
			  </li>
		</ul>
		
		</c:if>		    
		 

		  </div>
		 </nav>
		
  </div>
</nav>

<!--

<div>
	<a href="<%= request.getContextPath() %>/sample2/main">메인</a>
	<a href="<%= request.getContextPath() %>/sample2/member/signup">회원가입</a>
	<c:if test="${empty sessionScope.userLogined }" >
		<a href="<%= request.getContextPath() %>/sample2/member/login">로그인</a>
	</c:if>
	
	<c:if  test = "${not empty sessionScope.userLogined }">
		<a href="<%= request.getContextPath() %>/sample2/member/info">정보보기</a>
		<a href="<%= request.getContextPath() %>/sample2/member/logout">로그아웃</a>
		<a href="<%= request.getContextPath() %>/sample2/board/write">글쓰기</a>	
		<a href="<%= request.getContextPath() %>/sample2/member/list">회원 목록보기</a>
	</c:if>
		<a href="<%= request.getContextPath() %>/sample2/board/list">글 목록보기</a>

</div>

-->