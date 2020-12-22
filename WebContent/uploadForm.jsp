<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
    import="java.util.*"%>

       <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
       <%-- 태그라이브 불러옴  --%>
       <c:set var = "contextPath" value="${pageContext.request.contextPath}"/> <!-- 이부분을 안써서  에러가남 -->
       <%-- contextPath 변수 생성 --%>
<%
    request.setCharacterEncoding("UTF-8");
%>

<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드창</title>
</head>
<body>
<%-- 서블릿에 요청해 파일을 업로드합니다. upload.do.//
anctype=파일 업로드시 반드시 encTupe을 multipat/form-data로 설정해야 합니다. --%>
<form action="${contextPath }/ss" method="post"
enctype="multipart/form-data">
파일1: <input type="file" name="file1"> <br>
파일2: <input type="file" name="file2"> <br>


파라미터1: <input type="text" name="param1" ><br>
파라미터2: <input type="text" name="param2" ><br>
파라미터3: <input type="text" name="param3" ><br>

<input type="submit" value="업로드" >



</form>
</body>
</html>