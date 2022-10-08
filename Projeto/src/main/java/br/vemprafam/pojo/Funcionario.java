package br.vemprafam.pojo;

import java.util.Date;

public class Funcionario {

	private int ra;
	private String nome;
	private String email;
	private Date dataNascimento;
	private double salario;
	@Override
	public String toString() {
		return "Funcionario [ra=" + ra + ", nome=" + nome + ", email=" + email + ", dataAdmissao=" + dataNascimento + ", salario=" + salario
				+ "]";
	}
	public Funcionario(int ra, String nome, String email, Date dataNascimento, double salario) {
		super();
		this.ra = ra;
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.salario = salario;
	}
	public Funcionario() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getRa() {
		return ra;
	}
	public void setRe(int ra) {
		this.ra = ra;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
}