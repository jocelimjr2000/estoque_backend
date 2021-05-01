package up.estoque.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Nota {

	/*
	 * Attributes
	 */

	@Id
	@Column(length = 11)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@Column(length = 40)
	@NotBlank(message = "This field is required")
	private String numero;

	@Column(length = 1)
	private String tipo;

	@Temporal(TemporalType.DATE)
	@NotNull(message = "This field is required")
	private Date data;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "nota_codigo")
	@NotNull(message = "This field is required")
	private List<Movimento> produtoQtd;

	/*
	 * Constructors
	 */

	public Nota() {

	}

	/*
	 * Getters and Setters
	 */

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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
