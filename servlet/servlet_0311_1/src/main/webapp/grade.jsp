<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	환영해요 ^^ 성적을 알려주세요
	<form action="GetGradeServlet" method="get">
		<label>국어</label>
		<input name='kor'></input>
		<label>영어</label>
		<input name='eng'></input>
		<label>수학</label>
		<input name='math'></input>
		<input type="submit" value="전송"/>
	</form>
</body>
</html>