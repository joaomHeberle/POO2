import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Path dir1= Paths.get("aula1","aula1","dados");
        
        // Path dirNovo = dir1.resolve("dados");
        // if(! Files.exists(dirNovo)){
        //     Files.createDirectories(dirNovo);
        // }
        Path arquivo = dir1.resolve("ideias.csv");
        if(! Files.exists(arquivo)){
            Files.createFile(arquivo);
        }
    }
}
