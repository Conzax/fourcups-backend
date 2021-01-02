<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1" charset="UTF-8">
    <title>Sign In — Fourcups</title>
</head>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Rubik:ital,wght@0,500;1,500&display=swap" rel="stylesheet">
<body>
<header>
    <button class="btn" onclick="window.location.href='/'">Back</button>
</header>
<div class="center-container">
    <form action="/signin" method="POST">
        <input class="input" name="nickname" type="text" placeholder="Nickname" required>
        <input class="input" name="password" type="password" placeholder="Password" required>
        <button type="submit" class="btn-large">Sign In</button>
        <div class="link" onclick="window.location.href='/signup'">or sign up...</div>
    </form>
</div>
</body>
<style>
    * {
        font-family: 'Rubik', sans-serif;
        box-sizing: border-box;
    }
    header {
        padding: 15px 20px;
        overflow: hidden;
    }
    form {
        margin: 0 auto;
        width: 240px;
        text-align: center;
    }
    input:focus::placeholder {
        color: transparent;
    }
    .link {
        color: rgba(0, 0, 0, 0.5);
        margin-top: 16px;
        font-size: 16px;
        cursor: pointer;
        transition: .25s;
    }
    .link:hover {
        color: rgba(94, 92, 230, 1);
    }
    .center-container {
        background-color: rgba(238, 238, 238, 1);
        border-radius: .64rem;
        padding: 16px;
        position: absolute;
        margin: auto;
        top: 0;
        right: 0;
        bottom: 0;
        left: 0;
        width: fit-content;
        height: fit-content;
    }
    .input {
        color: rgba(94, 92, 230, 1);
        background-color: rgba(0, 0, 0, .125);
        width: 100%;
        padding: 8px 16px;
        border: 2px solid rgba(0, 0, 0, .075);
        border-radius: .64rem;
        margin-top: 4px;
        margin-bottom: 4px;
        font-size: 16px;
        outline: none;
        transition: .25s;
    }
    .input:focus {
        border: 2px solid rgba(94, 92, 230, 1);
    }
    .btn {
        color: rgba(238, 238, 238, 1);
        background-color: rgba(94, 92, 230, 1);
        padding: 8px 16px;
        border: 0 solid;
        border-radius: .64rem;
        margin-top: 4px;
        margin-left: 4px;
        margin-right: 16px;
        font-size: 16px;
        outline: none;
        align-self: center;
        transition: .25s;
        cursor: pointer;
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.125);
    }
    .btn:hover {
        background-color: rgba(0, 0, 0, 1);
        border: 0;
        box-shadow: 0 4px 16px 0 rgba(0, 0, 0, 0.25);
    }
    .btn-large {
        color: rgba(238, 238, 238, 1);
        background-color: rgba(94, 92, 230, 1);
        width: 100%;
        padding: 12px 24px;
        border: 0 solid;
        border-radius: .64rem;
        margin-top: 8px;
        font-size: 24px;
        outline: none;
        transition: .25s;
        cursor: pointer;
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.125);
    }
    .btn-large:hover {
        background-color: rgba(0, 0, 0, 1);
        border: 0;
        box-shadow: 0 4px 16px 0 rgba(0, 0, 0, 0.25);
    }
</style>