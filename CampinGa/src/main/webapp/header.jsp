<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CampinGa</title>
<link href="css/campinga.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="script/main.js"></script> 
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
					<li><a href="camp.do?command=businessmanMypage">
						${loginBusinessman.name}(${loginBusinessman.bid})</a></li>
					<li><a href="camp.do?command=logout">Logout</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="camp.do?command=loginForm">Login</a></li>
					<li><a href="camp.do?command=contractForm">Join</a></li>
				</c:otherwise>
			</c:choose>
			<li><a href="camp.do?command=noticeList">Notice</a></li>
		</ul>
	</nav>
	
	<div id="logo"><!-- 로고시작 -->
		<a href="camp.do?command=index">
			<img src="images/CampinGa_logo.png">
		</a>
	</div><!-- 로고 끝 -->
	
	<nav id="category_menu">		
		<div onclick="location.href='camp.do?command=category&kind=1'"><span>전체</span></div>
		<div onclick="location.href='camp.do?command=category&kind=2'"><span>오토캠핑</span></div>
		<div onclick="location.href='camp.do?command=category&kind=3'"><span>글램핑</span></div>
		<div onclick="location.href='camp.do?command=category&kind=4'"><span>카라반</span></div>
		<div onclick="location.href='camp.do?command=category&kind=5'"><span>캠프닉</span></div>	
	</nav>
	</header>







