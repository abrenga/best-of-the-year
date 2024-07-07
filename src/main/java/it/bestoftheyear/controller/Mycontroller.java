package it.bestoftheyear.controller;

import java.util.ArrayList;
import java.util.List;

import it.bestoftheyear.Song;
import it.bestoftheyear.model.TableSongs;
import it.bestoftheyear.repository.RepositorySongs;
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

	/*Movies*/

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
	
	
	
	/*DatabaseMovies*/
	
	@Autowired
	private DatabaseMyRepository repository;
	
	@GetMapping("/tableFavoritMovies/{title}")
	public String tableIndex(@PathVariable(name="title") String nome, Model model) {
		insertMovieIntoTable(nome);
		
		List<MovieTable> movie = repository.findAll();
		model.addAttribute("movies", movie);
		return "table/tableFavoritMovies";
	}
	
	public void insertMovieIntoTable(String nome) {
		MovieTable movie = new MovieTable();
		movie.setTitle(nome);
		
		repository.save(movie);
	}
	public void insertSongIntoTable(String nome){
		TableSongs song = new TableSongs();
		song.setTitle(nome);
		songRepo.save(song);
	}
	
	/*musica*/

	private ArrayList<Song> getBestSongs(){
		ArrayList<Song> songs = new ArrayList<Song>();
		int id = 1;
		Song songs1= new Song(id++,"via del campo");
		Song songs2= new Song(id++,"volta la carta");
		Song songs3= new Song(id++,"il testamento di Tito");
		Song songs4= new Song(id++,"Don Faffaè");
		songs.add(songs1);
		songs.add(songs2);
		songs.add(songs3);
		songs.add(songs4);

		return songs;


	}

	private Song getSong(Integer id){
		ArrayList <Song> songs= getBestSongs();
		Song song=null;
		for (int i =0; i<songs.size(); i++){
			if(songs.get(i).getId()==id){
				song = songs.get(i);
			}
		}return song;
	}

	@GetMapping("/songs")
	public String musics(Model model){
		ArrayList songs = getBestSongs();
		model .addAttribute("songs",songs);
		return "songs";
	}


	@GetMapping("/singleSongs/{id}")
	public String singleSongs(@PathVariable(name="id") Integer id,Model model ){
		Song song= getSong(id);
		model.addAttribute("song",song);
		return "singleSongs";
	}

	@Autowired
	private RepositorySongs songRepo;

	@GetMapping("/tableFavoritSongs/{title}")
	public String tableIndexSongs(@PathVariable(name="title") String nome, Model model) {
		insertSongIntoTable(nome);
		List<TableSongs> songs =  songRepo.findAll();
		model.addAttribute("songs", songs);
		return "table/tableFavoritSongs";
	}


	

}
