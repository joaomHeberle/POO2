package jogo.views;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import application.Main;
import application.models.Jogador;
import application.models.Missao;
import dao.JogadorDAO;
import dao.JogadorMissaoDAO;
import dao.MissaoDAO;
import jogo.models.Player2;
import jogo.utils.MissaoUtil;
import jogo.utils.Som;
import jplay.Keyboard;
import jplay.Scene;

import jplay.Window;

public class Cenario2 extends Cenario {
	private Window janela;
	private Scene cena;
	private Player2 player;
	private Keyboard teclado;
	public static int tam = 20;

	private int id;
	
	public Cenario2(Window window,int id) {
		janela = window;
		cena = new Scene();
		cena.loadFromFile("src/recursos/scn/cenario2.scn");
		player = new Player2(600, 500);
		teclado = janela.getKeyboard();
		this.id=id;

		Som.play("src/recursos/audio/mapa1.mid");
		run();
	}

	private void run() {

		while (true) {

			player.controle(janela, teclado);
			player.caminho(cena);

			cena.moveScene(player);

	
			player.draw();
			janela.update();
			mudarCenario();
			pegarMissao();
			
		}

	}
	private void mudarCenario() {
		if(tileCollision(63, player, cena)==true) {
			new Cenario1(janela,id);
		}
		
	}
	private void pegarMissao() {
		if (teclado.keyDown(Keyboard.ENTER_KEY)) {
		if(tileCollision(66, player, cena)==true) {
			
			try {
			JogadorDAO jdao = new JogadorDAO();
			Jogador j = new Jogador();
			JogadorMissaoDAO jmDAO = new JogadorMissaoDAO();
			MissaoDAO mDAO = new MissaoDAO();
			j = jdao.get(this.id);
			j.setMissoes(jmDAO.listDados(j));
			
			 List<Missao> pers = new ArrayList<>();
		    JDialog.setDefaultLookAndFeelDecorated(true);
		    
		    pers=jmDAO.listMissaoNaoSelecionada(j);
		    Object[] selectionValues = pers.toArray();
		   
		    Object selection = JOptionPane.showInputDialog(null, "Escolha uma missão",
		        "Lista de missões", JOptionPane.QUESTION_MESSAGE, null, selectionValues,null);
		
	
			var a=selection.toString();

			String[] corte=a.split(" ");

			int aux_Id= Integer.parseInt(corte[2]);
			j.setMissoes(mDAO.listById(aux_Id));
			jmDAO.insert(j);

			}catch (NullPointerException e) {
				System.out.println("deve escolher uma missão");
			}
		}
		}
		
	}
	
	
}
