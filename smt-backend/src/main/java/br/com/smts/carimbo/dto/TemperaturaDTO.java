package br.com.smts.carimbo.dto;

import java.io.Serializable;
import java.util.Date;

import br.com.smt.carimbo.model.TemperaturaModel;
/**
 * 
 * @author Joao Guedes
 * Data: 21/08/2019
 *
 */
public class TemperaturaDTO  implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
    private String descricao;
	private String responsavel;
	private Integer numeroLote;
	private Integer temperaturaRegistrada;
	private Boolean jaAlertado;
	
//	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date dataRegistro;
	
	public TemperaturaDTO(TemperaturaModel obj) {
		this.id = obj.getId();
		this.descricao = obj.getDescricao();
		this.numeroLote = obj.getNumeroLote();
		this.temperaturaRegistrada = obj.getTemperaturaRegistrada();
		this.dataRegistro = obj.getDataRegistro();
	}

	public TemperaturaDTO() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public Integer getTemperaturaRegistrada() {
		return temperaturaRegistrada;
	}

	public void setTemperaturaRegistrada(Integer temperaturaRegistrada) {
		this.temperaturaRegistrada = temperaturaRegistrada;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getJaAlertado() {
		return jaAlertado;
	}

	public void setJaAlertado(Boolean jaAlertado) {
		this.jaAlertado = jaAlertado;
	}

	public Integer getNumeroLote() {
		return numeroLote;
	}

	public void setNumeroLote(Integer numeroLote) {
		this.numeroLote = numeroLote;
	}

	 
}
