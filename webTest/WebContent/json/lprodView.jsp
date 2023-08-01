<%@page import="kr.or.ddit.json.vo.LprodVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

  <%
  //Controller(Servlet)에서 보내온 데이터를 받는다 
  	List<LprodVO> lprodList = (List<LprodVO>)request.getAttribute("lprodList");

  %>
<body>
<h3> Lprod 자료 목록</h3>
<table border="1">

	<tr>
		<th>LPROD_ID </th>
		<th>LPROD_GU </th>
		<th>LPROD_NM </th> 
	</tr> 	
<%

	for(LprodVO lvo : lprodList){
		
	

%>
	<tr>
		<td> <%=lvo.getLprod_id() %> </td>
		<td> <%=lvo.getLprod_gu() %> </td>
		<td> <%=lvo.getLprod_nm() %> </td>
	</tr>

<%
	}
%>

</table>

</body>
</html>