package up.estoque.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import up.estoque.requests.ProdutoRequest;

@Entity
public class Produto {

	/*
	 * Attributes
	 */

	@Id
	@Column(length = 11)
	private Long codigoInterno;

	@Column(length = 50)
	private String codigoExterno;

	@Column(length = 200)
	private String descricao;

	@Column(length = 100)
	private String nome;

	@Column(length = 11)
	private String unidade;

	@OneToOne
	private Categoria categoria;

	@OneToMany(mappedBy = "filial", cascade = CascadeType.ALL)
	private List<ProdutoFilial> produtosFilial;

	/*
	 * Constructors
	 */

	public Produto() {

	}

	public Produto(ProdutoRequest request) {
		this.codigoInterno = request.getCodigoInterno();
		this.codigoExterno = request.getCodigoExterno();
		this.descricao = request.getDescricao();
		this.nome = request.getNome();
		this.unidade = request.getUnidade();
	}

	/*
	 * Getters and Setters
	 */

	public Long getCodigoInterno() {
		return codigoInterno;
	}

	public void setCodigoInterno(Long codigoInterno) {
		this.codigoInterno = codigoInterno;
	}

	public String getCodigoExterno() {
		return codigoExterno;
	}

	public void setCodigoExterno(String codigoExterno) {
		this.codigoExterno = codigoExterno;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<ProdutoFilial> getProdutosFilial() {
		return produtosFilial;
	}

	public void setProdutosFilial(List<ProdutoFilial> produtosFilial) {
		this.produtosFilial = produtosFilial;
	}

}
