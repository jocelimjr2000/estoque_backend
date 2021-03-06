package up.estoque.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Movimento {

	/*
	 * Attributes
	 */
	
	@Id
	@Column(length = 11)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "nota_codigo")
	private Nota nota;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "produtoFilial_codigo")
	private ProdutoFilial produtoFilial;

	@NotNull(message = "Preenchimento Obrigatório")
	private Double qtdMovimentada;

	@NotNull(message = "Preenchimento Obrigatório")
	private Double precoUnitario;

	/*
	 * Getters and Setters
	 */

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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
