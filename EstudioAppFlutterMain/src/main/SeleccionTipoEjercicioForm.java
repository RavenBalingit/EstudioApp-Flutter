package main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// Dialog window to select the type of exercise (Test or Fill-in-the-Blanks).
public class SeleccionTipoEjercicioForm extends JDialog {

    private BloqueTematico bloqueSeleccionado; // The topic chosen in the previous window.
    private JFrame parentForm;                 // Reference to the main window.

    // Constructor.
    public SeleccionTipoEjercicioForm(JFrame parent, BloqueTematico bloque) {
        super(parent, "Seleccionar Tipo de Ejercicio", true); // Modal dialog
        this.parentForm = parent;
        this.bloqueSeleccionado = bloque;

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // Dispose on close, don't exit app.
        setSize(400, 200);
        setLocationRelativeTo(parent); // Center relative to parent
        setLayout(new BorderLayout(10, 10));

        // Panel for the buttons.
        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Padding

        // Create buttons for exercise types.
        JButton btnPreguntasTest = new JButton(TipoEjercicio.TEST.toString());
        JButton btnRellenarCodigo = new JButton(TipoEjercicio.RELLENAR_CODIGO.toString());

        // Set button font.
        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        btnPreguntasTest.setFont(buttonFont);
        btnRellenarCodigo.setFont(buttonFont);

        // Add action listeners to start the study session.
        btnPreguntasTest.addActionListener(e -> iniciarSesionEstudio(TipoEjercicio.TEST));
        btnRellenarCodigo.addActionListener(e -> iniciarSesionEstudio(TipoEjercicio.RELLENAR_CODIGO));

        // Add buttons to panel.
        buttonPanel.add(btnPreguntasTest);
        buttonPanel.add(btnRellenarCodigo);

        // Title label showing the selected topic.
        JLabel lblTitle = new JLabel("Tema: " + bloque.toString(), SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitle.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        // Add components to dialog.
        add(lblTitle, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        // Add a window listener to show the parent form when this dialog is closed.
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                showParentFormIfNotStudying();
            }
            @Override
            public void windowClosing(WindowEvent e) {
                 showParentFormIfNotStudying();
            }
        });
    }

    // Starts the study session by creating a manager and opening the question display form.
    private void iniciarSesionEstudio(TipoEjercicio tipo) {
        dispose(); // Close this selection dialog.
        // Create the session manager with the selected topic and exercise type.
        StudySessionManager manager = new StudySessionManager(bloqueSeleccionado, tipo);

        // Check if there are exercises available for the selection.
        if (!manager.hayEjerciciosDisponibles()) {
            JOptionPane.showMessageDialog(parentForm,
                "No hay ejercicios disponibles para la selección:\n" + bloqueSeleccionado + " - " + tipo,
                "Sin Ejercicios",
                JOptionPane.INFORMATION_MESSAGE);
            // Show the main form again if no exercises were found.
            if (parentForm != null) {
                parentForm.setVisible(true);
            }
            return; // Stop if no exercises.
        }
        // Create and show the question display form. Pass the parent form reference.
        new QuestionDisplayForm(parentForm, manager, true).setVisible(true);
    }

     // Helper method to decide whether to show the parent (MainForm)
     // Ensures parent isn't shown if the QuestionDisplayForm is still active.
    private void showParentFormIfNotStudying() {
        boolean questionDisplayActive = false;
        // Check if any QuestionDisplayForm window is currently visible.
        for (Window window : Window.getWindows()) {
            if (window instanceof QuestionDisplayForm && window.isVisible()) {
                questionDisplayActive = true;
                break;
            }
        }
        // Show the parent form only if the QuestionDisplayForm is NOT active.
        if (parentForm != null && !questionDisplayActive) {
            parentForm.setVisible(true);
        }
    }
}