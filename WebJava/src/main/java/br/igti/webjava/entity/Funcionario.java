package br.igti.webjava.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;




@Entity
@Table(name="Funcionario")
public class Funcionario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public Funcionario(){
		
	}
	public Funcionario(String nome){
		this.nome = nome;
	}
	
	
	@Id	
	@GenericGenerator(name="seq_funcionario", strategy="native", parameters=@Parameter(name="sequence", value="seq_funcionario"))
	@GeneratedValue(generator="seq_funcionario")
	@Column(name="id_funcionario")
	private Integer id;
	
	@Column(nullable = false, length = 50, unique= true)
	private String nome;
	
	@Column(nullable = false, length = 10,unique= true)	
	private String login;
	
	@Column(nullable = false, length = 10)	
	private String senha;
	
	public Integer getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
