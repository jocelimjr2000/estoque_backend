package up.estoque.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Nota {
	
	@Id
	@Column(length = 11)
	private Long id;
	
	@Column(length = 40)
	private Long numero;
	
	@Column(length = 10)
	private String tipo;
	
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@OneToMany
	@JoinColumn(name="nota_id")
	private List<ProdutoQtd> produtoQtd;
	
	public Nota() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
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

	public List<ProdutoQtd> getProdutoQtd() {
		return produtoQtd;
	}

	public void setProdutoQtd(List<ProdutoQtd> produtoQtd) {
		this.produtoQtd = produtoQtd;
	}
	
	
}
