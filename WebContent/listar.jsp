<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Lista de Operações</title>
</head>
<body bgcolor="#FFFFCC">
	<h1> <center> Lista de Operações </center> </h1>
	<br>
	<table border=1 align="center">
		<tr>
			<td width="185"><h3>Código de Mercadoria</h3></td>
			<td width="185"><h3>Tipo de Mercadoria</h3></td>
			<td width="185"><h3>Nome da Mercadoria</h3></td>
			<td width="120"><h3>Quantidade</h3></td>
			<td width="140"><h3>Preço</h3></td>
			<td width="150"><h3>Tipo de Negócio</h3></td>
		</tr>
		<c:forEach items="${lista}" var="mercadoria">
			<tr>
				<td align="center">${mercadoria.codigoMercadoria}</td>
				<td align="center">${mercadoria.tipoMercadoria}</td>
				<td align="center">${mercadoria.nomeMercadoria}</td>
				<td align="center">${mercadoria.quantidade}</td>
				<td align="center">${mercadoria.preco}</td>
				<td align="center">${mercadoria.tipoNegocio}</td>
				<td><a href="./Excluir?codigo=${mercadoria.codigoMercadoria}">Excluir</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<br>
	<br>
	<center><a HREF="./mercado.jsp"> Voltar </a></center>
</body>
</html>