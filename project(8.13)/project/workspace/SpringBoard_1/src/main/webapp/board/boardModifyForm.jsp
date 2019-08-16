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
<title>Insert title here</title>
<script type="text/javascript" src="../script/boardScript.js"></script>
</head>
<body>
<h2 style="text-align: center;">글수정</h2>
<%--
	* 자바 데이터를 다음 페이지로 전달하는 방법1 : get 방식 사용
	<form action="boardModify.jsp?seq=<%=seq%>&pg=<%=pg%>">
	* 자바 데이터를 다음 페이지로 전달하는 방법2 : <input> 태그 사용
	<input type="hidden" name="seq" value="<%=seq%>">
	<input type="hidden" name="pg" value="<%=pg%>">
 --%>
<form action="../board/boardModify.do" name="boardModifyForm" method="post">
	<input type="hidden" name="seq" value="${seq}">
	<input type="hidden" name="pg" value="${pg}">
	
	<table border="1" style="margin: auto;">
		<tr>
			<th width="50">제목</th>
			<td><input type="text" name="subject" size="59"
				value="${boardDTO.getSubject()}"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="15" cols="45" 
				name="content">${boardDTO.getContent()}</textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="글수정" onclick="checkBoardModify()">
				<input type="reset" value="다시 작성">
			</td>
		</tr>
	</table>
</form>
</body>
</html>










