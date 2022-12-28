package br.com.loja.teste;

import java.util.List;

import br.com.loja.bean.Categoria;
import br.com.loja.dao.CategoriaDAO;
import br.com.loja.factory.DAOFactory;

public class TesteCategoriaDAO {

	public static void main(String[] args) {
		CategoriaDAO dao = DAOFactory.getCategoriaDAO();
		
		List<Categoria> lista = dao.listar();
		for(Categoria categoria : lista) {
			System.out.println(categoria.getCodigo() + " " + categoria.getNome());
		}

	}

}
