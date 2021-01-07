<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1" charset="UTF-8">
    <title>Account — Fourcups</title>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Rubik:ital,wght@0,500;1,500&amp;display=swap" rel="stylesheet">
    <link href="css/account.css" rel="stylesheet">
    <script src="js/feather.js"></script>
</head>
<body>
<div class="sidebar">
    <header>
        <div class="nickname">${ nickname }</div>
    </header>
    <button class="btn-sidebar" onclick="deleteAccountModal()">Delete Account</button>
    <button class="btn-sidebar" onclick="window.location.href='/'">Sign Out</button>
</div>
<div class="delete-modal" id="delete-modal">
    <div class="center-container">
        <form action="delete" method="POST">
            <div style="margin-bottom:8px;color:rgba(94,92,230,1);font-size:20px">Are you sure?</div>
            <input type="hidden" value="${ nickname }">
            <input class="input-modal" id="password" name="nickname" type="password" placeholder="Password">
            <input class="input-modal" id="passwordRetype" name="nickname" type="password" placeholder="Retype Password">
            <button type="submit" style="width:100%;" class="btn-modal">Delete</button>
            <div class="link" onclick="deleteAccountModalClose()">cancel</div>
        </form>
    </div>
</div>
<div class="container">
    <div class="label">Profile</div>
    <br>
    <label>Change Nickname</label>
    <form action="/update/nickname" method="POST">
        <input class="input" name="nickname" type="text" placeholder="New Nickname" required="">
        <input class="input" type="submit" value="Update">
        <div style="font-size:10px;color:rgba(0,0,0,0.5)">*you can only change this once per 2 weeks.</div>
    </form>
    <br>
    <label>Change E-mail</label>
    <form action="/update/email" method="POST">
        <input class="input" name="email" type="email" placeholder="New E-mail" required="">
        <input class="input" name="password" type="password" placeholder="Current Password" required="">
        <input class="input" type="submit" value="Update">
    </form>
    <br>
    <label>Change Password</label>
    <form action="/update/password" method="POST">
        <input class="input" name="password" type="password" placeholder="Current Password" required="">
        <input class="input" name="password" type="password" placeholder="New Password" required="">
        <input class="input" type="submit" value="Update">
    </form>
</div>
<div class="bottom-nav">
    <div onclick="deleteAccountModal()" style="display:block"><i data-feather="trash"></i></div>
    <div onclick="window.location.href='/'" style="display:block"><i data-feather="log-out"></i></div>
</div>
</body>
<script src="js/account.js"></script>
</html>