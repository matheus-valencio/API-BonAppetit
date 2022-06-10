package com.api.bonappetit.dto;

import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.api.bonappetit.model.Pedidos;
import com.api.bonappetit.model.PedidosItens;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ContaDTO {
	
	private Long id;
	
	@NotBlank
	@Length(min = 3, max = 60)
	private String nome;
	
	private String login;
	
	@Length(max = 120)
	private String endereco;
	
	private String email;
		
	private Set<Integer> perfis;
	
	@Getter(onMethod = @__(@JsonIgnore))
	@Setter(onMethod = @__(@JsonProperty))
	private String senha;
	
	private List<Pedidos> pedidos;

}	
