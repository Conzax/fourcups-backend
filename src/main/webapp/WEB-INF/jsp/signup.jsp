<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1" charset="UTF-8">
    <title>Sign Up — Fourcups</title>
</head>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Rubik:ital,wght@0,500;1,500&display=swap" rel="stylesheet">
<link href="css/login.css" rel="stylesheet">
<body>
<header>
    <button class="btn" onclick="window.location.href='/'">Back</button>
</header>
<div class="center-container">
    <form action="signup" method="POST">
        <input class="input" id="nickname" name="nickname" type="text" placeholder="Nickname">
        <input class="input" name="email" type="text" placeholder="E-mail">
        <input class="input" name="password" type="password" placeholder="Password">
        <button type="submit" class="btn-large">Sign Up</button>
        <div class="link" onclick="window.location.href='/signin'">or sign in...</div>
    </form>
</div>
</body>