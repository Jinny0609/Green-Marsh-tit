<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.tit.model.LoginVO"%>
<%@ page import="com.tit.model.NaverVO"%>
<%@ page import="com.tit.mapper.NaverMapper"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Document</title>
<link rel="stylesheet" href="resources/css/Medical.css">
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
			<a class="navbar-brand" href="#">Green Marsh Tit</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarColor01"
				aria-controls="navbarColor01" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarColor01">
				<ul class="navbar-nav me-auto">
					<li class="nav-item"><a class="nav-link active" href="#">Home
							<span class="visually-hidden">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Features</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#">About</a></li>
				</ul>
				<span style="color: white" class="user-nickname">닉네임</span>


		<button type="button" id="logoutBtn" class="btn btn-light basic">로그아웃</button>
		<button type="button" id="withdrawBtn" class="btn btn-light basic">회원탈퇴</button>
			</div>
		</div>
	</nav>

	<div class="project_box">
		<div class="card mb-3" id="project_item2">
			<h3 class="card-header">기준정보 관리 기능 구현</h3>
			<div class="card-body">
				<h5 class="card-title">SNS 서비스 연동 회원가입</h5>
			</div>
			<svg xmlns="http://www.w3.org/2000/svg"
				class="d-block user-select-none" width="100%" height="200"
				aria-label="Placeholder: Image cap" focusable="false" role="img"
				preserveAspectRatio="xMidYMid slice" viewBox="0 0 318 180"
				style="font-size: 1.125rem; text-anchor: middle">
          <rect width="100%" height="100%" fill="#868e96"></rect>
          <text x="50%" y="50%" fill="#dee2e6" dy=".3em"></text>
          <text x="50%" y="50%" fill="#dee2e6" dy=".3em">Image cap</text>
        </svg>
			

			<div class="card-body">
				<a href="#" class="card-link">페이지로 이동</a> <a href="#"
					class="card-link">Another link</a>
			</div>
			<div class="card-footer text-muted">2023.04.17 ~ 2023.05.11</div>
		</div>
		<div class="card mb-3" id="project_item">
			<h3 class="card-header">IoT기반정보 대시보드 구현</h3>
			<div class="card-body">
				<h5 class="card-title">팀 주제</h5>
			</div>
			<svg xmlns="http://www.w3.org/2000/svg"
				class="d-block user-select-none" width="100%" height="200"
				aria-label="Placeholder: Image cap" focusable="false" role="img"
				preserveAspectRatio="xMidYMid slice" viewBox="0 0 318 180"
				style="font-size: 1.125rem; text-anchor: middle">
          <rect width="100%" height="100%" fill="#868e96"></rect>
          <text x="50%" y="50%" fill="#dee2e6" dy=".3em">Image cap</text>
        </svg>
			<div class="card-body">
				<a href="#" class="card-link">페이지로 이동</a> <a href="#"
					class="card-link">Another link</a>
			</div>
			<div class="card-footer text-muted">2023.05.12 ~ 2023.05.24</div>
		</div>
		<div class="card mb-3" id="project_item">
			<h3 class="card-header">병원솔루션 SCM관리프로세스</h3>
			<div class="card-body">
				<h5 class="card-title">팀 주제</h5>
			</div>
			<svg xmlns="http://www.w3.org/2000/svg"
				class="d-block user-select-none" width="100%" height="200"
				aria-label="Placeholder: Image cap" focusable="false" role="img"
				preserveAspectRatio="xMidYMid slice" viewBox="0 0 318 180"
				style="font-size: 1.125rem; text-anchor: middle">
          <rect width="100%" height="100%" fill="#868e96"></rect>
          <text x="50%" y="50%" fill="#dee2e6" dy=".3em">Image cap</text>
        </svg>
			<div class="card-body">
				<a href="#" class="card-link">페이지로 이동</a> <a href="#"
					class="card-link">Another link</a>
			</div>
			<div class="card-footer text-muted">2023.05.25 ~ 2023.06.30</div>
		</div>
	</div>
	<script>
 var snsid = '<%= session.getAttribute("Snsid") %>';
// 로그아웃 버튼 요소 가져오기
var logoutButton = document.querySelector("#logoutBtn");
// 회원탈퇴 버튼 요소 가져오기
var withdrawButton = document.querySelector("#withdrawBtn");
// 닉네임 요소 가져오기
const nicknameEl = document.querySelector('.user-nickname');

logoutButton.addEventListener("click", function() {
	  // 로그아웃 로직 실행
	  if (snsid === 'kakao') {
	    location.href = 'https://kauth.kakao.com/oauth/logout?client_id=bb6fa36306e975c901f7c29c94043b31&logout_redirect_uri=http://localhost:8080/logout';
	  } else if (snsid === 'naver') {
	    location.href = '/oauth2/naver/logout';
	  } else if (snsid === 'google') {
	    location.href = '/oauth2/google/logout';
	  } else if (snsid === 'basic') {
	    location.href = '/MainMemberlogout';
	  } else {
	    alert('잘못된 SNS 값입니다.');
	  }
	});

	withdrawButton.addEventListener("click", function() {
	  // 회원탈퇴 로직 실행
	  if (snsid === 'kakao') {
	    location.href = '/remove';
	  } else if (snsid === 'naver') {
	    location.href = '/oauth2/naver/logoutin';
	  } else if (snsid === 'google') {
	    location.href = '/oauth2/google/acount_rm';
	  } else if (snsid === 'basic') {
	    location.href = '/MainMemberDelete';
	  } else {
	    alert('잘못된 SNS 값입니다.');
	  }
	});

switch (snsid) {
case 'kakao':
  nicknameEl.textContent = "<%=session.getAttribute("usernickname")%>님";
  break;
case 'naver':
  nicknameEl.textContent = "<%=name%>님";
  break;
case 'google':
  nicknameEl.textContent = "<%=session.getAttribute("googleNickname")%>님";
  break;
  
case 'basic':
	  nicknameEl.textContent = "<%=session.getAttribute("usernickname")%>님";
	  break;
default:
  nicknameEl.textContent = "닉네임";
  break;
}

</script>
</body>
</html>