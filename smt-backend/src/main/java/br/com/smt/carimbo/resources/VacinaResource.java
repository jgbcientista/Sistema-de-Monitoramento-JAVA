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

import br.com.smt.carimbo.model.VacinaModel;
import br.com.smt.carimbo.service.VacinaService;
import br.com.smts.carimbo.dto.VacinaDTO;

/**
 * 
 * @author Joao Guedes
 * Data: 21/08/2019
 *
 */

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(value = "/vacinas")
public class VacinaResource {

	@Autowired
	private VacinaService service;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<VacinaDTO>> findAll() {
		List<VacinaModel> list = service.findAll();
		List<VacinaDTO> listDto = list.stream().map(obj -> new VacinaDTO(obj)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<VacinaDTO> findId(@PathVariable("id") Integer id) {
		VacinaModel vacina = service.find(id);
		VacinaDTO vacinaDto = new VacinaDTO(vacina);  
		return ResponseEntity.ok().body(vacinaDto);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<List<VacinaDTO>> deletar(@PathVariable("id") Integer id) {
		VacinaModel vacinaDeletar = service.find(id);
		service.deletar(vacinaDeletar);
		return findAll();
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> alterar(@Valid @RequestBody VacinaDTO vacinaDTO) {
		VacinaModel obj = service.fromDTO(vacinaDTO);
		service.alterar(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody VacinaDTO vacinaDTO) {
		VacinaModel obj = service.fromDTO(vacinaDTO);
		service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
