<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- 
	이것은 JSP주석을 나타낸다 
--%>

<%

	//이 영역은 JSP문서에서 JAVA코드를 사용할 수 있는 영역으로 '스트립트릿'이라고 한다.
	//String name = "홍길동";
	
%>

<%--

<%= 변수명 또는 수식 %>  ==> JSP문서에서 변수나 수식의 결과르 출력할 때  사용한다 

--%>


<!--
	<form>태그의 속성
	1) action ==> <form>태그에서 전송한 데이터를 받아서 처리할 문서명 또는 서블릿URL
					 (생략하면 현재 문서명으로 설정된다.) 
	2) method ==> 전송방식(GET, POST) ==> 기본값: GET(메소드 생략시 GET)
	3) target ==> 응답이 나타날 프레임
	4) enctype ==> 서버로 파일을 전송할 때 이 속성에 'multipart/form-data'로 지정해야 한다.

 -->
  
 
<h3> Request연습 Form(숫자 입력은 정수로 입력하세요)</h3>
<hr>
<form action="/webTest/requestTest02.do" method="post">
<table>
<tr>
	<td> <input type="text" size="7" name="num1">  </td>
	<td>
		<select name="op">
			<option value="+"> + </option>
			<option value="-"> - </option>
			<option value="*"> * </option>
			<option value="/"> / </option>	
			<option value="%"> % </option>			
		</select>	
	</td>
	<td> <input type="text" size="7" name="num2">  
	<input type="submit" value="확인" > </td>
</tr>	
</table>
</form>
</body>
</html>