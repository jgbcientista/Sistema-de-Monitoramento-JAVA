package br.com.smt.carimbo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import br.com.smts.carimbo.dto.UsuarioDTO;

/**
 * 
 * @author Joao Guedes
 * Data: 21/08/2019
 *
 */

@Entity(name="USUARIO")
public class UsuarioModel {
	
	@Id
	@SequenceGenerator(name = "SEQ_USUARIO", sequenceName = "SEQ_USUARIO", allocationSize = 1)
	@GeneratedValue(generator = "SEQ_USUARIO", strategy = GenerationType.AUTO)
	private Integer id;
	
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "login", nullable = false)
	private String login;
	
	@Column(name = "senha", nullable = false)
	private String senha;
	
	public UsuarioModel() {
	}
	
	public UsuarioModel(UsuarioDTO dto) {
		this.id = dto.getId();
		this.nome = dto.getNome();
		this.login = dto.getLogin();
		this.senha = dto.getSenha();
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	
}
