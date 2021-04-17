package up.estoque.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import up.estoque.annotations.CheckExistsProduto;

public class ProdutoRequest {
	
	@NotNull(message = "This field is required")
	@CheckExistsProduto(inverse = true, message = "Product exists")
	private Long codigoInterno;
	
	@NotBlank(message = "This field is required")
	private String codigoExterno;
	
	@NotBlank(message = "This field is required")
	private String descricao;
	
	@NotBlank(message = "This field is required")
	private String nome;
	
	@NotBlank(message = "This field is required")
	private String unidade;
	
	@NotBlank(message = "This field is required")
	@Pattern(regexp = "[pPmMfF]+", message = "Invalid category")
	private String categoria;

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

	public String getCategoria() {
		return categoria.toUpperCase();
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

}
