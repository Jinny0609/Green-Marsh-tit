<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>패스워드 찾기 페이지 입니다.</title>
<link href="resources/css/findpassword.css" rel="stylesheet" type="text/css" />
<link href="resources/css/buttons.css" rel="stylesheet" type="text/css" />

<!-- jQuery 라이브러리 추가 -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<!-- jQuery UI 라이브러리 추가 -->
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>

<!-- 모달 창을 표시하는 jQuery 코드 -->
<script>
$(document).ready(function() {
  <% if ("passwordPopup".equals(request.getAttribute("viewName"))) { %>
    $("#passwordPopup").load("passwordPopup.jsp", function() {
      $(this).dialog({
        modal: true,
        width: 600,		// 너비 
        height: 450,	// 높이  
        buttons: {
          "확인": function() {
            $(this).dialog("close");
          }
        }
      });
    });
  <% } else if ("error".equals(request.getAttribute("viewName"))) { %>
    $("#error").load("error.jsp", function() {
      $(this).dialog({
        modal: true,
        width: 600,		// 너비
        height: 450,	// 높이 
        buttons: {
          "확인": function() {
            $(this).dialog("close");
          }
        }
      });
    });
  <% } %>
});
</script>




</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid">
   		 <a href="#">
  			<img src="resources/img/logo.png" class="logo" alt="My Logo">
		</a>
  </div>
</nav>

	<div class="boxy">
		<div>
			<h1>Green Marsh Tit</h1>
		</div>
		<div class="title">
			<h2>비밀번호를 찾고자 하는 아이디를 입력해주세요.</h2>
		</div>
		<form action="/findpassword" method="post">
		    <div class="boxy1">
		        <input type="text" name="email" placeholder="이메일을 입력하세요." required>
		    </div>
		    <div class="boxy2">
		        <button type="submit" class="btn-hover color-8">비밀번호찾기</button>
		        <button type="button" class="btn-hover color-8" onclick="location.href='/'">뒤로가기</button>
		    </div>
		</form>
	</div>
	
	<!-- 비밀번호 팝업 모달 창 -->
	<div id="passwordPopup" title="비밀번호" style="display:none;">
	  <p>비밀번호: ${password}</p>
	</div>
	
	<!-- 에러 모달 창 -->
	<div id="error" title="오류" style="display:none;">
	  <p>${errorMessage}</p>
	</div>
</body>
</html>