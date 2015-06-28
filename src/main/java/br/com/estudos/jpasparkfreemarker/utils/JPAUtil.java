package br.com.estudos.jpasparkfreemarker.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author turbiani
 *
 */
public class JPAUtil {
	private static EntityManagerFactory factory = 
			Persistence.createEntityManagerFactory("controlefinancas");
	
	public EntityManager getEntityManager(){
		return factory.createEntityManager();
	}
}
