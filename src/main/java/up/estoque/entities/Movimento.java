package up.estoque.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Movimento {

	/*
	 * Attributes
	 */
	
	@Id
	@Column(length = 11)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "nota_id")
	private Nota nota;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "produtoFilial_id")
	private ProdutoFilial produtoFilial;

	private Double qtdMovimentada;

	private Double precoUnitario;

	/*
	 * Constructors
	 */

	public Movimento() {

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

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}

	public ProdutoFilial getProdutoFilial() {
		return produtoFilial;
	}

	public void setProdutoFilial(ProdutoFilial produtoFilial) {
		this.produtoFilial = produtoFilial;
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
