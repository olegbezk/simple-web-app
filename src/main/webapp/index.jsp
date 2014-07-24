<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
</head>
<body>
	<form action="UserLogin" method="post">
		<table border="1">
			<tr>
				<th colspan="2">Login Form</th>
			</tr>
			<tr>
				<td>Enter your UserId:</td>
				<td><input type="text" name="user"></td>
			</tr>
			<tr>
				<td>Enter your Password:</td>
				<td><input type="password" name="pass"></td>
			</tr>
			<tr>
				<td>Confirm Password:</td>
				<td><input type="password" name="conf"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" name="submit"></td>
				<td><input type="submit" value="Register" name="register"></td>
			</tr>
		</table>
	</form>
</body>
</html>
