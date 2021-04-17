package up.estoque.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import up.estoque.requests.FilialRequest;

@Entity
public class Endereco {

	/*
	 * Attributes
	 */
	
	@Id
	@Column(length = 11)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 200)
	private String rua;

	@Column(length = 10)
	private String numero;

	@Column(length = 300)
	private String complemento;

	@Column(length = 7)
	private String cep;

	@Column(length = 50)
	private String bairro;

	@Column(length = 50)
	private String cidade;

	@Column(length = 2)
	private String uf;

	/*
	 * Constructors
	 */

	public Endereco() {

	}

	public Endereco(FilialRequest request) {
		this.bairro = request.getBairro();
		this.cep = request.getCep();
		this.cidade = request.getCidade();
		this.complemento = request.getComplemento();
		this.numero = request.getNumero();
		this.rua = request.getRua();
		this.uf = request.getUf();
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

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

}
