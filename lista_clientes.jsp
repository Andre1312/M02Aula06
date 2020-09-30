<%@page import="java.util.List"%>
<%@page import="m02aula06.basica.Cliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LISTA CLIENTES</title>
</head>
<body>
	
	<%
	
	List<Cliente> lista = (List<Cliente>)request.getAttribute("clientes");
	
	for(int i=0; i<lista.size(); i++){
		
		
		out.print("<table style=\"width:100%\">");
		out.print("<tr>");
		out.print("<th> - </th>");
		//out.print("<th>Alterar</th>");
		out.print("<th>ID</th>");
		out.print("<th>Nome</th>");
		out.print("<th>CPF</th>");
		out.print("<th>e-Mail</th>");
		out.print("<th>eData Nasc.</th>");
		out.print("<th>Sexo</th>");
		out.print("<th>Nome Social</th>");
		out.print("<th>Apelido</th>");
		out.print("<th>Telefone</th>");
		out.print("</tr>");
		
		out.print("<tr>");
		out.print("<td><a href='ClienteController.jsp?excluir=1&id="+ lista.get(i).getId() +"'>Excluir</a></td>");
		out.print("<td>" + lista.get(i).getId() + "</td>");
		out.print("<td>" + lista.get(i).getNome() + "</td>");
		out.print("<td>" + lista.get(i).getCpf() + "</td>");
		out.print("<td>" + lista.get(i).getEmail()+ "</td>");
		out.print("<td>" + lista.get(i).getDataNascimento() + "</td>");
		out.print("<td>" + lista.get(i).getSexo() + "</td>");
		out.print("<td>" + lista.get(i).getNomeSocial() + "</td>");
		out.print("<td>" + lista.get(i).getApelido() + "</td>");
		out.print("<td>" + lista.get(i).getTelefone() + "</td>");
		
		out.print("</tr>");
		
		out.print("</table");
		
		
		//out.print(i+"\t" + lista.get(i).getNome() );
		//out.print("\t " + lista.get(i).getCpf() );
		//out.print("\t "  + lista.get(i).getEmail() );
		//out.print("\t "  + lista.get(i).getDataNascimento() );
		//out.print("\t "  + lista.get(i).getSexo() );
		//out.print("\t "  + lista.get(i).getNomeSocial() );
		//out.print("\t "  + lista.get(i).getApelido() );
		//out.print("\t "  + lista.get(i).getTelefone() + "<br/>");
		
	}
	%>
</body>
</html>