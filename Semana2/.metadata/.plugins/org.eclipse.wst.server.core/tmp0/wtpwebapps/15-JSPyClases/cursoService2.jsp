<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.curso.service.CursoService2" %>
<%@ page import="com.curso.model.Curso" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
CursoService2 cs = new CursoService2();
List<Curso> listaCursos = cs.buscarTodos();

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