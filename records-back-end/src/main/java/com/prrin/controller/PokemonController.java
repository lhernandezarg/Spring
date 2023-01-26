package com.prrin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prrin.controller.request.AdultEvolutionPokemon;
import com.prrin.controller.request.NormalPokemon;
import com.prrin.model.records.Pokemon;

@RestController
@RequestMapping("/api/v1/pokemon")
public class PokemonController {

	private List<Pokemon> pokemons = new ArrayList<>();

	@PostMapping("/")
	public ResponseEntity<?> addPokemon(@RequestBody Pokemon p) {
		pokemons.add(p);
		return new ResponseEntity<Integer>(201, HttpStatus.CREATED);
	}

	@PostMapping("/normal")
	public ResponseEntity<?> addNormalPokemon(@RequestBody NormalPokemon p) {
		Pokemon pokemon = new Pokemon(p.id(), p.name());
		pokemons.add(pokemon);
		return new ResponseEntity<Integer>(201, HttpStatus.CREATED);
	}

	@PostMapping("/adult")
	public ResponseEntity<?> addPokemonType(@RequestBody AdultEvolutionPokemon p) {
		Pokemon pokemon = new Pokemon(p.id(), p.name(), p.type());
		pokemons.add(pokemon);
		return new ResponseEntity<Integer>(201, HttpStatus.CREATED);
	}

	@GetMapping("/")
	public ResponseEntity<?> get() {
		return new ResponseEntity<List<Pokemon>>(pokemons, HttpStatus.OK);
	}
}