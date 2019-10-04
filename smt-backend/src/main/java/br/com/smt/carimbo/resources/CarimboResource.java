package br.com.smt.carimbo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.smt.carimbo.model.CarimboModel;
import br.com.smt.carimbo.service.CarimboService;
import br.com.smts.carimbo.dto.CarimboDTO;

/**
 * 
 * @author Joao Guedes
 * Data: 21/08/2019
 *
 */

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(value = "/carimbos")
public class CarimboResource {

	@Autowired
	private CarimboService service;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<CarimboDTO>> findAll() {
		List<CarimboModel> list = service.findAll();
		List<CarimboDTO> listDto = list.stream().map(obj -> new CarimboDTO(obj)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);
	}

//	@RequestMapping(value="/{id}", method=RequestMethod.GET)
//	public ResponseEntity<List<CarimboDTO>> find(@PathVariable String id) {
//		CarimboModel obj = service.find(id);
////		return ResponseEntity.ok().body(obj);
//		return null;
//	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody CarimboDTO carimboDto) {
		CarimboModel obj = service.fromDTO(carimboDto);
		service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
