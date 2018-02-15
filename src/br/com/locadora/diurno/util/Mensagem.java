package br.com.locadora.diurno.util;

import javax.faces.context.*;
import javax.faces.application.*;

public class Mensagem {

	public static void sucesso(String texto){
		
		FacesContext
			.getCurrentInstance()
			.addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, texto, null));
				
	}
	
	public static void erro(String texto){
		
		FacesContext
			.getCurrentInstance()
			.addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, texto, null));
				
	}
	
}
