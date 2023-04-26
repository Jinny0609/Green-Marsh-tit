<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.tit.model.NaverVO"%>
<%@ page import="com.tit.model.LoginVO" %>
<%@ page import="com.tit.mapper.NaverMapper" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 성공</title>
</head>
<body>
<!-- naver -->
<%
    NaverVO naverVO = (NaverVO) session.getAttribute("naverVO");
    String name = naverVO != null ? naverVO.getNickname() : "";
    String email = naverVO != null ? naverVO.getEmail() : "";
%>

<!-- kakao -->
<p style="display:none" class="kakao"><%= session.getAttribute("usernickname") %>님 환영합니다.</p>
<!-- naver -->
<p style="display:none" class="naver"><%= name %>님 환영합니다.</p>
<p><%= naverVO %></p>
<button id="btn">로그인페이지로 이동</button>
<!-- naver -->


</body>
</html>