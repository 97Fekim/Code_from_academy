<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>���繫�ҿ� ���Ű��� ȯ���մϴ�</h1>
	
	<h2>����� get �μ��Դϴ�</h2>
	<li>������ �Է��ϼ���</li>
	<form action="ServiceDongsamuso" method="get">
		<div>
			<label>����</label>
			<input name='age'></input>
		</div>
		<div>
			<label>�ֹε�Ϲ�ȣ</label>
			<input name='id'></input>
		</div>
		<div>
			<label>�ּ�</label>
			<input name='address'></input>
		</div>
		<div>
			<label>�̸�</label>
			<input name='name'></input>
		</div>
		<div>
			<label>����</label>
			<input name='gender'></input>
		</div>
		<div>
			<label>������</label>
			<input name='residence'></input>
		</div>
		
		<input type="submit" value="����"/>
	</form>
	
	<h2>����� post �μ��Դϴ�</h2>
	<li>������ �Է��ϼ���</li>
	<form action="ServiceDongsamuso" method="post">
		<div>
			<label>����</label>
			<input name='age'></input>
		</div>
		<div>
			<label>�ֹε�Ϲ�ȣ</label>
			<input name='id'></input>
		</div>
		<div>
			<label>�ּ�</label>
			<input name='address'></input>
		</div>
		<div>
			<label>�̸�</label>
			<input name='name'></input>
		</div>
		<div>
			<label>����</label>
			<input name='gender'></input>
		</div>
		<div>
			<label>������</label>
			<input name='residence'></input>
		</div>
		
		<input type="submit" value="����"/>
	</form>
	
</body>
</html>