package br.com.smt.carimbo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.smt.carimbo.model.UsuarioModel;
import br.com.smt.carimbo.repositories.UsuarioRepository;
import br.com.smt.carimbo.service.exeception.ObjectNotFoundException;
import br.com.smts.carimbo.dto.UsuarioDTO;

/**
 * 
 * @author Joao Guedes
 * Data: 21/08/2019
 *
 */

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repo;

	public UsuarioModel find(Integer id) {
		Optional<UsuarioModel> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + UsuarioModel.class.getName()));
	}
	
	public List<UsuarioModel> findAll() {
		return repo.findAll();
	}
	
	public UsuarioModel insert(UsuarioModel obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public UsuarioModel alterar(UsuarioModel obj) {
		return repo.save(obj);
	}
	
	public void deletar(UsuarioModel obj) {
		repo.delete(obj);
	}
	
	public UsuarioModel fromDTO(UsuarioDTO dto) {
		return new UsuarioModel(dto);
	}

	public List<UsuarioModel> findLike(String id) {
//		return repo.findAll().;
		return null;
	}
	
}
