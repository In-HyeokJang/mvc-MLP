<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%// 1.폼에서 넘겨준 파라메터 받는다. 2. 파라메터를 DTO에 저장 3. DTO값을 디비에 저장 %>
<%//  String wname = request.getParameter("wname"); 랑    dto.setWname(wname); 합친 코드 */ %>
<%//  property 에서 '*'를 쓰면 모든 속성 된다.' */ %>

<% 	
	boolean flag = (boolean)request.getAttribute("flag"); // dto를 dao에 만들어서 저장
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
		if(flag){
			out.print("글 등록 성공입니다.");
		}else{
			out.print("글 등록 실패입니다.");
		}
	%>
	</div>
	
	<button class="btn" onclick="location.href='createForm.do'">다시 등록</button>
	<button class="btn"onclick="location.href='list.do'">목록</button>
</div>

</body>
</html>