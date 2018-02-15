package br.com.locadora.diurno.dao;

import javax.ejb.Stateless;

import br.com.locadora.diurno.entidade.Cliente;

@Stateless	
public class ClienteDAO extends GenericDAO<Cliente> {

	public ClienteDAO() {
		super(Cliente.class);
	}

}
