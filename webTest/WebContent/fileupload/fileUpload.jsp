<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 연습</title>
</head>
<body>
<h3> 파일 업로드 연습</h3>
<form action="<%=request.getContextPath() %>/fileUpload.do" 
method="post" enctype="multipart/form-data"><!--파일 업로드 반드시 포스트와 enctype써주기!!   -->
	작성자 이름: <input type="text" name="username"> <br> <br>
	한 개 파일 선택: <input type="file" name="upFile1"> <br> <br>
	여러 개 파일 선택: <input type="file" name="upFile2" multiple> <br> <br>
	<input type="submit" value="전 송">
</form>

<br> <hr> <br>

<a href="<%=request.getContextPath() %>/fileList.do">파일 목록보기</a>

</body>
</html>