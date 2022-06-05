<%@ page language="java" contentType="text/html; charset=UTF-8"%> 
<%request.setCharacterEncoding("utf-8"); %>



<%
	boolean flag = (boolean)request.getAttribute("flag");
	// action에서 받아온거 flag로 해서 저장 하고 밑에서 받아서 성공 삭제 실행
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
			out.print("글 삭제 성공");
		}else{
			out.print("글 삭제 실패");
		}
	%>
	</div>
	<button class='btn' onclick="location.href='create.do'">다시등록</button>
	<button class='btn' onclick="location.href='list.do'">목록</button>
</div>
</body> 
</html> 