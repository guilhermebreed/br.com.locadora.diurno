package br.com.locadora.diurno.testes;

import javax.persistence.*;

import br.com.locadora.diurno.entidade.Modelo;

public class Main {

	public static void main(String[] args){
		
		Modelo modelo1 =new Modelo();
		modelo1.setIdModelo((short)1);
		modelo1.setDescricao("Fiat");
		
		
		Modelo modelo2 =new Modelo();
		modelo2.setIdModelo((short)2);
		modelo2.setDescricao("Fiat");
		
		System.out.print(modelo1.equals(modelo2));
		
	}
}
