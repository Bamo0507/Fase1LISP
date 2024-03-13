import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Tokenizer {
    // Método para dividir una cadena en tokens
    public List<String> tokenize(String input) {
        List<String> tokens = new ArrayList<>();
        StringBuilder currentToken = new StringBuilder();
        boolean inString = false;

        // Iterar sobre cada caracter del input
        for (char c : input.toCharArray()) {
            if (Character.isWhitespace(c)) {
                // Si no estamos dentro de una cadena, agregamos el token actual
                if (!inString && currentToken.length() > 0) {
                    tokens.add(currentToken.toString());
                    currentToken.setLength(0); // Limpiamos el StringBuilder
                }
            } else if (c == '(' || c == ')') {
                // Si no estamos dentro de una cadena, agregamos el token actual y el caracter de paréntesis
                if (!inString && currentToken.length() > 0) {
                    tokens.add(currentToken.toString());
                    currentToken.setLength(0);
                }
                tokens.add(String.valueOf(c));
            } else if (c == '"') {
                // Cambiamos el estado de inString para indicar que estamos dentro o fuera de una cadena
                inString = !inString;
                if (!inString && currentToken.length() > 0) {
                    tokens.add(currentToken.toString());
                    currentToken.setLength(0);
                }
                currentToken.append(c);
            } else {
                // Agregamos caracteres al token actual
                currentToken.append(c);
            }
        }

        // Agregamos el último token si hay alguno
        if (currentToken.length() > 0) {
            tokens.add(currentToken.toString());
        }

        // Verificamos si el token es una palabra clave o un número
        for (int i = 0; i < tokens.size(); i++) {
            String token = tokens.get(i);
            if (isKeyword(token)) {
                tokens.set(i, token); // No hay cambio de mayúsculas a minúsculas
            } else if (isNumber(token)) {
                // Convertimos a entero los números y eliminamos los ceros a la izquierda
                tokens.set(i, String.valueOf(Integer.parseInt(token)));
            }
        }

        return tokens;
    }

    // Método para verificar si un token es una palabra clave de Lisp
    private boolean isKeyword(String token) {
        return Arrays.asList("defun", "cond", "setq", "let", "if", "T", "NIL", "t", "progn").contains(token);
    }

    // Método para verificar si un token es un número
    private boolean isNumber(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}