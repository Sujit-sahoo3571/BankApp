<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage ="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% out.println("Error Occured:- ");


%>
<%=exception.getMessage() %>
<br> <br> 
<jsp:include page="application.html"></jsp:include>
</body>
</html>