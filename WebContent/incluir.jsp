<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script>
function validaCampos() {
	var msg = '';
	if (document.forms[0].codigo.value == null || document.forms[0].codigo.value == ''){
		msg = msg + 'Favor Informar o Código da Mercadoria';
		msg = msg + '\n';
	}
	
	if (document.forms[0].tipo.value == null || document.forms[0].tipo.value == ''){
		msg = msg + 'Favor Informar o Tipo da Mercadoria';
		msg = msg + '\n';
	}
	
	if (document.forms[0].nomeMercadoria.value == null || document.forms[0].nomeMercadoria.value == ''){
		msg = msg + 'Favor Informar o Nome da Mercadoria';
		msg = msg + '\n';
	}
	
	if (document.forms[0].quantidade.value == null || document.forms[0].quantidade.value == ''){
		msg = msg + 'Favor Informar a Quantidade da Mercadoria';
		msg = msg + '\n';
	}
	
	if (document.forms[0].preco.value == null || document.forms[0].preco.value == ''){
		msg = msg + 'Favor Informar o Preço da Mercadoria';
		msg = msg + '\n';
	}
	
	if (msg != '')
	{
		alert(msg);
		return false;
	}
	
	if (isNaN(document.forms[0].codigo.value)){
		alert('Favor Informar o Código apenas com números');
		document.forms[0].codigo.select();
		return false;
	}
	
	if (isNaN(document.forms[0].quantidade.value)){
		alert('Favor Informar a Quantidade apenas com números');
		document.forms[0].quantidade.select();
		return false;
	}
	
	charDec = ",";
	var reDecimalPt = /^[+-]?((\d+|\d{1,3}(\.\d{3})+)(\,\d*)?|\,\d+)$/;
	if (! reDecimalPt.test(document.forms[0].preco.value)) {
		alert('Favor Informar o Preço apenas com números');
		document.forms[0].preco.select();
		return false;
	}
	
	document.forms[0].submit();
}

function voltar(){
	
}

</script>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inclusão de Dados</title>
</head>
<body bgcolor="#FFFFCC">
<h1> <center> Inclusão de Dados: </center> </h1>
	<form align="center" method="post" action="./Incluir">
		<table align="center">
			<tr><td>Código de Mercadoria: </td><td><input type="text" name="codigo"></td></tr>
			<tr><td>Tipo de Mercadoria:</td><td><input type="text" name="tipo"></td></tr>
			<tr><td>Nome da Mercadoria: </td><td><input type="text" name="nomeMercadoria"></td></tr>
			<tr><td>Quantidade: </td><td><input type="text" name="quantidade"></td></tr>
			<tr><td>Preço: </td><td><input type="text" name="preco"></td></tr>
			<tr><td>Tipo de Negócio: </td><td>
			<select name="tipoNegocio">
				<option value="compra" selected="selected">Compra</option>
				<option value="venda">Venda</option>
			</select>
			</td></tr>
		</table>
		<br>
		<input type="button" name="gravar" value="Gravar" onClick="validaCampos()">
		<input type="reset" value="Limpar">
		<br>
		<br>
		<br>
		<br>
		<a HREF="./mercado.jsp" > Voltar </a>
	
	</form>
	
	<c:if test="${incluiu == 'false'}">
		<h4><center>Registro já Cadastrado</center></h4>
	</c:if>
</body>
</html>