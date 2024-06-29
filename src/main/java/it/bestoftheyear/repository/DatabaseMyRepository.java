package it.bestoftheyear.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.bestoftheyear.model.MovieTable;



public interface DatabaseMyRepository extends JpaRepository<MovieTable, Integer>{
	
	
	
}