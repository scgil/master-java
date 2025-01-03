<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.curso.modelo.PaginaWeb" %>
<%@ page import="com.curso.service.PaginaWebService" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resultado de la búsqueda</title>
</head>
<body>

<%
PaginaWebService pgws = new PaginaWebService();
List<PaginaWeb> websTematica = (List<PaginaWeb>) request.getAttribute("tematica");
String tematica = websTematica.get(0).getTematica();
%>

<h1>Tematica: <%=tematica%></h1>

<%
for(int i=0; i<websTematica.size(); i++){

%>

<a href='<%= websTematica.get(i).getUrl() %>'>Enlace.</a><br>
<p> Descripción: <%= websTematica.get(i).getDescripcion() %> </p>
		
<%} %>




</body>
</html>