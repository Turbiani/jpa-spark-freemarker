package br.com.estudos.jpasparkfreemarker.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.estudos.jpasparkfreemarker.entity.Conta;

/**
 * @author turbiani
 *
 */
public class ContaDAO {
	private EntityManager em;

	public ContaDAO(EntityManager em) {
		super();
		this.em = em;
	}
	
	/**
	 * Default Constructor
	 */
	public ContaDAO(){}
	
	public Conta busca(Integer id, EntityManager manager){
		return manager.find(Conta.class, id);
	}
	
	public List<Conta> lista(EntityManager manager){
		return manager.createQuery("Select c from Conta c", Conta.class).getResultList();
	}
	
	public void adiciona(Conta conta, EntityManager manager){
		manager.persist(conta);
	}
	
	public void remove(Conta conta, EntityManager manager){
		manager.remove(conta);
	}
	
	public Conta busca(Integer id){
		return this.em.find(Conta.class, id);
	}
	
	public List<Conta> lista(){
		return this.em.createQuery("Select c from Conta c", Conta.class).getResultList();
	}
	
	public void adiciona(Conta conta){
		this.em.persist(conta);
	}
	
	public void remove(Conta conta){
		this.em.remove(conta);
	}
}
