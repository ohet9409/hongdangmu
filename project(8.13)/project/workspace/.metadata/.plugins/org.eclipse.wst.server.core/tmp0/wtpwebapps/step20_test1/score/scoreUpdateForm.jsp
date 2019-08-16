<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
div {
	width: 400px;
	margin: auto;
	align-content: center;
}
table {
	margin: auto;
}
</style>
</head>
<body>
	<h2 align="center">성적 수정</h2>
	<div>
	<form action="scoreUpdate.do" name="scoreFrm">
	<input type="hidden" name="pg" value="${pg}">
	<input type="hidden" name="studNo" value="${dto.studNo}">
	<input type="hidden" name="name" value="${dto.name}">
		<table>
			<tr>
				<th bgcolor="orange" width="50px" align="center">학번</td>
				<td>
					<input type="text" name="studNo" value="${dto.studNo}" disabled="disabled">
				</td>
			</tr>
			<tr>
				<th bgcolor="orange" width="50px" align="center">이름</td>
				<td>
					<input type="text" name="name" value="${dto.name}" disabled="disabled">
				</td>
			</tr>
			<tr>
				<th bgcolor="orange" width="50px" align="center">국어</td>
				<td>
					<input type="text" name="kor" value="${dto.kor}">
				</td>
			</tr>
			<tr>
				<th bgcolor="orange" width="50px" align="center">영어</td>
				<td>
					<input type="text" name="eng" value="${dto.eng}">
				</td>
			</tr>
			<tr>
				<th bgcolor="orange" width="50px" align="center">수학</td>
				<td>
					<input type="text" name="mat" value="${dto.mat}">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="수정">
					<input type="reset" value="다시쓰기">
					<input type="button" value="목록" onclick="location.href='scoreList.do'">
				</td>
			</tr>
		</table>
	</form>
	<a href="scoreList.do">리스트</a>
	</div>
</body>
</html>