package br.com.casadocodigo.model;

import java.math.BigDecimal;

import javax.persistence.Embeddable;

/**
 * @author Ramon Vieira
 *
 */

@Embeddable
public class Preco {
	
	private BigDecimal valor;
	private TipoPreco tipoPreco;

	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public TipoPreco getTipoPreco() {
		return tipoPreco;
	}
	public void setTipoPreco(TipoPreco tipoPreco) {
		this.tipoPreco = tipoPreco;
	}

}
