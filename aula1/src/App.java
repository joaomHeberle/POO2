import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class App {

 
    public static void main(String[] args) throws Exception {
        List<Ideia> test;
        test = new ArrayList<>();
 
        Path dir1= Paths.get("aula1");
        
        Path dirNovo = dir1.resolve("dados");
        if(! Files.exists(dirNovo)){
            Files.createDirectories(dirNovo);
        }
        Path dirArquivo = Paths.get("aula1", "dados");
        Path arquivo = dirArquivo.resolve("ideias.csv");
        if(! Files.exists(arquivo)){
            Files.createFile(arquivo);
        }
        

        Ideia i1 = new Ideia("mundo", "acabou", 2);
        Ideia i2 = new Ideia("noia", "crack", 2);
        Ideia i3 = new Ideia("bako", "gan", 2);
        test.add(i1);
        test.add(i2);
        test.add(i3);
        i1.gravar(test);
        i2.inserir();
        List<Ideia> testa;
        testa = new ArrayList<>();

testa=i2.lista();
        System.out.println( testa);

     
    }
}
