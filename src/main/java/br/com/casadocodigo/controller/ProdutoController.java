package br.com.casadocodigo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.dao.ProdutoDAO;
import br.com.casadocodigo.infra.FileSaver;
import br.com.casadocodigo.model.Preco;
import br.com.casadocodigo.model.Produto;
import br.com.casadocodigo.model.TipoPreco;
import br.com.casadocodigo.validation.ProdutoValidation;

/**
 * @author Ramon Vieira
 *
 */

@Controller
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoDAO produtoDao;
	
	@Autowired
	private FileSaver fileSaver;
	
	@InitBinder
	public void initBinder (WebDataBinder webDataBinder) {
		webDataBinder.addValidators(new ProdutoValidation());
	}
	
	@RequestMapping(value="/form")
	public ModelAndView form(Produto produto){
		
		ModelAndView modelAndView = new ModelAndView("produto/form");
		
		modelAndView.addObject("listPrecos", TipoPreco.values());
		
		return modelAndView;
	}
	
	@RequestMapping(value="/cadastrar",method=RequestMethod.POST)
	@CacheEvict(value="home", allEntries=true)
	public ModelAndView cadastrar(MultipartFile sumario ,@Valid Produto produto, BindingResult bindingResult ,RedirectAttributes redirectAttributes){
		
		if(bindingResult.hasErrors()){
			return form(produto);
		}
		
//		produto.setSumarioPath(fileSaver.write("arquivos-sumario", sumario));
//
//		System.out.println("# -- Inicio path arquivo -- #");
//		System.out.println(sumario.getOriginalFilename());
//		System.out.println("----");
//		System.out.println(produto.toString());
//		System.out.println("# -- FIM -- #");
		
		produto.setSumarioPath("/");
		
		produtoDao.gravar(produto);

		redirectAttributes.addFlashAttribute("message", "Produto cadastrado com sucesso!");
		
		return new ModelAndView("redirect:list");
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	@Cacheable(value="produtoListar")
	public ModelAndView listar () {
		ModelAndView modelAndView = new ModelAndView("produto/list");
		
		List<Produto> listProdutos = produtoDao.getList();
		
		modelAndView.addObject("listaProdutos", listProdutos);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/detalhe/{id}",method=RequestMethod.GET)
	@Cacheable(value="produtoDetalhar")
	public ModelAndView detalhar (@PathVariable int id) {
		ModelAndView modelAndView = new ModelAndView("produto/detalhe");
		
		Produto produto = produtoDao.findById(id);
		
		List<Preco> precos = produto.getPrecos();
		
		modelAndView.addObject("produto", produto);
		modelAndView.addObject("listPrecos", precos);
		
		return modelAndView;
	}

}
