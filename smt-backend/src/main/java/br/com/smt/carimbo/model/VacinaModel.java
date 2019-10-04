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

import br.com.smts.carimbo.dto.CarimboDTO;
import br.com.smts.carimbo.dto.VacinaDTO;

/**
 * 
 * @author Joao Guedes
 * Data: 21/08/2019
 *
 */

@Entity(name="VACINA")
public class VacinaModel {
	
	@Id
	@SequenceGenerator(name = "SEQ_VAR_VACINA", sequenceName = "SEQ_VAR_VACINA", allocationSize = 1)
	@GeneratedValue(generator = "SEQ_VAR_VACINA", strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "responsavel", nullable = false)
	private String responsavel;
	
	@Column(name = "lote", nullable = true)
	private Integer lote;
	
	@Column(name = "temperatura_registrada", nullable = true)
	private Integer temperaturaRegistrada;

//	@JsonFormat(pattern = "dd/MM/yyyy@HH:mm:ss.SSSZ")
	@Column(name = "data_aplicacao")
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date dataAplicacao;

	public VacinaModel() {
	}
	
	public VacinaModel(Integer id, String nome, String responsavel, Integer lote, Integer temperaturaRegistrada, Date dataAplicacao) {
		this.id = id;
		this.nome = nome;
		this.responsavel = responsavel;
		this.lote = lote;
		this.temperaturaRegistrada = temperaturaRegistrada;
		this.dataAplicacao = dataAplicacao;
	}
	
	public VacinaModel(VacinaDTO vacinaDTO) {
		this.id = vacinaDTO.getId();
		this.nome = vacinaDTO.getNome();
		this.dataAplicacao = new Date();
		this.lote = vacinaDTO.getLote();
		this.temperaturaRegistrada = vacinaDTO.getTemperaturaRegistrada();
		this.responsavel = vacinaDTO.getResponsavel();
	}

	public VacinaModel(CarimboDTO carimboDto) {
		this.id = carimboDto.getId();
		this.dataAplicacao = carimboDto.getDataAplicacao();
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
