package br.vemprafam.servlet2;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.vemprafam.dao.DaoAluno;
import br.vemprafam.pojo.Aluno;

/**
 * Servlet implementation class ServletCadastro
 */
@WebServlet("/cadastrarAluno")
public class ServletCadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCadastro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		dao.inserirAluno(new Aluno(ra,nome,email,dataNascimento,salario));
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='ISO-8859-1'>");
		out.println("<tittle>Resposta</tittle>");
		out.println("</head>");
		out.println("<body>");
		out.println("Aluno Cadastrado<br/>");
		out.println("<a href = /Projeto>voltar ao menu principal</a>");
		out.println("</body>");
		out.println("</html>");
	}
	
	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
