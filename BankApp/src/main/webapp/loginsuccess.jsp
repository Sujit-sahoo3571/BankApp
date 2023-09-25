<%@page import="test.BankacBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String msg = (String) request.getAttribute("msg");
out.println(msg);

BankacBean bb = (BankacBean) request.getAttribute("bacbean");
out.println("<br> This page belongs to "+bb.getAcchold()+"<br> ");

%>

<jsp:include page="application.html" />

<a href ="logout"> Log out </a>


</body>
</html>