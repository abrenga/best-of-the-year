package it.bestoftheyear.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import it.bestoftheyear.model.Table;


public interface DatabaseMyRepository extends JpaRepository<Table, Integer>{
	
}