package br.com.smt.carimbo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import br.com.smts.carimbo.dto.CategoriaDTO;

/**
 * 
 * @author Joao Guedes
 * Data: 21/08/2019
 *
 */

@Entity(name="CATEGORIA")
public class CategoriaModel {
	
	@Id
	@SequenceGenerator(name = "SEQ_CATEGORIA", sequenceName = "SEQ_CATEGORIA", allocationSize = 1)
	@GeneratedValue(generator = "SEQ_CATEGORIA", strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	public CategoriaModel() {
	}
	
	public CategoriaModel(CategoriaDTO dto) {
		this.id = dto.getId();
		this.nome = dto.getNome();
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
