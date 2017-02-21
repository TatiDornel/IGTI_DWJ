package br.igti.webjava.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="Ponto")
public class Ponto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GenericGenerator(name="seq_ponto", strategy="native", parameters=@Parameter(name="sequence", value="seq_ponto"))
	@GeneratedValue( generator="seq_ponto")
	@Column(name="id_ponto")
	private Integer id;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_funcionario")
	private Funcionario funcionario;
	
	@Column(name="data")
	private LocalDate data;
	
	@Column(name="hora_1")
	private LocalDateTime entrada;
	
	@Column(name="hora_2")
	private LocalDateTime intervalo;
	
	@Column(name="hora_3")
	private LocalDateTime retorno;
	
	@Column(name="hora_4")
	private LocalDateTime saida;
	
	
	public Integer getId() {
		return id;
	}


	public Funcionario getFuncionario() {
		return funcionario;
	}


	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}


	public LocalDate getData() {
		return data;
	}


	public void setData(LocalDate data) {
		this.data = data;
	}


	public LocalDateTime getEntrada() {
		return entrada;
	}


	public void setEntrada(LocalDateTime entrada) {
		this.entrada = entrada;
	}


	public LocalDateTime getIntervalo() {
		return intervalo;
	}


	public void setIntervalo(LocalDateTime intervalo) {
		this.intervalo = intervalo;
	}


	public LocalDateTime getRetorno() {
		return retorno;
	}


	public void setRetorno(LocalDateTime retorno) {
		this.retorno = retorno;
	}


	public LocalDateTime getSaida() {
		return saida;
	}


	public void setSaida(LocalDateTime saida) {
		this.saida = saida;
	}


	public void setId(Integer id) {
		this.id = id;
	}
	public String toJson(){
		String r = "{";
		r += "idfuncionario:" + id + ",";
		r += "data:\"" + data + "\",";
		r += "hora_1:\"" + entrada + "\",";
		r += "hora_2:\"" + intervalo + "\",";
		r += "hora_3:\"" + retorno + "\",";
		r += "hora_4:\"" + saida + "\"";
		r += "}";
		return r;
	}

	
}
