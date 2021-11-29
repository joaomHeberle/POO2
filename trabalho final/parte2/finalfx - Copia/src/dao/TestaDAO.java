package dao;

import java.util.ArrayList;
import java.util.List;

import application.models.Jogador;

public class TestaDAO {

	public static void main(String[] args) {
		JogadorDAO jdao = new JogadorDAO();
		Jogador jg = new Jogador();
		// testa insert e get
		var nam = "joao";
		var exp = 10;
		var nivel = 5;
		var moeda = 100;

		System.out.println("testa insert");
		jg.setNome(nam);
		jg.setExpNovoNivel(exp);
		jg.setNivel(nivel);
		jg.setQtdMoedas(moeda);
		jdao.insert(jg);
		List<Jogador> lista = new ArrayList<>();
		lista = jdao.list(20, 0);
		var id = lista.get(lista.size() - 1).getIdJogador();
		jg.setIdJogador(id);
		var nome = lista.get(lista.size() - 1).getNome();

		System.out.println(nome.equals(jg.getNome()));
		// testa get
		var jogador1 = jdao.get(id);
		System.out.println("testa get");
		System.out.println(jogador1.getNome().equals(nam));
		System.out.println(jogador1.getNivel() == nivel);
		System.out.println(jogador1.getExpNovoNivel() == exp);
		System.out.println(jogador1.getQtdMoedas() == moeda);
		System.out.println(jogador1.getIdJogador() == id);
		// testa update
		System.out.println("testa update");
		nam = "mario";
		exp = 23;
		nivel = 12;
		moeda = 50;
		jg.setNome(nam);
		jg.setExpNovoNivel(exp);
		jg.setNivel(nivel);
		jg.setQtdMoedas(moeda);

		jdao.update(jg);
		lista = jdao.list(20, 0);
		jogador1 = jdao.get(id);
		System.out.println(jogador1.getNome().equals(nam));
		System.out.println(jogador1.getNivel() == nivel);
		System.out.println(jogador1.getExpNovoNivel() == exp);
		System.out.println(jogador1.getQtdMoedas() == moeda);
		System.out.println(jogador1.getIdJogador() == id);
		// testa delete
		System.out.println("testa delete");
		jdao.delete(id);
		lista = jdao.list(20, 0);
			try {
				System.out.println((lista.get(lista.size() - 1).getIdJogador() == jogador1.getIdJogador()) == false);
			}catch (IndexOutOfBoundsException e) {
				System.out.println("banco vazio");
			}
	
	
			

	

	}

}
