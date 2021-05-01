package up.estoque.requests;



import javax.validation.constraints.NotBlank;

public class FilialRequest {

	/*
	 * Attributes
	 */

	@NotBlank(message = "This field is required")
	private String nome;


	/*
	 * Getters and Setters
	 */

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


}
