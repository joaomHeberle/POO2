
public class Jogador {
    private int idPersonagem;
    private final String nome;
    private int nivel;
    private int qtdMoedas;
    private int expNovoNivel;
    private static int contId;
 


    public Jogador(int idPersonagem, String nome, int nivel,  int qtdMoedas,int expNovoNivel) {

        this.expNovoNivel = expNovoNivel;
        this.nivel = nivel;
        this.nome = nome;
        this.qtdMoedas = qtdMoedas;
        this.idPersonagem = idPersonagem;
        
        contId++;
    }   
 public Jogador(String nome) {
     this.nome=nome;
     this.nivel=0;
     this.qtdMoedas=0;
     this.idPersonagem=contId;
     this.expNovoNivel=0;

        contId++;
 }

    public int getExpNovoNivel() {
        return this.expNovoNivel;
    }

    public int getIdPersonagem() {
        return this.idPersonagem;
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
        return " Experiencia:" + getExpNovoNivel() + ", nivel:" + getNivel()  + ", nome:" + getNome()
                 + ", Moedas:" + getQtdMoedas() + ";";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Jogador)) {
            return false;
        }
        Jogador jogador = (Jogador) o;
        return jogador.idPersonagem == jogador.idPersonagem;
    }

   
}
