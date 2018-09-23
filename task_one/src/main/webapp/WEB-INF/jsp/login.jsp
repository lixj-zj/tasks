<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">  
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
	<h1>Hello, world! login login</h1>

	<div class="container">
		<form action="${pageContext.request.contextPath }/user/checkLogin"  method="post">
			<table border="1">
				<tr>
					<td>用户名</td>
					<td><input type="text" name="username" id="username"></td>
				</tr>
				<tr>
					<td>密码</td>
					<td><input type="text" name="password" id="password"></td>
				</tr>
				<tr>
					<td> <input type="submit" id="login" value="登陆"/></td>
				</tr>
			</table>
		</form>
    </div>
    ${message }
</body>
</html>