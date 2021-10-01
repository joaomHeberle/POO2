
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

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
        this.encode = Charset.forName("UTF-8");
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

   public List<Ideia> lista() throws IOException{
    List<String> dados;
    List<Ideia> idei = new ArrayList<>();
    try {
        dados = Files.readAllLines(this.arquivo,this.encode);
        
    } catch (Exception e) {
        System.out.println(e);
        throw new RuntimeException("erro: problemas ao abrir o arquivo:");
    }
    for (String linha : dados) {
        String[] campos = linha.split(";");
   
        Ideia i = new Ideia(campos[0],campos[1],Integer.parseInt(campos[2]));
        idei.add(i);
    }

    
     
    
    
    return idei;
   }
}
