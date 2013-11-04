<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>새 책</h2>
<form method="post" action="add.do">
제목: <input type="text" name="title"><br>
저자: <input type="text" name="author"><br>
가격: <input type="text" name="price"><br>
수량: <input type="text" name="qty"><br>
<input type="submit" value="등록">
<input type="reset" value="취소" onclick="location.href='list.do';">
</form>
</body>
</html>