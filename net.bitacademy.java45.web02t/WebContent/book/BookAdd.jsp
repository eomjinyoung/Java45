<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// Refresh 방법 2
response.addHeader("Refresh", "1;url=list");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Refresh 방법 1 -->
<!--  
<meta http-equiv="Refresh" content="1;url=list">
-->
<title>책 등록 결과</title>
</head>
<body>
<p>책 등록 성공입니다!</p>
</body>
</html>