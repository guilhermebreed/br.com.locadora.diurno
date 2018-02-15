package br.com.locadora.diurno.entidade;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;


@Entity
@Table(name="Modelo") //Opcional
public class Modelo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Short idModelo;
	
	@Column(name="Descricao")//Opcional caso nome da coluna estiver diferente
	@NotNull(message="Informe a descrição")
	private String descricao;
	
	@OneToMany(mappedBy="modelo")
	private List<Veiculo> veiculos;
	

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	public Short getIdModelo() {
		return idModelo;
	}

	public void setIdModelo(Short idModelo) {
		this.idModelo = idModelo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idModelo == null) ? 0 : idModelo.hashCode());
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
		Modelo other = (Modelo) obj;
		if (idModelo == null) {
			if (other.idModelo != null)
				return false;
		} else if (!idModelo.equals(other.idModelo))
			return false;
		return true;
	}

	
}
