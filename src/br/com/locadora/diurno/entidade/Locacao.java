package br.com.locadora.diurno.entidade;

import java.util.Date;
import javax.persistence.*;
import java.util.*;

@Entity
public class Locacao {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idLocacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInicio;
	
	private Double valorTotal;
	
	@ManyToOne
	@JoinColumn(name = "idCliente") //Nome FK
	private Cliente cliente;
	
	@OneToMany(mappedBy="locacao")
	private List<LocacaoVeiculo> locacaoVeiculos;
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<LocacaoVeiculo> getLocacaoVeiculos() {
		return locacaoVeiculos;
	}

	public void setLocacaoVeiculos(List<LocacaoVeiculo> locacaoVeiculos) {
		this.locacaoVeiculos = locacaoVeiculos;
	}

	public Integer getIdLocacao() {
		return idLocacao;
	}

	public void setIdLocacao(Integer idLocacao) {
		this.idLocacao = idLocacao;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
	
	
}
