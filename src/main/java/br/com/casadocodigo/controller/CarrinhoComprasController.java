package br.com.casadocodigo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.dao.ProdutoDAO;
import br.com.casadocodigo.model.CarrinhoCompras;
import br.com.casadocodigo.model.CarrinhoItem;
import br.com.casadocodigo.model.Produto;
import br.com.casadocodigo.model.TipoPreco;

@Controller
@RequestMapping("/carrinho")
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class CarrinhoComprasController {
	
	@Autowired
	private ProdutoDAO ProdutoDAO;
	
	@Autowired
	private CarrinhoCompras carrinhoCompras;
	
	@RequestMapping("/add")
	public ModelAndView add (Integer produtoId,TipoPreco tipoPreco) {
		
		ModelAndView modelAndView = new ModelAndView("redirect:/carrinho");
		
		CarrinhoItem  carrinhoItem = criaItem(produtoId, tipoPreco);
		
		carrinhoCompras.add(carrinhoItem);
		
		return modelAndView;
	}
	
	private CarrinhoItem criaItem(Integer produtoId, TipoPreco tipoPreco){
		Produto produto = ProdutoDAO.findById(produtoId);
	    CarrinhoItem carrinhoItem = new CarrinhoItem(produto, tipoPreco);
	    return carrinhoItem;
	}

	@RequestMapping("/remover")
	public ModelAndView remover (Integer produtoId, TipoPreco tipoPreco){
		
		carrinhoCompras.remover(produtoId, tipoPreco);
	
		return new ModelAndView("redirect:/carrinho");
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView itens(){
	    return new ModelAndView("/carrinho/itens");
	}

}
