<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
div {
	margin: auto;
	width: 600px;
}
</style>
</head>
<body>
<div>
	<h2 align="center">상세 정보</h2>
	<table border="1" style="border-collapse: collapse;">
		<tr align="center" bgcolor="orange">
			<td colspan="6" height="30px;">${dto.name }</td>
		</tr>
		<tr align="center" bgcolor="ffffcc">
			<td width="100">학번</td>
			<td width="100">국어</td>
			<td width="100">영어</td>
			<td width="100">수학</td>
			<td width="100">총점</td>
			<td width="100">평균</td>
		</tr>
		<tr align="center" bgcolor="ffffcc">
			<td>${dto.studNo}</td>
			<td>${dto.kor}</td>
			<td>${dto.eng}</td>
			<td>${dto.mat}</td>
			<td>${dto.tot}</td>
			<td>${dto.avg}</td>
		</tr>
	</table>
	<input type="button"onclick="location.href='scoreList.do?pg=${pg}'" value="목록" id="a">
	<input type="button" value="성적수정" onclick="location.href='scoreUpdateForm.do?pg=${pg}&studNo=${dto.studNo}'">
	<input type="button"onclick="location.href='scoreDelete.do?studNo=${dto.studNo}&pg=${pg}'"value="성적삭제" >
</div> 
</body>
</html>