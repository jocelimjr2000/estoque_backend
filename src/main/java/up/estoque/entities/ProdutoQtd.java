package up.estoque.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProdutoQtd {

	@Id
	@Column(length = 11)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "nota_id")
	private Nota nota;
	
	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;

	private Double qtdMovimentada;

	private Double precoUnitario;

	public ProdutoQtd() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Double getQtdMovimentada() {
		return qtdMovimentada;
	}

	public void setQtdMovimentada(Double qtdMovimentada) {
		this.qtdMovimentada = qtdMovimentada;
	}

	public Double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(Double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

}
