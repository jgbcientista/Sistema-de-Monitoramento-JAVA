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

import br.com.smt.carimbo.model.TemperaturaModel;
import br.com.smt.carimbo.service.TemperaturaService;
import br.com.smts.carimbo.dto.TemperaturaDTO;

/**
 * 
 * @author Joao Guedes
 * Data: 21/08/2019
 *
 */

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(value = "/temperaturas")
public class TemperaturaResource {

	@Autowired
	private TemperaturaService service;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<TemperaturaDTO>> findAll() {
		List<TemperaturaModel> list = service.findAll();
		List<TemperaturaDTO> listDto = list.stream().map(obj -> new TemperaturaDTO(obj)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<TemperaturaDTO> findId(@PathVariable("id") Integer id) {
		TemperaturaModel model = service.find(id);
		TemperaturaDTO vacinaDto = new TemperaturaDTO(model);  
		return ResponseEntity.ok().body(vacinaDto);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<List<TemperaturaDTO>> deletar(@PathVariable("id") Integer id) {
		TemperaturaModel vacinaDeletar = service.find(id);
		service.deletar(vacinaDeletar);
		return findAll();
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> alterar(@Valid @RequestBody TemperaturaDTO vacinaDTO) {
		TemperaturaModel obj = service.fromDTO(vacinaDTO);
		service.alterar(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody TemperaturaDTO vacinaDTO) {
		TemperaturaModel obj = service.fromDTO(vacinaDTO);
		service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
