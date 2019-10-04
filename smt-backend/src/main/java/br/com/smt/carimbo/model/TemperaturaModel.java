package br.com.smt.carimbo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.smts.carimbo.dto.TemperaturaDTO;

/**
 * 
 * @author Joao Guedes
 * Data: 21/08/2019
 *
 */

@Entity(name="TEMPERATURA")
public class TemperaturaModel {
	
	@Id
	@SequenceGenerator(name = "SQ_TEMPERATURA", sequenceName = "SQ_TEMPERATURA", allocationSize = 1)
	@GeneratedValue(generator = "SQ_TEMPERATURA", strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "descricao", nullable = false)
	private String descricao;
	
	@Column(name = "numero_lote", nullable = false)
	private Integer numeroLote;
	
	@Column(name = "temperatura_registrada", nullable = false)
	private Integer temperaturaRegistrada;

	@Column(name = "data_registro")
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date dataRegistro;
	
	@Column(name = "ja_alertado", nullable = true)
	private Boolean jaAlertado;

	public TemperaturaModel(TemperaturaDTO vacinaDTO) {
		this.id = vacinaDTO.getId();
		this.descricao = vacinaDTO.getDescricao();
		this.dataRegistro = new Date();
		this.numeroLote = vacinaDTO.getNumeroLote();
		this.temperaturaRegistrada = vacinaDTO.getTemperaturaRegistrada();
		this.jaAlertado = vacinaDTO.getJaAlertado();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
