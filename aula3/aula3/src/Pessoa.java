public class Pessoa {
    private final int id;
    private final String nome;
    private final Sexo sexo;

    public Pessoa(int id, String nome, Sexo sexo) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
    }

    public static Pessoa fromLine(String[] linha) {

        return new Pessoa(Integer.parseInt(linha[0]),
         linha[1],
         Sexo.valueOf(linha[2]));

    }

    public int getId() {
        return this.id;
    }



    public String getNome() {
        return this.nome.toUpperCase();
    }

    public Sexo getSexo() {
        return this.sexo;
    }

    @Override
    public String toString() {
        return
            " id='" + getId() + "'" +
            ", nome='" + getNome() + "'" +
            ", sexo='" + getSexo() + "'" ;
    }

}
