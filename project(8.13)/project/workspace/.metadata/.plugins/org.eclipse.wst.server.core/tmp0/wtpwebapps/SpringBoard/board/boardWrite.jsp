<%@page import="board.bean.BoardDTO"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<script type="text/javascript">
	if(${su > 0}) {
		alert("작성하신 글을 저장하였습니다.");		
	} else { 
		alert("작성하신 글을 저장하지 못하였습니다.");
	}
	location.href="../board/boardList.do?pg=1";
</script>
</head>
<body>

<%--
제목 : <%=subject %><br>
내용 : <%=content %><br>
이름 : <%=name %><br>
--%>
</body>
</html>








