package it.bestoftheyear.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import it.bestoftheyear.Movie;
import it.bestoftheyear.model.MovieTable;
import it.bestoftheyear.repository.DatabaseMyRepository;

import org.springframework.ui.Model;

@Controller
public class Mycontroller {
	@GetMapping("/")
	public String nome() {
		return "greetings1";
	}

	private ArrayList<Movie> getBestMovies() {
		ArrayList<Movie> movies = new ArrayList<Movie>();
		int id = 1;
		Movie movie1 = new Movie(id++, "tre uomini e una gamba");
		Movie movie2 = new Movie(id++, "chiedimi se sono felice");
		Movie movie3 = new Movie(id++, "La legenda di Ald Jhonny e jack");
		movies.add(movie1);
		movies.add(movie2);
		movies.add(movie3);
		return movies;
	}

	@GetMapping("/movies")
	public String movies(Model model) {
		ArrayList<Movie> bestMovies = getBestMovies();
		model.addAttribute("bestMovies", bestMovies);
		return "movies";
	}

	@GetMapping("/movies/{id}")
	public String singleMovie(@PathVariable(name = "id") int id, Model model) {
		ArrayList<Movie> bestMovies = getBestMovies();
		for (int i = 0; i < bestMovies.size(); i++) {
			if (bestMovies.get(i).getId() == id) {
				
				model.addAttribute("movie",bestMovies.get(i));
			}
		}

		return "singleMovie";
	}
	
	
	
	/*Database*/
	
	@Autowired
	private DatabaseMyRepository repository;
	
	@GetMapping("/table/{title}")
	public String tableIndex(@PathVariable(name="title") String nome, Model model) {
		insertIntoTable(nome);
		
		List<MovieTable> movie = repository.findAll();
		model.addAttribute("movies", movie);
		return "table/table";
	}
	
	public void insertIntoTable(String nome) {
		MovieTable movie = new MovieTable();
		movie.setTitle(nome);
		
		repository.save(movie);
	}
	
	
	
	

}
