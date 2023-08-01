<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.0.min.js"></script>
<script type="text/javascript">

$(function() {
	
	$('#lprodBtn').on('click',function(){
		
		$.ajax({
			
			url : "<%=request.getContextPath()%>/lprodList.do",
			type: "get",
			//data : 전송할 데이터 없음
			success: function(data){  //data->
				let htmlCode="<table border='1'>";
				htmlCode+= "<tr><th>Lprod_ID</th><th>Lprod_GU</th><th>Lprod_NM</th>"
				
				$.each(data,function(i,v){
					htmlCode+="<tr><td>"+v.lprod_id+"</td>";
					htmlCode+="<td>"+v.lprod_gu+"</td>";
					htmlCode+="<td>"+v.lprod_nm+"</td></tr>";
					
				})
				
					html="</table>"
				
				  $("#result").html(htmlCode);
			},
			error : function(xhr){
	            alert("오류...")
			},
			 dataType : "json"
		})
		
	})
	
	//Ajax 사용하지 않기
	$('#lprodBtn2').on('click',function(){
		location.href="<%= request.getContextPath() %>/lprodList2.do";
		
		
		
	})
	
})

//비동기:  웹브라우저 안에 있는 ajax객체가 일하는것 (쟤가 서버랑 통신) 원하는 곳에 해석해서 보여줌, 필요한 데이터만 가져옴
	
//동기: 전송누르면 주소가 바뀌고 , 서버로 요청하면 요청한 결과가 웹브라우저로 전송 그 전부를 해석해서 보여주는것 , 응답을 할때 html전체 코드가 다 온다
//요청을 햏ㅆ는데 서버에서 처리하는 시간이 길면 흰색화면이 나올수 있다 깜빡임이 일어날수있음. 



</script>

</head>
<body>
<!--
 처리하는 서블릿 URL Mapping==> /lprodList.do 
 -->
 
 
 
 
 
 
<form >
	<input type="button" id="lprodBtn" value="Lprod자료 가져오기(Ajax이용)">
	<input type="button" id="lprodBtn2" value="Lprod자료 가져오기(Ajax 사용하지 않기)">

</form>
<h3> Lprod 자료 목록</h3>
<div id="result"></div>
</body>
</html>