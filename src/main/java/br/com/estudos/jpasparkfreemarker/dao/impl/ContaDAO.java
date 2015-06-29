package br.com.estudos.jpasparkfreemarker.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.estudos.jpasparkfreemarker.dao.AbstractDAO;
import br.com.estudos.jpasparkfreemarker.entity.Conta;
import br.com.estudos.jpasparkfreemarker.utils.JPAUtil;

/**
 * @author turbiani
 *
 */
public class ContaDAO extends AbstractDAO<Conta>{
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
		Conta conta = this.getEm().find(Conta.class, id); 
		fechaEm();
		return conta;
	}
	
	public List<Conta> lista(){
		List<Conta> contas =  this.getEm().createQuery("Select c from Conta c", Conta.class).getResultList();
		fechaEm();
		return contas;
	}
	
	public void adiciona(Conta conta){
		this.getEm().persist(conta);
		fechaEm();
	}
	
	public void remove(Conta conta){
		this.getEm().remove(conta);
		fechaEm();
	}
	
	@Override
	public void remove(int id) {
		Conta c = this.busca(id);
		this.getEm().remove(c);
		fechaEm();
	}

	@Override
	public void remove(int id, EntityManager em) {
		Conta c = this.busca(id);
		em.remove(c);
	}
	
	private EntityManager getEm(){
		if(this.em==null){
			this.em = new JPAUtil().getEntityManager();
		}
		return this.em;
	}
	
	private void fechaEm(){
		this.getEm().close();
	}
}
