<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.vemprafam.pojo.Aluno"%>
<%@page import="br.vemprafam.dao.DaoAluno"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulário de alteração</title>
</head>
<body>
<%
int ra = Integer.parseInt(request.getParameter("ra"));
DaoAluno dao = new DaoAluno();
Aluno f = dao.buscarPeloRa(ra);
SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
String dataNascimentoStr = format.format(f.getDataNascimento());
%>

<form action="executaAlteracao.jsp">
RA:<input type='text' name='ra' value='<%=f.getRa()%>'/><br/>
nome:<input type='text' name='nome' value='<%=f.getNome()%>'/><br/>
email:<input type='text' name='email' value='<%=f.getEmail()%>'/><br/>
data de Nascimento:<input type='text' name='dataNsc' value='<%=dataNascimentoStr%>'/><br/>
salário:<input type='text' name='salario' value='<%=f.getSalario()%>'/><br/>
<input type='submit' value='Enviar'>
</form>
<br/>
<a href='/Projeto'>voltar ao menu principal</a>
</body>
</html>