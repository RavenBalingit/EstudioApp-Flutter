// Enum defining the different thematic blocks available for study.
package main;

public enum BloqueTematico {
    I18N_L10N("Internacionalización y Localización"),
    API_REST_JSON("API REST y JSON"),
    BUILD_APK_AAB("Creación y Publicación APK/AAB"),
    AMBOS("Todos los Temas"); // Option to study all topics combined.

    private final String displayName;

    // Constructor for the enum constant.
    BloqueTematico(String displayName) {
        this.displayName = displayName;
    }

    // Returns the display-friendly name of the topic.
    @Override
    public String toString() {
        return displayName;
    }
}