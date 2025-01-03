<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bucle según datos entrada formulario</title>
</head>
<body>
<%
 int  tope = Integer.parseInt(request.getParameter("numero"));

for (int i=1; i<=tope; i++ ){%>
	<p><%=i %></p>

<%}%>

 



</body>
</html>