// Abstract base class for all study items (questions, exercises).
package main;

public abstract class ItemEstudio {
    protected String enunciado; // The statement or title of the study item.

    // Constructor for the study item.
    public ItemEstudio(String enunciado) {
        this.enunciado = enunciado;
    }

    // Getter for the statement/title.
    public String getEnunciado() {
        return enunciado;
    }
}