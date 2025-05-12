package main;
import java.util.List;
import java.util.Map;
import java.util.Objects;

// Represents a fill-in-the-blanks code exercise.
public class EjercicioRellenarCodigo extends ItemEstudio {
    private String codigoConHuecos;          // The code snippet with blanks (e.g., "________ // 1").
    private List<String> elementosSugeridos; // Suggested words/code snippets for the blanks.
    private Map<Integer, String> soluciones; // Map where key is the blank number and value is the correct solution.

    // Constructor for a code-filling exercise.
    public EjercicioRellenarCodigo(String enunciado, String codigoConHuecos, List<String> elementosSugeridos, Map<Integer, String> soluciones) {
        super(enunciado);
        this.codigoConHuecos = codigoConHuecos;
        this.elementosSugeridos = elementosSugeridos;
        this.soluciones = soluciones;
    }

    // Getter for the code with blanks.
    public String getCodigoConHuecos() {
        return codigoConHuecos;
    }

    // Getter for the suggested elements.
    public List<String> getElementosSugeridos() {
        return elementosSugeridos;
    }

    // Getter for the solutions map.
    public Map<Integer, String> getSoluciones() {
        return soluciones;
    }

    // Returns the total number of blanks in the exercise.
    public int getNumeroDeHuecos() {
        return soluciones.size();
    }

    // Verifies if the user's filled answers match the correct solutions.
    public boolean verificarRespuestas(Map<Integer, String> respuestasUsuario) {
        // Check if the number of user answers matches the number of blanks.
        if (respuestasUsuario.size() != soluciones.size()) {
            return false; // Different number of answers means incorrect.
        }

        // Iterate through each correct solution.
        for (Map.Entry<Integer, String> solucionEntry : soluciones.entrySet()) {
            Integer numeroHueco = solucionEntry.getKey();
            String respuestaCorrecta = solucionEntry.getValue();
            // Get the user's answer for the current blank number.
            String respuestaUsuario = respuestasUsuario.get(numeroHueco);

            // If the user didn't provide an answer or it doesn't match (ignoring case and whitespace), return false.
            if (respuestaUsuario == null || !respuestaCorrecta.trim().equalsIgnoreCase(respuestaUsuario.trim())) {
                return false; // Mismatch found.
            }
        }
        // If all answers matched, return true.
        return true;
    }
}