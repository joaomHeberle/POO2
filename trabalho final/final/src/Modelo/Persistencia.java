package Modelo;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Persistencia{
    private Path arquivo;
    private Charset encode;

    public Persistencia() {
        
        Path pasta = Paths.get("banco");
        this.encode = Charset.forName("UTF-8");
        this.arquivo = pasta.resolve("jogador.csv");
    }

    public Path getArquivo() {
        return this.arquivo;
    }

    public Charset getEncode() {
        return this.encode;
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
        String aux = (i.verMaiorID() + 1) + ";" + i.getNome() + ";" + i.getNivel() + ";" + i.getQtdMoedas() + ";"
                + i.getExpNovoNivel() + "\n";
        Files.writeString(arquivo, aux, StandardOpenOption.APPEND);

    }

    public static Jogador fromLine(String[] campos) {

        return new Jogador(Integer.parseInt(campos[0]), campos[1], Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]), Integer.parseInt(campos[4]));

    }

    public List<Jogador> getId(int id) throws IOException {
        Path arq = Paths.get("banco", "jogador.csv");

        List<Jogador> lista = Files.lines(arq).map(l -> fromLine(l.split(";"))).filter(j -> j.getIdJogador() == id)
                .collect(Collectors.toList());

        return lista;
    }

    public void update(Jogador up) throws IOException {
 
   
       Path arq = Paths.get("banco", "jogador.csv");

       List<Jogador> lista = Files.lines(arq)
       .map(l -> fromLine(l.split(";")))
        .collect(Collectors.toList());

        String aux = "";

        for (int tam = 0; tam < lista.size(); tam++) {
            if(up.getIdJogador()==lista.get(tam).getIdJogador()){
                aux += up.getIdJogador() + ";" + up.getNome() + ";" + up.getNivel() + ";"
                + up.getQtdMoedas()+ ";" + up.getExpNovoNivel() + "\n";
            } else{
                aux += lista.get(tam).getIdJogador() + ";" + lista.get(tam).getNome() + ";" + lista.get(tam).getNivel() + ";"
                + lista.get(tam).getQtdMoedas() + ";" + lista.get(tam).getExpNovoNivel() + "\n";
            }
            
        }

        Files.writeString(arquivo, aux);
   
    }

    public void delete(int id) throws IOException {

        Path arq = Paths.get("banco", "jogador.csv");

        List<Jogador> lista = Files.lines(arq).map(l -> fromLine(l.split(";"))).filter(j -> j.getIdJogador() != id)
                .collect(Collectors.toList());
       
        lista.stream().forEach(System.out::println);
        inserirApagando(lista);

    }

    private void inserirApagando(List<Jogador> i) throws IOException {

        String aux = "";

        for (int tam = 0; tam < i.size(); tam++) {
            aux += i.get(tam).getIdJogador() + ";" + i.get(tam).getNome() + ";" + i.get(tam).getNivel() + ";"
                    + i.get(tam).getQtdMoedas() + ";" + i.get(tam).getExpNovoNivel() + "\n";
        }

        Files.writeString(arquivo, aux);

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
