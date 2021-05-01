package up.estoque.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Produto {

	/*
	 * Attributes
	 */

	@Id
	@Column(length = 11)
	@NotNull(message = "Preenchimento Obrigatório")
	private Long codigoInterno;

	@Column(length = 50)
	@NotBlank(message = "Preenchimento Obrigatório")
	private String codigoExterno;

	@Column(length = 200)
	@NotBlank(message = "Preenchimento Obrigatório")
	private String descricao;

	@Column(length = 100)
	@NotBlank(message = "Preenchimento Obrigatório")
	private String nome;

	@Column(length = 11)
	@NotBlank(message = "Preenchimento Obrigatório")
	private String unidade;

	@OneToOne
	@NotNull(message = "Preenchimento Obrigatório")
	private Categoria categoria;

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

}
