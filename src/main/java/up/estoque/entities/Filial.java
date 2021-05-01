package up.estoque.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Filial {

	/*
	 * Attributes
	 */

	@Id
	@Column(length = 11)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@Column(length = 300)
	@NotBlank(message = "Preenchimento Obrigatório")
	private String nome;
	
	@JsonIgnore
	@OneToMany(mappedBy = "filial")
	private List<ProdutoFilial> produtosFilial;

	/*
	 * Getters and Setters
	 */

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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
