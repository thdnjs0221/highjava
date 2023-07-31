<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session Login 페이지</title>
</head>

<%
   // JSP문서에서의 Session은 'session'이라는 이름으로 저장되어 있다.
   String loginId = (String)session.getAttribute("LOGINID");

%>

<body>      

<% 
   // 로그인이 안된 상태
   if(loginId==null){
      
%>
   
   <form action="<%=request.getContextPath()%>/sessionLogin.do" method="post">
      <table border="1" style="margin:0 auto;">
         <tr>
            <td>ID : </td>
            <td><input type="text" name="userId" placeholder="ID를 입력하세요."></td>
         </tr>
         <tr>
            <td>PASS : </td>
            <td><input type="password" name="userPass" value="" placeholder="PASSWORD를 입력하세요."></td>
         </tr>
         <tr>
            <td colspan="2" style="text-align:center;"><input type="submit" name="login" value="Login">
      </table>
   </form>

<%
   // 로그인 되었을 때
   }else{
         
%>

   <h2><%=loginId %>님 반갑습니다.</h2>
   <a href="<%=request.getContextPath()%>/sessionLogout.do">로그아웃</a>

<%
   }
%>
   </body>
</html>
