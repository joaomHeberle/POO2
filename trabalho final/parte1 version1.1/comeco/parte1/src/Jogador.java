import java.nio.file.Files;
import java.util.List;

public class Jogador {
    private int idJogador;
    private String nome;
    private int nivel;
    private int qtdMoedas;
    private int expNovoNivel;

    public int verMaiorID() {
        int i = 0, aux = 0;

        List<String> dados;
        Persistencia p = new Persistencia();

        try {
            dados = Files.readAllLines(p.getArquivo(), p.getEncode());

        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException("erro: problemas ao abrir o arquivo:");
        }
        for (String linha : dados) {
            String[] campos = linha.split(";");

            i = Integer.parseInt(campos[0]);
            if (i < aux) {
                i = aux;

            }

        }

        return i;
    }

    public Jogador(int idJogador, String nome, int nivel, int qtdMoedas, int expNovoNivel) {

        this.expNovoNivel = expNovoNivel;
        this.nivel = nivel;
        this.nome = nome;
        this.qtdMoedas = qtdMoedas;
        this.idJogador = idJogador;

    }
  
    public Jogador(String nome) {

        this.nome = nome;
        this.nivel = 0;
        this.qtdMoedas = 0;
        this.idJogador = verMaiorID() + 1;
        this.expNovoNivel = 0;

    }

    public int getExpNovoNivel() {
        return this.expNovoNivel;
    }

    public int getIdJogador() {
        return this.idJogador;
    }

    public int getNivel() {
        return this.nivel;
    }

    public String getNome() {
        return this.nome;
    }

    public int getQtdMoedas() {
        return this.qtdMoedas;
    }

    @Override
    public String toString() {
        return "ID=: " + getIdJogador() + " Experiencia:" + getExpNovoNivel() + " nivel:" + getNivel() + " nome:"
                + getNome() + " Moedas:" + getQtdMoedas() + "\n";
    }

}
