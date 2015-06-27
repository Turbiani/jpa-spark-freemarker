package br.com.estudos.jpasparkfreemarker.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.estudos.jpasparkfreemarker.entity.Conta;

public class TesteInsereConta {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("controlefinancas");
		
		EntityManager em = factory.createEntityManager();
		
		Conta conta = new Conta();
		conta.setTitular("Leo");
		conta.setNumero("1234");
		conta.setBanco("Bradesco");
		conta.setAgencia("Andorinha");
		
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		em.close();
		
		System.out.println("Conta gravada com sucesso!");
	}
}
