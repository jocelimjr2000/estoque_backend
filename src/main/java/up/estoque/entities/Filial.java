package up.estoque.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Filial {
	
	@Id
	@Column(length = 11)
	private Long id;
	
	@Column(length = 300)
	private String nome;
	
	@OneToOne
	@JoinColumn(referencedColumnName = "id")
	private Endereco endereco;
	
	@OneToMany
	@JoinColumn(name="filial_id")
	private List<Telefone> telefones;
	
	@OneToMany
	@JoinColumn(name="filial_id")
	private List<Produto> produtos;
	
	public Filial() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
}
