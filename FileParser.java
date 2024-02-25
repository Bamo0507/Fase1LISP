import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileParser {
    private String archivo;

    public FileParser(String archivo) {
        this.archivo = archivo;
    }

    public String parse(){
        StringBuilder contenido = new StringBuilder();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        
        return contenido.toString();
    }
}