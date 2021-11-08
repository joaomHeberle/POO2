package Modelo;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;



public class App {
 

    public static void main(String[] args) throws Exception {
        String nome;
        Persistencia p = new Persistencia();
        p.criaPasta();
        p.criaArquivo();
        // p.inicioID();
        List<Jogador> test;
        test = new ArrayList<>();
        nome = JOptionPane.showInputDialog("qual o seu nome ?");
        Jogador i1 = new Jogador(nome);
        // Jogador i2 = new Jogador("mario");
        // Jogador i3 = new Jogador("antonio");
        test.add(i1);

        p.inserir(i1);
    
        List<Jogador> pers = new ArrayList<>();

        List<Jogador> jogador = p.lista();
        JOptionPane.showMessageDialog(null,p.lista());
        for (Jogador jogador2 : jogador) {
            System.out.println(jogador2);
        }
        pers = p.getId(6);
        pers.stream().forEach(System.out::println);
        p.delete(14);
        Jogador i4 = new Jogador(15, "debora", 548, 472, 350);
        p.update(i4);
      	
        System.out.println("nivel: "+i4.getNivel());
   

    }

}
