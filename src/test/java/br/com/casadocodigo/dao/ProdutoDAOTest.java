package br.com.casadocodigo.dao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.casadocodigo.builders.ProdutoBuilder;
import br.com.casadocodigo.conf.JPAConfiguration;
import br.com.casadocodigo.model.Produto;
import br.com.casadocodigo.model.TipoPreco;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ProdutoDAO.class,JPAConfiguration.class })
public class ProdutoDAOTest {
	
    @Autowired
    private ProdutoDAO ProdutoDAO;

    @Transactional
    @Test
    public void shouldSumAllPricesOfEachBookPerType() {        

        List<Produto> printedBooks = ProdutoBuilder
                .newProduto(TipoPreco.IMPRESSO, BigDecimal.TEN).more(4)
                .buildAll();
        
        printedBooks.stream().forEach(ProdutoDAO::gravar);

        List<Produto> ebooks = ProdutoBuilder
                .newProduto(TipoPreco.EBOOK, BigDecimal.TEN).more(4).buildAll();
        
        ebooks.stream().forEach(ProdutoDAO::gravar);
        
        BigDecimal value = ProdutoDAO.somaPrecoPorTipo(TipoPreco.IMPRESSO);
        
        Assert.assertEquals(new BigDecimal(286).setScale(2), value);

    }

}
