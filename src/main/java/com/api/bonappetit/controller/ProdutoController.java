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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.bonappetit.dto.ProdutoDTO;
import com.api.bonappetit.service.ProdutoService;
import com.api.bonappetit.service.S3Service;


@RestController
@RequestMapping("/produtos")
public class ProdutoController implements ControllerInterface<ProdutoDTO>{

	@Autowired
	private ProdutoService service;
	
	@Autowired
	private S3Service serviceS3;

	@Override
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<ProdutoDTO>> getAll() {	
		return ResponseEntity.ok(service.findAll());
	}
	
	
	@Override
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<?> get(@PathVariable("id") Long id) {
		ProdutoDTO obj = service.findById(id);
		if (obj != null) {
			return ResponseEntity.ok(obj);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@Override
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping(produces = "application/json", consumes = "multipart/form-data")
	public ResponseEntity<ProdutoDTO> post(@ModelAttribute ProdutoDTO obj,@RequestParam(name = "file") MultipartFile file) throws URISyntaxException {
		ProdutoDTO dto = service.create(obj);
		String nomeLink = dto.getProdutoImagem();
		String alvo = "https://bonappetit-bucket.s3.sa-east-1.amazonaws.com/";
		String substituto = "";
		String nomeSemLink = nomeLink.replace(alvo, substituto);

		serviceS3.upload(file, nomeSemLink);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId())
				.toUri();
		return ResponseEntity.created(location).body(dto);
	}

	@Override
	@PutMapping
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<?> put(@Valid @RequestBody ProdutoDTO obj) {
		if (service.update(obj)) {
			return ResponseEntity.ok(obj);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@Override
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		if (service.delete(id)) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@Override
	public ProdutoDTO findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProdutoDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ProdutoDTO> post(ProdutoDTO obj) throws URISyntaxException {
		// TODO Auto-generated method stub
		return null;
	}


}
