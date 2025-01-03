<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.curso.service.CursoService" %>
<%@ page import="com.curso.model.Curso" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejemplo 1. Cursos y nivel</title>
</head>
<body>
<%
CursoService cs = new CursoService();
List<Curso> listaCursos=cs.buscarTodos();

for (Curso curso:listaCursos){
%>
<p>Nombre del curso:<%=curso.getNombre() %>--- Nivel del curso:<%=curso.getNivel() %>
<% }%>
<h1>OTRA FORMA</h1>
<form action="loqsea.jsp" method="post">
 <select name="nombreCurso">
 <% for (Curso c:listaCursos){	 %> 
  <option value="<%=c.getNombre()%>"><%=c.getNombre()%></option> 
<% }%> 
 </select>
 <input type="submit" value="Enviar">
</form>

</body>
</html>