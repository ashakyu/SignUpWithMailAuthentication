<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서정보관리-도서정보</title>
</head>
<body>
<h2>도서정보관리-도서정보</h2>
	<table border="1">
		<tr>
			<td rowspan="6">
				<img src="<c:url value='/resources/upload/${book.image }' />" width="300" height="400"/>
			</td>
		</tr>
		<tr>
			<td>BOOK ISBN</td>
			<td>${book.isbn }</td>
		</tr>
		<tr>
			<td>도서명</td>
			<td>${book.name }</td>
		</tr>
		<tr>
			<td>저자</td>
			<td>${book.auth }</td>
		</tr>
		<tr>
			<td>출판사</td>
			<td>${book.publisher }</td>
		</tr>
		<tr>
			<td>도서 가격</td>
			<td>${book.price }</td>
		</tr>
		<tr>
			<td>책 소개</td>
			<td>${book.description }</td>
		</tr>
	</table>
</body>
</html>