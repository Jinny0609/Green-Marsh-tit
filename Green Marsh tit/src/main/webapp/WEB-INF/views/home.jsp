<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
	<meta name="google-signin-client_id" content="YOUR_CLIENT_ID.apps.googleusercontent.com">
	<title>Home</title>
	<script src="https://apis.google.com/js/platform.js" async defer></script>
</head>
<body>
<h1>
	구글로그인 테스트
</h1>
	
	<div class="g-signin2" data-onsuccess="onSignIn"></div>
</body>
</html>
