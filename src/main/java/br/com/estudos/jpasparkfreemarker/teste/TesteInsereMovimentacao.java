package br.com.estudos.jpasparkfreemarker.teste;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.estudos.jpasparkfreemarker.entity.Movimentacao;
import br.com.estudos.jpasparkfreemarker.entity.TipoMovimentacao;

/**
 * @author turbiani
 *
 */
public class TesteInsereMovimentacao {
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("controlefinancas");
		
		EntityManager em = factory.createEntityManager();
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setDescricao("Teste de insercao sem Conta");
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setTipo(TipoMovimentacao.ENTRADA);
		
		em.getTransaction().begin();
		em.persist(movimentacao);
		em.getTransaction().commit();
		em.close();
		
		System.out.println("Movimentacao gravada com sucesso!");
	}
}
