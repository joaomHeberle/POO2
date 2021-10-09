import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Persistencia {
    private Path arquivo;
    private Charset encode;

    public Persistencia() {
        Path pasta = Paths.get("banco");
        this.encode = Charset.forName("UTF-8");
        this.arquivo = pasta.resolve("jogador.csv");
    }
    
    public void criaPasta() throws IOException {
        Path dir1 = Paths.get("banco");

        if (!Files.exists(dir1)) {
            Files.createDirectories(dir1);
        }

    }

    public void criaArquivo() throws IOException {
        Path dir1 = Paths.get("banco");
        Path arquivo = dir1.resolve("jogador.csv");
        if (!Files.exists(arquivo)) {
            Files.createFile(arquivo);
        }
    }

    public void inserir(Jogador i) throws IOException {
        Path dir1 = Paths.get("banco");
        Path arquivo = dir1.resolve("jogador.csv");
        String aux = i.getIdPersonagem() + ";" + i.getNome() + ";" + i.getNivel() + ";" 
        + i.getQtdMoedas() + ";" + i.getExpNovoNivel() + "\n";
        Files.writeString(arquivo, aux, StandardOpenOption.APPEND);

    }
    // ◦ get(id): que recebe um id (inteiro) e retorna um objeto da classe de modelo (considere a
    // criação de um campo id que é único e como seria possível gerenciar isso);
    // ◦ update(obj): que altera a linha do objeto de id passado por parâmetro para os novos valores
    // armazenados em obj;
    // ◦ delete(id): que deleta do arquivo a linha do id passado por parâmetro;
    public Jogador getId(int id){
        return null;
    }
    public Jogador update(int id){
        return null;
    }
    public Jogador delete(int id){
        return null;
    }
    public List<Jogador> lista() throws IOException {
        List<String> dados;
        List<Jogador> play = new ArrayList<Jogador>();
        try {
            dados = Files.readAllLines(this.arquivo, this.encode);

        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException("erro: problemas ao abrir o arquivo:");
        }
        for (String linha : dados) {
            String[] campos = linha.split(";");

            Jogador i = new Jogador(Integer.parseInt(campos[0]), campos[1], Integer.parseInt(campos[2]),
                    Integer.parseInt(campos[3]), Integer.parseInt(campos[4]));
            play.add(i);

      
        }
        return play;
    }
}
