package br.com.estudos.jpasparkfreemarker.dao;

import java.util.List;

import javax.persistence.EntityManager;

public abstract class AbstractDAO<T> {
	
	public abstract T busca(Integer id);
	
	public abstract List<T> lista();
	
	public abstract void adiciona(T object);
	
	public abstract void remove(T object);
	
	public abstract void remove(int id);
	
	public abstract T busca(Integer id, EntityManager em);
	
	public abstract List<T> lista(EntityManager em);
	
	public abstract void adiciona(T object, EntityManager em);
	
	public abstract void remove(T object, EntityManager em);
	
	public abstract void remove(int id, EntityManager em);

}
