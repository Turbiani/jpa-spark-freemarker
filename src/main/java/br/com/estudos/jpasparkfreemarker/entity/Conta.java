package br.com.estudos.jpasparkfreemarker.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author turbiani
 *
 */

@Entity
public class Conta {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String titular;
	private String banco;
	private String agencia;
	private String numero;
	
	@OneToMany(mappedBy="conta")
	private List<Movimentacao> movimentacoes;

	public Integer getId() {
		return id;
	}
	
	public String getTitular() {
		return titular;
	}
	
	public void setTitular(String titular) {
		this.titular = titular;
	}
	
	public String getBanco() {
		return banco;
	}
	
	public void setBanco(String banco) {
		this.banco = banco;
	}
	
	public String getAgencia() {
		return agencia;
	}
	
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}

	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

	public void setMovimentacoes(List<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}
	
}
