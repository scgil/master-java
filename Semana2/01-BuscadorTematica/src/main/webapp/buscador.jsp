<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.curso.service.PaginaWebService" %>
<%@ page import="com.curso.modelo.PaginaWeb" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
PaginaWebService pgs = new PaginaWebService();
List<String> listaTematica = pgs.tematicas();
%>

<form action="BuscarWebs" method="post">
 <select name="nombreTematica">
 <% for (String tematica:listaTematica){	 %> 
  <option value="<%=tematica%>"><%=tematica%></option> 
<% }%> 
 </select>
 <input type="submit" value="Enviar">
</form>

</body>
</html>