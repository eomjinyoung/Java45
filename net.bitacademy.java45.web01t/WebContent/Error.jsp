<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>실행 오류!</title>
</head>
<body>
<h2>실행 오류!</h2>
<pre>
<%
Exception e = (Exception)request.getAttribute("error");
e.printStackTrace(new PrintWriter(out));
%>
</pre>
</body>
</html>