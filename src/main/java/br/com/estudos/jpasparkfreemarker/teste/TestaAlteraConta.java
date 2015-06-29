package br.com.estudos.jpasparkfreemarker.teste;

import javax.persistence.EntityManager;

import br.com.estudos.jpasparkfreemarker.dao.impl.ContaDAO;
import br.com.estudos.jpasparkfreemarker.entity.Conta;
import br.com.estudos.jpasparkfreemarker.utils.JPAUtil;

/**
 * @author turbiani
 *
 */
public class TestaAlteraConta {
	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		
		ContaDAO dao = new ContaDAO(manager);
		
		manager.getTransaction().begin();
		
		//ME DEVOLVE UMA INSTANCIA MANAGED
		Conta conta = dao.busca(3);
		conta.setTitular("Joao");
		
		//TESTANDO SEM INSTANCIA MANAGED, E SIM DETACHAD
		Conta conta2 = new Conta();
		conta2.setTitular("Jessica");
		//PARA GRAVAR NO BANCO PRECISO PERSISTIR A INSTACIA
		manager.persist(conta2);
		//QUAL A DIFERENÇA ENTRE PERSIST E MERGE ?
		//COM O PERSIST CASO EU SETE ALGUM ATRIBUTO DA INSTANCIA QUE PASSEI PARA ELE, NO COMMIT ESTA ALTERACAO
		//SERÁ REALIZADA
		//JA O MERGE DEIXA A INSTANCIA QUE PASSEI PARA ELE DETACHED
		//O PERSIST É VOID O MERGE ME DEVOLVE UMA NOVA INSTANCIA MANAGED, A ORIGINAL FICA DETACHED
		//Conta c = manager.merge(conta2) -AGORA C É MANAGED E conta2 DETACHED
		//SE REALIZAR ALTERACOES EM c NO COMMIT VAO PARA O BANCO, JÁ EM conta2 NÃO
		
		manager.getTransaction().commit();
		manager.close();		
		
	}
}
