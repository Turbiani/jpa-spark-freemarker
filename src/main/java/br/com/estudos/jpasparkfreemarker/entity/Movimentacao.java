package br.com.estudos.jpasparkfreemarker.entity;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.estudos.jpasparkfreemarker.listener.MovimentacaoListener;

/**
 * @author turbiani
 *
 */
@Entity
@EntityListeners(MovimentacaoListener.class)
public class Movimentacao {
	@Id 
	@GeneratedValue
	private Integer id;
	
	private String descricao;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;
	
	private BigDecimal valor;
	
	@ManyToOne//(cascade = CascadeType.PERSIST) //COM O CASCADE AS DEPENDENCIAS NÃO PRECISAM ESTAR MANAGED 
	private Conta conta;
	
	@Enumerated(EnumType.STRING)
	private TipoMovimentacao tipo;
	
	private Calendar dataAtualizacao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public TipoMovimentacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoMovimentacao tipo) {
		this.tipo = tipo;
	}
	
	
	
	public Calendar getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Calendar dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	@Override
	public String toString() {
		return "Movimentacao [id=" + id + ", descricao=" + descricao
				+ ", data=" + data + ", valor=" + valor + ", conta=" + conta
				+ ", tipo=" + tipo + "]";
	}
	
	
}
