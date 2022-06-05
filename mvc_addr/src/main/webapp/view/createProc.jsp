<%@ page language="java" contentType="text/html; charset=UTF-8"%> 

<%
	boolean flag = (boolean)request.getAttribute("flag");
	// createProcAction에서 flag 받은거 여기로 가져와서 받음
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
	// flag에 내용이 있으면 성공 없으면 실패
		if(flag){
			out.print("글 등록 성공");
		}else{
			out.print("글 등록 실패");
		}
	%>
	</div>
	<button class='btn' onclick="location.href='create.do'">다시등록</button>
	<button class='btn' onclick="location.href='list.do'">목록</button>
</div>
</body> 
</html> 