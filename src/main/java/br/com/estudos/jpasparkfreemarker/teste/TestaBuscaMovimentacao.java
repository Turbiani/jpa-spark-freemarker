package br.com.estudos.jpasparkfreemarker.teste;

import javax.persistence.EntityManager;

import br.com.estudos.jpasparkfreemarker.dao.MovimentacaoDAO;
import br.com.estudos.jpasparkfreemarker.entity.Movimentacao;
import br.com.estudos.jpasparkfreemarker.utils.JPAUtil;

/**
 * @author turbiani
 *
 */
public class TestaBuscaMovimentacao {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		MovimentacaoDAO dao = new MovimentacaoDAO(em);
		
		em.getTransaction().begin();
		
		Movimentacao mov = dao.busca(2);
		
		System.out.println(mov.getConta().getTitular());
		
		em.close();
	}
}
