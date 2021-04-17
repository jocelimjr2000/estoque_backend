package up.estoque.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Categoria {

	/*
	 * Attributes
	 */

	@Id
	@Column(length = 1)
	private String id;

	@Column(length = 10)
	private String tipo;

	/*
	 * Constructors
	 */

	public Categoria() {
	}

	/*
	 * Getters and Setters
	 */

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
