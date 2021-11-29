package dao;

import application.models.Jogador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JogadorDAO implements DAO<Jogador> {

	@Override
	public boolean insert(Jogador e) {
		String query = "INSERT INTO jogador (nome, nivel, moedas, experiencia) VALUES (?,?,?,?)";
		try (Connection con = ConnectionFactory.getConnection()) {
			var pstm = con.prepareStatement(query);
			pstm.setString(1, e.getNome());
			pstm.setLong(2, e.getNivel());
			pstm.setLong(3, e.getQtdMoedas());
			pstm.setLong(4, e.getExpNovoNivel());

			pstm.execute();
			pstm.close();
			return true;
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}

	}

	public boolean delete(int id) {
		String query = "DELETE FROM jogador WHERE \"id_Jogador\" = ?";
		try (Connection con = ConnectionFactory.getConnection()) {
			var pstm = con.prepareStatement(query);
			pstm.setInt(1, id);
			pstm.execute();
			pstm.close();
			return true;
		} catch (SQLException ex) {

			throw new RuntimeException(ex);
		}

	}

	@Override
	public Jogador get(int id) {
		String query = "SELECT * FROM jogador WHERE \"id_Jogador\" = ?";
		try (Connection con = ConnectionFactory.getConnection()) {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, id);
			ResultSet resposta = pstm.executeQuery();
			resposta.next();
			var jog = new Jogador(resposta.getString("nome"));
			jog.setNivel(resposta.getInt("nivel"));
			jog.setQtdMoedas(resposta.getInt("moedas"));
			jog.setIdJogador(resposta.getInt("id_Jogador"));

			jog.setExpNovoNivel(resposta.getInt("experiencia"));

			resposta.close();
			pstm.close();
			return jog;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Jogador> list(int limit, int offset) {
		String query = "SELECT * FROM jogador LIMIT ? OFFSET ?";

		var jogas = new ArrayList<Jogador>();
		try (Connection con = ConnectionFactory.getConnection()) {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, limit);
			pstm.setInt(2, offset);
			ResultSet resposta = pstm.executeQuery();

			while (resposta.next()) {
				var jog = new Jogador(resposta.getString("nome"));
				jog.setNivel(resposta.getInt("nivel"));
				jog.setQtdMoedas(resposta.getInt("moedas"));
				jog.setIdJogador(resposta.getInt("id_Jogador"));

				jog.setExpNovoNivel(resposta.getInt("experiencia"));
				jogas.add(jog);
			}
			resposta.close();
			pstm.close();
			return jogas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean update(Jogador obj) {
		String sql = "UPDATE jogador SET nome=?, nivel=?, moedas=?, experiencia=? WHERE \"id_Jogador\"=? ";
		try (Connection con = ConnectionFactory.getConnection()) {
			var pstm = con.prepareStatement(sql);
			pstm.setString(1, obj.getNome());
			pstm.setLong(2, obj.getNivel());
			pstm.setLong(3, obj.getQtdMoedas());
			pstm.setObject(4, obj.getExpNovoNivel());
			pstm.setInt(5, obj.getIdJogador());
			pstm.execute();
			pstm.close();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
