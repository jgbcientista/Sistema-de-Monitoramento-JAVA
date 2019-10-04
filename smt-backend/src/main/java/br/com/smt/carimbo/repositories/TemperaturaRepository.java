package br.com.smt.carimbo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.smt.carimbo.model.TemperaturaModel;

@Repository
public interface TemperaturaRepository extends JpaRepository<TemperaturaModel, Integer>{
	
}
