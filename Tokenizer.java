import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Tokenizer {
    // Método para dividir una cadena en tokens
    public List<String> tokenize(String input) {
        List<String> tokens = new ArrayList<>();
        StringBuilder currentToken = new StringBuilder();
        boolean inWord = false;

        // Iterar sobre cada caracter del input
        for (char c : input.toCharArray()) {
            // Ignorar espacios en blanco
            if (c == ' ' || c == '(' || c == ')') {
                // Si hay un token actual, agregarlo a la lista de tokens
                if (currentToken.length() > 0) {
                    tokens.add(currentToken.toString());
                    currentToken = new StringBuilder();
                    inWord = false;
                }
                // Si el caracter es un paréntesis, agregarlo como un token separado
                if (c == '(' || c == ')') {
                    tokens.add(String.valueOf(c));
                }
            } else {
                // Agregar caracteres al token actual
                currentToken.append(c);
                inWord = true;
            }
        }

        // Agregar el último token si hay alguno
        if (currentToken.length() > 0) {
            tokens.add(currentToken.toString());
        }

        return tokens;
    }
}