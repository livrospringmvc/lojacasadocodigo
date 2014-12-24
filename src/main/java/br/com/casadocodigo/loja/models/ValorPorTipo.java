package br.com.casadocodigo.loja.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import br.com.casadocodigo.loja.controllers.TipoLivro;

@Embeddable
public class ValorPorTipo {

	@Column(scale = 2)
	//@NumberFormat(style=Style.CURRENCY)
	private BigDecimal valor;
	private TipoLivro tipoLivro;

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public TipoLivro getTipoLivro() {
		return tipoLivro;
	}

	public void setTipoLivro(TipoLivro tipoLivro) {
		this.tipoLivro = tipoLivro;
	}

}
