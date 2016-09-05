package br.com.casadocodigo.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(Exception.class)	
	public ModelAndView exececaoGenerica(Exception exception) {
		
		ModelAndView modelAndView = new ModelAndView("error");
		
		modelAndView.addObject("exception",exception);
		
		return modelAndView;
	}
	
}
