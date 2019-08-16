<%@page import="board.dao.BoardDAO"%>
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
	if(${su > 0}) { 
			alert("삭제성공");
			location.href="../board/boardList.do?pg=${pg}";
	} else {
			alert("삭제실패");
			location.href="../board/boardView.do?seq=${seq}&pg=${pg}"
	} 
</script>
</head>
<body>

</body>
</html>