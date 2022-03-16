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
	<table>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>이메일</th>
		</tr>
		<c:forEach var='item' items="${members}">
			<tr>
			<td>${item.no}</td>
			<td>${item.name}</td>
			<td>${item.email}</td>
			</tr>
		</c:forEach>
	</table>	
<jsp:include page="/Tail.jsp"/>	
</body>
</html>