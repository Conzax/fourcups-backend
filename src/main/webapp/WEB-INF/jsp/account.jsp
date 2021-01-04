<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"%>
<html lang="en">

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1" charset="UTF-8">
    <title>Account — Fourcups</title>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Rubik:ital,wght@0,500;1,500&amp;display=swap" rel="stylesheet">
    <style>
        * {
            font-family: 'Rubik', sans-serif;
            box-sizing: border-box;
        }

        body {
            margin: 0;
        }

        header {
            padding: 15px 20px;
            overflow: hidden;
        }

        form {
            margin: 0 auto;
        }
        input:focus::placeholder {
            color: transparent;
        }

        label {
            margin-left: 8px;
        }

        .nickname {
            color: rgba(255, 255, 255, 1);
            font-weight: bold;
            font-size: 28px;
        }

        .sidebar {
            display: none;
            width: 260px;
            height: 100%;
            position: fixed;
            padding: 16px;
            background-color: rgba(88, 86, 214, 1);
            border-radius: .64rem;
            animation: scroll 500s linear infinite;
        }
        .bottom-nav {
            background-color: rgba(88, 86, 214, 1);
            overflow: hidden;
            position: fixed;
            bottom: 0;
            width: 100%;
            display: flex;
            justify-content: center;
        }
        .bottom-nav div {
            border-radius: .64rem;
            padding: 12px;
            flex-grow: 1;
            text-align: center;
            font-size: 16px;
            color: rgba(238, 238, 238, 1);
            display: flex;
            flex-direction: column;
            height: 100%;
            justify-content: center;
            transition: .25s;
            margin: 8px;
        }
        .bottom-nav div:hover {
            background-color: rgba(0, 0, 0, .25);
        }
        .login-modal {
            display: none;
            position: fixed;
            left: 0;
            bottom: 0;
            width: 100%;
            height: 100%;
            background: rgba(0, 0, 0, 0.75);
            flex-direction: row;
            align-items: center;
            justify-content: center;
            z-index: 1000;
            transition: .4s;
        }

        .container {
            padding-left: 20%;
            padding-top: 4%;
            height: 100%;
        }

        @media only screen and (min-width: 1380px) {
            .sidebar {
                display: block;
                width: 260px;
                height: 100%;
                position: fixed;
                padding: 16px;
                background-color: rgba(88, 86, 214, 1);
                border-radius: .64rem;
                animation: scroll 500s linear infinite;
            }

            .container {
                padding-left: 20%;
                padding-top: 4%;
                height: 100%;
            }

            .bottom-nav {
                display: none;
            }

            .btn {
                display: block;
                color: rgba(238, 238, 238, 1);
                background-color: rgba(94, 92, 230, 1);
                padding: 8px 16px;
                border: 0 solid;
                border-radius: .64rem;
                margin-top: 24px;
                margin-left: 4px;
                margin-right: 4px;
                font-size: 24px;
                outline: none;
                transition: .25s;
                cursor: pointer;
                box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.125);
            }
        }

        .label {
            color: rgba(88, 86, 214, 1);
            margin-left: 8px;
            font-weight: bold;
            font-size: 32px;
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

        .input {
            color: rgba(94, 92, 230, 1);
            background-color: rgba(0, 0, 0, .125);
            padding: 8px 16px;
            border: 2px solid rgba(0, 0, 0, .075);
            border-radius: .64rem;
            margin: 4px;
            font-size: 16px;
            outline: none;
            transition: .25s;
        }

        .input:focus {
            border: 2px solid rgba(94, 92, 230, 1);
        }

        .input-modal {
            color: rgba(94, 92, 230, 1);
            background-color: rgba(0, 0, 0, .125);
            padding: 8px 16px;
            border: 2px solid rgba(0, 0, 0, .075);
            border-radius: .64rem;
            margin: 4px;
            width: 100%;
            font-size: 16px;
            outline: none;
            transition: .25s;
        }

        .input-modal:focus {
            border: 2px solid rgba(94, 92, 230, 1);
        }

        .center-container {
            background-color: rgba(238, 238, 238, 1);
            border-radius: .64rem;
            padding: 16px;
            position: absolute;
            margin: auto;
            top: 0;
            width: 260px;
            right: 0;
            bottom: 0;
            left: 0;
            height: fit-content;
            text-align: center;
        }

        .btn-sidebar {
            color: rgba(238, 238, 238, 1);
            background-color: rgba(0, 0, 0, 0.25);
            padding: 10px 20px;
            border: 0 solid;
            border-radius: .64rem;
            margin-top: 8px;
            font-size: 18px;
            width: 100%;
            outline: none;
            transition: .25s;
            cursor: pointer;
        }

        .btn-sidebar:hover {
            background-color: rgba(255, 255, 255, 0.25);
            border: 0;
            box-shadow: 0 4px 16px 0 rgba(0, 0, 0, 0.25);
        }
        .btn {
            display: none;
        }

        .btn:hover {
            background-color: rgba(0, 0, 0, 1);
            border: 0;
            box-shadow: 0 4px 16px 0 rgba(0, 0, 0, 0.25);
        }
    </style>
    <script src="https://unpkg.com/feather-icons"></script>
</head>

<body>
<div class="sidebar">
    <header>
        <div class="nickname">BIETONSTAFF</div>
    </header>
    <button class="btn-sidebar" onclick="">Profile</button>
    <button class="btn-sidebar" onclick="deleteAccountModal()">Delete Account</button>
</div>
<div class="login-modal" id="login-modal">
    <div class="center-container">
        <form action="/signup" method="POST">
            <div style="margin-bottom: 8px; color: rgba(94, 92, 230, 1); font-size: 20px;">Are you sure?</div>
            <input class="input-modal" id="password" name="nickname" type="password" placeholder="Password">
            <input class="input-modal" id="password-retype" name="nickname" type="password" placeholder="Retype Password">
            <button type="submit" style="width: 100%;" class="btn">Delete</button>
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
        <div style="font-size: 10px; color: rgba(0, 0, 0, 0.5);">*you can only change this once per 2 weeks.</div>
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
    <button type="button" class="btn" onclick="window.location.href='/'">Sign Out</button>
</div>
<div class="bottom-nav">
    <div onclick="window.location.href='/account'" style="display: block;"><i data-feather="user"></i></div>
    <div onclick="deleteAccountModal()" style="display: block;"><i data-feather="trash"></i></div>
    <div onclick="window.location.href='/'" style="display: block;"><i data-feather="log-out"></i></div>
</div>
<script>
    feather.replace()
    function deleteAccountModal() {
        document.getElementById("login-modal").style.display = "flex";
    }
    function deleteAccountModalClose() {
        document.getElementById("login-modal").style.display = "none";
    }
</script>
</body>
</html>