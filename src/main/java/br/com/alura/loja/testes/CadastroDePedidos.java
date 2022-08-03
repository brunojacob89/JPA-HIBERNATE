package br.com.alura.loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.ClienteDAO;
import br.com.alura.loja.dao.PedidoDAO;
import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.modelo.Cliente;
import br.com.alura.loja.modelo.ItemPedido;
import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;
import br.com.alura.loja.vo.RelatorioDeVendasVo;

public class CadastroDePedidos {

	public static void main(String[] args) {

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		Produto produto = produtoDAO.buscaPorId(12l);
		Produto produto2 = produtoDAO.buscaPorId(13l);
		
		em.getTransaction().begin();
		
//		Cliente cliente = new Cliente("Bruno", "123456");
		Cliente cliente = em.find(Cliente.class, 1l);
		Pedido pedido2 = new Pedido(cliente);
		Pedido pedido3 = new Pedido(cliente);
		pedido2.adicionaItem(new ItemPedido(20, pedido2, produto));
		pedido3.adicionaItem(new ItemPedido(40, pedido3, produto2));
		
//		ClienteDAO clienteDAO = new ClienteDAO(em);
//		clienteDAO.cadastrar(cliente);
		
		PedidoDAO pedidoDAO = new PedidoDAO(em);
//		pedidoDAO.cadastrar(pedido2);
//		pedidoDAO.cadastrar(pedido3);
		
		
		
		em.getTransaction().commit();
		
		
//		BigDecimal totalVendido = pedidoDAO.valorTotalVendido();
//		System.out.println("VALOR TOTAL " + totalVendido);
		
		
		List<RelatorioDeVendasVo> relatorio = pedidoDAO.relatorioDeVendas();

		relatorio.forEach(System.out::println);
		}
	

}
