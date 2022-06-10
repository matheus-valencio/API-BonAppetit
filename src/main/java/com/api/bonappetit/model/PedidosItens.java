package com.api.bonappetit.model;


	import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

	@Getter
	@Setter
	@Entity
	@ToString
	@NoArgsConstructor
	@Table(name = "tb_pedidosItens")
	public class PedidosItens extends AbstractEntity {
		private static final long serialVersionUID = 1L;
		

		@Column(name = "quantidade")
		private Integer quantidade;
		
		@Column(name = "ds_observacaoItem")
		private String observacaoItem;
		
		@JsonBackReference
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="pedidos_id", nullable=true,insertable=true)
		private Pedidos pedidos;

		@JsonManagedReference
		@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
		 private List<PedidoItensProdutos> pedidoItensProdutos;
		
				

}
