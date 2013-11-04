<%@page import="net.bitacademy.java45.vo.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html><head><title>책 상세정보</title></head><body>
<h2>책 상세정보</h2>

<c:if test="${!empty book}">
아이디: ${book.id}<br>
저자: ${book.author}<br> 
제목: ${book.title}<br> 
가격: $${book.price}<br>
수량: ${book.qty}<br>
</c:if>
<p>
<a href="update.do?id=${book.id}">[변경]</a>
<a href="delete.do?id=${book.id}">[삭제]</a>
<a href="list.do">[목록]</a>
</p>
</body></html>













