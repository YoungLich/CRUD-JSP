package br.vemprafam.servlet2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.vemprafam.dao.DaoAluno;
import br.vemprafam.pojo.Aluno;

/**
 * Servlet implementation class DeletarAluno
 */
@WebServlet("/deletarFuncionario")
public class DeletarAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int ra;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletarAluno() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ra = Integer.parseInt(request.getParameter("ra"));
		DaoAluno dao = new DaoAluno();
		dao.excluirFuncionario(new Aluno(ra, null, null, null, 0));
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='ISO-8859-1'>");
		out.println("<tittle>Resposta</tittle>");
		out.println("</head>");
		out.println("<body>");
		out.println("Deletar Funcionario<br/>");
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

	public int getRa() {
		return ra;
	}

	public void setRa(int ra) {
		this.ra = ra;
	}

}
