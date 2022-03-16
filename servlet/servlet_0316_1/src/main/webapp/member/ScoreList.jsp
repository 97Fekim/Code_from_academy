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
	<table>
		<tr style="background-color:red">
			<th>전화번호</th>
			<th>주소</th>
			<th>이름</th>
			<th>국어</th>
			<th>영어</th>
			<th>수학</th>
			<th>등급</th>
		</tr>
		<c:forEach var='item' items="${scores}">
			<tr>
			<td>${item.tel}</td>
			<td>${item.address}</td>
			<td>${item.name}</td>
			<td>${item.kor}</td>
			<td>${item.eng}</td>
			<td>${item.math}</td>
			<td>${item.grade}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>