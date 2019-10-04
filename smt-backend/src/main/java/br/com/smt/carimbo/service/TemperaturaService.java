package br.com.smt.carimbo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.smt.carimbo.model.TemperaturaModel;
import br.com.smt.carimbo.repositories.TemperaturaRepository;
import br.com.smt.carimbo.service.exeception.ObjectNotFoundException;
import br.com.smts.carimbo.dto.TemperaturaDTO;

/**
 * 
 * @author Joao Guedes
 * Data: 21/08/2019
 *
 */

@Service
public class TemperaturaService {

	@Autowired
	private TemperaturaRepository repo;


	public TemperaturaModel find(Integer id) {
		Optional<TemperaturaModel> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + TemperaturaModel.class.getName()));
	}
	
	public List<TemperaturaModel> findAll() {
		return repo.findAll();
	}
	
	public TemperaturaModel insert(TemperaturaModel obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public TemperaturaModel alterar(TemperaturaModel obj) {
		return repo.save(obj);
	}
	
	public void deletar(TemperaturaModel obj) {
		repo.delete(obj);
	}
	
	public TemperaturaModel fromDTO(TemperaturaDTO carimboDto) {
		return new TemperaturaModel(carimboDto);
	}

	public List<TemperaturaModel> findLike(String id) {
		return null;
	}
	
}
