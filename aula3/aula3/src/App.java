import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;


public class App {
    private static <T> T func(Funcional<T> func, T op1, T op2) {
        return (T) func.doisParaUm(op1, op2);
    }

    public static void main(String[] args) throws Exception {
// 3.3 -Tente realizar os lambdas e Streams desenvovidos no item 3.2, 
// por fim, crie um Stream que processe o arquivo da seguinte maneira: retorne uma 
// List<Pessoa> com as pessoas com nomes compostos por ao
// menos 2 palavras e do sexo masculino. Essa lista deve estar com os 
// nomes em maiúsculo.

// Funcional<Double> lambda = (op1,op2)->{
//     return op1+op2;
// };
// System.out.println(func(lambda,2.4,2.5));
System.out.println(func((a,b)->a+b,3,8));
Path dir1= Paths.get("src");
        
        Path dirNovo = dir1.resolve("dados");
        if(! Files.exists(dirNovo)){
            Files.createDirectories(dirNovo);
        }
        Path dirArquivo = Paths.get("src", "dados");
        Path arquivo = dirArquivo.resolve("dados.txt");
        if(! Files.exists(arquivo)){
            Files.createFile(arquivo);
        }
Path arq = Paths.get("src", "dados","dados.txt");

Files.lines(arq).forEach(System.out::println);
System.out.println("===================");
List<Pessoa> lista = Files.lines(arq)
.map(l -> Pessoa.fromLine(l.split(";")))
.filter(p -> p.getNome().contains(" "))
.filter(p-> p.getSexo()==Sexo.MASCULINO)
.collect(Collectors.toList());

lista.stream().forEach(System.out::println);
    }
}
