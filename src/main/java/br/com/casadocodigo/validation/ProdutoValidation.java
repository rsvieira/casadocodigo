package br.com.casadocodigo.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.casadocodigo.model.Produto;

/**
 * @author Ramon Vieira
 *
 */

public class ProdutoValidation implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Produto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		
		Produto produto = (Produto) object;

		ValidationUtils.rejectIfEmpty(errors, "titulo", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "descricao", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "dataLancamento", "field.required");
		
		if(produto.getPaginas() <= 0){
			errors.reject("paginas","field.required");
		}
		
	}

}
