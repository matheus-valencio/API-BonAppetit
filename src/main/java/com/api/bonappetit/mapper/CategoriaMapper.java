package com.api.bonappetit.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.api.bonappetit.dto.CategoriaDTO;
import com.api.bonappetit.model.Categoria;

import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class CategoriaMapper {

	public Categoria toEntity(CategoriaDTO obj) {
		Categoria categoria = new Categoria();
		categoria.setId(obj.getId());
		categoria.setNome(obj.getNome());
		return categoria;
	}
	
	public CategoriaDTO toDTO(Categoria obj) {
		CategoriaDTO categoriaDTO = new CategoriaDTO();
		categoriaDTO.setId(obj.getId());
		categoriaDTO.setNome(obj.getNome());
		return categoriaDTO;
	}
	
	public List<Categoria> toEntity(List<CategoriaDTO> list) {
		List<Categoria> lista = new ArrayList<>();
		for (CategoriaDTO m : list) {
			lista.add(toEntity(m));
		}
		return lista;
	}

	public List<CategoriaDTO> toDTO(List<Categoria> list) {
		List<CategoriaDTO> lista = new ArrayList<>();
		for (Categoria m : list) {
			lista.add(toDTO(m));
		}
		return lista;
	}

}
