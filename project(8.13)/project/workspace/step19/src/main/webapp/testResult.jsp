
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	// 저장된 폴더 위치 = 절대경로
    	String realFolder = "D:\\android_3rd_oh\\Dropbox\\spring\\workspace\\step19\\src\\main\\webapp\\storage";
    	/* MultipartRequest multi = new MultipartRequest(request, realFolder, 5*1024*1024,"UTF-8"
    			, new DefaultFileRenamePolicy()); */
    	/* String image1 = multi.getOriginalFileName("image1"); */
    	/* String path = realFolder + "\\" + image1; */
    	String image1 = null;
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=image1%>
<img alt="이미지" src="storage/<%=image1%>">
</body>
</html>