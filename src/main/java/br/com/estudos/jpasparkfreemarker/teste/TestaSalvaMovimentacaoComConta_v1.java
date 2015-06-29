package br.com.estudos.jpasparkfreemarker.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.estudos.jpasparkfreemarker.dao.impl.MovimentacaoDAO;
import br.com.estudos.jpasparkfreemarker.entity.Conta;
import br.com.estudos.jpasparkfreemarker.entity.Movimentacao;
import br.com.estudos.jpasparkfreemarker.entity.TipoMovimentacao;
import br.com.estudos.jpasparkfreemarker.utils.JPAUtil;

/**
 * @author turbiani
 *
 */
public class TestaSalvaMovimentacaoComConta_v1 {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		//CRIANDO INSTANCIA DE CONTA
		Conta conta = new Conta();
		conta.setAgencia("Agencia de Santana");
		conta.setBanco("Banco Itau Card");
		conta.setNumero("2059");
		conta.setTitular("House");
		
		
		//CRIANDO INSTANCIA DE MOVIMENTACAO QUE DEPENDE DE UMA CONTA
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setConta(conta);
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Conta de farofa macachera - setembro/2013");
		movimentacao.setValor(new BigDecimal("50"));
		movimentacao.setTipo(TipoMovimentacao.SAIDA);
		
		
		//COLOCANDO NO PERSIST CONTEXT
		MovimentacaoDAO movimentacaoDao = new MovimentacaoDAO(em);
		movimentacaoDao.adiciona(movimentacao);
		
		//PERSISTINDO NO BANCO DE DADOS
		em.persist(movimentacao);
		//DARÁ EXCEPTION POIS CONTA ESTÁ FORA DO CONTEXTO DE PERSISTENCIA
		em.getTransaction().commit();
		em.close();
	}
}
