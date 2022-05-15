package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import application.models.Jogador;
import application.models.Missao;

public class JogadorMissaoDAO {

	public void insert(Jogador e) {
		String query = "INSERT INTO \"jogadorMissao\" (id_missao, id_jogador) VALUES (?,?)";
		try (Connection con = ConnectionFactory.getConnection()) {
			var pstm = con.prepareStatement(query);
			pstm.setLong(1, e.getMissoes().get(0).getIdMissao());
			pstm.setLong(2, e.getIdJogador());


			pstm.execute();
			pstm.close();
			
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}
	
	


	public void delete(int idMissao,int idJogador) {
		String query = "DELETE FROM \"jogadorMissao\" WHERE id_missao=? AND id_jogador = ?";
		try (Connection con = ConnectionFactory.getConnection()) {
			var pstm = con.prepareStatement(query);
			pstm.setInt(1, idMissao);
			pstm.setInt(2, idJogador);
			pstm.execute();
			pstm.close();
		
		} catch (SQLException ex) {

			throw new RuntimeException(ex);
		}
	 
	}




	public List<Missao> listDados(Jogador e) {
		String query = "SELECT \"id_Missao\", tipo, status, descricao,quantidade from \"jogadorMissao\" left outer join jogador on \"id_Jogador\"=id_jogador left outer join missao on \"id_Missao\"= id_missao where id_jogador=?";

		List<Missao> missa = new ArrayList<Missao>();
		try (Connection con = ConnectionFactory.getConnection()) {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, e.getIdJogador());
			ResultSet resposta = pstm.executeQuery();

			while (resposta.next()) {
				var m = new Missao();
				m.setIdMissao(resposta.getInt("id_Missao"));
				m.setDescricao(resposta.getString("descricao"));
				m.setTipo(resposta.getString("tipo"));
				m.setStatus(resposta.getBoolean("status"));
				m.setQuantidade(resposta.getInt("quantidade"));
				missa.add(m);
			}
			resposta.close();
			pstm.close();
			return missa;
		} catch (SQLException obj) {
			throw new RuntimeException(obj);
		}
	}


	public List<Missao> listMissaoNaoSelecionada(Jogador e) {
		String query = "SELECT distinct \"id_Missao\",\"id_Jogador\", tipo, status, descricao,quantidade\r\n"
				+ "from missao\r\n"
				+ "left outer join \"jogadorMissao\"\r\n"
				+ "on \"id_Missao\"= id_missao\r\n"
				+ "left outer join jogador\r\n"
				+ "on \"id_Jogador\"= id_jogador\r\n"
				+ "where \"id_Jogador\" is null \r\n"
				+ "OR \"id_Jogador\"!=?";

		List<Missao> missa = new ArrayList<Missao>();
		try (Connection con = ConnectionFactory.getConnection()) {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, e.getIdJogador());
			ResultSet resposta = pstm.executeQuery();

			while (resposta.next()) {
				var m = new Missao();
				m.setIdMissao(resposta.getInt("id_Missao"));
				m.setDescricao(resposta.getString("descricao"));
				m.setTipo(resposta.getString("tipo"));
				m.setStatus(resposta.getBoolean("status"));
				m.setQuantidade(resposta.getInt("quantidade"));
				missa.add(m);
			}
			resposta.close();
			pstm.close();
			return missa;
		} catch (SQLException obj) {
			throw new RuntimeException(obj);
		}
	}




}
