package br.com.locadora.diurno.controller;

import br.com.locadora.diurno.entidade.*;
import br.com.locadora.diurno.dao.*;

import java.io.ByteArrayOutputStream;
import java.util.List;

import javax.ejb.*;
import javax.faces.bean.*;

import javax.faces.context.*;
import javax.servlet.http.*;

@ManagedBean
public class VeiculoRelatorioController {

	private Double precoInicial;
	private Double precoFinal;
	
	@EJB
	private VeiculoDAO veiculoDAO;
	
	private List<Veiculo> veiculos;
	
	public void pdf(){
		
		try{
			
			ByteArrayOutputStream os 
				= veiculoDAO.pdfPorPreco(precoInicial, precoFinal);
			
			
			HttpServletResponse response 
					= (HttpServletResponse) FacesContext
						.getCurrentInstance()
						.getExternalContext()
						.getResponse();
			
			response.setContentType("application/pdf");
			response.setHeader("Content-disposition", "inline;filename=relatorio.pdf");
			response.getOutputStream().write(os.toByteArray());
			
			FacesContext.getCurrentInstance().responseComplete();
			
			
		}catch(Exception ex){
			
		}
		
	}
	
	public void consultar(){
		this.veiculos 
			= veiculoDAO.consultaPorPreco(precoInicial, precoFinal);
	}
	
	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}



	public Double getPrecoInicial() {
		return precoInicial;
	}
	public void setPrecoInicial(Double precoInicial) {
		this.precoInicial = precoInicial;
	}
	public Double getPrecoFinal() {
		return precoFinal;
	}
	public void setPrecoFinal(Double precoFinal) {
		this.precoFinal = precoFinal;
	}
	
	
}
