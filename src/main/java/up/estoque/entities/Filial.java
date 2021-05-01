package up.estoque.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import up.estoque.requests.FilialRequest;

@Entity
public class Filial {

	/*
	 * Attributes
	 */

	@Id
	@Column(length = 11)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 300)
	private String nome;
	
	@OneToMany(mappedBy = "filial", cascade = CascadeType.ALL)
	  private List<ProdutoFilial> produtosFilial;

	/*
	 * Constructors
	 */

	public Filial() {

	}

	public Filial(FilialRequest request) {
		this.nome = request.getNome();
	}

	/*
	 * Getters and Setters
	 */

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
	public List<ProdutoFilial> getProdutosFilial() {
		return produtosFilial;
	}

	public void setProdutosFilial(List<ProdutoFilial> produtosFilial) {
		this.produtosFilial = produtosFilial;
	}


}
