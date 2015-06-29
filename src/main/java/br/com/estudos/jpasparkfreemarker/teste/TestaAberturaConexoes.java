package br.com.estudos.jpasparkfreemarker.teste;

import javax.persistence.EntityManager;

import br.com.estudos.jpasparkfreemarker.utils.JPAUtil;

public class TestaAberturaConexoes {
	public static void main(String[] args) {
		for (int i = 1; i <= 30; i++) {
			EntityManager em = new JPAUtil().getEntityManager();
			em.getTransaction().begin();
			System.out.println("Criando o EntityManager " + i);
		}
		
		try {
			Thread.sleep(30 * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
