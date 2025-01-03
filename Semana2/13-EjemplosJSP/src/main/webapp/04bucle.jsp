<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Bucle mejorado</title>
</head>
<body>  
<% for (int i=1; i<11; i++){

	out.println("<p>" + i + "</p>");
}

%>
Lo vamos a  hacer más sencillo

<% for (int i=1; i<11; i++){%>
	<p><%=i%></p>
<%} %>

</body>
</html>