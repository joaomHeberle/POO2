package dao;

import java.time.LocalDate;
import java.util.List;

import application.models.Jogador;
import application.models.Missao;

public class TestaMissaoDAO {


	public static void main(String[] args) {
		Missao m = new Missao();
		Missao m2 = new Missao();
		MissaoDAO mDAO = new MissaoDAO();
		JogadorDAO jDAO = new JogadorDAO();
		JogadorMissaoDAO jmDAO = new JogadorMissaoDAO();
		m.setDataInicio(LocalDate.of(2005, 12, 19));
		m.setDescricao("ola");
		m.setDataFim(LocalDate.of(2005, 12, 23));
		m.setTipo("eliminação");
		m.setQuantidade(20);
		m.setStatus(false);
//	//	-------segundo----------
		m2.setDataInicio(LocalDate.of(2021, 12, 19));
		m2.setDescricao("mafagafo");
		m2.setDataFim(LocalDate.of(2033, 01, 30));
		m2.setTipo("sobrevivencia");
		m2.setStatus(false);
		m2.setQuantidade(30);
		Jogador j = new Jogador();
		j = jDAO.get(43);

		//jDAO.insert(j);
//		mDAO.insert(m);
//		mDAO.insert(m2);
		//j.setMissoes(mDAO.listById(63));
		//j.setMissoes(jmDAO.listDados(j));
		System.out.println(j);
		//jmDAO.updateJogadorMissao(j.getIdJogador(), j.getMissoes().get(1).getIdMissao(), 50);
		
		
		System.out.println(j);
		
//		jmDAO.insert(j);
//		j.setMissoes(mDAO.listById(62));
//		jmDAO.insert(j);
//		j.setMissoes(jmDAO.listDados(j));
//		System.out.println(m.getIdMissao());
//		System.out.println("testa list");
//		var missa = mDAO.list(16, 0);
//	
//	
//		int id = m.getIdMissao();
//	     for (Missao mis : missa) {
//	            System.out.println(mis);
//	        }
//		System.out.println(id);
//		System.out.println("testa get");
//		var tget = mDAO.get(id);
//		System.out.println(tget);
//		
//		System.out.println("testa update");
//		Missao mUp = new Missao();
//		mUp.setDescricao("testinha");
//		mUp.setDataInicio(LocalDate.of(2005, 12, 20));
//	
//		mUp.setDataFim(LocalDate.of(2005, 12, 05));
//		mUp.setTipo(2);
//		mUp.setStatus(true);
//		mUp.setIdMissao(id);
//		mDAO.update(mUp);
//		missa = mDAO.list(16, 0);
//
//		  for (Missao mis : missa) {
//	            System.out.println(mis);
//	        }
//		System.out.println("testa delete");
////		jDAO.delete(j.getIdJogador());
////		mDAO.delete(m.getIdMissao());
////		jmDAO.delete(m.getIdMissao(), j.getIdJogador());
//		
//		missa = mDAO.list(16, 0);
//		System.out.println(missa.get(missa.size()-1).getIdMissao()==id);
//		
//
//		System.out.println(j);
//
//
//		
//		
	}

}
