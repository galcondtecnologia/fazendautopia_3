<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN TESTE</title>
</head>
<body>
<form action="ServletAutenticacao" method="post">
		<input readonly="readonly" type="hidden" id="url" name="url" 
			value="<%= request.getParameter("url") %>" />
		<table style="align-items: center;">
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email" /></td>

			</tr>
			
			<tr>
				<td>Senha:</td>
				<td><input type="password" name="senha" /></td>
			</tr>
			<br></br>
			<tr><td></td>
				<td><input type="submit" value="Logar"> </input></td>
			</tr>

		</table>
	</form>
</body>
</html>