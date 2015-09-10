package br.com.estudos.jpasparkfreemarker.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.estudos.jpasparkfreemarker.dao.AbstractDAO;
import br.com.estudos.jpasparkfreemarker.entity.Conta;

/**
 * @author turbiani
 *
 */
public class ContaDAO extends AbstractDAO<Conta>{
	

	public ContaDAO(EntityManager em) {
		super(em);
	}
	
	/**
	 * Default Constructor
	 */
	public ContaDAO(){}

	public Conta busca(Integer id) {
		Conta conta = this.getEm().find(Conta.class, id); 
		fechaEm();
		return conta;
	}

	public Conta busca(Integer id, EntityManager em) {
		return em.find(Conta.class, id); 
	}

	public List<Conta> lista() {
		List<Conta> contas =  this.getEm().createQuery("Select c from Conta c", Conta.class).getResultList();
		fechaEm();
		return contas;
	}

	public List<Conta> lista(EntityManager em) {
		return em.createQuery("Select c from Conta c", Conta.class).getResultList();
	}

	public void remove(Conta conta) {
		this.getEm().remove(conta);
		fechaEm();		
	}

	public void remove(int id) {
		Conta c = this.busca(id);
		this.getEm().remove(c);
		fechaEm();
	}

	public void remove(Conta conta, EntityManager em) {
		em.remove(conta);
	}

	public void remove(int id, EntityManager em) {
		Conta c = this.busca(id);
		em.remove(c);
	}

	public void adiciona(Conta conta) {
		this.getEm().getTransaction().begin();
		this.getEm().persist(conta);
		this.getEm().getTransaction().commit();
		fechaEm();
	}

	public void adiciona(Conta conta, EntityManager em) {
		em.persist(conta);
	}
	
}
