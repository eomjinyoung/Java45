<%@page import="net.bitacademy.java45.vo.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head><title>책 목록</title></head><body>
<h2>책 목록1</h2>
<%
List<Book> list = (List<Book>)request.getAttribute("list");
for(Book book : list) {%>
	<p><input type='checkbox' name='id' value='<%=book.getId()%>' />
	<%=book.getAuthor()%>, <%=book.getTitle()%>, $<%=book.getPrice()%></p>
<%}%>
</body></html>
