<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario que se crea con JSP</title>
</head>
<body>
<form action="02bucleRequest.jsp" method="post">
<select name="numero">
<% for ( int i=0; i<=20;i++){ %>
<option value="<%=i%>"><%=i%></option>
<%}%>

</select>
<input type="submit" value="Enviar">
</form>
 

</body>
</html>