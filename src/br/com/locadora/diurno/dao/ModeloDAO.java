package br.com.locadora.diurno.dao;

import br.com.locadora.diurno.entidade.Modelo;
import javax.ejb.*;

@Stateless
public class ModeloDAO extends GenericDAO<Modelo> {
	
	public ModeloDAO(){
		super(Modelo.class);
	}
}
