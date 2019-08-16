<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적관리</title>
<script type="text/javascript" src="../script/scoreScript.js">
</script>
<style type="text/css">
div {
	width: 500px;
	margin: auto;
	align-content: center;
}
.writeForm {
	margin: auto;
}

</style>
</head>
<body>
	<h2 align="center">성적 입력</h2>
	<div> 
	<form action="../score/scoreWrite.do" name="scoreFrm">
		<table class="writeForm">
			<tr>
				<th bgcolor="orange" width="50px" align="center">학번</td>
				<td>
					<input type="text" name="studNo">
				</td>
			</tr>
			<tr>
				<th bgcolor="orange" width="50px" align="center">이름</td>
				<td>
					<input type="text" name="name">
				</td>
			</tr>
			<tr>
				<th bgcolor="orange" width="50px" align="center">국어</td>
				<td>
					<input type="text" name="kor">
				</td>
			</tr>
			<tr>
				<th bgcolor="orange" width="50px" align="center">영어</td>
				<td>
					<input type="text" name="eng">
				</td>
			</tr>
			<tr>
				<th bgcolor="orange" width="50px" align="center">수학</td>
				<td>
					<input type="text" name="mat">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" onclick="input()" value="입력">
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