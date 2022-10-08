<%@page import="br.vemprafam.pojo.Aluno"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.vemprafam.dao.DaoAluno"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alteração</title>
</head>
<body>
<%
int ra = Integer.parseInt(request.getParameter("ra"));
String nome = request.getParameter("nome");
String email = request.getParameter("email");
SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
Date dataNascimento;
try {
	dataNascimento = format.parse(request.getParameter("dataNsc"));
} catch (ParseException e) {
	dataNascimento = null;
} 
double salario = Double.parseDouble(request.getParameter("salario"));
DaoAluno dao = new DaoAluno();
dao.atualizarAluno(new Aluno(ra,nome,email,dataNascimento,salario));
%>
Aluno atualizado
<br/>
<a href='/Projeto'>voltar ao menu principal</a>

</body>
</html>