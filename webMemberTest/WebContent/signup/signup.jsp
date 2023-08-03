<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 입력폼</title>
</head>

<body>

<form action="<%=request.getContextPath()%>/signup.do" method="post">
      <table border="" style="margin:0 auto;">
      
         <tr>
            <td>ID : </td>
            <td><input type="text" name="userId" placeholder="ID를 입력하세요.">
            <input type="submit" name="중복확인" value="중복확인"> </td>
         </tr>
         
         <tr>
            <td>PASS : </td>
            <td><input type="password" name="userPass" value="" placeholder="PASSWORD를 입력하세요."></td>
         </tr>
          <tr>
            <td>PASS 확인: </td>
            <td><input type="password" name="userPass1" value="" placeholder="PASSWORD를 입력하세요."></td>
         </tr>
          <tr>
            <td>이름 : </td>
            <td><input type="text" name="userName" placeholder="ID를 입력하세요."></td>
         </tr>
         <tr>
            <td>전화번호 : </td>
            <td><input type="text" name="userTel" ></td>
         </tr>
         <tr>
            <td>회원주소 : </td>
            <td><input type="text" name="userAddr"></td>
         </tr>
         <tr>
            <td>프로필사진 : </td>
            <td><input type="submit" name="Photo" value="파일선택" ></td>
         </tr>
         
         <tr>
            <td colspan="2" style="text-align:center;">
            <input type="submit" name="저장" value="저장">
             <input type="reset" name="취소" value="취소">
              <input type="submit" name="회원목록" value="회원목록">
             </td>
         </tr>
      </table>
   </form>

</body>
</html>