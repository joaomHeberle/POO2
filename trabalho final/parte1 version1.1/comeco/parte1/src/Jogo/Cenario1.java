package Jogo;

import jplay.Scene;
import jplay.Sprite;
import jplay.Window;

public class Cenario1 {
    private Window janela;
    private Scene cena;

    public Cenario1(Window window){
        janela = window;
        cena = new Scene();
        cena.loadFromFile("comeco/parte1/src/recursos/scn/cenario1.scn");
        run();
    }

    private void run() {
        while (true){
            cena.draw();
            janela.update();

        }
    }
}
