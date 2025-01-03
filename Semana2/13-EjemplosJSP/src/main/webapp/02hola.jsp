<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hola 2</title>
</head>
<body>
<%
String texto="Otra vez hola";
//en 01hola.jsp hemos usado out.println(saludo)
//Ahora vamos a usar una expresión JSP
%>
<h2>Un texto cualquiera de HTML</h2>
<!--  Esto es una expresión JSP -->
<%=texto %>
</body>
</html>