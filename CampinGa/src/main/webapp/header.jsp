<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CampinGa</title>
<link href="css/campinga.css" rel="stylesheet">  
<script src="member/script/member.js"></script>
<script src="camping/script/camping.js"></script>
</head>
<body>

<div id="wrap">
	<header>
	<nav id="top_menu"> <!-- 메인메뉴 시작 -->
		<ul>
			<c:choose>
				<c:when test="${not empty loginUser}">
					<li><a href="camp.do?command=mypage" style="width: 100px;">
						${loginUser.name}(${loginUser.mid})</a></li>
					<li><a href="camp.do?command=logout">Logout</a></li>
				</c:when>
				<c:when test="${not empty loginBusinessman}">
					<li><a href="camp.do?command=mypage">
						${loginBusinessman.name}(${loginBusinessman.bid})</a></li>
					<li><a href="camp.do?command=logout">Logout</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="camp.do?command=loginForm">Login</a></li>
					<li><a href="camp.do?command=contractForm">Join</a></li>
				</c:otherwise>
			</c:choose>
			<li><a href="camp.do?command=reviewForm">Notice</a></li>
		</ul>
	</nav>
	
	<div id="logo"><!-- 로고시작 -->
		<a href="camp.do?command=index">
			<img src="images/CampinGa_logo.png" width="220" height="50">
		</a>
	</div><!-- 로고 끝 -->
	
	<nav id="category_menu"> <!-- 카테고리 메뉴 시작  -->
		<ul>
			<li><a href="camp.do?command=category&kind=1">전체</a></li>
			<li><a href="camp.do?command=category&kind=2">오토캠핑</a></li>
			<li><a href="camp.do?command=category&kind=3">글램핑</a></li>
			<li><a href="camp.do?command=category&kind=4">카라반</a></li>
			<li><a href="camp.do?command=category&kind=5">캠프닉</a></li>
		</ul>
	</nav> <!-- 카테고리 메뉴 끝 -->
	</header>







