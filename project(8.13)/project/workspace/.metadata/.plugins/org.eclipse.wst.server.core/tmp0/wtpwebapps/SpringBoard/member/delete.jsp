<%@page import="member.dao.MemberDAO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload= function() {
	if(${su > 0}) { 
				alert("회원탈퇴 성공");			
		} else { 
				alert("회원탈퇴 실패");
		} 
		location.href = "../main/index.jsp";
	}
</script>
</head>
<body>

</body>
</html>




