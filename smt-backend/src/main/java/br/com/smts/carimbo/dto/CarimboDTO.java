package br.com.smts.carimbo.dto;

import java.io.Serializable;
import java.util.Date;

import br.com.smt.carimbo.model.CarimboModel;

/**
 * 
 * @author Joao Guedes
 * Data: 21/08/2019
 *
 */

public class CarimboDTO  implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
    private String numeroProcesso;
	private Integer paginaInicial;
	private Integer paginaFinal;
	private String string;
	
//	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date dataAplicacao;

	public CarimboDTO() {
	}

	public CarimboDTO(CarimboModel carimbo) {
		this.id = carimbo.getId();
		this.numeroProcesso = carimbo.getNumeroProcesso();
		this.paginaInicial = carimbo.getPaginaInicial();
		this.paginaFinal = carimbo.getPaginaFinal();
		this.string = carimbo.getString();
		this.dataAplicacao = carimbo.getDataAplicacao();
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNumeroProcesso() {
		return numeroProcesso;
	}
	
	public void setNumeroProcesso(String numeroProcesso) {
		this.numeroProcesso = numeroProcesso;
	}
	
	public Integer getPaginaInicial() {
		return paginaInicial;
	}
	
	public void setPaginaInicial(Integer paginaInicial) {
		this.paginaInicial = paginaInicial;
	}
	
	public Integer getPaginaFinal() {
		return paginaFinal;
	}
	
	public void setPaginaFinal(Integer paginaFinal) {
		this.paginaFinal = paginaFinal;
	}
	
	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}
	
	public Date getDataAplicacao() {
		return dataAplicacao;
	}

	public void setDataAplicacao(Date dataAplicacao) {
		this.dataAplicacao = dataAplicacao;
	}
}
