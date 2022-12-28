package br.com.loja.dao;

import java.util.List;

import br.com.loja.bean.Produto;
import br.com.loja.exception.DBException;

public interface ProdutoDAO {
	
	void cadastrar(Produto produto) throws DBException;
	
	void atualizar(Produto produto) throws DBException;
	
	void remover(int codigo)throws DBException;
	
	Produto buscar(int id);
	List<Produto> listar();

}
