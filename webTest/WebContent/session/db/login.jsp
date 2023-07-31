<%@page import="kr.or.ddit.session.login.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<%
//JSP문서에서는 세션은 'session'이라는 이름으로 저장되어있다 


MemberVO loginMember = (MemberVO) session.getAttribute("loginMember");
%>

<body>

<%
if (loginMember==null) {  //로그인이 안 된 상태
%>
    <form action="<%=request.getContextPath()%>/login.do" method="post">
   <!--jsp는 view로 쓰기 때문에  /login.do(서블릿에 거쳐서 login jsp로 가기) -->
   <!--post방식  -->


      <table style="margin: 0 auto;" border="1">
         <tr>

            <td>ID:</td>
            <td><input type="text" name="userid" value=""
               placeholder="아이디를 입력하세요"></td>
         </tr>

         <tr>

            <td>PASS:</td>
            <td><input type="password" name="userpass"
               placeholder="비밀번호를 입력하세요"></td>
         </tr>

         <tr>

            <td colspan="2" style="text-align: center;"><input
               type="submit" value="login"></td>
         </tr>

      </table>
   </form>


<%
} else { //로그인 되었을 때 
%>
<h3><%=loginMember.getMem_name()%> 님 반갑습니다!!!</h3>
 <a href="<%=request.getContextPath()%>/logout.do">로그아웃</a> 

</body>
<%
}
%>
</html>


