package com.api.bonappetit.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@Table(name = "tb_categorias")
public class Categoria extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "nm_categoriaProduto")
	private String nome;

	
}
