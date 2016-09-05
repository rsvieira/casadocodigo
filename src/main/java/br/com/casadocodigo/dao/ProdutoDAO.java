package br.com.casadocodigo.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.casadocodigo.model.Produto;
import br.com.casadocodigo.model.TipoPreco;

/**
 * @author Ramon Vieira
 *
 */

@Repository
@Transactional
public class ProdutoDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public void gravar(Produto produto) {
		entityManager.persist(produto);
	}

	public List<Produto> getList() {
		return entityManager.createQuery("from Produto", Produto.class).getResultList();
	}

	public Produto findById(int id) {
		return entityManager.createQuery("select distinct(p) from Produto p join fetch p.precos preco where p.id = :id ",
				Produto.class).setParameter("id", id).getSingleResult();
	}

	public BigDecimal somaPrecoPorTipo(TipoPreco tipoPreco) {

		TypedQuery<BigDecimal> query = entityManager
				.createQuery("select sum(preco.valor) from Produto p "
				+ "join p.precos preco where preco.tipoPreco = :tipoPreco",BigDecimal.class);
				
		query.setParameter("tipoPreco", tipoPreco);
		
		return query.getSingleResult();
	}

}
