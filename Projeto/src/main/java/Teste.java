import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Teste {

	public static void main(String[] args) {
		System.out.println("Hello world");
		try {
			Connection connection = DriverManager.getConnection(
					"jdbc:hsqldb:hsql://localhost/", "SA", "");
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM ALUNOS");
			while( rs.next()) {
				int re = rs.getInt("re");
				String nome = rs.getString(2);
				Date dataAdimissao = rs.getDate(3);
				double salario = rs.getDouble("salario");
				
				System.out.println(re + " " + nome + " " + dataAdimissao + " " + salario);
			}
			stmt.executeUpdate("INSERT INTO ALUNOS VALUES(8,'Márcia','2000-01-01',5000)");
			
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
