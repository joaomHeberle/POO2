package Modelo;
import java.util.ArrayList;
import java.util.List;

public class TestePersistencia {
    public static void main(String[] args) throws Exception {
        // cria a pasta e o arquivo que sera usado de banco de dados
        Persistencia p = new Persistencia();
        p.criaPasta();
        p.criaArquivo();

        // cria os jogadores para serem salvos no arquivo
        List<Jogador> test;
        test = new ArrayList<>();

        Jogador i1 = new Jogador("joao");
        Jogador i2 = new Jogador(2, "debora",5, 472, 350);
        Jogador i3 = new Jogador(3, "miguel",10, 472, 350);
        test.add(i1);
        test.add(i2);
        test.add(i3);
        p.inserir(i1);
        p.inserir(i2);
        p.inserir(i3);
        List<Jogador> pers = new ArrayList<>();
//        System.out.println("======Lista========");
//        List<Jogador> jogador = p.lista();// lista todos os jogadores cadastrados
//        for (Jogador jogador2 : jogador) {
//            System.out.println(jogador2);
//        }
//        System.out.println("======Retorno do get========");
//        pers = p.getId(6); // busca o usuario passado por ID
//        pers.stream().forEach(System.out::println);
//        System.out.println("==============Depois do Delete ==================");
//        p.delete(2); // passa o ID para deletar a linha
//        System.out.println("=============Depois do UPDATE============");
//        Jogador i4 = new Jogador(1, "debora", 548, 472, 350); // cria o usuario que sera atualizado de acordo com o ID passado
//        p.update(i4);
//
//        for (Jogador jogador2 : jogador = p.lista()) {
//            System.out.println(jogador2);
//        }

    }
}
