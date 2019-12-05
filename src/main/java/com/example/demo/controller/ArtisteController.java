package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Artiste;
import com.example.demo.repository.ArtisteRepository;


@RestController
public class ArtisteController {
	
	@Autowired
	ArtisteRepository artisteRepository;
	
	@GetMapping("/artistes")
	public List<Artiste> getAllArtistes() {
		return artisteRepository.findAll();
	}
	
	@GetMapping("/artiste/{id}")
	public Artiste getArtisteById(@PathVariable Integer id) {
		return artisteRepository.findById(id).get();
	}
	
	@PostMapping("/artiste")
	public Artiste createArtiste(@RequestBody Artiste artiste) {
		return artisteRepository.save(artiste);
	}
	
	@DeleteMapping("/artiste/{id}")
	public void deleteArtiste(@PathVariable Integer id) {
		artisteRepository.deleteById(id);
	}

}
