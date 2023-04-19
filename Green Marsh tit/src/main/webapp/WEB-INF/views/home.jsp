<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="false" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- https://cobook.tistory.com/31사이트 들어가서 보자 -->
<link href= "resources/LoginPage.css"rel="stylesheet" type="text/css" />
</head>
<body>
 <div class="login">
	<div class="login-html">
		<input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">로그인</label>
		<input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">회원가입</label>
		<div class="login-form">
			<div class="sign-in-htm">
				<div class="group">
					<!-- <label for="user" class="label">아이디</label> -->
					<input id="user" type="text" class="input"placeholder="아이디">
				</div>
				<div class="group">
					<!-- <label for="pass" class="label">패스워드</label> -->
					<input id="pass" type="password" class="input" data-type="password"placeholder="패스워드">
				</div>
				<div class="group">
					<input id="check" type="checkbox" class="check" checked>
					<label for="check"><span class="icon"></span>로그인정보 기억하기</label>
				</div>
				
				<div class="social-icons">
				    <a onclick="location.href='http://localhost:8080/login'"><img src="resources/img/naver.png" class="social-icon"></a>
				    <a href="#"><img src= "resources/img/google.png"class="social-icon"></a>
				    <a href="#"><img src= "resources/img/kakao.png" class="social-icon"></a>
				</div>
				
				<div class="group">
					<input type="submit" class="button" value="로그인">
				</div>
				
				<div class="hr"></div>
				<div class="foot-lnk">
					<a href="#forgot">비밀번호를 잊으셨습니까?</a>
				</div>
			</div>
			<div class="sign-up-htm">
				<div class="group">
					<input id="user" type="text" class="input"placeholder="아이디">
				</div>
				<div class="group">
					<input id="pass" type="password" class="input" data-type="password"placeholder="패스워드">
				</div>
				
				<div class="group">
					<input id="pass" type="password" class="input" data-type="password"placeholder="패스워드 확인">
				</div>
				
				<div class="group">
					<input id="pass" type="text" class="input"placeholder="이메일">
				</div>
				
				<div class="group">
					<input type="submit" class="button" value="회원가입">
				</div>
				
				<div class="hr"></div>
				<div class="foot-lnk">
					<label for="tab-1"><a>이미 회원이십니까?</a></label>
				</div>
			</div>
		</div>
	</div>
</div>
   <script src="https://use.fontawesome.com/releases/v5.15.4/js/all.js" crossorigin="anonymous"></script>
</body>

</html>
