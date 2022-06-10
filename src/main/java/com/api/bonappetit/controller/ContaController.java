package com.api.bonappetit.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.bonappetit.dto.ContaDTO;
import com.api.bonappetit.dto.ProdutoDTO;
import com.api.bonappetit.exception.AuthorizationException;
import com.api.bonappetit.service.ContaService;

@RestController
@RequestMapping("/conta")
public class ContaController implements ControllerInterface<ContaDTO> {

	@Autowired
	private ContaService service;

	@Override
	@GetMapping
	public ResponseEntity<List<ContaDTO>> getAll() {
		return ResponseEntity.ok(service.findAll());
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<?> get(@PathVariable("id") Long id) {
		try {
			ContaDTO obj = service.findById(id);
			if (obj != null) {
				return ResponseEntity.ok(obj);
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} catch (AuthorizationException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}

	@Override
	@PostMapping
	public ResponseEntity<ContaDTO> post(@Valid @RequestBody ContaDTO obj) throws URISyntaxException {
		ContaDTO dto = service.create(obj);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId())
				.toUri();
		return ResponseEntity.created(location).body(dto);
	}

	@Override
	@PutMapping
	public ResponseEntity<?> put(@Valid @RequestBody ContaDTO obj) {
		if (service.update(obj)) {
			return ResponseEntity.ok(obj);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		if (service.delete(id)) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@Override
	public ContaDTO findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContaDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ProdutoDTO> post(@Valid ProdutoDTO obj, MultipartFile file) throws URISyntaxException {
		// TODO Auto-generated method stub
		return null;
	}

}
