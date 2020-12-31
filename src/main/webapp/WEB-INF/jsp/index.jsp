<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1" charset="UTF-8">
    <title>Fourcups</title>
</head>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Rubik:ital,wght@0,500;1,500&display=swap" rel="stylesheet">
<body>
<header class="header">
    <a class="brand-name-header" href="/">Fourcups</a>
    <div class="right-header">
        <div class="dropdown-header">
            <button class="btn-dropdown">Account</button>
            <div class="dropdown-content">
                <a href="signin">Sign In</a>
                <a href="signup">Sign Up</a>
            </div>
        </div>
    </div>
</header>
<div class="center-container">
    <div class="brand-name">Fourcups</div>
    <div class="tagline">Better Experience</div>
    <button class="btn-large" onclick="window.location.href='https://play.google.com/store/apps/details?id=com.fortcups.android'">Download</button>
</div>
</body>
<style>

    * {
        font-family: 'Rubik', sans-serif;
        box-sizing: border-box;
    }
    .header {
        background-color: rgba(94, 92, 230, 1);
        border-radius: .64rem;
        padding: 15px 20px;
        overflow: hidden;
    }
    .brand-name-header {
        color: rgba(238, 238, 238, 1);
        font-size: 28px;
        display: inline-block;
        vertical-align: middle;
        transition: .25s;
        text-decoration: none;
    }
    .brand-name-header:hover {
        color: rgba(238, 238, 238, 0.75);
    }
    .right-header {
        float: right;
    }
    .btn-large {
        color: rgba(238, 238, 238, 1);
        background-color: rgba(94, 92, 230, 1);
        padding: 12px 24px;
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
    .btn-large:hover {
        background-color: rgba(0, 0, 0, 1);
        border: 0;
        box-shadow: 0 4px 16px 0 rgba(0, 0, 0, 0.25);
    }
    .btn-dropdown {
        background-color: rgba(0, 0, 0, .25);
        border-radius: .64rem;
        color: rgba(238, 238, 238, 1);
        padding: 8px 16px;
        font-size: 16px;
        border: none;
        cursor: pointer;
        transition: .25s;
        outline: none;
    }
    .dropdown-header {
        display: inline-block;
    }
    .dropdown-content {
        display: none;
        position: absolute;
        padding: 8px;
        background-color: rgba(134, 133, 236, 1);
        border-radius: .64rem 0 .64rem .64rem;
        min-width: 10rem;
        box-shadow: 0 8px 16px 0 rgba(134, 133, 236, 0.125);
        z-index: 1;
        right: 28px;
    }
    .dropdown-content a {
        color: rgba(238, 238, 238, 1);
        padding: 8px 16px;
        text-decoration: none;
        display: block;
    }
    .dropdown-content a:hover {
        background-color: rgba(94, 92, 230, 1);
        border-radius: .64rem;
    }
    .dropdown-header:hover .btn-dropdown {
        background-color: rgba(255, 255, 255, .25);
        border-radius: .64rem .64rem 0 0;
        box-shadow: 0 4px 10px 0 rgba(0, 0, 0, 0.125);
    }
    .dropdown-header:hover .dropdown-content {
        display: block;
    }
    .center-container {
        position: absolute;
        margin: auto;
        top: 0;
        right: 0;
        bottom: 0;
        left: 0;
        width: fit-content;
        height: fit-content;
        border-radius: 3px;
        text-align:center;
        cursor: default;
    }
    .brand-name {
        color: rgba(88, 86, 214, 1);
        font-weight: bold;
        font-size: 64px;
        display: flex;
        justify-content: center;
    }
    .tagline {
        color: rgba(88, 86, 214, .8);
        font-size: 18px;
        display: flex;
        justify-content: center;
    }
</style>
</html>