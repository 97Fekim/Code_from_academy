<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/Header.jsp"/>
<h1>회원 목록2</h1>
<a href='add'>신규회원</a>
<a href='../auth/logout'>로그아웃</a>
	<table>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>이메일</th>
		</tr>
		<c:forEach var='member' items="${members}">
			<tr>
			<td><a href = 'update?no=${member.no}'>${member.no}</td>
			<td>${member.name}</td>
			<td>${member.email}<a href='delete?no=${member.no}'>[삭제]</a></td>
			</tr>
		</c:forEach>
	</table>	
<jsp:include page="/Tail.jsp"/>	
</body>
</html>