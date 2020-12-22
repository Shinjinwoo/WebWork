<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--태그라이브러리 불러옴 --%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 다운로드</title>
</head>
<body>
	<form action="result.jsp" method="post">
		<input type="hidden" name="param1" value="1.jpg"> <input
			type="hidden" name="param2" value="2.jpg"> <input
			type="submit" value="이미지 다운로드">
	</form>
</body>
</html>