import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        String filePath = "Fibonacci.lsp";
        FileParser fileParser = new FileParser(filePath);
        String fileContent = fileParser.parse();
        
        // Aquí puedes procesar el contenido del archivo como desees
        System.out.println("Contenido del archivo:");
        System.out.println();
        System.out.println(fileContent);
        System.out.println();

    

        System.out.println(tokens);

    }
}
