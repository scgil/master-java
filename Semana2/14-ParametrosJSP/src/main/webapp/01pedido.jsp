<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Eco de los datos del pedido</title>
</head>
<body>
<%String codigo = request.getParameter("codigo");
String unidades = request.getParameter("unidades");
%>

 
<h2>Has comprado <%=unidades %> unidades del producto con código <%=codigo %>. </h2>


</body>
</html>