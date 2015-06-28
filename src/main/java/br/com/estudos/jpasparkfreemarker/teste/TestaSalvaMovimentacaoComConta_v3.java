package br.com.estudos.jpasparkfreemarker.teste;

import javax.persistence.EntityManager;

import br.com.estudos.jpasparkfreemarker.dao.ContaDAO;
import br.com.estudos.jpasparkfreemarker.dao.MovimentacaoDAO;
import br.com.estudos.jpasparkfreemarker.entity.Conta;
import br.com.estudos.jpasparkfreemarker.entity.Movimentacao;
import br.com.estudos.jpasparkfreemarker.utils.JPAUtil;

/**
 * @author turbiani
 *
 */
public class TestaSalvaMovimentacaoComConta_v3 {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		ContaDAO contaDao = new ContaDAO(em);
		Conta conta = contaDao.busca(1);
		
		MovimentacaoDAO movimentacaoDao = new MovimentacaoDAO(em);
		Movimentacao movimentacao 		= movimentacaoDao.busca(3);
		
		movimentacao.setConta(conta);
		//PERSISTINDO NO BANCO DE DADOS
		em.persist(movimentacao);
		
		em.getTransaction().commit();
		em.close();
	}
}
