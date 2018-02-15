package br.com.locadora.diurno.entidade;

import javax.persistence.*;

@Embeddable
public class LocacaoVeiculoId {

	private Integer idLocacao;
	
	private Integer idVeiculo;

	public Integer getIdLocacao() {
		return idLocacao;
	}

	public void setIdLocacao(Integer idLocacao) {
		this.idLocacao = idLocacao;
	}

	public Integer getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(Integer idVeiculo) {
		this.idVeiculo = idVeiculo;
	}
	
	
	
}
