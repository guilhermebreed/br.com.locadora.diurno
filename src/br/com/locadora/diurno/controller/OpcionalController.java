package br.com.locadora.diurno.controller;

import javax.ejb.*;
import javax.faces.bean.*;

import br.com.locadora.diurno.entidade.*;
import br.com.locadora.diurno.dao.*;
import java.util.List;

@ManagedBean
@RequestScoped
public class OpcionalController {

	@EJB
	private OpcionalDAO opcionalDAO;
	
	public List<Opcional> consultar(){
		return opcionalDAO.todos();
	}
	
}
