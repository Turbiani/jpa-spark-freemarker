package br.com.estudos.jpasparkfreemarker.dao;

import javax.persistence.EntityManager;

import br.com.estudos.jpasparkfreemarker.facade.CrudInterface;
import br.com.estudos.jpasparkfreemarker.utils.JPAUtil;

/**
 * @author turbiani
 *
 * @param <T>
 */
public abstract class AbstractDAO<T> implements CrudInterface<T>{
	
	protected EntityManager em;
	
	/**
	 * Default Constructor
	 */
	public AbstractDAO(){}
	
	/**
	 * @param em
	 */
	public AbstractDAO(EntityManager em){
		this.em = em;
	}
	
	protected EntityManager getEm(){
		if(this.em==null){
			this.em = new JPAUtil().getEntityManager();
		}
		return this.em;
	}
	
	protected void fechaEm(){
		this.getEm().close();
	}	

}
