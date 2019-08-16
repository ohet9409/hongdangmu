<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<img alt="tumi" src="../image/tumi.png" width="30" height="30"
		onclick="location.href='../main/index.jsp'" 
		style="cursor: pointer;">
	${name}(${id})님이 로그인
</body>
</html>








