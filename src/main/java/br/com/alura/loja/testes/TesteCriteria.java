package br.com.alura.loja.testes;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.util.JPAUtil;

public class TesteCriteria {

	public static void main(String[] args) {

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		
		produtoDAO.buscarPorParemetros("PS5", null, null);
	}

}
