<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>사용자 로그인</h2>
	<form action="login" method="post">
		<div>
			<label for="email">이메일</label>
			<input type='text' name='email'/>
		</div>
		<div>
			<label for="password">암호</label>
			<input type='text' name='password'/>
		</div>
		<input type="submit" value="로그인"/>
	</form>
</body>
</html>