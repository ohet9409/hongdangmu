<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>이미지 등록</h2>
<form action="imageboardWrtie" enctype="multipart/form-data" method="post">
	<table border="1">
		<tr>
			<td>상품코드</td>
			<td><input type="text" name="imageId" value="Img_"></td>
		</tr>
		<tr>
			<td>상품명</td>
			<td><input type="text" name="imageName"></td>
		</tr>
		<tr>
			<td>단가</td>
			<td><input type="text" name="imagePrice"></td>
		</tr>
		<tr>
			<td>개수</td>
			<td><input type="text" name="imageQty"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td>
				<textarea rows="10" cols="40" name="imageContent"></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2"><input type="file" name="img"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<input type="submit" value="이미지등록">
			<input type="reset" value="다시작성">
			</td>
		</tr>
	</table>
</form>
</body>
</html>