<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Eco datos formulario</title>
</head>
<body>
<c:if test="${param.numero>=5}">
	<c:out value="Aprobado"></c:out>
</c:if>
<c:if test="${param.numero<5}">
	<c:out value="Aprobado"></c:out>
</c:if>

<c:choose>
	<c:when test="${param.numero>=5}">
		<c:out value="Has aprobado"></c:out>
	</c:when>
	<c:otherwise>
		<c:out value="Has suspendido"></c:out>
	</c:otherwise>
</c:choose>

</body>
</html>