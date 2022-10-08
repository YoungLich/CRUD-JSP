package br.vemprafam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.vemprafam.pojo.Aluno;

public class DaoAluno {
	private Connection connection;
	private String url = "jdbc:hsqldb:hsql://localhost/";
	private String user = "SA";
	private String password = "";
	
	public DaoAluno() {
		try {
			connection = DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public void inserirAluno( Aluno aluno ) {
		try {
			String sql = "INSERT INTO AlUNOS VALUES(?,?,?,?,?)";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, aluno.getRa());
			pstmt.setString(2, aluno.getNome());
			pstmt.setString(3, aluno.getEmail());
			pstmt.setDate( 4, new java.sql.Date(aluno.getDataNascimento().getTime()));
			pstmt.setDouble(5, aluno.getSalario());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
	public void excluirFuncionario( Aluno aluno ) {
		try {
			String sql = "DELETE FROM ALUNOS WHERE RA=?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, aluno.getRa());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}		
	}
	
	public List<Aluno> getLista() {
		List<Aluno> result = new ArrayList<>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM ALUNOS");
			while( rs.next() ) {
				int ra = rs.getInt("ra");
				String nome = rs.getString(2);
				String email = rs.getString(3);
				Date dataNascimento = rs.getDate(4);
				double salario  = rs.getDouble("salario");
				Aluno aluno = new Aluno(ra,nome,email,dataNascimento,salario);
				result.add(aluno);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return result;
	}
	
	public Aluno buscarPeloRa( int ra ) {
		try {
			String sql = "SELECT * FROM ALUNOS WHERE RA=?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, ra);
			ResultSet rs = pstmt.executeQuery();
			if ( rs.next() ) {
				return new Aluno(rs.getInt(1),
									   rs.getString(2),
									   rs.getString(3),
									   rs.getDate(4),
									   rs.getDouble(5));
									 
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}		
		
	}
	
	public void atualizarAluno (Aluno aluno) {
		try {
			String sql = "UPDATE ALUNOS SET NOME=?, DATA_NASCIMENTO=?, SALARIO=?, EMAIL=? WHERE RA=?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, aluno.getNome());
			pstmt.setDate(2, new java.sql.Date(aluno.getDataNascimento().getTime()));
			pstmt.setDouble(3, aluno.getSalario());
			pstmt.setString(4, aluno.getEmail());
			pstmt.setInt(5, aluno.getRa());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}		
	}
}