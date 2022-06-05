<%@ page language="java" contentType="text/html; charset=UTF-8"%> 

<%
// boolean pflag = (boolean)request.getAttribute("pflag");
boolean flag = (boolean)request.getAttribute("flag");	
	//boolean 타입으로 받아 와서 넣기 성공 실패 만들기
%>

 
<!DOCTYPE html> 

<html> 
<head>
  <title>homepage</title>
  <meta charset="utf-8">
</head>
<body> 
<div class="container">
	<div class="well well-Lg">
	<%
		if(flag){
			out.print("글 수정 성공");
		}else{
			out.print("글 수정 실패");
		}
	%>
	</div>
	<button class='btn' onclick="location.href='create.do'">다시등록</button>
	<button class='btn' onclick="location.href='list.do'">목록</button>
</div>
</body> 
</html> 