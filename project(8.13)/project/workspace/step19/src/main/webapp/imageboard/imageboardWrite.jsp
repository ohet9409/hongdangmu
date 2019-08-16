<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload = function() {
	if(${imageboardDTO.image1 != null}){
		 alert("작성하신 글을 저장하였습니다");
	} else {
		 alert("작성하신 글을 저장하지 못했습니다");
	}
}
 
</script>
</head>
<body>
<c:if test="${imageboardDTO.image1 != null}">
	상품코드 : ${imageboardDTO.imageId }<br>
	상품이름 : ${imageboardDTO.imageName }<br>
	상품단가 : ${imageboardDTO.imageQty }<br>
	상품개수 : ${imageboardDTO.imagePrice }<br>
	상품설명 : ${imageboardDTO.imageContent }<br> 
<img alt="이미지" src="../storage/${imageboardDTO.image1 }">	<br>
</c:if>

</body>
</html>