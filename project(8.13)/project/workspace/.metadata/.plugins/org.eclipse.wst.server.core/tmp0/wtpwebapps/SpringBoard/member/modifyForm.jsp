<%@page import="member.bean.MemberDTO"%>
<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원수정</title>
<script type="text/javascript" src="../script/memberScript.js?v=1"></script>
</head>
<body>
<form action="../member/modify.do" name="modifyForm" method="post">
	<table border="1">
		<tr>
			<td align="center">이름</td>
			<td><input type="text" name="name" placeholder="이름 입력"
					value="${memberDTO.getName()}"></td>
		</tr>
		<tr>
			<td align="center">아이디</td>
			<td>
				<input type="text" name="id" value="${memberDTO.getId()}">
			</td>
		</tr>
		<tr>
			<td align="center">비밀번호</td>
			<td><input type="password" name="pwd" size="30"
					value="${memberDTO.getPwd()}"></td>
		</tr>
		<tr>
			<td align="center">재확인</td>
			<td><input type="password" name="repwd" size="30"
					value="${memberDTO.getPwd()}"></td>
		</tr>
		<tr>
			<td align="center">성별</td>
			<td>
			<c:if test="${memberDTO.getGender().equals('0')}"> 
			
				<input type="radio" name="gender" value="0" checked>남
				<input type="radio" name="gender" value="1">여
				</c:if>
				<c:if test="${memberDTO.getGender().equals('1')}"> 
			
				<input type="radio" name="gender" value="0">남
				<input type="radio" name="gender" value="1" checked>여 
			 </c:if> 
			</td>
		</tr>
		<tr>
			<td align="center">이메일</td>
			<td>
				<input type="text" name="email1" 
					value="${memberDTO.getEmail1()}">@
				<input type="text" name="email2"
					value="${memberDTO.getEmail2()}">
			</td>
		</tr>
		<tr>
			<td align="center">핸드폰</td>
			<td>
				<input type="text" name="tel1" size="10"
					value="${memberDTO.getTel1()}">-
				<input type="text" name="tel2" size="10"
					value="${memberDTO.getTel2()}">-
					
				<input type="text" name="tel3" size="10"
					value="${memberDTO.getTel3()}">
			</td>
		</tr>
		<tr>
			<td align="center">주소</td>
			<td><input type="text" name="addr" size="50"
					value="${memberDTO.getAddr()}"></td>
		</tr>
		<tr>
			<td align="center" colspan="2">
				<input type="button" value="회원수정" onclick="checkModify()">
				<input type="reset" value="다시 작성">
			</td>
		</tr>
	</table>
</form>
<a href="../main/index.jsp">메인화면</a>
</body>
</html>









