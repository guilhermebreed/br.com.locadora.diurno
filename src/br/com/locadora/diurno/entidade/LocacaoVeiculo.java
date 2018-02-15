package br.com.locadora.diurno.entidade;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class LocacaoVeiculo {

	@EmbeddedId
	private LocacaoVeiculoId id;
	
	@NotNull(message="Informe o valor")
	private Double valor;
	
	@NotNull(message="Informe a quantidade de dias")
	@Min(value=1, message="Qtd. de dias deve ser maior ou igual a 1")
	private Short quantidadeDia;
	
	@ManyToOne
	@JoinColumn(name="idVeiculo")
	@MapsId("idVeiculo")
	private Veiculo veiculo;
	
	@ManyToOne
	@JoinColumn(name="idLocacao")
	@MapsId("idLocacao")
	private Locacao locacao;

	public LocacaoVeiculoId getId() {
		return id;
	}

	public void setId(LocacaoVeiculoId id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Short getQuantidadeDia() {
		return quantidadeDia;
	}

	public void setQuantidadeDia(Short quantidadeDia) {
		this.quantidadeDia = quantidadeDia;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Locacao getLocacao() {
		return locacao;
	}

	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}
	
	
}
