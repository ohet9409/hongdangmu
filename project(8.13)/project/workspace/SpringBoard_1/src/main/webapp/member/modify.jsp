<%@page import="member.dao.MemberDAO"%>
<%@page import="member.bean.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"	
%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function() {
		if(${su > 0}) { 
			alert("회원 수정 성공");
			location.href="../main/index.jsp";
		} else { 
			alert("회원 수정 실패");	
			location.href="../member/modifyForm.do";
		 } 	
	}
</script>
</head>
<body>

</body>
</html>




