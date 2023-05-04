<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.tit.model.NaverVO"%>
<%@ page import="com.tit.model.LoginVO" %>
<%@ page import="com.tit.mapper.NaverMapper" %>
<!DOCTYPE html>
<html>
<link href="resources/css/MemberJoin.css" rel="stylesheet" type="text/css" />
<link href="resources/css/MemberJoin2.css" rel="stylesheet" type="text/css" />
<head>
<meta charset="UTF-8">
<title>Main Page</title>
</head>
<body>
<!-- naver -->
<%
    NaverVO naverVO = (NaverVO) session.getAttribute("naverVO");
    String name = naverVO != null ? naverVO.getNickname() : "";
    String email = naverVO != null ? naverVO.getEmail() : "";
%>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid">
   		 <a href="MemberJoin.jsp">
  			<img src="resources/img/logo.png" class="logo" alt="My Logo">
		</a>
  </div>
</nav>

<p class="user-nickname">환영합니다</p>

<!-- <button id="btn" onclick="location.href='/'">로그인페이지로 이동</button> -->


<div class="center">
	<img src="resources/img/쇠박새.png">
	<div class="buttons">
   		 <button class="btn-hover color-8" onclick="location.href='/'">로그인페이지로 이동</button>
	</div>
</div>

<script>
var snsid = '<%= session.getAttribute("Snsid") %>';
//닉네임 요소 가져오기
const nicknameEl = document.querySelector('.user-nickname');

switch (snsid) {
case 'kakao':
  nicknameEl.textContent = "<%=session.getAttribute("usernickname")%>님 환영합니다.";
  break;
case 'naver':
  nicknameEl.textContent = "<%=name%>님 환영합니다.";
  break;
case 'google':
  nicknameEl.textContent = "<%=session.getAttribute("googleNickname")%>님 환영합니다.";
  break;
default:
  nicknameEl.textContent = "<%=session.getAttribute("usernickname")%>님 환영합니다.";
  break;
}
</script>
</body>
</html>