package DAO;

import Modelo.Jogador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JogadorDAO {
	public void insert(Jogador e) {
		String query = "INSERT INTO jogador (nome, nivel, moedas, experiencia) VALUES (?,?,?,?)";
		try (Connection con = ConnectionFactory.getConnection()) {
			var pstm = con.prepareStatement(query);
			pstm.setString(1, e.getNome());
			pstm.setLong(2, e.getNivel());
			pstm.setLong(3, e.getQtdMoedas());
			pstm.setLong(4, e.getExpNovoNivel());
			pstm.execute();
			pstm.close();
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}

	public void delete(int id) {
		String query = "DELETE FROM jogador WHERE \"id_Jogador\" = ?";
		try (Connection con = ConnectionFactory.getConnection()) {
			var pstm = con.prepareStatement(query);
			pstm.setInt(1, id);
			pstm.execute();
			pstm.close();
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}

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

	public List<Jogador> list(int offset, int limit) {
		String query = "SELECT * FROM jogador LIMIT ? OFFSET ?";
		var jogas = new ArrayList<Jogador>();
		try (Connection con = ConnectionFactory.getConnection()) {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, limit);
			pstm.setInt(2, offset);
			ResultSet resposta = pstm.executeQuery();
			// loop
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
}
