package com.api.bonappetit.model;


	import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
	@Table(name = "tb_pedidos")
	public class Pedidos extends AbstractEntity {
		private static final long serialVersionUID = 1L;
		

		@Temporal(TemporalType.TIMESTAMP)
		@Column(name = "dt_data")
		private Calendar dataPedido;

		@Column(name = "ds_enderecoPedido")
		private String enderecoPedido;

		
		@Column(name = "ds_observacaoPedido")
		private String observacaoPedido;
		
		@JsonManagedReference
		@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pedidos")
		 private List<PedidosItens> pedidosItens;
		
		
	//	@JsonBackReference
	//	@ManyToOne(fetch = FetchType.LAZY)
	//	@JoinColumn(name="conta_id", nullable=true,insertable=true)
	//	private Conta conta;
		@Getter(onMethod = @__(@JsonIgnore))
		@Setter(onMethod = @__(@JsonProperty))
		@ManyToOne(fetch = FetchType.LAZY)
		private Conta conta;

			@JsonCreator
			public Pedidos(@JsonProperty("conta") long id) {
	        this.conta = new Conta();
	        this.conta.setId(id);
			} 
		
		
		
}
