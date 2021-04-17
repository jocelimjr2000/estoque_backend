package up.estoque.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import up.estoque.requests.NotaRequest;

@Entity
public class Nota {

	/*
	 * Attributes
	 */

	@Id
	@Column(length = 11)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 40)
	private String numero;

	@Column(length = 1)
	private String tipo;

	@Temporal(TemporalType.DATE)
	private Date data;

	@OneToMany
	@JoinColumn(name = "nota_id")
	private List<Movimento> produtoQtd;

	/*
	 * Constructors
	 */

	public Nota() {

	}

	public Nota(NotaRequest request) {
		this.numero = request.getNumero();
		this.tipo = request.getTipo();
		this.data = request.getData();
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<Movimento> getProdutoQtd() {
		return produtoQtd;
	}

	public void setProdutoQtd(List<Movimento> produtoQtd) {
		this.produtoQtd = produtoQtd;
	}

}
