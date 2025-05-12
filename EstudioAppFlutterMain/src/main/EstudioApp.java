package main;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

// Main application class to launch the study app.
public class EstudioApp {
    public static void main(String[] args) {
        // Ensure GUI updates happen on the Event Dispatch Thread.
        SwingUtilities.invokeLater(() -> {
            try {
                // Set the look and feel to match the native system for better user experience.
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                // Print an error message if the system look and feel cannot be set.
                System.err.println("No se pudo establecer el Look and Feel del sistema: " + e.getMessage());
            }
            // Create and display the main form.
            new MainForm();
        });
    }
}