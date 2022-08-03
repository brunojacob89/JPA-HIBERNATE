package br.com.alura.loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.loja.dao.CategoriaDAO;
import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDeProdutos {

	public static void main(String[] args) {

//		cadastraProduto();
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDao = new ProdutoDAO(em);
		
//		Produto p = produtoDao.buscaPorId(2l);
//		System.out.println(p.getPreco());
		
//		List<Produto> todos = produtoDao.buscarTodos();
//		todos.forEach(p2 -> System.out.println(p2.getNome()));
		
//		List<Produto> todos = produtoDao.buscarPorNome("Xiaomi Redm");
//		todos.forEach(p2 -> System.out.println(p2.getNome()));
		
		List<Produto> todos = produtoDao.buscarPorNomeDaCategoria("CELULARES");
		todos.forEach(p2 -> System.out.println(p2.getNome()));
		
//		BigDecimal precoDoProduto = produtoDao.buscarPrecoDoProdutoComNome("Xiaomi Redm");
//		System.out.println(precoDoProduto);
		
	
	}

	
	
	
	
	
	private static void cadastraProduto() {
		Categoria celulares = new Categoria("CELULARES");
		Produto celular = new Produto("Xiaomi Redm","Celular Legal",new BigDecimal("800"),celulares);
		
		
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja");
//		EntityManager em = factory.createEntityManager();
		
		EntityManager em = JPAUtil.getEntityManager();
		
		//CODIGO PARA ADICIONA OUTROS PRODUTOS
//		Categoria celulares = em.createQuery("SELECT c FROM Categoria c WHERE c.nome = :nome", Categoria.class).setParameter("nome", "celulares").getSingleResult();
//		Produto outro = new Produto("Sansung", "SMARTFONE 128GB", new BigDecimal("1857.00"), celulares);
		
		ProdutoDAO produtoDao = new ProdutoDAO(em);
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);
		
		em.getTransaction().begin();// para iniciar a transacao
		
		categoriaDAO.cadastrar(celulares);
		produtoDao.cadastrar(celular); // faz o insert
		
//		Categoria produto = em.find(Categoria.class, 5l); Para encontra uma entidade .
//		em.remove(produto);
		
		
		
		em.getTransaction().commit(); // faz o commit
		em.close();// fechando o recurso
	}

}
