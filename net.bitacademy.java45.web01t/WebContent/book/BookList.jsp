<%@page import="net.bitacademy.java45.vo.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html><head><title>책 목록</title></head><body>
<h2>책 목록3</h2>

<c:forEach var="book" items="${requestScope.list}">
	<p><input type='checkbox' name='id' value='${book.id}' />
	${book.author}, 
	<a href="detail?id=${book.id}">${book.title}</a>, 
	$${book.price}</p>
</c:forEach>
</body></html>
