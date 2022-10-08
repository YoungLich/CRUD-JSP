<%@page import="br.vemprafam.pojo.Aluno"%>
<%@page import="java.util.List"%>
<%@page import="br.vemprafam.dao.DaoAluno"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista versão JSP</title>
</head>
<body>
<table border='1'>
<tr>
<th>RA</th><th>nome</th><th>email</th><th>dataNsc</th><th>salário</th>
</tr>

<%
DaoAluno dao = new DaoAluno();
List<Aluno> lista = dao.getLista();
for( Aluno f: lista) {
%>

<tr>
<td><%=f.getRa()%></td>
<td><%=f.getNome()%></td>
<td><%=f.getEmail()%></td>
<td><%=f.getDataNascimento()%></td>
<td><%=f.getSalario()%></td>
</tr>

<%
}
%>
</table>
<br/>
<a href='/Projeto'>voltar ao menu principal</a>
</body>
</html>