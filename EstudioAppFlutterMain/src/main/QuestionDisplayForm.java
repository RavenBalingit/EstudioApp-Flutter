package main;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat; // Para formatear el porcentaje
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects; // Import required for Objects.requireNonNullElse


// Dialog window where the actual studying takes place (displaying questions/exercises).
public class QuestionDisplayForm extends JDialog {

    private JFrame parentForm;             // Reference to the main window (or selection window).
    private StudySessionManager manager;   // Manages the current session's state.

    // --- GUI Components ---
    private JLabel lblContadorPreguntas;       // Displays "Question X of Y".
    private JTextPane textPaneEnunciadoCodigo; // Displays question text or code snippet.
    private JPanel panelOpcionesEntradas;      // Holds radio buttons or drop targets.
    private JScrollPane scrollPaneOpcionesEntradas; // Scroll pane for options/inputs.
    private JButton btnVerificar;              // Button to check the answer.
    private JButton btnSiguiente;              // Button to move to the next item.
    private JLabel lblFeedback;                // Shows "Correct!", "Incorrect.", etc.
    private JScrollPane scrollPaneSugerencias; // Scroll pane for suggested words (drag & drop).
    private JPanel panelPalabrasSugeridas;    // Panel holding the draggable word labels.

    // --- State Variables ---
    private ButtonGroup grupoOpcionesTest;       // Groups radio buttons for multiple choice.
    private List<JRadioButton> radioButtonsOpciones; // List of radio buttons.

    private List<DropTargetPanel> dropTargetPanels; // Panels where words can be dropped.
    private Map<DropTargetPanel, JLabel> droppedWordsMap; // Tracks which word label is in which panel.
    private EjercicioRellenarCodigo currentEjercicioRellenar; // The current fill-in-the-blanks exercise.
    private List<JLabel> draggableWordLabels;     // Labels for the suggested words.

    // Constructor.
    public QuestionDisplayForm(JFrame parent, StudySessionManager manager, boolean visible) {
        super(parent, "Sesión de Estudio - Flutter", true); // Updated title
        this.parentForm = parent;
        this.manager = manager;
        this.droppedWordsMap = new HashMap<>();
        this.draggableWordLabels = new ArrayList<>();

        // Exit early if manager is null and we intended to show the window.
        if (manager == null && visible) {
            System.err.println("Error: StudySessionManager es nulo.");
            // Optionally show an error message to the user here.
            dispose(); // Close the dialog if initialization fails.
            return;
        }

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(850, 750); // Set window size.
        setLocationRelativeTo(parent); // Center relative to parent.
        setLayout(new BorderLayout(10, 10)); // Main layout.

        initComponents(); // Initialize all GUI components.
        if (manager != null) {
             cargarSiguientePregunta(); // Load the first question/exercise.
        }

        // Add listener to handle window closing event.
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                // Show the parent form when this window is closed.
                if (parentForm != null) {
                    parentForm.setVisible(true);
                }
            }
            @Override
            public void windowClosing(WindowEvent e) {
                // Also handle the 'X' button closing.
                if (parentForm != null) {
                    parentForm.setVisible(true);
                }
            }
        });
    }

    // Sets up the GUI components.
    private void initComponents() {
        // --- Top Panel (Counter and Suggestions) ---
        JPanel panelSuperior = new JPanel(new BorderLayout());
        lblContadorPreguntas = new JLabel("Ejercicio X de Y", SwingConstants.CENTER);
        lblContadorPreguntas.setFont(new Font("Arial", Font.BOLD, 16));
        panelSuperior.add(lblContadorPreguntas, BorderLayout.NORTH);

        // Panel and scroll pane for suggested words (initially hidden).
        panelPalabrasSugeridas = new JPanel();
        panelPalabrasSugeridas.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5)); // Flow layout for words.
        scrollPaneSugerencias = new JScrollPane(panelPalabrasSugeridas);
        scrollPaneSugerencias.setBorder(BorderFactory.createTitledBorder("Arrastra las palabras a los huecos:"));
        scrollPaneSugerencias.setPreferredSize(new Dimension(getWidth(), 120)); // Fixed preferred height.
        panelSuperior.add(scrollPaneSugerencias, BorderLayout.SOUTH);
        scrollPaneSugerencias.setVisible(false); // Hide until needed.

        add(panelSuperior, BorderLayout.NORTH); // Add top panel to the main layout.

        // --- Center Panel (Question/Code Display) ---
        textPaneEnunciadoCodigo = new JTextPane();
        textPaneEnunciadoCodigo.setEditable(false); // User cannot edit the question/code.
        textPaneEnunciadoCodigo.setFont(new Font("Monospaced", Font.PLAIN, 14)); // Monospaced font for code.
        textPaneEnunciadoCodigo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Padding.
        JScrollPane scrollPaneEnunciado = new JScrollPane(textPaneEnunciadoCodigo); // Add scrolling.
        add(scrollPaneEnunciado, BorderLayout.CENTER); // Add to main layout.

        // --- Bottom Panel (Options/Inputs and Buttons) ---
        panelOpcionesEntradas = new JPanel(); // Panel for radio buttons or drop targets.
        panelOpcionesEntradas.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        scrollPaneOpcionesEntradas = new JScrollPane(panelOpcionesEntradas); // Add scrolling.

        // Panel for control buttons (Verify, Next) and feedback label.
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        btnVerificar = new JButton("Verificar Respuesta");
        btnSiguiente = new JButton("Siguiente Ejercicio"); // Text updated later if last question.

        lblFeedback = new JLabel(" ", SwingConstants.CENTER); // Feedback label (initially empty).
        lblFeedback.setFont(new Font("Arial", Font.BOLD, 14));
        lblFeedback.setPreferredSize(new Dimension(400, 25)); // Preferred size for layout.
        lblFeedback.setOpaque(false); // Transparent background.

        // Set button fonts.
        btnVerificar.setFont(new Font("Arial", Font.PLAIN, 14));
        btnSiguiente.setFont(new Font("Arial", Font.PLAIN, 14));

        // Add action listeners for buttons.
        btnVerificar.addActionListener(e -> verificarRespuesta());
        btnSiguiente.addActionListener(e -> {
            if (manager != null) {
                manager.avanzarSiguienteEjercicio(); // Tell manager to move to next item.
                cargarSiguientePregunta();          // Load the new item into the GUI.
            }
        });

        // Add buttons and feedback label to the button panel.
        panelBotones.add(btnVerificar);
        panelBotones.add(btnSiguiente);
        panelBotones.add(lblFeedback);

        // Container for the bottom part (options/inputs + buttons).
        JPanel bottomContainer = new JPanel(new BorderLayout());
        bottomContainer.add(scrollPaneOpcionesEntradas, BorderLayout.CENTER); // Options/inputs area.
        bottomContainer.add(panelBotones, BorderLayout.SOUTH);                // Buttons area.
        add(bottomContainer, BorderLayout.SOUTH); // Add to main layout.
    }

    // Loads the next question or exercise from the manager into the GUI.
    private void cargarSiguientePregunta() {
        if (manager == null) return; // Safety check.
        ItemEstudio item = manager.getEjercicioActual(); // Get the current item.

        // If item is null, we've finished the session.
        if (item == null) {
            mostrarResumenSesion(); // Display session summary.
            return; // Exit the method.
        }

        // Reset state for the new item.
        resetUIState();

        // Update the counter label.
        lblContadorPreguntas.setText("Ejercicio " + (manager.getIndiceEjercicioActual() + 1) + " de " + manager.getNumeroTotalEjercicios());

        // Load content based on the type of study item.
        if (item instanceof PreguntaTest) {
            mostrarPreguntaTest((PreguntaTest) item);
        } else if (item instanceof EjercicioRellenarCodigo) {
            currentEjercicioRellenar = (EjercicioRellenarCodigo) item;
            mostrarEjercicioRellenar(currentEjercicioRellenar);
        }

         // Update "Next" button text if it's the last exercise.
         if (manager.esUltimoEjercicio()) {
            btnSiguiente.setText("Finalizar Sesión");
        } else {
            btnSiguiente.setText("Siguiente Ejercicio");
        }

        // Refresh layout and scroll positions.
        refreshLayout();
    }

    // Resets UI elements to their default state before loading a new item.
    private void resetUIState() {
        currentEjercicioRellenar = null;
        droppedWordsMap.clear();
        draggableWordLabels.clear();
        panelPalabrasSugeridas.removeAll(); // Clear suggested words panel.
        panelOpcionesEntradas.removeAll(); // Clear previous options/inputs.

        lblFeedback.setText(" "); // Reset feedback label.
        lblFeedback.setForeground(Color.BLACK);
        lblFeedback.setVisible(true); // Make sure feedback is visible (might be hidden on error).

        btnVerificar.setEnabled(true);  // Enable Verify button.
        btnSiguiente.setEnabled(false); // Disable Next button until verified.
        scrollPaneSugerencias.setVisible(false); // Hide suggestions pane by default.
    }

    // Refreshes the layout of panels and resets scroll positions.
    private void refreshLayout() {
        panelOpcionesEntradas.revalidate();
        panelOpcionesEntradas.repaint();
        panelPalabrasSugeridas.revalidate();
        panelPalabrasSugeridas.repaint();
        // Scroll text panes to the top.
        SwingUtilities.invokeLater(() -> { // Ensure runs after layout
             if (textPaneEnunciadoCodigo != null && textPaneEnunciadoCodigo.getDocument().getLength() > 0) {
                 textPaneEnunciadoCodigo.setCaretPosition(0);
             }
             if (scrollPaneOpcionesEntradas != null) {
                 scrollPaneOpcionesEntradas.getViewport().setViewPosition(new Point(0,0));
             }
             if (scrollPaneSugerencias != null) {
                scrollPaneSugerencias.getViewport().setViewPosition(new Point(0,0));
             }
        });

        // Refresh the button panel containing the feedback label.
        if (lblFeedback.getParent() != null) {
            lblFeedback.getParent().revalidate();
            lblFeedback.getParent().repaint();
        }
    }

    // Displays the session summary when all exercises are completed.
    private void mostrarResumenSesion() {
        int correctas = manager.getRespuestasCorrectas();
        int incorrectas = manager.getRespuestasIncorrectas();
        int total = manager.getTotalIntentos();
        double porcentaje = (total == 0) ? 0.0 : manager.getPorcentajeAciertos(); // Avoid division by zero
        DecimalFormat df = new DecimalFormat("0.00"); // Format percentage.

        // Build the summary message using HTML for basic formatting.
        String resumen = String.format(
            "<html><body style='width: 300px;'>" + // Basic width constraint
            "¡Has completado todos los ejercicios de esta sección!<br><br>" +
            "<b>Resumen de la Sesión:</b><br>" +
            "Ejercicios Correctos: %d<br>" +
            "Ejercicios Incorrectos: %d<br>" +
            "Total de Ejercicios Intentados: %d<br>" +
            "Porcentaje de Aciertos: %s%%" +
            "</body></html>",
            correctas, incorrectas, total, df.format(porcentaje)
        );

        // Show the summary in a message dialog.
        JOptionPane.showMessageDialog(this, resumen, "Fin de la Sesión", JOptionPane.INFORMATION_MESSAGE);
        dispose(); // Close the QuestionDisplayForm window.
    }


    // Configures the UI to display a multiple-choice question.
    private void mostrarPreguntaTest(PreguntaTest pregunta) {
        textPaneEnunciadoCodigo.setContentType("text/plain"); // Simple text display.
        textPaneEnunciadoCodigo.setText(pregunta.getEnunciado()); // Set question text.

        // Use BoxLayout for vertical arrangement of radio buttons.
        panelOpcionesEntradas.setLayout(new BoxLayout(panelOpcionesEntradas, BoxLayout.Y_AXIS));
        grupoOpcionesTest = new ButtonGroup(); // Ensures only one radio button can be selected.
        radioButtonsOpciones = new ArrayList<>();

        // Create and add a radio button for each option.
        for (String opcion : pregunta.getOpciones()) {
            // Use HTML to allow basic formatting and wrapping within the radio button label.
            JRadioButton radio = new JRadioButton("<html><body style='width: 500px'>" + escapeHtml(opcion) + "</body></html>");
            radio.setFont(new Font("Arial", Font.PLAIN, 13));
            grupoOpcionesTest.add(radio);        // Add to group.
            radioButtonsOpciones.add(radio);    // Add to list for later checking.
            panelOpcionesEntradas.add(radio);   // Add to the display panel.
            panelOpcionesEntradas.add(Box.createRigidArea(new Dimension(0, 5))); // Add spacing.
        }
        // Adjust the preferred height of the options panel dynamically.
        int preferredHeightTest = Math.min(500, pregunta.getOpciones().size() * 35 + 40); // Calculate height, capped at 500px.
        scrollPaneOpcionesEntradas.setPreferredSize(new Dimension(scrollPaneOpcionesEntradas.getPreferredSize().width, preferredHeightTest));
    }

    // Configures the UI to display a fill-in-the-blanks code exercise.
    private void mostrarEjercicioRellenar(EjercicioRellenarCodigo ejercicio) {
        // Display the exercise description and code snippet.
        textPaneEnunciadoCodigo.setContentType("text/plain"); // Keep as plain text for now.
        setupStyledDocument(ejercicio.getEnunciado(), ejercicio.getCodigoConHuecos());


        // --- Setup Draggable Words ---
        panelPalabrasSugeridas.removeAll(); // Clear previous words.
        draggableWordLabels.clear();        // Clear the list of labels.
        // Create a draggable label for each suggested word.
        for (String palabra : ejercicio.getElementosSugeridos()) {
            JLabel palabraLabel = createDraggableLabel(palabra);
            panelPalabrasSugeridas.add(palabraLabel); // Add to the suggestions panel.
            draggableWordLabels.add(palabraLabel);    // Keep track of the label.
        }
        scrollPaneSugerencias.setVisible(true); // Make the suggestions panel visible.


        // --- Setup Drop Targets ---
        panelOpcionesEntradas.setLayout(new GridBagLayout()); // Use GridBagLayout for alignment.
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(3, 5, 3, 5);       // Padding around components.
        gbc.fill = GridBagConstraints.HORIZONTAL; // Make components fill horizontally.

        dropTargetPanels = new ArrayList<>(); // List to hold the drop panels.
        int numHuecos = ejercicio.getNumeroDeHuecos();

        // Create a label and a drop target panel for each blank.
        for (int i = 0; i < numHuecos; i++) {
            // Label for the blank number ("Hueco 1:", "Hueco 2:", etc.)
            gbc.gridx = 0; // Column 0
            gbc.gridy = i; // Row i
            gbc.weightx = 0.0; // Don't stretch horizontally.
            gbc.anchor = GridBagConstraints.WEST; // Align left.
            JLabel lblHuecoNumero = new JLabel("Hueco " + (i + 1) + ":");
            lblHuecoNumero.setFont(new Font("Arial", Font.PLAIN, 13));
            panelOpcionesEntradas.add(lblHuecoNumero, gbc);

            // The panel where the word can be dropped.
            gbc.gridx = 1; // Column 1
            gbc.weightx = 1.0; // Allow horizontal stretching.
            gbc.anchor = GridBagConstraints.CENTER; // Center content within the cell.
            DropTargetPanel dropPanel = new DropTargetPanel(i + 1); // Create the drop panel.
            dropTargetPanels.add(dropPanel); // Add to list.
            panelOpcionesEntradas.add(dropPanel, gbc); // Add to the layout.
        }

        // Adjust the preferred height of the drop target area.
        int singleDropPanelHeight = new DropTargetPanel(0).getPreferredSize().height; // Get height of one panel.
        int visibleRows = Math.min(numHuecos, 6); // Show up to 6 rows without excessive scrolling.
        // Calculate preferred height based on visible rows and padding.
        int preferredHeightHuecos = visibleRows * (singleDropPanelHeight + gbc.insets.top + gbc.insets.bottom) + 20;
        preferredHeightHuecos = Math.max(100, Math.min(preferredHeightHuecos, 300)); // Min 100px, Max 300px.

        scrollPaneOpcionesEntradas.setPreferredSize(new Dimension(scrollPaneOpcionesEntradas.getPreferredSize().width, preferredHeightHuecos));
    }

    // Helper to set up the JTextPane content for code exercises.
    private void setupStyledDocument(String enunciado, String codigo) {
         StyledDocument doc = textPaneEnunciadoCodigo.getStyledDocument();
         Style defaultStyle = doc.getStyle(StyleContext.DEFAULT_STYLE);
         // Ensure a Monospaced font is used for the code section.
         StyleConstants.setFontFamily(defaultStyle, "Monospaced");
         StyleConstants.setFontSize(defaultStyle, 14);

         try {
             doc.remove(0, doc.getLength()); // Clear previous content.
             // Insert enunciado first
             doc.insertString(doc.getLength(), enunciado + "\n\n", defaultStyle);
             // Insert code block with delimiters
             doc.insertString(doc.getLength(), "--- INICIO CÓDIGO ---\n", defaultStyle);
             doc.insertString(doc.getLength(), codigo, defaultStyle); // The actual code
             doc.insertString(doc.getLength(), "\n--- FIN CÓDIGO ---", defaultStyle);
         } catch (BadLocationException e) {
             System.err.println("Error al insertar texto en JTextPane: " + e.getMessage());
             textPaneEnunciadoCodigo.setText("Error al cargar el ejercicio:\n" + enunciado); // Fallback
         }
    }


    // Creates a styled JLabel that can be dragged.
    private JLabel createDraggableLabel(String word) {
         JLabel palabraLabel = new JLabel(word);
         palabraLabel.setOpaque(true); // Make background visible.
         palabraLabel.setBackground(new Color(220, 220, 255)); // Light blue background.
         // Compound border: line border + empty padding inside.
         palabraLabel.setBorder(BorderFactory.createCompoundBorder(
             BorderFactory.createLineBorder(Color.GRAY),
             BorderFactory.createEmptyBorder(5, 8, 5, 8) // Padding (top, left, bottom, right).
         ));
         palabraLabel.setFont(new Font("Arial", Font.BOLD, 13));
         // Set up the TransferHandler to enable dragging this label.
         palabraLabel.setTransferHandler(new WordSourceTransferHandler(word));
         // Add mouse listener to initiate drag on mouse press.
         palabraLabel.addMouseListener(new MouseAdapter() {
             public void mousePressed(MouseEvent e) {
                 JComponent comp = (JComponent) e.getSource();
                 TransferHandler handler = comp.getTransferHandler();
                 // Start the drag operation.
                 handler.exportAsDrag(comp, e, TransferHandler.COPY); // COPY action allows dropping multiple times if needed.
             }
         });
         return palabraLabel;
    }


    // Action performed when the "Verify" button is clicked.
    private void verificarRespuesta() {
        if (manager == null) return; // Safety check.
        ItemEstudio itemActual = manager.getEjercicioActual(); // Get the current item.

        // Reset feedback label.
        lblFeedback.setText(" ");
        lblFeedback.setForeground(Color.BLACK);
        lblFeedback.setVisible(true);

        // Handle case where there's somehow no current item.
        if (itemActual == null) {
            lblFeedback.setText("Error: No hay ejercicio actual para verificar.");
            lblFeedback.setForeground(Color.RED);
            btnVerificar.setEnabled(false); // Disable verify.
            btnSiguiente.setEnabled(true); // Enable next (to finish).
            refreshFeedbackPanel();
            return;
        }

        boolean fueRespuestaCorrecta = false; // Flag to track correctness.

        // --- Verification Logic for Multiple Choice ---
        if (itemActual instanceof PreguntaTest) {
            PreguntaTest pregunta = (PreguntaTest) itemActual;
            // Check if an option was selected.
            if (grupoOpcionesTest.getSelection() == null) {
                lblFeedback.setText("Por favor, selecciona una opción.");
                lblFeedback.setForeground(Color.ORANGE); // Use orange for warnings.
                refreshFeedbackPanel();
                return; // Stop verification.
            }
            // Find the selected radio button and get its text.
            String respuestaUsuario = "";
            for (JRadioButton radio : radioButtonsOpciones) {
                if (radio.isSelected()) {
                    // Extract text, removing HTML tags used for formatting.
                    String htmlText = radio.getText();
                    respuestaUsuario = htmlText.replaceAll("<[^>]*>", "").replace("&lt;", "<").replace("&gt;", ">").trim();
                    break;
                }
            }
            // Check if the extracted answer is correct.
            fueRespuestaCorrecta = pregunta.verificarRespuesta(respuestaUsuario);
            // Provide feedback based on correctness.
            if (fueRespuestaCorrecta) {
                lblFeedback.setText("¡Correcto!");
                lblFeedback.setForeground(new Color(0, 128, 0)); // Green for correct.
            } else {
                // Show the correct answer if incorrect. Use HTML for formatting.
                lblFeedback.setText("<html>Incorrecto. La respuesta correcta era: <br/><b>" + escapeHtml(pregunta.getRespuestaCorrecta()) + "</b></html>");
                lblFeedback.setForeground(Color.RED); // Red for incorrect.
            }

        // --- Verification Logic for Fill-in-the-Blanks ---
        } else if (itemActual instanceof EjercicioRellenarCodigo) {
            // Ensure we have the current exercise object and drop panels.
            if (currentEjercicioRellenar == null || dropTargetPanels == null || dropTargetPanels.isEmpty()) {
                lblFeedback.setText("Error interno: No se puede verificar el ejercicio.");
                lblFeedback.setForeground(Color.RED);
                fueRespuestaCorrecta = false; // Mark as incorrect due to error.
            } else {
                 boolean todosLosHuecosCorrectos = true; // Assume correct initially.
                 // Check each drop target panel.
                 for (DropTargetPanel dropPanel : dropTargetPanels) {
                     String palabraEnHueco = dropPanel.getDroppedWord(); // Get the word dropped in this blank.
                     // Get the correct solution for this blank number.
                     String solucionParaEsteHueco = currentEjercicioRellenar.getSoluciones().get(dropPanel.getBlankNumber());

                     // Check if a word was dropped and if it matches the solution.
                     if (palabraEnHueco != null && !palabraEnHueco.isEmpty()) {
                         if (palabraEnHueco.equals(solucionParaEsteHueco)) {
                             // Correct word: set background to light green.
                             dropPanel.setFeedbackColor(new Color(200, 255, 200));
                         } else {
                             // Incorrect word: set background to light red and mark session as incorrect.
                             dropPanel.setFeedbackColor(new Color(255, 200, 200));
                             todosLosHuecosCorrectos = false;
                         }
                     } else {
                         // Blank is empty: reset background and mark session as incorrect.
                         dropPanel.setFeedbackColor(Color.WHITE); // Or a light gray warning color
                         todosLosHuecosCorrectos = false;
                     }
                 }
                 fueRespuestaCorrecta = todosLosHuecosCorrectos; // Update overall correctness flag.
                 // Set the main feedback label based on overall correctness.
                 if (fueRespuestaCorrecta) {
                     lblFeedback.setText("¡Todos los huecos son correctos!");
                     lblFeedback.setForeground(new Color(0, 128, 0));
                 } else {
                     lblFeedback.setText("Algunos huecos son incorrectos o están vacíos. Revisa los colores.");
                     lblFeedback.setForeground(Color.RED);
                 }
            }
        }

        // Record the result in the session manager.
        if (manager != null) {
            manager.registrarRespuesta(fueRespuestaCorrecta);
        }

        // Update button states after verification.
        btnVerificar.setEnabled(false); // Disable verify until next question.
        btnSiguiente.setEnabled(true);  // Enable next button.

        // Update "Next" button text if it's now the last exercise.
        if (manager != null && manager.esUltimoEjercicio()) {
            btnSiguiente.setText("Finalizar Sesión");
        } else {
            btnSiguiente.setText("Siguiente Ejercicio");
        }

        // Refresh the panel containing the feedback label to show changes.
        refreshFeedbackPanel();
    }

    // Helper to refresh the panel containing the feedback label.
    private void refreshFeedbackPanel() {
         if (lblFeedback.getParent() != null) {
            lblFeedback.getParent().revalidate();
            lblFeedback.getParent().repaint();
        }
    }

    // Helper function to escape basic HTML characters for display in labels/buttons.
    private String escapeHtml(String text) {
        if (text == null) return "";
        return text.replace("&", "&amp;")
                   .replace("<", "&lt;")
                   .replace(">", "&gt;")
                   .replace("\"", "&quot;")
                   .replace("'", "&#39;");
    }


    // --- Inner Classes for Drag and Drop ---

    // Represents the panel where a word can be dropped.
    private class DropTargetPanel extends JPanel {
        private JLabel wordLabel;        // Label to display the dropped word or placeholder text.
        private int blankNumber;         // The number of the blank this panel represents (1-based).
        private String droppedWordText = null; // The actual word dropped here, or null if empty.

        public DropTargetPanel(int blankNumber) {
            this.blankNumber = blankNumber;
            // Initialize the label with placeholder text.
            this.wordLabel = new JLabel("Arrastra aquí (Hueco " + blankNumber + ")");
            this.wordLabel.setForeground(Color.LIGHT_GRAY); // Placeholder text is gray.
            this.wordLabel.setFont(new Font("Arial", Font.ITALIC, 12));
            this.wordLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center text.

            setLayout(new BorderLayout()); // Simple layout.
            add(wordLabel, BorderLayout.CENTER);
            setPreferredSize(new Dimension(150, 35)); // Define preferred size.
            setBorder(BorderFactory.createDashedBorder(Color.GRAY)); // Dashed border indicates drop target.
            setBackground(Color.WHITE); // Default background.

            // Set the TransferHandler to accept dropped words.
            this.setTransferHandler(new WordDropTargetTransferHandler());
        }

        // Sets the word in the panel when dropped.
        public void setDroppedWord(String word, JLabel originalDraggableLabel) {
            this.droppedWordText = word;
            this.wordLabel.setText(word); // Display the dropped word.
            this.wordLabel.setForeground(Color.BLACK); // Normal text color.
            this.wordLabel.setFont(new Font("Arial", Font.BOLD, 13)); // Style for dropped word.
            this.wordLabel.setBackground(new Color(220, 220, 255)); // Match draggable label background.
            this.wordLabel.setOpaque(true);

            // --- Crucial: Clear the word from any *other* panel that held the *same* original draggable label ---
            // This prevents one draggable word appearing in multiple blanks simultaneously.
            // Iterate over a copy of the map to avoid ConcurrentModificationException if modifying the map.
            for (Map.Entry<DropTargetPanel, JLabel> entry : new HashMap<>(droppedWordsMap).entrySet()) {
                 // If another panel (entry.getKey() != this) currently holds the same source label (entry.getValue() == originalDraggableLabel)
                 if (entry.getValue() == originalDraggableLabel && entry.getKey() != this) {
                    entry.getKey().clearWord(); // Clear the word from that other panel.
                }
            }
            // --- End Crucial Section ---

            // Associate this panel with the original draggable label.
            droppedWordsMap.put(this, originalDraggableLabel);
            setFeedbackColor(Color.WHITE); // Reset background color on drop.
        }

        // Clears the word from the panel, resetting to placeholder state.
        public void clearWord() {
            this.droppedWordText = null; // No word dropped.
            // Reset label appearance to placeholder style.
            this.wordLabel.setText("Arrastra aquí (Hueco " + blankNumber + ")");
            this.wordLabel.setForeground(Color.LIGHT_GRAY);
            this.wordLabel.setFont(new Font("Arial", Font.ITALIC, 12));
            this.wordLabel.setOpaque(false); // Make label background transparent.
            this.wordLabel.setBackground(UIManager.getColor("Panel.background")); // Match panel background.
            // Remove the association between this panel and the draggable label.
            droppedWordsMap.remove(this);
            setBackground(Color.WHITE); // Reset panel background.
            repaint(); // Ensure visual update.
        }

        // Returns the word currently dropped in this panel, or null if empty.
        public String getDroppedWord() {
            return droppedWordText;
        }

        // Returns the blank number this panel represents.
        public int getBlankNumber() {
            return blankNumber;
        }

        // Sets the background color to provide visual feedback (e.g., green for correct, red for incorrect).
        public void setFeedbackColor(Color color) {
            // Only apply feedback color if a word is actually present.
            if (droppedWordText != null && !droppedWordText.isEmpty()) {
                wordLabel.setBackground(color);
                wordLabel.setOpaque(true); // Ensure background color is visible.
            } else {
                // If no word, reset panel background (slightly different if feedback color wasn't white).
                setBackground(color.equals(Color.WHITE) ? Color.WHITE : new Color(240,240,240));
                wordLabel.setOpaque(false); // Ensure label background is transparent.
            }
            repaint(); // Redraw the component.
        }
    }

    // Handles the transfer of data *from* a draggable word label.
    private class WordSourceTransferHandler extends TransferHandler {
        private final String word; // The word being dragged.

        public WordSourceTransferHandler(String word) {
            this.word = word;
        }

        // Define the drag action (COPY is common, allows dropping same word multiple times if needed).
        @Override
        public int getSourceActions(JComponent c) {
            return COPY;
        }

        // Creates the Transferable object containing the word data.
        @Override
        protected Transferable createTransferable(JComponent c) {
            // Pass both the word string and the source JLabel itself.
            return new TransferableWord(word, (JLabel) c);
        }

        // Called after the drag operation is complete (optional cleanup).
        @Override
        protected void exportDone(JComponent source, Transferable data, int action) {
            // No cleanup needed here for COPY action.
        }
    }

    // Custom Transferable class to hold the word and its source label.
    public static class TransferableWord implements Transferable {
        // Custom DataFlavor to identify our specific transferable type.
        public static final DataFlavor WORD_FLAVOR;
        static {
            try {
                // Use a unique MIME type incorporating the class name.
                WORD_FLAVOR = new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType + ";class=" + TransferableWord.class.getName());
            } catch (ClassNotFoundException e) {
                 // Should not happen with standard JVM classes.
                throw new RuntimeException("Error inicializando DataFlavor", e);
            }
        }

        private String word;        // The word being transferred.
        private JLabel sourceLabel; // The original JLabel component that was dragged.

        public TransferableWord(String word, JLabel sourceLabel) {
            this.word = Objects.requireNonNull(word, "Word cannot be null");
            this.sourceLabel = Objects.requireNonNull(sourceLabel, "Source label cannot be null");
        }

        // Returns the supported DataFlavors (our custom one and plain String).
        @Override
        public DataFlavor[] getTransferDataFlavors() {
            return new DataFlavor[]{WORD_FLAVOR, DataFlavor.stringFlavor};
        }

        // Checks if a given DataFlavor is supported.
        @Override
        public boolean isDataFlavorSupported(DataFlavor flavor) {
            return flavor.equals(WORD_FLAVOR) || flavor.equals(DataFlavor.stringFlavor);
        }

        // Provides the actual data based on the requested DataFlavor.
        @Override
        public Object getTransferData(DataFlavor flavor) {
            if (flavor.equals(WORD_FLAVOR)) {
                return this; // Return the whole TransferableWord object for our custom flavor.
            }
            if (flavor.equals(DataFlavor.stringFlavor)) {
                return word; // Return just the word string for plain text flavor.
            }
            // Should ideally throw UnsupportedFlavorException if flavor is not supported.
            return null;
        }

        // Getters for the data.
        public String getWord() { return word; }
        public JLabel getSourceLabel() { return sourceLabel; }
    }


    // Handles the transfer of data *to* a DropTargetPanel.
    private class WordDropTargetTransferHandler extends TransferHandler {
        // Determines if the drop target can accept the dragged data.
        @Override
        public boolean canImport(TransferSupport support) {
            // Only accept drops if the data flavor is our custom WORD_FLAVOR.
            return support.isDataFlavorSupported(TransferableWord.WORD_FLAVOR);
        }

        // Processes the data when it's dropped onto the component.
        @Override
        public boolean importData(TransferSupport support) {
            if (!canImport(support)) {
                return false; // Cannot import this data type.
            }
            // Get the target component (the DropTargetPanel).
            DropTargetPanel targetPanel = (DropTargetPanel) support.getComponent();
            // Get the transferable data being dropped.
            Transferable transferable = support.getTransferable();
            try {
                // Extract our custom TransferableWord object from the data.
                TransferableWord transferableWord = (TransferableWord) transferable.getTransferData(TransferableWord.WORD_FLAVOR);

                // --- Logic to handle word replacement ---
                JLabel sourceLabelDragged = transferableWord.getSourceLabel();
                // Check if the *same source label* is already in *another* drop panel.
                // Iterate over a copy to avoid issues while modifying the map.
                for (Map.Entry<DropTargetPanel, JLabel> entry : new HashMap<>(droppedWordsMap).entrySet()) {
                     // If another panel (entry.getKey() != targetPanel)
                     // currently holds the same source label (entry.getValue() == sourceLabelDragged)
                     if (entry.getValue() == sourceLabelDragged && entry.getKey() != targetPanel) {
                        entry.getKey().clearWord(); // Clear the word from that *other* panel.
                    }
                }
                // --- End Logic ---

                // Set the word in the target panel, passing the source label for tracking.
                targetPanel.setDroppedWord(transferableWord.getWord(), sourceLabelDragged);
                return true; // Import successful.
            } catch (Exception e) {
                // Handle potential exceptions during data transfer.
                System.err.println("Error al importar datos de D&D: " + e.getMessage());
                e.printStackTrace();
                return false; // Import failed.
            }
        }
    }
}