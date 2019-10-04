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

import br.com.smt.carimbo.model.ProcessoModel;
import br.com.smt.carimbo.service.ProcessoService;
import br.com.smts.carimbo.dto.ProcessoDTO;

/**
 * 
 * @author Robson Mattos
 * Data: 25/07/2019
 *
 */

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(value = "/processos")
public class ProcessoResource {

	@Autowired
	private ProcessoService service;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<ProcessoDTO>> findAll() {
		List<ProcessoModel> list = service.findAll();
		List<ProcessoDTO> listDto = list.stream().map(obj -> new ProcessoDTO(obj)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<ProcessoDTO> find(@PathVariable String id) {
		
//		String codigoProcesso = id.substring(0, 4);
//		String anoProcesso = id.substring(4, 8);
		
//		codigoProcesso = codigoProcesso.concat(" / " + anoProcesso);
		
//		ProcessoModel processo = service.find(codigoProcesso);
		ProcessoModel processo = service.find(id);
		ProcessoDTO obj = service.fromModel(processo);
 		return ResponseEntity.ok().body(obj);
//		return null;
	}
	
//	@RequestMapping(value="/{id}", method=RequestMethod.GET)
//	public ResponseEntity<ProcessoDTO> find(@PathVariable String id) {
//		ProcessoModel processo = service.find(id);
//		ProcessoDTO obj = service.fromModel(processo);
// 		return ResponseEntity.ok().body(obj);
////		return null;
//	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ProcessoDTO processoDto) {
		ProcessoModel obj = service.fromDTO(processoDto);
		service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
