package br.com.estudos.jpasparkfreemarker.listener;

import java.util.Calendar;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import br.com.estudos.jpasparkfreemarker.entity.Movimentacao;

/**
 * @author turbiani
 *
 */
public class MovimentacaoListener {
	@PreUpdate
	public void pretUpdate(Movimentacao entidade){
		System.out.println("Vou gravar a data de atualizacao(UPDATE) Movimentacao!!!");
		entidade.setDataAtualizacao(Calendar.getInstance());
		System.out.println(entidade.toString());
	}
	
	@PrePersist
	public void prePersist(Movimentacao entidade){
		System.out.println("Vou gravar a data de atualizacao(INSERT) MovimentacaoxD!!!");
		entidade.setDataAtualizacao(Calendar.getInstance());
		System.out.println(entidade.toString());
	}
}
