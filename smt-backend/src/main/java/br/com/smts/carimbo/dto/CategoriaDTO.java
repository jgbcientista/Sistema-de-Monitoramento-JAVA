package br.com.smts.carimbo.dto;

import java.io.Serializable;

import br.com.smt.carimbo.model.CategoriaModel;
/**
 * 
 * @author Joao Guedes
 * Data: 21/08/2019
 *
 */

public class CategoriaDTO  implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
    private String nome;
	
	public CategoriaDTO(CategoriaModel obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
	}
	
	

	public CategoriaDTO() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	 

	 
}
