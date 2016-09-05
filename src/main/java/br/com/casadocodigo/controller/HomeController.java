package br.com.casadocodigo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.dao.ProdutoDAO;
import br.com.casadocodigo.model.Produto;

/**
 * @author Ramon Vieira
 *
 */

@Controller
public class HomeController {
	
	@Autowired
	private ProdutoDAO produtoDAO; 
	
	@RequestMapping("/")
	@Cacheable(value="home")
	public ModelAndView index(){
		
		ModelAndView modelAndView = new ModelAndView("home");
		
		List<Produto> listProdutos = produtoDAO.getList();
		
		modelAndView.addObject("listProdutos", listProdutos);
		
		return modelAndView;
	}
	

}
