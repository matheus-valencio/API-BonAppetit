package com.api.bonappetit.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.bonappetit.dto.CategoriaDTO;
import com.api.bonappetit.dto.CategoriaDTO;
import com.api.bonappetit.dto.ProdutoDTO;
import com.api.bonappetit.service.CategoriaService;
import com.api.bonappetit.service.CategoriaService;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/categoria")
public class CategoriaController implements ControllerInterface<CategoriaDTO> {

	@Autowired
	private CategoriaService service;

	@Override
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<CategoriaDTO>> getAll() {
		return ResponseEntity.ok(service.findAll());
	}


	@Override
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<?> get(@PathVariable("id") Long id) {
		CategoriaDTO obj = service.findById(id);
		if (obj != null) {
			return ResponseEntity.ok(obj);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@Override
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping(produces = "application/json")
	public ResponseEntity<CategoriaDTO> post(@Valid @RequestBody CategoriaDTO obj) throws URISyntaxException {
		CategoriaDTO dto = service.create(obj);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId())
				.toUri();
		return ResponseEntity.created(location).body(dto);
	}

	@Override
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PutMapping(produces = "application/json")
	public ResponseEntity<?> put(@Valid @RequestBody CategoriaDTO obj) {
		if (service.update(obj)) {
			return ResponseEntity.ok(obj);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@Override
	@PreAuthorize("hasAnyRole('ADMIN')")
	@DeleteMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		if (service.delete(id)) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@Override
	public CategoriaDTO findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoriaDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ProdutoDTO> post(@Valid ProdutoDTO obj, MultipartFile file) throws URISyntaxException {
		// TODO Auto-generated method stub
		return null;
	}

}
