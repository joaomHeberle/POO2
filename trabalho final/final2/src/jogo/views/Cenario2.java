package jogo.views;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import application.Main;
import application.models.Jogador;
import dao.JogadorDAO;
import jogo.models.Player2;
import jplay.Keyboard;
import jplay.Scene;

import jplay.Window;

public class Cenario2 extends Cenario {
	private Window janela;
	private Scene cena;
	private Player2 player;
	private Keyboard teclado;
	public static int tam = 20;
	private boolean testa=true;
	private int id;
	
	public Cenario2(Window window,int id) {
		janela = window;
		cena = new Scene();
		cena.loadFromFile("src/recursos/scn/cenario2.scn");
		player = new Player2(600, 500);
		teclado = janela.getKeyboard();
		this.id=id;

		//Som.play("src/recursos/audio/Path.mid");
		run();
	}

	private void run() {

		while (true) {
			// cena.draw();
			player.controle(janela, teclado);
			player.caminho(cena);

			cena.moveScene(player);
//		player.x += cena.getXOffset();
//			player.y += cena.getYOffset();
	
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
			 List<Jogador> pers = new ArrayList<>();
		    JDialog.setDefaultLookAndFeelDecorated(true);
		    pers=jdao.list(16, 0);
		    Object[] selectionValues = pers.toArray();
		   
		    Object selection = JOptionPane.showInputDialog(null, "Escolha uma missão",
		        "Lista de missões", JOptionPane.QUESTION_MESSAGE, null, selectionValues,null);
		
			System.out.println(selection);
			var a=selection.toString();
			System.out.println(a);
			String[] corte=a.split(" ");
			System.out.println(corte[1]);
			int aux_Id= Integer.parseInt(corte[1]);
			
			System.out.println(aux_Id);
			}catch (NullPointerException e) {
				System.out.println("deve escolher uma missão");
			}
		}
		}
		
	}
	
	
}
