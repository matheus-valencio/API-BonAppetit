package com.api.bonappetit.controller;

import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.api.bonappetit.dto.ProdutoDTO;

public interface ControllerInterface<T> {
	ResponseEntity<List<T>> getAll();
	ResponseEntity<?> get(Long id);
	ResponseEntity<T> post(T obj) throws URISyntaxException;
	ResponseEntity<?> put(T obj);
	ResponseEntity<?> delete(Long id);
	T findById(Long id);
	List<T> findAll();
	ResponseEntity<ProdutoDTO> post(ProdutoDTO obj, MultipartFile file) throws URISyntaxException;
}
