package br.com.estudos.jpasparkfreemarker.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.estudos.jpasparkfreemarker.entity.Movimentacao;

/**
 * @author turbiani
 *
 */
public class MovimentacaoDAO {
private EntityManager em;
	
	public MovimentacaoDAO(EntityManager manager){
		this.em = manager;
	}
	
	/**
	 * Default constructor
	 */
	public MovimentacaoDAO(){}
	
	public void adiciona(Movimentacao movimentacao, EntityManager manager){
		manager.persist(movimentacao);
	}
	
	public Movimentacao busca (Integer id, EntityManager manager){
		return manager.find(Movimentacao.class, id);
	}
	
	public List<Movimentacao> lista(EntityManager manager){
		return manager.createQuery("select m from Movimentacao m",Movimentacao.class).getResultList();
	}
	
	public void remove (Movimentacao movimentacao, EntityManager em){
		this.em.remove(movimentacao);
	}
	
	public void adiciona(Movimentacao movimentacao){
		this.em.persist(movimentacao);
	}
	
	public Movimentacao busca (Integer id){
		return this.em.find(Movimentacao.class, id);
	}
	
	public List<Movimentacao> lista(){
		return this.em.createQuery("select m from Movimentacao m",Movimentacao.class).getResultList();
	}
	
	public void remove (Movimentacao movimentacao){
		this.em.remove(movimentacao);
	}
}
