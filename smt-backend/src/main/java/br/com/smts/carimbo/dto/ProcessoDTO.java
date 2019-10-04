package br.com.smts.carimbo.dto;

import br.com.smt.carimbo.model.ProcessoModel;

/**
 * 
 * @author Joao Guedes
 * Data: 21/08/2019
 *
 */

public class ProcessoDTO {
	private String id;
	private String title;
	private String codigo;

	public ProcessoDTO() {
	}
	
	public ProcessoDTO(ProcessoModel processoModel) {
		this.id = processoModel.getId();
		this.title = processoModel.getTitle();
		this.codigo = processoModel.getCodigo();
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
		ProcessoDTO other = (ProcessoDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
