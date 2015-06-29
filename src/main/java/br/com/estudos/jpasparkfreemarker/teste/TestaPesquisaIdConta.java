package br.com.estudos.jpasparkfreemarker.teste;

import javax.persistence.EntityManager;

import br.com.estudos.jpasparkfreemarker.dao.impl.ContaDAO;
import br.com.estudos.jpasparkfreemarker.entity.Conta;
import br.com.estudos.jpasparkfreemarker.utils.JPAUtil;

/**
 * @author turbiani
 *
 */
public class TestaPesquisaIdConta {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		
		ContaDAO dao = new ContaDAO(em);
		
		em.getTransaction().begin();
		
		Conta encontrado = dao.busca(2);
		
		System.out.println(encontrado.getTitular());
		
		em.close();
	}
}
