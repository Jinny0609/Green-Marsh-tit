<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.tit.model.NaverVO"%>
<!doctype html>
<html lang="ko">
<head>
<script type="text/javascript"
	src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.2.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<style type="text/css">
html, div, body, h3 {
	margin: 0;
	padding: 0;
}

h3 {
	display: inline-block;
	padding: 0.6em;
}
</style>
</head>
<body>
	<header>
		<h1>Green Marsh Tit Page</h1>
		<a href="/oauth2/naver/logoutin">회원탈퇴</a> <a
			href="/oauth2/naver/logout">로그아웃</a>
	</header>

	<div
		style="background-color: #15a181; width: 100%; height: 50px; text-align: center; color: white;">
		<h3>로그인 성공</h3>
	</div>

	<br>
<%
    NaverVO naverVO = (NaverVO) session.getAttribute("naverVO");
    String name = naverVO != null ? naverVO.getNickname() : "";
    String email = naverVO != null ? naverVO.getEmail() : "";
%>

<h2>환영합니다. <%= name %>님</h2>
<h4><%= email %></h4>
	<h4 style="text-align: center" id="email"></h4>

</body>
</html>
