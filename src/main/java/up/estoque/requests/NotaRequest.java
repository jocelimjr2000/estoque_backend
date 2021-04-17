package up.estoque.requests;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class NotaRequest {
	
	@NotNull(message = "This field is required")
	private Date data;
	
	@NotBlank(message = "This field is required")
	private String numero;
	
	@NotBlank(message = "This field is required")
	@Pattern(regexp = "[eEsS]+", message = "Invalid type")
	private String tipo;

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo.toUpperCase();
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
