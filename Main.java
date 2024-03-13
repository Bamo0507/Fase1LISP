import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Ejemplo de uso del Tokenizer y LispInterpreter
        Tokenizer tokenizer = new Tokenizer();

        FileParser parser = new FileParser("condicional.lisp");

        // Cadena de ejemplo con una función Lisp
        String input = parser.parse();

        // Obtener los tokens
        List<String> tokens = tokenizer.tokenize(input);
        System.out.println("Tokens: " + tokens);
    }
}