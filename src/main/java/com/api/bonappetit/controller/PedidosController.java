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

import com.api.bonappetit.dto.PedidosDTO;
import com.api.bonappetit.dto.ProdutoDTO;
import com.api.bonappetit.service.PedidosService;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/pedidos")
public class PedidosController implements ControllerInterface<PedidosDTO> {

	@Autowired
	private PedidosService service;

	@Override
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<PedidosDTO>> getAll() {
		return ResponseEntity.ok(service.findAll());
	}


	@Override
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<?> get(@PathVariable("id") Long id) {
		PedidosDTO obj = service.findById(id);
		if (obj != null) {
			return ResponseEntity.ok(obj);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@Override
	@PostMapping(produces = "application/json")
	public ResponseEntity<PedidosDTO> post(@Valid @RequestBody PedidosDTO obj) throws URISyntaxException {
		PedidosDTO dto = service.create(obj);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId())
				.toUri();
		return ResponseEntity.created(location).body(dto);
	}

	@Override
	@PutMapping(produces = "application/json")
	public ResponseEntity<?> put(@Valid @RequestBody PedidosDTO obj) {
		if (service.update(obj)) {
			return ResponseEntity.ok(obj);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@Override
	@DeleteMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		if (service.delete(id)) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@Override
	public PedidosDTO findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PedidosDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ProdutoDTO> post(@Valid ProdutoDTO obj, MultipartFile file) throws URISyntaxException {
		// TODO Auto-generated method stub
		return null;
	}

}
