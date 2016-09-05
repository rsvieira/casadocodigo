package br.com.casadocodigo.model;

import java.math.BigDecimal;

/**
 * @author Ramon Vieira
 *
 */

public class DadosServico {
	
	private BigDecimal value;

	public DadosServico() {
	
	}
	
	public DadosServico(BigDecimal value) {
		this.value = value;
	}

	public BigDecimal getValue() {
		return value;
	}
	

}
