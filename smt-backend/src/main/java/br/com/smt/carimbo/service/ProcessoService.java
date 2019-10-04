package br.com.smt.carimbo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.smt.carimbo.model.ProcessoModel;
import br.com.smt.carimbo.repositories.ProcessoRepository;
import br.com.smt.carimbo.service.exeception.ObjectNotFoundException;
import br.com.smts.carimbo.dto.ProcessoDTO;

@Service
public class ProcessoService {

	@Autowired
	private ProcessoRepository repo;

	public ProcessoModel find(String id) {
		Optional<ProcessoModel> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Processo não encontrado! Id: " + id + ", Tipo: " + ProcessoModel.class.getName()));
	}
	
	public List<ProcessoModel> findAll() {
		return repo.findAll();
	}
	
	public ProcessoModel insert(ProcessoModel obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public ProcessoModel fromDTO(ProcessoDTO processoDto) {
		return new ProcessoModel(processoDto);
	}

	public ProcessoDTO fromModel(ProcessoModel processoModel) {
		return new ProcessoDTO(processoModel);
	}
	
	public List<ProcessoModel> findLike(String id) {
//		return repo.findAll().;
		return null;
	}
	
}
