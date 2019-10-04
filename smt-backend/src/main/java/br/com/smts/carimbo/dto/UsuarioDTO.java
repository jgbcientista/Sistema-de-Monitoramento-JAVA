package br.com.smts.carimbo.dto;

import java.io.Serializable;

import br.com.smt.carimbo.model.UsuarioModel;
/**
 * 
 * @author Joao Guedes
 * Data: 21/08/2019
 *
 */

public class UsuarioDTO  implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
    private String nome;
	private String login;
    private String senha;
	
	public UsuarioDTO(UsuarioModel obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.login = obj.getLogin();
		this.senha = obj.getSenha();
	}
	
	public UsuarioDTO() {
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
