package up.estoque.requests;

import javax.validation.constraints.NotNull;

import up.estoque.annotations.CheckExistsProduto;

public class NotaProdutoRequest {

	@NotNull(message = "This field is required")
	@CheckExistsProduto
	private Long codigoInterno;

	@NotNull(message = "This field is required")
	private Double qtd;

	public Long getCodigoInterno() {
		return codigoInterno;
	}

	public void setCodigoInterno(Long codigoInterno) {
		this.codigoInterno = codigoInterno;
	}

	public Double getQtd() {
		return qtd;
	}

	public void setQtd(Double qtd) {
		this.qtd = qtd;
	}

}
