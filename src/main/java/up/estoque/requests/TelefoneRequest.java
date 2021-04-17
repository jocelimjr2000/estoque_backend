package up.estoque.requests;

import javax.validation.constraints.NotBlank;

public class TelefoneRequest {

	/*
	 * Attributes
	 */

	@NotBlank(message = "This field is required")
	private int ddd;

	@NotBlank(message = "This field is required")
	private String numero;

	@NotBlank(message = "This field is required")
	private String tipo;

	/*
	 * Getters and Setters
	 */

	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
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

}
