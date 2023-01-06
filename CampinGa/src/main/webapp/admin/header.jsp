<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="admin/script/admin.js"></script>
</head>
<body>

<div id="wrap">
	<header>			
		<div id="logo">
			<a href="camp.do?command=index">
				<img src="images/CampinGa_logo.png" width="220" height="50">
			</a>
		</div>
		<input class="btn" type="button" value="logout" style="float: right;" 
			onClick="location.href='camp.do?command=adminLogout'">			
	</header>
	<div class="clear"></div>