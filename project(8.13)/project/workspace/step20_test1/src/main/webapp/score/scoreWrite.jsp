<%@page import="score.dao.ScoreDAO"%>
<%@page import="score.bean.ScoreDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	// 작업순서를 마지막에 실행하기위해서
	window.onload = function() {
		if(${su>0}){
			alert("저장성공");
			location.href="scoreList.do";
		}else if(${su==0}){
			alert("저장실패");
			history.back();
		}else if(${su<0}){
			alert("점수를 숫자로만 입력해주세요");
			history.back();
		}	
	}
	
</script>
</head>
<body>
<c:if test="${su>0 }">
	작성하신 성적을 저장하였습니다.
</c:if>
<c:if test="${su==0 }">
	작성하신 성적을 저장하지 못하였습니다.
</c:if>
<c:if test="${su<0 }">
	점수를 숫자로 입력해주세요
</c:if>
</body>
</html>