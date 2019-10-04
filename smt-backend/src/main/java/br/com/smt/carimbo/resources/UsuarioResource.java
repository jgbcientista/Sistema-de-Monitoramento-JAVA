package br.com.smt.carimbo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.smt.carimbo.model.UsuarioModel;
import br.com.smt.carimbo.service.UsuarioService;
import br.com.smts.carimbo.dto.UsuarioDTO;

/**
 * 
 * @author Joao Guedes
 * Data: 21/08/2019
 *
 */

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioService service;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<UsuarioDTO>> findAll() {
		List<UsuarioModel> list = service.findAll();
		List<UsuarioDTO> listDto = list.stream().map(obj -> new UsuarioDTO(obj)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<UsuarioDTO> findId(@PathVariable("id") Integer id) {
		UsuarioModel categoria = service.find(id);
		UsuarioDTO categoriaDto = new UsuarioDTO(categoria);  
		return ResponseEntity.ok().body(categoriaDto);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<List<UsuarioDTO>> deletar(@PathVariable("id") Integer id) {
		UsuarioModel categoriaDeletar = service.find(id);
		service.deletar(categoriaDeletar);
		return findAll();
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> alterar(@Valid @RequestBody UsuarioDTO vacinaDTO) {
		UsuarioModel obj = service.fromDTO(vacinaDTO);
		service.alterar(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody UsuarioDTO vacinaDTO) {
		UsuarioModel obj = service.fromDTO(vacinaDTO);
		service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
