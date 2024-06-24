package it.bestoftheyear.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ui.Model;

@Controller
public class Mycontroller {
	@GetMapping("/")
	public String nome(@RequestParam(name="name") String nome, Model model) {
       model.addAttribute("name", nome); 
		return "greetings1";
	}
	

}
