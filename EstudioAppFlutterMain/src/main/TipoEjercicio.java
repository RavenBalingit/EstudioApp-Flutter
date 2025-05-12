// Enum defining the types of exercises available.
package main;

public enum TipoEjercicio {
    TEST("Preguntas Test"),
    RELLENAR_CODIGO("Rellenar Código");

    private final String displayName;

    // Constructor for the enum constant.
    TipoEjercicio(String displayName) {
        this.displayName = displayName;
    }

    // Returns the display-friendly name of the exercise type.
    @Override
    public String toString() {
        return displayName;
    }
}