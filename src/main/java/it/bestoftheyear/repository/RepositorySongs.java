package it.bestoftheyear.repository;


import it.bestoftheyear.model.TableSongs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorySongs extends JpaRepository<TableSongs, Integer> {

}
