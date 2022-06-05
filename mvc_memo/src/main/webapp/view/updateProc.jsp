<%@ page language="java" contentType="text/html; charset=UTF-8"%>
    

<%
	boolean pflag = (boolean)request.getAttribute("pflag");
	boolean flag = (boolean)request.getAttribute("flag");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<div class="well well-Lg">
	<%
		if(!pflag){
			out.print("잘못된 비밀번호 입니다.");
		}
		else if(flag){
			out.print("글 수정 성공");
		}else{
			out.print(" 글 수정 실패 ");
		}
	%>
	</div>
	<% if(!pflag) { %>
		<button class = 'btn' onclick ="history.back()">다시시도</button>
	<% } %>
	<button class="btn" onclick="location.href='create.do'">다시 등록</button>
	<button class="btn"onclick="location.href='list.do'">목록</button>
</div>

</body>
</html>