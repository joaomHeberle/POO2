
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Persistencia p = new Persistencia();
        List<Jogador> test;
        test = new ArrayList<>();
        p.criaPasta();
        p.criaArquivo();
       
        
      
        

        Jogador i1 = new Jogador("joao");
        Jogador i2 = new Jogador("mario");
        Jogador i3 = new Jogador("antonio");
        test.add(i1);
        test.add(i2);
        test.add(i3);
        p.inserir(i1);
        p.inserir(i2);
        p.inserir(i3);
   
  
        List<Jogador> jogador = p.lista();
        for (Jogador jogador2 : jogador) {
            System.out.println(jogador2);
        }

    }
}
