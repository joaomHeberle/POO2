package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import application.models.Missao;

public class MissaoDAO implements DAO<Missao> {

	@Override
	public boolean insert(Missao e) {
		String query = "INSERT INTO missao (descricao, datainicio, datafim, status,tipo,quantidade) VALUES (?, ?, ?, ?,?,?) RETURNING \"id_Missao\"";
		try (Connection con = ConnectionFactory.getConnection()) {
			var pstm = con.prepareStatement(query);
			pstm.setString(1, e.getDescricao());
			pstm.setObject(2, e.getDataInicio());
			pstm.setObject(3, e.getDataFim());
			pstm.setBoolean(4,e.isStatus());
			pstm.setString(5,e.getTipo());
			pstm.setInt(6, e.getQuantidade());
			var rs = pstm.executeQuery();
			var x=rs.next();
			e.setIdMissao(rs.getInt("id_Missao"));
			rs.close();
			pstm.close();
			return x;
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public boolean delete(int id) {
		String query = "DELETE FROM missao WHERE \"id_Missao\" = ?";
		try (Connection con = ConnectionFactory.getConnection()) {
			var pstm = con.prepareStatement(query);
			pstm.setInt(1, id);
			var x =pstm.execute();
			pstm.close();
			return x;
		} catch (SQLException ex) {

			throw new RuntimeException(ex);
		}

	}

	@Override
	public boolean update(Missao obj) {
		String sql = "UPDATE missao SET descricao=?, datainicio=?, datafim=?, status=?, tipo=?, quantidade=? WHERE \"id_Missao\"=?";
		try (Connection con = ConnectionFactory.getConnection()) {
			var pstm = con.prepareStatement(sql);
			pstm.setString(1, obj.getDescricao());
			pstm.setObject(2, obj.getDataInicio());
			pstm.setObject(3, obj.getDataFim());
			pstm.setBoolean(4,obj.isStatus());
			pstm.setString(5,obj.getTipo());
			pstm.setInt(6,obj.getQuantidade());
			pstm.setInt(7, obj.getIdMissao());

			var x =pstm.execute();
			pstm.close();
			return x;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public List<Missao> list(int limit, int offset) {
		String query = "SELECT * FROM missao LIMIT ? OFFSET ?";

		List<Missao> missa = new ArrayList<Missao>();
		try (Connection con = ConnectionFactory.getConnection()) {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, limit);
			pstm.setInt(2, offset);
			ResultSet resposta = pstm.executeQuery();

			while (resposta.next()) {
				var m = new Missao();
				m.setDataInicio(resposta.getObject("datainicio",LocalDate.class));
				m.setDescricao(resposta.getString("descricao"));
				m.setDataFim(resposta.getObject("datafim",LocalDate.class));
				m.setTipo(resposta.getString("tipo"));
				m.setStatus(resposta.getBoolean("status"));
				m.setQuantidade(resposta.getInt("quantidade"));
				m.setIdMissao(resposta.getInt("id_Missao"));
				missa.add(m);
			}
			resposta.close();
			pstm.close();
			return missa;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}



	@Override
	public Missao get(int id) {
		String query = "SELECT * FROM missao WHERE \"id_Missao\" = ?";
		try (Connection con = ConnectionFactory.getConnection()) {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, id);
			ResultSet resposta = pstm.executeQuery();
			resposta.next();
			var m = new Missao();
			m.setDataInicio(resposta.getObject("datainicio",LocalDate.class));
			m.setDescricao(resposta.getString("descricao"));
			m.setDataFim(resposta.getObject("datafim",LocalDate.class));
			m.setTipo(resposta.getString("tipo"));
			m.setStatus(resposta.getBoolean("status"));
			m.setQuantidade(resposta.getInt("quantidade"));
			m.setIdMissao(resposta.getInt("id_Missao"));
	
			resposta.close();
			pstm.close();
			return m;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Missao> listById(int id) {
		String query = "SELECT * FROM missao WHERE \"id_Missao\"=?";

		List<Missao> missa = new ArrayList<Missao>();
		try (Connection con = ConnectionFactory.getConnection()) {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, id);
			ResultSet resposta = pstm.executeQuery();

			while (resposta.next()) {
				var m = new Missao();
				m.setDataInicio(resposta.getObject("datainicio",LocalDate.class));
				m.setDescricao(resposta.getString("descricao"));
				m.setDataFim(resposta.getObject("datafim",LocalDate.class));
				m.setTipo(resposta.getString("tipo"));
				m.setStatus(resposta.getBoolean("status"));
				m.setQuantidade(resposta.getInt("quantidade"));
				m.setIdMissao(resposta.getInt("id_Missao"));
				missa.add(m);
			}
			resposta.close();
			pstm.close();
			return missa;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


}
