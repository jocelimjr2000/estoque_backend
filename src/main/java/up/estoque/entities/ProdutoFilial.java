package up.estoque.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = {
		@UniqueConstraint(columnNames = { "filial_id", "produto_codigoInterno" }) })
public class ProdutoFilial {

	@Id
	@Column(length = 11)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Double qtd;

	private Double custoMedio;
	
	private Double precoDeLista;

	@ManyToOne
	private Filial filial;

	@ManyToOne
	private Produto produto;

	public ProdutoFilial() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getQtd() {
		return qtd;
	}

	public void setQtd(Double qtd) {
		this.qtd = qtd;
	}

	public Double getCustoMedio() {
		return custoMedio;
	}

	public void setCustoMedio(Double custoMedio) {
		this.custoMedio = custoMedio;
	}

	public Filial getFilial() {
		return filial;
	}

	public void setFilial(Filial filial) {
		this.filial = filial;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public Double getPrecoDeLista() {
		return precoDeLista;
	}

	public void setPrecoDeLista(Double precoDeLista) {
		this.precoDeLista = precoDeLista;
	}

}
