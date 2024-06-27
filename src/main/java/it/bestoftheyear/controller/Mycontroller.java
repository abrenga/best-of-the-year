package it.bestoftheyear.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.bestoftheyear.Movie;
import it.bestoftheyear.Songs;

import org.springframework.ui.Model;

@Controller
public class Mycontroller {
	@GetMapping("/")
	public String nome(@RequestParam(name="name") String nome, Model model) {
       model.addAttribute("name", nome); 
		return "greetings1";
	}

	private ArrayList<Movie> getBestMovies() {
		ArrayList <Movie> movies= new ArrayList<Movie>();
		Movie movie = new Movie( 1, "ma che ne so");
		Movie movim= new Movie( 2, "ma che so");
		movies.add(movie);
		movies.add(movim);
		return movies;
		
		
	
	}
	
	
	private ArrayList <Songs> getBestSongs() {
		ArrayList <Songs> songs= new ArrayList<Songs>();
		Songs song =new Songs(1,"canzoneblabla");
		songs.add(song);
		return songs;
		
	}
	
	
	@GetMapping("/movies")
	public String movies(Model model) {
		ArrayList<Movie> bestMovies=getBestMovies();
		model.addAttribute("bestMovies",bestMovies);
		return "greetings1";
		
		
	}
	
	@GetMapping("/songs")
	public String songs(Model model) {
		ArrayList<Songs>bestSongs=getBestSongs();
		model.addAttribute("bestSongs",bestSongs);
		return "songs";
	}
	

}
