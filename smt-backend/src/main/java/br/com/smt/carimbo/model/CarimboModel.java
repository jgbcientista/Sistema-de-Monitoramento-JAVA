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

/**
 * 
 * @author Robson Mattos
 * Data: 25/07/2019
 *
 */

@Entity(name="CARIMBO")
public class CarimboModel {
	
	@Id
	@SequenceGenerator(name = "SEQ_CAR_CATEGORIA", sequenceName = "SEQ_CAR_CATEGORIA", allocationSize = 1)
	@GeneratedValue(generator = "SEQ_CAR_CATEGORIA", strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name = "numero_processo", nullable = false)
	private String numeroProcesso;
	
	@Column(name = "pagina_inicial", nullable = false)
	private Integer paginaInicial;
	
	@Column(name = "pagina_final", nullable = false)
	private Integer paginaFinal;

	@Column(name = "string", nullable = false)
	private String string;
	
//	@JsonFormat(pattern = "dd/MM/yyyy@HH:mm:ss.SSSZ")
	@Column(name = "data_aplicacao")
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date dataAplicacao;

	public CarimboModel() {
	}

	public CarimboModel(CarimboDTO carimboDto) {
		this.id = carimboDto.getId();
		this.numeroProcesso = carimboDto.getNumeroProcesso();
		this.paginaInicial = carimboDto.getPaginaInicial();
		this.paginaFinal = carimboDto.getPaginaFinal();
		this.string = carimboDto.getString();
		this.dataAplicacao = carimboDto.getDataAplicacao();
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarimboModel other = (CarimboModel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
