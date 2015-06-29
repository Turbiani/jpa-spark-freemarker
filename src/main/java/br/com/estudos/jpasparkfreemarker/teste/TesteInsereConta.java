package br.com.estudos.jpasparkfreemarker.teste;

import javax.persistence.EntityManager;

import br.com.estudos.jpasparkfreemarker.dao.impl.ContaDAO;
import br.com.estudos.jpasparkfreemarker.entity.Conta;
import br.com.estudos.jpasparkfreemarker.utils.JPAUtil;

/**
 * @author turbiani
 *
 */
public class TesteInsereConta {
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		ContaDAO dao = new ContaDAO(em);
		
		Conta conta = new Conta();
		conta.setTitular("Jeh");
		conta.setNumero("101112");
		conta.setBanco("Banco do Brasil");
		conta.setAgencia("Itaim");
		
		em.getTransaction().begin();
		
		dao.adiciona(conta);
		
		em.getTransaction().commit();
		em.close();
		
		System.out.println("Conta gravada com sucesso!");
	}
}
