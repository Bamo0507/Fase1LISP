import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {
    private String input;

    public Tokenizer(String input) {
        this.input = input;
    }

    public ArrayList<String> tokenize() {
        //Se implementa un ArrayList, como fue descrito en la Fase 1
        ArrayList<String> tokens = new ArrayList<>(); //Ayudará a tener los tokens separados entre sí
        // Patrón para reconocer tokens
        Pattern pattern = Pattern.compile("\\(|\\)|[\\w+-/*<>=]+|\"[^\"]*\"");

        Matcher matcher = pattern.matcher(input);
        
        while (matcher.find()) {
            String token = matcher.group();
            token = token.trim(); // Eliminar espacios al principio y al final del token
            if (!token.isEmpty()) {
                tokens.add(token);
            }
        }

        for (String t : tokens) {
            String sinEspacio = t.trim();
            int indice = tokens.indexOf(t);
            tokens.set(indice, sinEspacio);
        }
        
        for (String t : tokens) {
            System.out.println(t);
        }

        return tokens;
    }
}
