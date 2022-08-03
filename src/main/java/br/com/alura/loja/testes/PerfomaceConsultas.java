package br.com.alura.loja.testes;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.PedidoDAO;
import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.util.JPAUtil;

public class PerfomaceConsultas {

	public static void main(String[] args) {

		EntityManager em = JPAUtil.getEntityManager();
		PedidoDAO pedidoDao = new PedidoDAO(em);
//		Pedido pedido = em.find(Pedido.class, 6l);
		Pedido pedido = pedidoDao.buscarPedidoComCliente(7l);
		em.close();
		System.out.println(pedido.getCliente().getNome());
		
	}

}
