package br.com.locadora.diurno.dao;

import javax.ejb.*;
import br.com.locadora.diurno.entidade.*;

@Stateless
public class OpcionalDAO extends GenericDAO<Opcional> {
	
	public OpcionalDAO(){
		super(Opcional.class);
	}
	
}
