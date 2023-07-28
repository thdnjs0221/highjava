<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<%


%>


<body>


<form action="<%=request.getContextPath()%>/sessionLogin.do" method="post">
<table style="margin: 0 auto;">
<tr>

	<td>ID: </td>
	<td><input type="text" name="userid"  placeholder="아이디를 입력학세요"> </td>
</tr>

<tr>

	<td>PASS: </td>
	<td><input type="password" name="userpass"  placeholder="비밀번호를 입력하세요"></td>
</tr>

<tr>

	<td colspan="2" style="text-align: center;"><input type="submit" value="login" >
	 </td>
</tr>

</table>




</form>
</body>
</html>