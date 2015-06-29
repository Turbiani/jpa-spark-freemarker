package br.com.estudos.jpasparkfreemarker.facade;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.estudos.jpasparkfreemarker.dao.AbstractDAO;
import br.com.estudos.jpasparkfreemarker.utils.JPAUtil;

/**
 * @author turbiani
 *
 * @param <T>
 */
public class CrudFacade <T>{
	
	private String 				nomeDoDao;
	private String 				nomeDaClasse;
	private AbstractDAO<Object> dao;

    /**
     * @param typeParameterClass
     */
    public CrudFacade(Class<T> typeParameterClass) {
    	//SUPER HARD CODE, POREM CONTANDO COM A CoC = CONVENTION OVER CONFIGURATION HAHAHA =]
    	this.nomeDaClasse = typeParameterClass.getSimpleName();
    	this.nomeDoDao    = "br.com.estudos.jpasparkfreemarker.dao.impl."  
    			+ this.nomeDaClasse 
    			+ "DAO";
    }
    
    /**
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     */
    @SuppressWarnings("unchecked")
	public AbstractDAO<Object> getDao() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
    	dao = (AbstractDAO<Object>) Class.forName(nomeDoDao).newInstance();
    	return dao;
    }

	
	/**
	 * @param id
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public T busca(Integer id) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		EntityManager em = new JPAUtil().getEntityManager();		
		em.getTransaction().begin();
		
		Object object = getDao().busca(id, em);
		
		em.close();
		return (T) object;
	}
	
	/**
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	@SuppressWarnings("unchecked")
	public List<T> lista() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		EntityManager em = new JPAUtil().getEntityManager();		
		em.getTransaction().begin();
		
		List<T> lista = (List<T>) getDao().lista(em); 
		
		dao.lista(em);
		return lista;
	}
	
	/**
	 * @param object
	 */
	public void adiciona(T object){
		EntityManager em = new JPAUtil().getEntityManager();		
		em.getTransaction().begin();
		
		em.persist(object);
		
		em.close();
	}
	
	/**
	 * @param object
	 */
	public void remove(T object){
		EntityManager em = new JPAUtil().getEntityManager();		
		em.getTransaction().begin();
		
		em.remove(object);
		
		em.close();
	}
	
	/**
	 * @param id
	 */
	public void remove(int id){
		EntityManager em = new JPAUtil().getEntityManager();		
		em.getTransaction().begin();
		
		em.remove(id);
		
		em.close();
	}
	
}
