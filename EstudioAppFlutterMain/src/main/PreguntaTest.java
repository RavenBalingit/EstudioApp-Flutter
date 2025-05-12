package main;
import java.util.List;

// Represents a multiple-choice test question.
public class PreguntaTest extends ItemEstudio {
    private List<String> opciones;       // List of possible answers.
    private String respuestaCorrecta;  // The correct answer string.

    // Constructor for a test question.
    public PreguntaTest(String enunciado, List<String> opciones, String respuestaCorrecta) {
        super(enunciado);
        this.opciones = opciones;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    // Getter for the options.
    public List<String> getOpciones() {
        return opciones;
    }

    // Getter for the correct answer.
    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    // Verifies if the user's answer matches the correct answer (case-insensitive).
    public boolean verificarRespuesta(String respuestaUsuario) {
        // Trim whitespace and compare ignoring case.
        return respuestaCorrecta.equalsIgnoreCase(respuestaUsuario.trim());
    }
}