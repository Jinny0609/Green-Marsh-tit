<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 HOME</title>
</head>
<body>
<p><%= session.getAttribute("usernickname") %>님 환영합니다.</p>
<input type="button" value="로그아웃" onclick="location.href='/logout'">
<input type="button" value="회원탈퇴" onclick="location.href='/remove'">
</body>
</html>