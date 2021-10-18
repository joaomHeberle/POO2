package Modelo;
import java.util.ArrayList;
import java.util.List;

public class TesteJogador {
    public static void main(String[] args) throws Exception {
        // Cria a pasta e o arquivo para gerar o ID
        Persistencia p = new Persistencia();
        p.criaPasta();
        p.criaArquivo();


    List<Jogador> test;
    test = new ArrayList<>();

    //cria novo jogador de acordo com o cadastro que sera feito no menu
    Jogador i1 = new Jogador("jose");
    Jogador i2 = new Jogador("carlito");
    Jogador i3 = new Jogador("kratos");

    // testa o construtor usado para UPDATE, DELETE e receber dados do arquivo
    Jogador i4 = new Jogador(1, "Leon", 1, 0, 10);
    test.add(i1);
    test.add(i2);
    test.add(i3);
    // testa os toString
    System.out.println(i1.toString());
    System.out.println(i4.toString());



}
}
