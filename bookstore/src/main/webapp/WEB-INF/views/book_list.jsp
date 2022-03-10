<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글</title>
</head>
<body>
	<h2>도서정보관리-리스트</h2>
	검색 키워드 입력 :<form action = "search" method="get" name="condition" id="condition">
		<select name="searchType">
			<option value="name">책 제목</option>
			<option value="auth">작성자</option>
			<option value="publisher">출판사</option>
		</select>
		<input type="text" name="keyword" id="keyword" placeholder="도서제목 또는 저자 입력" value="${keyword}"/>
		<button type="submit">찾기</button> 
	</form>
			<table border="1">
			<tr>
				<th>등록 번호</th>
				<th>도서 표지</th>
				<th>도서 ISBN</th>
				<th>도서 제목</th>
				<th>저자</th>
				<th>출판사</th>
				<th>가격</th>
			</tr>
			<c:forEach var="b" items="${books}">
				<tr>
					<td>${b.num }</td>
					<td><img src="<c:url value='/resources/upload/${b.image }' />" width="100" height="100"> </td>
					<td>${b.isbn }</td>
					<td><a href="<c:url value='/detail/${b.num}' />">${b.name }</a></td>
					<td>${b.auth }</td>
					<td>${b.publisher }</td>
					<td>${b.price }</td>
				</tr>
			</c:forEach>
			</table>
		<a href="<c:url value='/add' />" >도서 정보 추가</a>
</body>
</html>