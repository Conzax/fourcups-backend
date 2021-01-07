<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1" charset="UTF-8">
    <title>Sign In — Fourcups</title>
</head>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Rubik:ital,wght@0,500;1,500&display=swap" rel="stylesheet">
<link href="css/login.css" rel="stylesheet">
<script src="js/feather.js"></script>
<body>
<header>
    <button class="btn" onclick="window.location.href='/'">Back</button>
</header>
<div class="center-container">
    <form action="signin" method="POST">
        <input class="input" name="nickname" type="text" placeholder="Nickname" required>
        <input class="input" name="password" type="password" placeholder="Password" required>
        <button type="submit" class="btn-large">Sign In</button>
        <div class="link" onclick="window.location.href='/signup'">or sign up...</div>
    </form>
</div>
<c:if test="${ alert != null }">
    <div id="alert" class="alert">${alert}
        <div onclick="document.getElementById('alert').style.display = 'none'" style="right: 0; position: fixed; margin-right: 16px; cursor: pointer"><i data-feather="x"></i></div>
    </div>
</c:if>
</body>
<script>
    feather.replace();
</script>
</html>