<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<link rel="stylesheet" href="stilo.css">

<title>Cadastro Cliente</title>
</head>
<body>
	<div class="client">
	<fieldset>
	<legend><h3>Clientes - Cadastro</h3></legend>
	<form action="ClienteController.jsp" method="POST">
	
	<label id="label-2" for="nome">NOME:</label>
	<input type="text" name="nome" id="nome" required="required"/>
	</br>
	<label id="label-1" for="cpf">CPF:</label>
	<input type="text" name="cpf" id="cpf" required="required"/>
	</br>
	<label id="label-3" for="email">EMAIL:</label>
	<input type="text" name="email" id="email" required="required"/>
	</br>
	<label id="label-4" for="dataNasc">DATA NASCIMENTO:</label>
	<input type="text" name="dataNasc" id="dataNasc" required="required"/>
	</br>
	<label id="label-5" for="sexo">SEXO:</label>
	<input type="text" name="sexo" id="sexo" required="required"/>
	</br>
	<label id="label-6" for="nomeSocial">NOME SOCIAL:</label>
	<input type="text" name="nomeSocial" id="nomeSocial" />
	</br>
	<label id="label-7" for="apelido">APELIDO:</label>
	<input type="text" name="apelido" id="apelido" />
	</br>
	<label id="label-8" for="telefone">TELEFONE:</label>
	<input type="text" name="telefone" id="telefone" required="required"/>
	</br> </br>
	<input id="salvar" type="submit" value="SALVAR"  /> <input id="alterar" type="submit" value="ALTERAR"  />
	</form>
	</fieldset>
	</div>
	
	
	
</form>
</body>
</html>