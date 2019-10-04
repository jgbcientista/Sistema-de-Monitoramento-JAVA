package br.com.smt.carimbo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.smt.carimbo.model.VacinaModel;

@Repository
public interface VacinaRepository extends JpaRepository<VacinaModel, Integer>{
	
}
