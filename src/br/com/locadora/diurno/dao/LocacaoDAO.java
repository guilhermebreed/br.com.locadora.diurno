package br.com.locadora.diurno.dao;

import javax.ejb.Stateless;
import br.com.locadora.diurno.entidade.Locacao;

@Stateless
public class LocacaoDAO extends GenericDAO<Locacao> {

	public LocacaoDAO() {
		super(Locacao.class);
	}

}
