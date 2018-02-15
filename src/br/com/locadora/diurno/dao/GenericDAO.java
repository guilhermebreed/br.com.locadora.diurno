package br.com.locadora.diurno.dao;

import javax.persistence.*;

import java.util.List;

import java.io.Serializable;

public class GenericDAO<T> {

	@PersistenceContext
	protected EntityManager em;
	
	private Class<T> classe;
	
	public GenericDAO(Class<T> classe){
		this.classe = classe;
	}
	
	public String salvar(T entidade){
		try{
			em.merge(entidade);//Altera ou Insere
		}catch(Exception ex){
			return "Erro ao salvar "+ex.getMessage();
		}
		
		return null;
	}
	
	public T obter(Serializable id){
		T entidade = em.find(classe, id);
		return entidade;
	}
	
	public String excluir(Serializable id){
		
		try{
			T entidade = obter(id);
			em.remove(entidade);//Excluir
		}catch(Exception ex){
			return "Erro ao excluir: "+ex.getMessage();
		}
		
		return null;
	}
	
	public List<T> todos(){
		
		TypedQuery<T> query =
				 em.createQuery("select m from "
						 +classe.getSimpleName()+" as m",classe);
		
		return query.getResultList();
	}
	
	
}
