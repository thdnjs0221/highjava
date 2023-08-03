<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>이미지 보기</h3>
<img  src="../images/강아지2.jfif" width="150"><br><br>
<img  src="<%=request.getContextPath()%>/images/강아지2.jfif" width="150"><br><br>

<!--
프로젝트에 없는 이미지 불러오기  *fileno=1 ==>디비에 저장된 1번째 불러오기
/images/imageView.do ==> 서블릿을 이용해서
-->
<img src="<%=request.getContextPath()%>/images/imageView.do?fileno=1" width="150">
<img src="<%=request.getContextPath()%>/images/imageView.do?fileno=3" width="150">

</body>
</html>