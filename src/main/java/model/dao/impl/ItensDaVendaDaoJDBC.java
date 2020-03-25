package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.ItensDaVendaDao;
import model.entities.ItensDaVenda;
import model.entities.Livro;

public class ItensDaVendaDaoJDBC implements ItensDaVendaDao {
	
	private Connection conn;
	
	public ItensDaVendaDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(ItensDaVenda obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO itens_da_venda "
					+ "(id_livro, qtd, subtotal) "
					+ "VALUES "
					+ "(?, ?, ?)");
			st.setInt(1, obj.getId_livro());
			st.setInt(2, obj.getQuantidade());
			st.setDouble(3, obj.getSubtotal());	
			
			int rowAffected = st.executeUpdate();
			
			if(rowAffected>0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					obj.setIdvenda(id);
				}
				DB.closeResultSet(rs);
			}
			else {
				throw new DbException("Erro inesperado, nenhuma linha afetada!");
			}
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void update(ItensDaVenda obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"UPDATE itens_da_venda "
					+ "SET id_livro = ?, qtd = ?, subtotal = ? "
					+ "WHERE idvenda = ?");
			st.setInt(1, obj.getId_livro());
			st.setInt(2, obj.getQuantidade());
			st.setDouble(3, obj.getSubtotal());
			st.setInt(4, obj.getId_livro());
			
			st.executeUpdate();
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ItensDaVenda findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"select * "
					+ "from itens_da_venda, livro "
					+ "where itens_da_venda.idvenda=?");
				st.setInt(1, id);
				rs = st.executeQuery();
				if (rs.next()) {
					Livro liv = new Livro();
					liv.setIdlivro(rs.getInt("idlivro"));
					liv.setTitulo(rs.getString("titulo"));
					liv.setPreco(rs.getDouble("preco"));
					liv.setEstoque(rs.getInt("estoque"));
					ItensDaVenda obj = new ItensDaVenda();
					obj.setIdvenda(rs.getInt("idvenda"));
					obj.setQuantidade(rs.getInt("qtd"));
					obj.setSubtotal(rs.getDouble("subtotal"));
					obj.setLivro(liv);
					return obj;
				}
					return null;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<ItensDaVenda> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
