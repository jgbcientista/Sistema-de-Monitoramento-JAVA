package br.com.smt.carimbo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.smt.carimbo.model.CategoriaModel;
import br.com.smt.carimbo.repositories.CategoriaRepository;
import br.com.smt.carimbo.service.exeception.ObjectNotFoundException;
import br.com.smts.carimbo.dto.CategoriaDTO;

/**
 * 
 * @author Joao Guedes
 * Data: 21/08/2019
 *
 */

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public CategoriaModel find(Integer id) {
		Optional<CategoriaModel> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + CategoriaModel.class.getName()));
	}
	
	public List<CategoriaModel> findAll() {
		return repo.findAll();
	}
	
	public CategoriaModel insert(CategoriaModel obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public CategoriaModel alterar(CategoriaModel obj) {
		return repo.save(obj);
	}
	
	public void deletar(CategoriaModel obj) {
		repo.delete(obj);
	}
	
	public CategoriaModel fromDTO(CategoriaDTO carimboDto) {
		return new CategoriaModel(carimboDto);
	}

	public List<CategoriaModel> findLike(String id) {
//		return repo.findAll().;
		return null;
	}
	
}
