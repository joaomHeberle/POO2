package jogo.utils;

import java.util.ArrayList;
import java.util.List;

import application.models.Jogador;
import application.models.Missao;
import dao.JogadorDAO;
import dao.JogadorMissaoDAO;
import dao.MissaoDAO;

public class MissaoUtil {
	int salva;
	private String separaIdQtd (int id) {
		try {
			String quantidade="";
			String tipo="";
			String Id="";
			JogadorDAO jdao = new JogadorDAO();
			Jogador j = new Jogador();
			JogadorMissaoDAO jmDAO = new JogadorMissaoDAO();
			MissaoDAO mDAO = new MissaoDAO();
			j = jdao.get(id);
			j.setMissoes(jmDAO.listDados(j));
			
			 List<Missao> pers = new ArrayList<>();
			 pers = j.getMissoes();
		


	String[] corte=pers.toString().split(" ");

	for(int i =0 ; i<1000;i++) {
	tipo=corte[i];
	if(tipo.equals("Eliminação")) {
		salva=i;
		break;
		
	}
	}
	quantidade=corte[salva+2];
	Id=corte[salva-7];




		
		return Id+ " "+quantidade;


		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("sem missao");
		}
		return null;
		
		
		
	}
	public int retornaQuantidade (int id) {
		try {
			String cheio = separaIdQtd(id);
			int quantidade;
			String[] corte=cheio.toString().split(" ");
			quantidade=Integer.parseInt(corte[1]);

			return quantidade;
		} catch (Exception e) {
			System.out.println("sem quantidade");
		}
		return 0;

	}
	
	public int retornaId (int id) {
		try {
			String cheio = separaIdQtd(id);
			int Id;
			String[] corte=cheio.toString().split(" ");
			Id=Integer.parseInt(corte[0]);

			return Id;
		} catch (Exception e) {
			System.out.println("sem ID");
		}
		return 0;

	}
	public void completouMissao(int joga, int missao) {
		JogadorMissaoDAO jmDAO = new JogadorMissaoDAO();
		jmDAO.delete(missao,joga);
	}

}
