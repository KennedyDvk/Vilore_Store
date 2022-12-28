package br.com.loja.factory;

import br.com.loja.dao.CategoriaDAO;
import br.com.loja.dao.ProdutoDAO;
import br.com.loja.dao.UsuarioDAO;
import br.com.loja.dao.impl.OracleCategoriaDAO;
import br.com.loja.dao.impl.OracleProdutoDAO;
import br.com.loja.dao.impl.OracleUsuarioDAO;

public class DAOFactory {

	public static ProdutoDAO getProdutoDAO() {
		return new OracleProdutoDAO();
	}
	
	public static CategoriaDAO getCategoriaDAO(){
		return new OracleCategoriaDAO();
	}
	
	public static UsuarioDAO getUsuarioDAO() {
		return new OracleUsuarioDAO();
	}
	
}
