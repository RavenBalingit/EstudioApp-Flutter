package main;
import java.util.List;

// Manages the state of a study session, including progress and current exercise.
public class StudySessionManager {
    private BloqueTematico bloqueTematico;     // The topic being studied.
    private TipoEjercicio tipoEjercicio;     // The type of exercise being done.
    private BancoDeEstudio bancoDeEstudio;   // Reference to the data store.

    // Lists to hold the exercises for the current session.
    private List<PreguntaTest> preguntasTestActuales;
    private List<EjercicioRellenarCodigo> ejerciciosRellenarActuales;
    private int indiceActual;                // Index of the current exercise in the list.

    // Statistics for the session.
    private int respuestasCorrectas;
    private int respuestasIncorrectas;

    // Constructor: Initializes the session with topic, type, and loads data.
    public StudySessionManager(BloqueTematico bloque, TipoEjercicio tipo) {
        this.bloqueTematico = bloque;
        this.tipoEjercicio = tipo;
        this.bancoDeEstudio = new BancoDeEstudio(); // Create the data store.
        this.indiceActual = 0;                      // Start at the first exercise.
        this.respuestasCorrectas = 0;
        this.respuestasIncorrectas = 0;
        cargarEjercicios();                         // Load the relevant exercises.
    }

    // Loads the appropriate list of exercises from the BancoDeEstudio based on type and topic.
    private void cargarEjercicios() {
        if (tipoEjercicio == TipoEjercicio.TEST) {
            preguntasTestActuales = bancoDeEstudio.getPreguntasTest(bloqueTematico);
        } else if (tipoEjercicio == TipoEjercicio.RELLENAR_CODIGO) {
            ejerciciosRellenarActuales = bancoDeEstudio.getEjerciciosRellenarCodigo(bloqueTematico);
        }
        // Reset index and stats when loading new exercises.
        this.indiceActual = 0;
        this.respuestasCorrectas = 0;
        this.respuestasIncorrectas = 0;
    }

    // Checks if there are any exercises loaded for the current session settings.
    public boolean hayEjerciciosDisponibles() {
        if (tipoEjercicio == TipoEjercicio.TEST) {
            return preguntasTestActuales != null && !preguntasTestActuales.isEmpty();
        } else if (tipoEjercicio == TipoEjercicio.RELLENAR_CODIGO) {
            return ejerciciosRellenarActuales != null && !ejerciciosRellenarActuales.isEmpty();
        }
        return false; // No exercises loaded.
    }

    // Returns the current study item (question or exercise) based on the index.
    public ItemEstudio getEjercicioActual() {
        if (tipoEjercicio == TipoEjercicio.TEST) {
            // Return the test question if the index is valid.
            if (preguntasTestActuales != null && indiceActual < preguntasTestActuales.size()) {
                return preguntasTestActuales.get(indiceActual);
            }
        } else if (tipoEjercicio == TipoEjercicio.RELLENAR_CODIGO) {
            // Return the code exercise if the index is valid.
            if (ejerciciosRellenarActuales != null && indiceActual < ejerciciosRellenarActuales.size()) {
                return ejerciciosRellenarActuales.get(indiceActual);
            }
        }
        return null; // No more exercises or list is empty.
    }

    // Moves to the next exercise in the list.
    public void avanzarSiguienteEjercicio() {
        indiceActual++;
    }

    // Checks if the current exercise is the last one in the list.
    public boolean esUltimoEjercicio() {
        if (tipoEjercicio == TipoEjercicio.TEST) {
            return preguntasTestActuales == null || indiceActual >= preguntasTestActuales.size() - 1;
        } else if (tipoEjercicio == TipoEjercicio.RELLENAR_CODIGO) {
            return ejerciciosRellenarActuales == null || indiceActual >= ejerciciosRellenarActuales.size() - 1;
        }
        return true; // Default to true if no exercises.
    }

    // Returns the type of exercise for the current session.
    public TipoEjercicio getTipoEjercicioActual() {
        return tipoEjercicio;
    }

     // Returns the total number of exercises in the current session.
     public int getNumeroTotalEjercicios() {
        if (tipoEjercicio == TipoEjercicio.TEST) {
            return preguntasTestActuales != null ? preguntasTestActuales.size() : 0;
        } else if (tipoEjercicio == TipoEjercicio.RELLENAR_CODIGO) {
            return ejerciciosRellenarActuales != null ? ejerciciosRellenarActuales.size() : 0;
        }
        return 0;
    }

    // Returns the index (0-based) of the currently displayed exercise.
    public int getIndiceEjercicioActual() {
        return indiceActual;
    }

    // Records whether the user's answer to the current exercise was correct.
    public void registrarRespuesta(boolean correcta) {
        if (correcta) {
            respuestasCorrectas++;
        } else {
            respuestasIncorrectas++;
        }
    }

    // --- Getters for Session Statistics ---
    public int getRespuestasCorrectas() {
        return respuestasCorrectas;
    }

    public int getRespuestasIncorrectas() {
        return respuestasIncorrectas;
    }

    public int getTotalIntentos() {
        return respuestasCorrectas + respuestasIncorrectas;
    }

    // Calculates and returns the percentage of correct answers.
    public double getPorcentajeAciertos() {
        int totalIntentos = getTotalIntentos();
        if (totalIntentos == 0) {
            return 0.0; // Avoid division by zero.
        }
        return ((double) respuestasCorrectas / totalIntentos) * 100.0;
    }
}