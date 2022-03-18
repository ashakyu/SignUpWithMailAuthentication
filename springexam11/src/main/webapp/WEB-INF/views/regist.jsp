<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script type="text/javascript">
	
</script>
</head>
<body>
	<form method="POST" action="regist" id="regist" name="regist">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" value= ${id }></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="password" value= ${password }></td>
			</tr>
			<tr>
				<td>이메일 인증</td>
				<td><input type="email" name="email" value=${email } placeholder="@까지 입력"></td>
			
			</tr>
<!-- 			<tr> -->
<!-- 				<td>인증번호 입력</td> -->
<%-- 				<td><input type="text" id="authkey" value=${authkey }></td> --%>
<!-- 			</tr> -->
		</table>
			
<!-- 		<input type="hidden" name="userkey" value="tester"> -->
		<input type="submit" value="회원가입">
	</form>
</body>
</html>