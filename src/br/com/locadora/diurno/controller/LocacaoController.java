package br.com.locadora.diurno.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import br.com.locadora.diurno.dao.ClienteDAO;
import br.com.locadora.diurno.dao.LocacaoDAO;
import br.com.locadora.diurno.entidade.*;

@ManagedBean
@SessionScoped
public class LocacaoController {

	@EJB
	private LocacaoDAO locacaoDAO;
	
	@EJB
	private ClienteDAO clienteDAO;
	
	private Locacao locacao;
	private LocacaoVeiculo locacaoVeiculo;
	
	public LocacaoController(){
		this.locacao = new Locacao();
		this.locacaoVeiculo = new LocacaoVeiculo();
	}
	
	public void adicionar(){
		//Verifica se a lista não foi inicializada
		if(this.locacao.getLocacaoVeiculos() == null){
			List<LocacaoVeiculo> veiculoLocacoes 
					= new ArrayList<LocacaoVeiculo>();
			this.locacao.setLocacaoVeiculos(veiculoLocacoes);
		}
		//Adiciona o veículo em locacao
		this.locacao.getLocacaoVeiculos().add(locacaoVeiculo);
		this.locacaoVeiculo = new LocacaoVeiculo();
	}
	
	
	
	public Locacao getLocacao() {
		return locacao;
	}

	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}

	public LocacaoVeiculo getLocacaoVeiculo() {
		return locacaoVeiculo;
	}

	public void setLocacaoVeiculo(LocacaoVeiculo locacaoVeiculo) {
		this.locacaoVeiculo = locacaoVeiculo;
	}

	public List<Cliente> todosClientes(){
		return clienteDAO.todos();
	}
	
}
