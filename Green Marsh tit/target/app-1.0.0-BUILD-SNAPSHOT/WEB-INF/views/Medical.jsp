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
    String snsid = (String) session.getAttribute("Snsid");
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
				<button style="display: none" type="button"
					class="btn btn-light kakao" onclick="location.href='https://kauth.kakao.com/oauth/logout?client_id=bb6fa36306e975c901f7c29c94043b31&logout_redirect_uri=http://localhost:8080/logout'">로그아웃</button>
				<button style="display: none" type="button"
					class="btn btn-light naver" onclick="location.href='/oauth2/naver/logout'">로그아웃</button>
				<button style="display: none" type="button"
					class="btn btn-light google">로그아웃</button>
				<button style="display: none" type="button"
					class="btn btn-light kakao" onclick="location.href='/remove'">회원탈퇴</button>
				<button style="display: none" type="button"
					class="btn btn-light naver" onclick="location.href='/oauth2/naver/logoutin'">회원탈퇴</button>
				<button style="display: none" type="button"
					class="btn btn-light google">회원탈퇴</button>
			</div>
		</div>
	</nav>

	<div class="project_box">
		<div class="card mb-3" id="project_item2">
			<h3 class="card-header">Card header</h3>
			<div class="card-body">
				<h5 class="card-title">Special title treatment</h5>
				<h6 class="card-subtitle text-muted">Support card subtitle</h6>
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
				<p class="card-text">Some quick example text to build on the
					card title and make up the bulk of the card's content.</p>
			</div>

			<div class="card-body">
				<a href="#" class="card-link">Card link</a> <a href="#"
					class="card-link">Another link</a>
			</div>
			<div class="card-footer text-muted">2 days ago</div>


		</div>
		<div class="card mb-3" id="project_item">
			<h3 class="card-header">Card header</h3>
			<div class="card-body">
				<h5 class="card-title">Special title treatment</h5>
				<h6 class="card-subtitle text-muted">Support card subtitle</h6>
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
				<p class="card-text">Some quick example text to build on the
					card title and make up the bulk of the card's content.</p>
			</div>

			<div class="card-body">
				<a href="#" class="card-link">Card link</a> <a href="#"
					class="card-link">Another link</a>
			</div>
			<div class="card-footer text-muted">2 days ago</div>
		</div>
	</div>
	</div>
	</div>

	<%
if (snsid != null && "naver".equals(snsid)) {
%>
	<script>
  document.addEventListener('DOMContentLoaded', function() {
    // 로그아웃 버튼 활성화
    document.querySelectorAll('.naver')[0].style.display = 'inline-block';
    document.querySelectorAll('.naver')[1].style.display = 'inline-block';

    // 로그아웃 버튼 클릭 시
    document.querySelector('.naver').addEventListener('click', function() {
      // 네이버 로그아웃 처리할 코드 작성
      // ...
      // 로그아웃 버튼 다시 숨기기
      document.querySelectorAll('.naver')[0].style.display = 'none';
    document.querySelectorAll('.naver')[1].style.display = 'none';
    });
  });
</script>
	<%
  } if (snsid != null && "kakao".equals(snsid)) {
%>
	<script>
  document.addEventListener('DOMContentLoaded', function() {
	//for(var i=0;i<2;i++){
		console.log(document.querySelectorAll('.kakao'));
	//}
	  
    // 로그아웃 버튼 활성화
    document.querySelectorAll('.kakao')[0].style.display = 'inline-block';
    document.querySelectorAll('.kakao')[1].style.display = 'inline-block';

    // 로그아웃 버튼 클릭 시
    document.querySelector('.kakao').addEventListener('click', function() {
      // 네이버 로그아웃 처리할 코드 작성
      // ...
      // 로그아웃 버튼 다시 숨기기
      document.querySelectorAll('.kakao')[0].style.display = 'none';
    document.querySelectorAll('.kakao')[1].style.display = 'none';
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