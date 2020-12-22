<%@ page language="java" contentType ="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html><head><meta charset="UTF-8"></head>
<body>
<%
	String appPath = application.getContextPath();
	String filePath = application.getRealPath("06_application.jsp");
	String serverInfo = application.getServerInfo();
%>


웹 어플리케이션의 컨텍스트 패스명<br>
<b><%=appPath %></b><hr>
웹 어플리케이션의 파일 경로명
<b><%=filePath %></b><hr>
컨테이너의 이름과 버전 변환
<b><%=serverInfo %></b><hr>
</body>


</html>