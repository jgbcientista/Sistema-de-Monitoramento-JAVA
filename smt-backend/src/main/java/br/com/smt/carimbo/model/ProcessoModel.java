package br.com.smt.carimbo.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.smts.carimbo.dto.ProcessoDTO;

/**
 * 
 * @author Robson Mattos
 * Data 02/08/2019
 *
 */

@Entity
@Table(name = "vw_processo")
public class ProcessoModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "codigo_processo")
	private String codigo;
	
	@Column(name = "iddocument")
	private String id;
	
	@Column(name = "nmtitle")
	private String title;
	
	public ProcessoModel() {
	}
	
	public ProcessoModel(ProcessoDTO processoDto) {
		this.id = processoDto.getId();
		this.title = processoDto.getTitle();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		ProcessoModel other = (ProcessoModel) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
