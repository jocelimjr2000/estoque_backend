package up.estoque.requests;



import javax.validation.constraints.NotBlank;

public class FilialRequest {

	/*
	 * Attributes
	 */

	@NotBlank(message = "This field is required")
	private String nome;

	@NotBlank(message = "This field is required")
	private String rua;

	@NotBlank(message = "This field is required")
	private String numero;

	@NotBlank(message = "This field is required")
	private String complemento;

	@NotBlank(message = "This field is required")
	private String cep;

	@NotBlank(message = "This field is required")
	private String bairro;

	@NotBlank(message = "This field is required")
	private String cidade;

	@NotBlank(message = "This field is required")
	private String uf;


	/*
	 * Getters and Setters
	 */

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
