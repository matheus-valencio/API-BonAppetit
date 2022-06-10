package com.api.bonappetit.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "tb_contas")
public class Conta extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "nm_nome")
	private String nome;
	
	@Column(name = "nm_email")
	private String email;
	
	@Column(name = "ds_endereco")
	private String endereco;
	
	@Column(name = "nm_login", length = 80, unique = true)
	private String login;
	
	@Column(name = "nm_senha")
	@Getter(onMethod = @__(@JsonIgnore))
	@Setter(onMethod = @__(@JsonProperty))
	private String senha;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "tb_perfil")
	private Set<Integer> perfis = new HashSet<>();

	public Set<TipoPerfil> getPerfis() {
		return perfis.stream().map(x -> TipoPerfil.toEnum(x)).collect(Collectors.toSet());
	}
	
	public Set<Integer> getPerfisAsInteger() {
		return perfis;
	}
	public void addPerfil(TipoPerfil perfil) {
		this.perfis.add(perfil.getCod());
	}
	


	
}
