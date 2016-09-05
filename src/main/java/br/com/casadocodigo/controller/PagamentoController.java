package br.com.casadocodigo.controller;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.model.CarrinhoCompras;
import br.com.casadocodigo.model.DadosServico;
import br.com.casadocodigo.model.Usuario;

/**
 * @author Ramon Vieira
 *
 */

@Controller
@RequestMapping("/pagamento")
public class PagamentoController {
	
	@Autowired
	private CarrinhoCompras carrinho;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private MailSender sender;
	
	@RequestMapping(value="/finalizar", method=RequestMethod.POST)
	public Callable<ModelAndView> finalizar(@AuthenticationPrincipal Usuario usuario, RedirectAttributes model){
	    return () -> {

	    	String uri = "http://book-payment.herokuapp.com/payment";
	        
	    	try {
	        
	    		String response = restTemplate.postForObject(uri, new DadosServico(carrinho.getTotal()), String.class);
	            
    			enviaEmailCompra(usuario);
	            
	            model.addFlashAttribute("message", response);
	            System.out.println(response);
	            return new ModelAndView("redirect:/produto/list");
        	} catch (HttpClientErrorException e) {
	            e.printStackTrace();
	            model.addFlashAttribute("message", "Valor maior que o permitido");
	            return new ModelAndView("redirect:/produto/list");
	        }
	    };
	}

	private void enviaEmailCompra(Usuario usuario) {
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		
		mailMessage.setTo(usuario.getEmail());
		
		mailMessage.setSubject("Compra Efetuada com sucesso");
		mailMessage.setText("O valor da sua compra foi de: R$ " + carrinho.getTotal());
		
		sender.send(mailMessage);
		
		System.out.println("Email enviado com sucesso!");
		
	}

}
