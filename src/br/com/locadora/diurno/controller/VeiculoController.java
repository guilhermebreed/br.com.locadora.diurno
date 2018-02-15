package br.com.locadora.diurno.controller;

import java.util.List;

import javax.ejb.*;
import br.com.locadora.diurno.entidade.Veiculo;
import br.com.locadora.diurno.util.Mensagem;
import br.com.locadora.diurno.dao.VeiculoDAO;
import javax.faces.bean.*;

@ManagedBean
public class VeiculoController {

	private Veiculo veiculo;
	
	
	@EJB
	private VeiculoDAO veiculoDAO;
	
	public VeiculoController(){
		this.veiculo = new Veiculo();
	}
	
	public List<Veiculo> consultar(){
		return veiculoDAO.todos();
	}
	
	public void salvar(){
		
		
		String erro = veiculoDAO.salvar(veiculo);

		if(erro == null){
			Mensagem.sucesso("Salvo!!!!");
			this.veiculo = new Veiculo();
		}
	}
	
	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	
}
