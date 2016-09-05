package br.com.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.model.Usuario;

/**
 * @author Ramon Vieira
 *
 */

@Controller
public class UsuarioController {
	
	@RequestMapping(value="/criarUsuario", method = RequestMethod.POST)
	public ModelAndView criaUsuario (@Valid Usuario usuario) {
	
		ModelAndView modelAndView = new ModelAndView("home");

		System.out.println(usuario.getEmail());
		System.out.println(usuario.getNome());
		System.out.println(usuario.getSenha());
		
//		usuarioDAO.gravar(usuario);
		
		return modelAndView;
		
	}

}
