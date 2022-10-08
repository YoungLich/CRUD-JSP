import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Teste1 {

	private static String ra;
	private static String dataNscStr;
	private static String email;

	public static void main(String[] args) {
		try {
			Connection connection = DriverManager.getConnection(
					"jdbc:hsqldb:hsql://localhost/", "SA", "");
			Statement stmt = connection.createStatement();
			try (Scanner scan = new Scanner(System.in)) {
				int ra = scan.nextInt();
				String nome = "aaa','2000-01-01',4000);DROP TABLE TESTE;INSERT INTO FUNCIONARIOS VALUES(12,'bbb";
				
				String dataNscStr = scan.next();

				double salario = scan.nextDouble();
				String sql = "INSERT INTO ALUNOS VALUES("+ra+
						",'"+nome+"','"+email+"','"+dataNscStr+"',"+salario+")";
				
				System.out.println(sql);		
				stmt.executeUpdate(sql);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static String getRa() {
		return ra;
	}

	public static void setRa(String ra) {
		Teste1.ra = ra;
	}
	public static String getEmail() {
		return email;
	}

	public static void setEmail(String email) {
		Teste1.email = email;
	}


	public static String getDataNscStr() {
		return dataNscStr;
	}

	public static void setDataNscStr(String dataNscStr) {
		Teste1.dataNscStr = dataNscStr;
	}

}