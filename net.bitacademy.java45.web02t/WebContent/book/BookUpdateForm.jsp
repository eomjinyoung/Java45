<%@page import="net.bitacademy.java45.vo.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html><head><title>책 변경</title></head><body>
<h2>책 변경</h2>

<form method="post" action="update.do">
아이디: <input type="text" readonly name="id" value="${book.id}"><br>
제목: <input type="text" name="title" value="${book.title}"><br>
저자: <input type="text" name="author" value="${book.author}"><br>
가격: <input type="text" name="price" value="${book.price}"><br>
수량: <input type="text" name="qty" value="${book.qty}"><br>
<input type="submit" value="변경">
<input type="reset" value="취소" onclick="location.href='detail.do?id=${book.id}';">
</form>

</body></html>













