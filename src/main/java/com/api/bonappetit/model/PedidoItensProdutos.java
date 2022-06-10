package com.api.bonappetit.model;


	import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

	@Getter
	@Setter
	@Entity
	@ToString
	@NoArgsConstructor
	@Table(name = "tb_pedidoItensProdutos")
	public class PedidoItensProdutos extends AbstractEntity {
		private static final long serialVersionUID = 1L;
		

		@JsonBackReference
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="pedidosItens_id", nullable=true,insertable=true)
		private PedidosItens pedidosItens;
		
	

		@ManyToOne(fetch = FetchType.EAGER)
		private Produto produto;
		
		@JsonCreator
	    public PedidoItensProdutos(@JsonProperty("produto") long id) {
	        this.produto = new Produto();
	        this.produto.setId(id);
	    } 

}
