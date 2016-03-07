<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mercado</title>
</head>
<body	bgcolor="#FFFFCC">
<h1> <center> Mercado </center> </h1>
<br>
<br>
<br>
<br>
<h2>	
	<div align="center">
	<tr align="left">	<a HREF="./incluir.jsp" > Incluir Operações</a></tr> 
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <tr  align="right">
	<a HREF="./Listar" > Lista de Operações </a> </tr>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<c:if test="${inserido == 'true'}">
		<h4><center>Incluído</center></h4>
	</c:if>
	
	<c:if test="${excluido == 'true'}">
		<h4><center>Excluído</center></h4>
	</c:if>
</h6>
</body>
</html>