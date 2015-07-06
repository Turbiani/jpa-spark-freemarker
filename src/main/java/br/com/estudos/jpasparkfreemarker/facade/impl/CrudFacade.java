package br.com.estudos.jpasparkfreemarker.facade.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.estudos.jpasparkfreemarker.dao.AbstractDAO;
import br.com.estudos.jpasparkfreemarker.facade.CrudInterface;
import br.com.estudos.jpasparkfreemarker.utils.JPAUtil;

/**
 * @author turbiani
 *
 * @param <T>
 */
public class CrudFacade <T> implements CrudInterface<T>{
	
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

	@SuppressWarnings("unchecked")
	public T busca(Integer id) {
		EntityManager em = new JPAUtil().getEntityManager();		
		em.getTransaction().begin();
		
		Object object = null;
		try {
			object = getDao().busca(id, em);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		em.close();
		return (T) object;
	}

	@SuppressWarnings("unchecked")
	public T busca(Integer id, EntityManager em) {
		Object object = null;
		try {
			object = getDao().busca(id, em);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (T) object;
	}

	@SuppressWarnings("unchecked")
	public List<T> lista() {
		EntityManager em = new JPAUtil().getEntityManager();		
		em.getTransaction().begin();
		
		List<T> lista = null;
		try {
			lista = (List<T>) getDao().lista(em);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		em.close();
		
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<T> lista(EntityManager em) {
		List<T> lista = null;
		try {
			lista = (List<T>) getDao().lista(em);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return lista;
	}

	public void remove(T object) {
		EntityManager em = new JPAUtil().getEntityManager();		
		em.getTransaction().begin();
		
		try {
			getDao().remove(object);
		
			em.getTransaction().commit();
		
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		em.close();
	}

	public void remove(int id) {
		EntityManager em = new JPAUtil().getEntityManager();		
		em.getTransaction().begin();
		
		try {
			getDao().remove(id);
		
			em.getTransaction().commit();
		
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		em.close();
	}

	public void remove(T object, EntityManager em) {
		try {
			getDao().remove(object, em);
		
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void remove(int id, EntityManager em) {
		try {
			getDao().remove(id, em);
		
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	public void adiciona(T object) {
		EntityManager em = new JPAUtil().getEntityManager();		
		em.getTransaction().begin();
		
		try {
			getDao().adiciona(object, em);
		
			em.getTransaction().commit();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		em.close();
	}

	public void adiciona(T object, EntityManager em) {
		try {
			getDao().adiciona(object, em);
		
			em.getTransaction().commit();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
