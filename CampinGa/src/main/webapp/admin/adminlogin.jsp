<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="admin/css/admin.css">
<script src="admin/script/admin.js"></script>
</head>
<body>
<div id="wrap">

	<article>
		<div id="loginform">
			<form name="frm" method="post" action="camp.do">
				<input type="hidden" name="command" value="adminLogin">
				<table>
					<tr><td>아 이 디</td><td><input type="text" name="adminId" size="10"></td></tr>
					<tr><td>비밀번호</td><td><input type="password" name="adminPwd" size="10"></td></tr>
					<tr align="center" >
						<td  colspan="2">	
							<input class="btn" type="submit" value="로그인" onClick="adminCheck();">
							<br><br><h4 style="color:red">${message}</h4></td></tr>
				</table>
			</form>
		</div>
	</article>
</div>

</body>
</html>