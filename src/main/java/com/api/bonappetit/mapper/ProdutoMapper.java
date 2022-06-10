package com.api.bonappetit.mapper;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.api.bonappetit.dto.ProdutoDTO;
import com.api.bonappetit.model.Produto;
import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class ProdutoMapper {

	public Produto toEntity(ProdutoDTO obj) {
		Produto produto = new Produto();
		produto.setId(obj.getId());
		produto.setValor(obj.getValor());
		produto.setNome(obj.getNome());
		produto.setDescricao(obj.getDescricao());
		produto.setProdutoImagem(getHashMd5( obj.getNome())+".jpg");
		produto.setCategoria(obj.getCategoria());
		return produto;
	}
	
	public ProdutoDTO toDTO(Produto obj) {
		ProdutoDTO produtoDTO = new ProdutoDTO();
		produtoDTO.setId(obj.getId());
		produtoDTO.setValor(obj.getValor());
		produtoDTO.setNome(obj.getNome());
		produtoDTO.setDescricao(obj.getDescricao());
		produtoDTO.setProdutoImagem("https://bonappetit-bucket.s3.sa-east-1.amazonaws.com/"+obj.getProdutoImagem());
		produtoDTO.setCategoria(obj.getCategoria());
		return produtoDTO;
	}
	
	public List<Produto> toEntity(List<ProdutoDTO> list) {
		List<Produto> lista = new ArrayList<>();
		for (ProdutoDTO m : list) {
			lista.add(toEntity(m));
		}
		return lista;
	}

	public List<ProdutoDTO> toDTO(List<Produto> list) {
		List<ProdutoDTO> lista = new ArrayList<>();
		for (Produto m : list) {
			lista.add(toDTO(m));
		}
		return lista;
	}
	public static String getHashMd5(String value) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        BigInteger hash = new BigInteger(1, md.digest(value.getBytes()));
        return hash.toString(16);
    }

}
