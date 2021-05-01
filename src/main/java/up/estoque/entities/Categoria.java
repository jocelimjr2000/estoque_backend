package up.estoque.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Categoria {

	/*
	 * Attributes
	 */

	@Id
	@Column(length = 1)
	@NotNull(message = "Preenchimento Obrigatório")
	@Size(min = 1, max = 1, message = "Permitido somente 1 caractere")
	private String codigo;

	@Column(length = 10)
	@NotNull(message = "Preenchimento Obrigatório")
	private String tipo;

	/*
	 * Constructors
	 */

	public Categoria() {
	}

	/*
	 * Getters and Setters
	 */

	public String getCodigo() {
		return codigo.toUpperCase();
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
