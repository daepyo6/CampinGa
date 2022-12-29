<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/campinga.css" rel="stylesheet">  
<script src="member/script/member.js"></script>
</head>
<body>

<div id="wrap">
	<header> <!--  로고, 주상단 메뉴, 카테고리 메뉴가 표시되는 영역 -->
	
		<div id="logo"><!-- 로고시작 -->
			<a href="camp.do?command=index">
				<img src="images/CampinGa_logo.png" width="220" height="50">
			</a>
		</div><!-- 로고 끝 -->
		
		<nav id="top_menu"> <!-- 메인메뉴 시작 -->
			<ul>
				<c:choose>
					<c:when test="${empty loginUser}">
						<li><a href="camp.do?command=loginForm">Login</a></li>
						<li><a href="camp.do?command=join">Join</a></li>
					</c:when>
					<c:otherwise>
						<li><p>${loginUser.name}(${loginUser.mid})</p></li>
						<li><a href="camp.do?command=logout">Logout</a></li>
						<li><a href="camp.do?command=myPage">Mypage</a></li>
					</c:otherwise>
				</c:choose>
				<li><a href="camp.do?command=adminNoticeList">Notice</a></li>
			</ul>
		</nav> <!-- 메인 메뉴 끝 -->
	
		<nav id="category_menu"> <!-- 카테고리 메뉴 시작  -->
			<ul>
				<li><a href="camp.do?command=category&kind=1">전체</a></li>
				<li><a href="camp.do?command=category&kind=2">캠핑장</a></li>
				<li><a href="camp.do?command=category&kind=3">글램핑</a></li>
			</ul>
		</nav> <!-- 카테고리 메뉴 끝 -->
	</header>







