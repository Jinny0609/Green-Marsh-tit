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
    String snsid = (String) session.getAttribute("Snsid");
%>

<!-- kakao -->
<p style="display:none" class="kakao"><%= session.getAttribute("usernickname") %>님 환영합니다.</p>
<!-- naver -->
<p style="display:none" class="naver"><%= name %>님 환영합니다.</p>
<button id="btn" onclick="location.href='/'">로그인페이지로 이동</button>
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
  } else {
%>
<script>
  document.querySelector('.naver').style.display = 'none';
  document.querySelector('.kakao').style.display = 'none';
</script>
<%
  }
%>


</body>
</html>