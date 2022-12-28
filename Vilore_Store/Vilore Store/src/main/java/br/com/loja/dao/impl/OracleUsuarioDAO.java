package br.com.loja.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.loja.bean.Usuario;
import br.com.loja.dao.UsuarioDAO;
import br.com.loja.singleton.ConnectionManager;

public class OracleUsuarioDAO implements UsuarioDAO{
	
	private Connection  connection;

	@Override
	public boolean validarUsuario(Usuario usuario) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			connection = ConnectionManager.getInstance().getConnection();
			stmt = connection.prepareStatement("SELECT * FROM TB_USUARIO WHERE DS_EMAIL = ?"
					+ "AND DS_SENHA = ?");
			stmt.setString(1, usuario.getEmail());
			stmt.setString(2, usuario.getSenha());
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				return true;
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
		}
		return false;
	}
	
}
