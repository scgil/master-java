<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Encabezados html creados con jsp</title>
</head>
<body> 
<% for (int i=1; i<7; i++){%>
	<h<%=i %>>Bienvenido a mi sitio web</h<%=i %>>	
<%}%>

<h1>Bienvenido a mi sitio web</h1>
<h2>Bienvenido a mi sitio web</h2>
<h3>Bienvenido a mi sitio web</h3>
<h4>Bienvenido a mi sitio web</h4>
<h5>Bienvenido a mi sitio web</h5>
<h6>Bienvenido a mi sitio web</h6>
</body>
</html>