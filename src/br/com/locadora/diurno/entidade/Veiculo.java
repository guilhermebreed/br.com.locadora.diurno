package br.com.locadora.diurno.entidade;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.util.List;

@Entity
@NamedQuery(name="veiculo.porPreco",
	query="select v from Veiculo as v "
			+ "where v.valor between :v1 and :v2")
public class Veiculo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idVeiculo;
	
	@NotNull(message="Informe a placa")
	private String placa;
	
	@NotNull(message="Informe o valor")
	private Double valor;
	
	@ManyToOne
	@JoinColumn(name="idModelo")
	@NotNull(message="Informe o modelo")
	private Modelo modelo;
	
	@ManyToMany
	@JoinTable(name="Veiculo_Opcional",
		joinColumns = @JoinColumn(name="IdVeiculo"),
		inverseJoinColumns = @JoinColumn(name="IdOpcional"))
	//@Size(min=1,message="")
	private List<Opcional> opcionais;
	
	
	public List<Opcional> getOpcionais() {
		return opcionais;
	}
	public void setOpcionais(List<Opcional> opcionais) {
		this.opcionais = opcionais;
	}
	public Modelo getModelo() {
		return modelo;
	}
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	public Integer getIdVeiculo() {
		return idVeiculo;
	}
	public void setIdVeiculo(Integer idVeiculo) {
		this.idVeiculo = idVeiculo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idVeiculo == null) ? 0 : idVeiculo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		if (idVeiculo == null) {
			if (other.idVeiculo != null)
				return false;
		} else if (!idVeiculo.equals(other.idVeiculo))
			return false;
		return true;
	}
	
	
}
