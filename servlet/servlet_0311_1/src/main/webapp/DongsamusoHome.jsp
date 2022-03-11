<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>동사무소에 오신것을 환영합니다</h1>
	
	<h2>여기는 get 부서입니다</h2>
	<li>정보를 입력하세요</li>
	<form action="ServiceDongsamuso" method="get">
		<div>
			<label>나이</label>
			<input name='age'></input>
		</div>
		<div>
			<label>주민등록번호</label>
			<input name='id'></input>
		</div>
		<div>
			<label>주소</label>
			<input name='address'></input>
		</div>
		<div>
			<label>이름</label>
			<input name='name'></input>
		</div>
		<div>
			<label>성별</label>
			<input name='gender'></input>
		</div>
		<div>
			<label>거주지</label>
			<input name='residence'></input>
		</div>
		
		<input type="submit" value="전송"/>
	</form>
	
	<h2>여기는 post 부서입니다</h2>
	<li>정보를 입력하세요</li>
	<form action="ServiceDongsamuso" method="post">
		<div>
			<label>나이</label>
			<input name='age'></input>
		</div>
		<div>
			<label>주민등록번호</label>
			<input name='id'></input>
		</div>
		<div>
			<label>주소</label>
			<input name='address'></input>
		</div>
		<div>
			<label>이름</label>
			<input name='name'></input>
		</div>
		<div>
			<label>성별</label>
			<input name='gender'></input>
		</div>
		<div>
			<label>거주지</label>
			<input name='residence'></input>
		</div>
		
		<input type="submit" value="전송"/>
	</form>
	
</body>
</html>