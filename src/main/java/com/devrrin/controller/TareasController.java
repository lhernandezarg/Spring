package com.devrrin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.devrrin.model.Tareas;
import com.devrrin.repo.ITareasRepository;
import com.devrrin.response.SuccessResponse;

@RestController
@RequestMapping("/api/v1/tareas")
public class TareasController {

	@Autowired
	private ITareasRepository repo;

	@PostMapping("/")
	public ResponseEntity<?> create(@RequestBody Tareas ob) {

		repo.saveAndFlush(ob);
		return new ResponseEntity<SuccessResponse>(new SuccessResponse("Crear Tarea.", "Tarea Creada con Exito.!"),
				HttpStatus.CREATED);

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Tareas ob) {

		Tareas base = repo.findById(id).orElse(null);

		if (base == null)
			return new ResponseEntity<SuccessResponse>(
					new SuccessResponse("Modificar Tarea.", "Está Tarea no Fue Encontrada para su Modificació.!"),
					HttpStatus.NOT_MODIFIED);

		base.setDescripcion(ob.getDescripcion());
		base.setEstado(ob.isEstado());

		repo.saveAndFlush(base);
		return new ResponseEntity<SuccessResponse>(
				new SuccessResponse("Modificar Tarea.", "Tarea Modificada con Exito.!"), HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<?> getALL() {
		return new ResponseEntity<List<Tareas>>(repo.findAll(), HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") int id) {
		return new ResponseEntity<Tareas>(repo.findById(id).orElse(new Tareas()), HttpStatus.OK);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		repo.deleteById(id);
		return new ResponseEntity<SuccessResponse>(
				new SuccessResponse("Eliminar Tarea.", "Tarea Eliminada con Exito.!"), HttpStatus.OK);

	}

}
