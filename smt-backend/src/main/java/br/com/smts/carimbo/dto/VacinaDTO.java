package br.com.smts.carimbo.dto;

import java.io.Serializable;
import java.util.Date;

import br.com.smt.carimbo.model.VacinaModel;

/**
 * 
 * @author Joao Guedes
 * Data: 21/08/2019
 *
 */

public class VacinaDTO  implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
    private String nome;
	private String responsavel;
	private Integer lote;
	private Integer temperaturaRegistrada;
	
//	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date dataAplicacao;
	
	public VacinaDTO(VacinaModel obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.responsavel = obj.getResponsavel();
		this.lote = obj.getLote();
		this.temperaturaRegistrada = obj.getTemperaturaRegistrada();
		this.dataAplicacao = obj.getDataAplicacao();
	}

	public VacinaDTO() {
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

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public Integer getLote() {
		return lote;
	}

	public void setLote(Integer lote) {
		this.lote = lote;
	}

	public Integer getTemperaturaRegistrada() {
		return temperaturaRegistrada;
	}

	public void setTemperaturaRegistrada(Integer temperaturaRegistrada) {
		this.temperaturaRegistrada = temperaturaRegistrada;
	}

	public Date getDataAplicacao() {
		return dataAplicacao;
	}

	public void setDataAplicacao(Date dataAplicacao) {
		this.dataAplicacao = dataAplicacao;
	}

	 
}
