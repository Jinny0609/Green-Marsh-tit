<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
    <h1>Google Test page</h1>
    <form th:action="@{/login/oauth2/code/google}" method="post">
        <button type="submit">Login with Google</button>
    </form>
</body>
</html>