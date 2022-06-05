<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ page import="model.*" %>
<%
	int addressnum = Integer.parseInt(request.getParameter("addressnum"));
	AddrDTO dto = (AddrDTO)request.getAttribute("dto"); // 한건의 레코드(데이터) 조회
%>
<!DOCTYPE html> 
<html> 
<head>
  <title>homepage</title>
  <meta charset="utf-8">
  <script type="text/javascript">
  	function update(addressnum){//수정페이지로 이동
  		let url = 'update.do?addressnum='+addressnum;
  		location.href = url;
  	}
  	function del(addressnum){// 삭제 페이지로 이동
  		//alert(bbsno);
  		let url = 'delete.do?addressnum='+addressnum;
  		location.href = url;
  	}

  </script>
  
</head>
<body> 
<div class="container">
<h1>주소록</h1>
<div class="panel panel-default">
	<div class="panel-heading">이름</div>
	<div class="panel-body"><%=dto.getName() %></div>
	<div class="panel-heading">전화번호</div>
	<div class="panel-body"><%=dto.getHandphone() %></div>
	<div class="panel-heading">우편번호</div>
	<div class="panel-body"><%=dto.getZipcode() %></div>
	<div class="panel-heading">주소</div>
	<div class="panel-body"><%=dto.getAddress() %></div>
	<div class="panel-heading">상세주소</div>
	<div class="panel-body"><%=dto.getAddress2( )%></div> <div>
	
	<button onclick="location.href='create.do'">등록</button>
	<button onclick="update('<%=addressnum%>')">수정</button>
	<button onclick="del('<%=addressnum %>')">삭제</button>
	<button onclick="location.href='list.do'">목록</button>

</div>
   </div>
 </div>


</body> 
</html> 