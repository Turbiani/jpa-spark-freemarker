package br.com.estudos.jpasparkfreemarker.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.estudos.jpasparkfreemarker.dao.AbstractDAO;
import br.com.estudos.jpasparkfreemarker.entity.Movimentacao;
import br.com.estudos.jpasparkfreemarker.utils.JPAUtil;

/**
 * @author turbiani
 *
 */
public class MovimentacaoDAO extends AbstractDAO<Movimentacao>{
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
	
	public void remove (Movimentacao movimentacao, EntityManager manager){
		manager.remove(movimentacao);
	}
	
	public void adiciona(Movimentacao movimentacao){
		this.getEm().persist(movimentacao);
		fechaEm();
	}
	
	public Movimentacao busca (Integer id){
		Movimentacao mov = this.getEm().find(Movimentacao.class, id);
		fechaEm();
		return mov;
	}
	
	public List<Movimentacao> lista(){
		List<Movimentacao> movimentacoes = this.getEm().createQuery("select m from Movimentacao m",Movimentacao.class).getResultList();
		fechaEm();
		return movimentacoes;
	}
	
	public void remove (Movimentacao movimentacao){
		this.getEm().remove(movimentacao);
		fechaEm();
	}
	
	@Override
	public void remove(int id) {
		Movimentacao mv = this.busca(id);
		this.getEm().remove(mv);
		fechaEm();
	}

	@Override
	public void remove(int id, EntityManager manager) {
		Movimentacao mv = this.busca(id);
		manager.remove(mv);
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
