package br.com.estudos.jpasparkfreemarker.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.estudos.jpasparkfreemarker.dao.AbstractDAO;
import br.com.estudos.jpasparkfreemarker.entity.Movimentacao;

/**
 * @author turbiani
 *
 */
public class MovimentacaoDAO extends AbstractDAO<Movimentacao>{
	
	public MovimentacaoDAO(EntityManager em){
		super(em);
	}
	
	/**
	 * Default constructor
	 */
	public MovimentacaoDAO(){}
	
	public Movimentacao busca(Integer id) {
		Movimentacao movimentacao = this.getEm().find(Movimentacao.class, id); 
		fechaEm();
		return movimentacao;
	}

	public Movimentacao busca(Integer id, EntityManager em) {
		return em.find(Movimentacao.class, id); 
	}

	public List<Movimentacao> lista() {
		List<Movimentacao> movimentacoes =  this.getEm().createQuery("Select m from Movimentacao m", Movimentacao.class).getResultList();
		fechaEm();
		return movimentacoes;
	}

	public List<Movimentacao> lista(EntityManager em) {
		return em.createQuery("Select c from Movimentacao c", Movimentacao.class).getResultList();
	}

	public void remove(Movimentacao Movimentacao) {
		this.getEm().remove(Movimentacao);
		fechaEm();		
	}

	public void remove(int id) {
		Movimentacao c = this.busca(id);
		this.getEm().remove(c);
		fechaEm();
	}

	public void remove(Movimentacao movimentacao, EntityManager em) {
		em.remove(movimentacao);
	}

	public void remove(int id, EntityManager em) {
		Movimentacao m = this.busca(id);
		em.remove(m);
	}

	public void adiciona(Movimentacao movimentacao) {
		this.getEm().getTransaction().begin();
		this.getEm().persist(movimentacao);
		this.getEm().getTransaction().commit();
		fechaEm();
	}

	public void adiciona(Movimentacao movimentacao, EntityManager em) {
		em.persist(movimentacao);
	}
	
}
