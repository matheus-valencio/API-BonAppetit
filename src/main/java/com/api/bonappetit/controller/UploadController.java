package com.api.bonappetit.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.api.bonappetit.service.S3Service;

@RestController
@RequestMapping("/upload")
public class UploadController {
	@Autowired
	private S3Service service;

	@PostMapping("/s3")
	public ResponseEntity<Void> uploadFile(@RequestParam(name = "file") MultipartFile file) {
		URI uri = service.upload(file,file.getOriginalFilename());
		return ResponseEntity.created(uri).build();
	}
	@DeleteMapping("/{nomeArquivo}")
	public ResponseEntity<Void> deleteFile(@PathVariable("nomeArquivo") String nomeArquivo) {
		URI uri = service.delete(nomeArquivo);
		return ResponseEntity.created(uri).build();
	}
}

