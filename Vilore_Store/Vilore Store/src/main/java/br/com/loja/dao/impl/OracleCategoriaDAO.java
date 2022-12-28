package br.com.loja.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.loja.bean.Categoria;
import br.com.loja.dao.CategoriaDAO;
import br.com.loja.singleton.ConnectionManager;

public class OracleCategoriaDAO implements CategoriaDAO{
	
	private Connection connection;

	@Override
	public List<Categoria> listar() {
		List<Categoria> lista = new ArrayList<Categoria>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			connection = ConnectionManager.getInstance().getConnection();
			stmt = connection.prepareStatement("SELECT * FROM TB_CATEGORIA");
			rs = stmt.executeQuery();
			
			
			while (rs.next()) {
				int codigo = rs.getInt("CD_CATEGORIA");
				String nome = rs .getString("NM_CATEGORIA");
			    Categoria categoria = new Categoria (codigo, nome);
			    lista.add(categoria);
			}
					
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				rs.close();
				connection.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}return lista;
		
		
	}
	
	

}
