package br.vemprafam.servlet2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.vemprafam.dao.DaoAluno;
import br.vemprafam.pojo.Aluno;

/**
 * Servlet implementation class ServletLista
 */
@WebServlet("/ServletLista")
public class ServletLista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLista() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoAluno dao = new DaoAluno();
		List<Aluno> lista = dao.getLista();
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='ISO-8859-1'>");
		out.println("<tittle>Aluno</tittle>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table border=1>");
		out.println("<tr>\r\n"
				+ "	<th>RA</th>\r\n"
				+ "	<th>Nome</th>\r\n"
				+ "	<th>Email</th>\r\n"
				+ "	<th>data nsc.</th>\r\n"
				+ "	<th>salário</th>\r\n"
				+ "		</tr>");
		for( Aluno f: lista) {
			out.println("<tr>\r\n"
					+ "<td>"+f.getRa()+"</td>"
					+ "<td>"+f.getNome()+"</td>"
					+ "<td>"+f.getEmail()+"</td>"
					+ "<td>"+f.getDataNascimento()+"</td>"
					+ "<td>"+f.getSalario()+"</td>\r\n"
					+ "	</tr>");
		}
		out.println("</table>");
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