package br.com.loja.teste;

import java.util.Calendar;
import java.util.List;

import br.com.loja.bean.Produto;
import br.com.loja.dao.ProdutoDAO;
import br.com.loja.exception.DBException;
import br.com.loja.factory.DAOFactory;

public class TesteProdutoDAO {

	public static void main(String[] args) {
		ProdutoDAO dao = DAOFactory.getProdutoDAO();
		
		//Cadastrar Produtos
		Produto produto = new Produto(1, "Bolsa ", 20 , Calendar.getInstance(), 100);
		
		try {
			dao.cadastrar(produto);
			System.out.println("Produto Cadastrado!");
		}catch (DBException e) {
			e.printStackTrace();
		}
		
		//Buscar um Produto pelo codigo e atualizar
		produto = dao.buscar( 44 );
		produto.setNome("Caderno capa dura ");
		produto.setValor( 30 );
		
		try {
			dao.atualizar(produto);
			System.out.println("Produto Atualizado!");
		}catch (DBException e) {
			e.printStackTrace();
		}
		
		//Listar os produtos
		List<Produto> lista = dao.listar();
		
		for (Produto item : lista) {
			System.out.println(item.getNome()+ " " + item.getQuantidade() + " " + item.getValor());
		}
		
		//remover um produto
		try {
			dao.remover( 44 );
			System.out.println("Produto removido");
		}catch (DBException e) {
			e.printStackTrace();
			
		}

	}
	

}
