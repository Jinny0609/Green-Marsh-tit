<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.tit.model.LoginVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 HOME</title>
</head>
<body>
<p><%= session.getAttribute("usernickname") %>님 환영합니다.</p>
<input type="button" id="bt" style="display:none" value="로그아웃" onclick="location.href='https://kauth.kakao.com/oauth/logout?client_id=bb6fa36306e975c901f7c29c94043b31&logout_redirect_uri=http://localhost:8080/logout'">
<input type="button" id="bt1" style="display:none" value="로그아웃1">
<input type="button" id="bt2" style="display:none" value="로그아웃2">
<input type="button" id="btn" style="display:none" value="회원탈퇴" onclick="location.href='/remove'">
<%
LoginVO loginVO = (LoginVO) session.getAttribute("loginVO");
if (loginVO != null && "kakao".equals(loginVO.getSns())) {
%>
<script>
  document.addEventListener('DOMContentLoaded', function() {
    // 로그아웃 버튼 활성화
    document.querySelector('#bt').style.display = 'inline-block';
    document.querySelector('#btn').style.display = 'inline-block';

    // 로그아웃 버튼 클릭 시
    document.querySelector('#bt','#btn').addEventListener('click', function() {
      // 네이버 로그아웃 처리할 코드 작성
      // ...
      // 로그아웃 버튼 다시 숨기기
      document.querySelector('#bt').style.display = 'none';
      document.querySelector('#btn').style.display = 'none';
    });
  });
</script>
<%
  } else {
%>
<script>
  document.querySelector('#bt').style.display = 'none';
</script>
<%
  }
%>
</body>
</html>