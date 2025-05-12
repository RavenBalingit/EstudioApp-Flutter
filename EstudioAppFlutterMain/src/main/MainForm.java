package main;
import javax.swing.*;
import java.awt.*;

// The main window of the application, allowing topic selection.
public class MainForm extends JFrame {

    public MainForm() {
        setTitle("Aplicación de Estudio - Flutter"); // Updated Title
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 250); // Initial size
        setLocationRelativeTo(null); // Center on screen
        setLayout(new BorderLayout(10, 10)); // Layout with spacing

        // Panel to hold the topic selection buttons.
        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 10, 10)); // Changed to 4 rows for new topics + Ambos
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Padding

        // Create buttons for each Flutter topic.
        JButton btnEstudiarI18n = new JButton(BloqueTematico.I18N_L10N.toString());
        JButton btnEstudiarApi = new JButton(BloqueTematico.API_REST_JSON.toString());
        JButton btnEstudiarBuild = new JButton(BloqueTematico.BUILD_APK_AAB.toString());
        JButton btnEstudiarAmbos = new JButton(BloqueTematico.AMBOS.toString());

        // Set a consistent font for buttons.
        Font buttonFont = new Font("Arial", Font.BOLD, 14); // Slightly smaller font
        btnEstudiarI18n.setFont(buttonFont);
        btnEstudiarApi.setFont(buttonFont);
        btnEstudiarBuild.setFont(buttonFont);
        btnEstudiarAmbos.setFont(buttonFont);

        // Add action listeners to open the exercise type selection window.
        btnEstudiarI18n.addActionListener(e -> abrirVentanaSeleccion(BloqueTematico.I18N_L10N));
        btnEstudiarApi.addActionListener(e -> abrirVentanaSeleccion(BloqueTematico.API_REST_JSON));
        btnEstudiarBuild.addActionListener(e -> abrirVentanaSeleccion(BloqueTematico.BUILD_APK_AAB));
        btnEstudiarAmbos.addActionListener(e -> abrirVentanaSeleccion(BloqueTematico.AMBOS));

        // Add buttons to the panel.
        buttonPanel.add(btnEstudiarI18n);
        buttonPanel.add(btnEstudiarApi);
        buttonPanel.add(btnEstudiarBuild);
        buttonPanel.add(btnEstudiarAmbos);

        // Title label.
        JLabel lblTitle = new JLabel("Selecciona un Bloque Temático de Flutter", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitle.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0)); // Padding

        // Add components to the frame.
        add(lblTitle, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        // Make the window visible.
        setVisible(true);
    }

    // Opens the next window to select the exercise type, hiding the current one.
    private void abrirVentanaSeleccion(BloqueTematico bloque) {
        this.setVisible(false); // Hide this main form.
        // Create and show the exercise type selection form.
        new SeleccionTipoEjercicioForm(this, bloque).setVisible(true);
    }
}