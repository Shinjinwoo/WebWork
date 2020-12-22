<%@ page language="java" contentType ="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>

<!DOCTYPE html>

<% 
pageContext.setAttribute("name","page man");
request.setAttribute("name","request man");
session.setAttribute("name","session man");
application.setAttribute("name","application man");

System.out.println("firstPage.jsp : ");
System.out.println("하나의 페이지 속성 : ");
System.out.println("하나의 요청 속성 : ");
System.out.println("하나의 세션 속성 : ");
System.out.println("하나의 어플리캐이션 속성 : ");

request.getRequestDispatcher("07_secondPage.jsp").forward(request,response);

%>