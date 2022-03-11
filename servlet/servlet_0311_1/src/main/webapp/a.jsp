<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	환영합니다 ^.^ 여기는 a.jsp 페이지입니다.
	<form action="GetTest" method="post">
		<label>이름</label>
		<input name='name'></input>
		<label>전화번호</label>
		<input name='phone'></input>
		<label>주소</label>
		<input name='address'></input>
		
		<input type="submit" value="전송"/>
	</form>
</body>
</html>