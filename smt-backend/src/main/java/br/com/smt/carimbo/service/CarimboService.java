package br.com.smt.carimbo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.smt.carimbo.model.CarimboModel;
import br.com.smt.carimbo.repositories.CarimboRepository;
import br.com.smt.carimbo.service.exeception.ObjectNotFoundException;
import br.com.smts.carimbo.dto.CarimboDTO;

@Service
public class CarimboService {

	@Autowired
	private CarimboRepository repo;

	public CarimboModel find(Integer id) {
		Optional<CarimboModel> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + CarimboModel.class.getName()));
	}
	
	public List<CarimboModel> findAll() {
		return repo.findAll();
	}
	
	public CarimboModel insert(CarimboModel obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public CarimboModel fromDTO(CarimboDTO carimboDto) {
		return new CarimboModel(carimboDto);
	}

	public List<CarimboModel> findLike(String id) {
//		return repo.findAll().;
		return null;
	}
	
}
