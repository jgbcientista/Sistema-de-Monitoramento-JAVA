package br.com.smt.carimbo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.smt.carimbo.model.VacinaModel;
import br.com.smt.carimbo.repositories.VacinaRepository;
import br.com.smt.carimbo.service.exeception.ObjectNotFoundException;
import br.com.smts.carimbo.dto.VacinaDTO;

/**
 * 
 * @author Joao Guedes
 * Data: 21/08/2019
 *
 */

@Service
public class VacinaService {

	@Autowired
	private VacinaRepository repo;


	public VacinaModel find(Integer id) {
		Optional<VacinaModel> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + VacinaModel.class.getName()));
	}
	
	public List<VacinaModel> findAll() {
		return repo.findAll();
	}
	
	public VacinaModel insert(VacinaModel obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public VacinaModel alterar(VacinaModel obj) {
		return repo.save(obj);
	}
	
	public void deletar(VacinaModel obj) {
		repo.delete(obj);
	}
	
	public VacinaModel fromDTO(VacinaDTO carimboDto) {
		return new VacinaModel(carimboDto);
	}

	public List<VacinaModel> findLike(String id) {
 		return repo.findAll();
	}
	
}
