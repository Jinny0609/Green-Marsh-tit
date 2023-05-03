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
    String snsid = (String) session.getAttribute("Snsid");
%>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid">
   		 <a href="MemberJoin.jsp">
  			<img src="resources/img/logo.png" class="logo" alt="My Logo">
		</a>
  </div>
</nav>
<!-- kakao -->
<p style="display:none" class="kakao"><%= session.getAttribute("usernickname") %>님 환영합니다.</p>
<!-- naver -->
<p style="display:none" class="naver"><%= name %>님 환영합니다.</p>
<!-- main -->
<p style="display:none" class="basic"><%= session.getAttribute("usernickname") %>님 환영합니다.</p>
<!-- google -->
<p style="display:none" class="google"><%= session.getAttribute("googleNickname") %>님 환영합니다.</p>
<!-- <button id="btn" onclick="location.href='/'">로그인페이지로 이동</button> -->
<!-- naver -->
<%
if (snsid != null && "naver".equals(snsid)) {
%>
<script>
  document.addEventListener('DOMContentLoaded', function() {
    // 로그아웃 버튼 활성화
    document.querySelector('.naver').style.display = 'block';

    // 로그아웃 버튼 클릭 시
    document.querySelector('#btn').addEventListener('click', function() {
      // 네이버 로그아웃 처리할 코드 작성
      // ...
      // 로그아웃 버튼 다시 숨기기
      document.querySelector('.naver').style.display = 'none';
    });
  });
</script>
<%
  } if (snsid != null && "kakao".equals(snsid)) {
%>
<script>
  document.addEventListener('DOMContentLoaded', function() {
    // 로그아웃 버튼 활성화
    document.querySelector('.kakao').style.display = 'block';

    // 로그아웃 버튼 클릭 시
    document.querySelector('#btn').addEventListener('click', function() {
      // 네이버 로그아웃 처리할 코드 작성
      // ...
      // 로그아웃 버튼 다시 숨기기
      document.querySelector('.kakao').style.display = 'none';
    });
  });
</script>
<%
  } if (snsid != null && "basic".equals(snsid)) {
%>
<script>
  document.addEventListener('DOMContentLoaded', function() {
    // 로그아웃 버튼 활성화
    document.querySelector('.basic').style.display = 'block';

    // 로그아웃 버튼 클릭 시
    document.querySelector('#btn').addEventListener('click', function() {
      // 네이버 로그아웃 처리할 코드 작성
      // ...
      // 로그아웃 버튼 다시 숨기기
      document.querySelector('.basic').style.display = 'none';
    });
  });
</script>
<%
  } if (snsid != null && "google".equals(snsid)) {
%>
<script>
  document.addEventListener('DOMContentLoaded', function() {
    // 로그아웃 버튼 활성화
    document.querySelector('.google').style.display = 'block';

    // 로그아웃 버튼 클릭 시
    document.querySelector('#btn').addEventListener('click', function() {
      // 네이버 로그아웃 처리할 코드 작성
      // ...
      // 로그아웃 버튼 다시 숨기기
      document.querySelector('.google').style.display = 'none';
    });
  });
</script>
<%
  } else {
%>
<script>
  document.querySelector('.naver').style.display = 'none';
  document.querySelector('.kakao').style.display = 'none';
  document.querySelector('.basic').style.display = 'none';
</script>
<%
  }
%>

<div class="center">
	<img src="resources/img/쇠박새.png">
	<div class="buttons">
   		 <button class="btn-hover color-8" onclick="location.href='/'">로그인페이지로 이동</button>
	</div>
</div>
</body>
</html>