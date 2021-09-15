
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.nio.charset.Charset;
import java.nio.file.StandardOpenOption;
public class Ideia {
    private Path arquivo;
    private Charset encode;
    private final String titulo;
    private final String descricao;
    private final int urgencia;
    
    
    public Ideia(String titulo, String descricao, int urgencia) {
        Path pasta = Paths.get("aula1", "dados");
        this.titulo = titulo;
        this.descricao = descricao;
        this.urgencia = urgencia;
        this.arquivo = pasta.resolve("ideias.csv");
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public int getUrgencia() {
        return this.urgencia;
    }

// - gravar(List<ideia>): o método recebe uma lista de ideias e grava no arquivo
// “ideias.csv”, cada ideia será representa por uma linha com os seus campos
// separados
// por “;” (considere que os campos textuais de Ideia não possuem esse
// caractere) no
// seguinte formato: titulo;descricao;urgencia. Considere que a gravação do
// arquivo vai
// ignorar dados que existam anteriormente no arquivo.
// - inserir(): o método adiciona ao final do arquivo uma linha com os dados da
// Ideia.
// - listar(): método que lê os dados do arquivo e para cada linha cria um
// objeto de Ideia
// com os seus campos (atributos) preenchidos e o adiciona a um List de contatos
// que será
// retornado pelo método.
  

    public void gravar(List<Ideia> ide) throws IOException {
   
        Files.writeString(this.arquivo, ide.toString().replace("[", "").replace("]", "").replace(", ", ""));
    }
    @Override
    public String toString() {
        return getTitulo() + ";" + getDescricao() + ";" + getUrgencia() + "\n";
    }


   public void inserir() throws IOException {
       String aux = this.titulo+";"+this.descricao+";"+this.urgencia+"\n";
       Files.writeString(this.arquivo, aux, StandardOpenOption.APPEND);
   }
}
