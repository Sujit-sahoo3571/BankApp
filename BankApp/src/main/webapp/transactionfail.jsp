<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage ="error.jsp"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String msg = (String) request.getAttribute("msg");

	if(!msg.isEmpty())
	throw new ServletException(msg);

%>

</body>
</html>