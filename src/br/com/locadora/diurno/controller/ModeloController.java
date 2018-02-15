package br.com.locadora.diurno.controller;

import br.com.locadora.diurno.entidade.*;
import br.com.locadora.diurno.dao.*;
import javax.ejb.*;
import javax.faces.bean.*;
import java.util.*;
import br.com.locadora.diurno.util.*;

@ManagedBean
public class ModeloController {

	private Modelo modelo;
	
	@EJB
	private ModeloDAO modeloDAO;
	
	public ModeloController(){
		this.modelo = new Modelo();
	}

	public void salvar(){
		String erro = modeloDAO.salvar(modelo);
		
		if(erro == null){ //Não houve erros
			Mensagem.sucesso("Operação realizada com sucesso.");
			this.modelo = new Modelo();//Limpar o form
		}else{
			Mensagem.erro("Erro: "+erro);
		}
		
	}
	
	public void excluir(Modelo modelo){
		String erro = modeloDAO.excluir(modelo.getIdModelo());
	
		if(erro == null){
			Mensagem.sucesso("Excluído com sucesso");
		}else{
			Mensagem.erro("Erro: "+erro);
		}
	}
	
	
	public void editar(Modelo modeloEditado){
		this.modelo = modeloEditado;
	}
	
	
	public List<Modelo> consultar(){
		return modeloDAO.todos();
	}
	
	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	
	
}
