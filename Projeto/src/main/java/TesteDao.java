import java.util.List;

import br.vemprafam.dao.DaoAluno;
import br.vemprafam.pojo.Aluno;

public class TesteDao {

	public static void main(String[] args) {
		DaoAluno dao = new DaoAluno();
		
		List<Aluno> lista = dao.getLista();
		for( Aluno aluno: lista ) {
			System.out.println(aluno);
		}
	}

}