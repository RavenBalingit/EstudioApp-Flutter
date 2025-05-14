package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Class responsible for loading and providing study materials (questions and exercises).
public class BancoDeEstudio {

    // Lists to hold questions and exercises for each Flutter topic.
    private List<PreguntaTest> preguntasTestI18n;
    private List<EjercicioRellenarCodigo> ejerciciosRellenarI18n;
    private List<PreguntaTest> preguntasTestApiRest;
    private List<EjercicioRellenarCodigo> ejerciciosRellenarApiRest;
    private List<PreguntaTest> preguntasTestBuild;
    private List<EjercicioRellenarCodigo> ejerciciosRellenarBuild;

    // Constructor: Loads all study materials when the object is created.
    public BancoDeEstudio() {
        cargarPreguntasI18n();
        cargarEjerciciosI18n();
        cargarPreguntasApiRest();
        cargarEjerciciosApiRest();
        cargarPreguntasBuild();
        cargarEjerciciosBuild();
    }

    // --- Loading Methods for Flutter Content ---

    private void cargarPreguntasI18n() {
        preguntasTestI18n = new ArrayList<>();
        String pregunta;
        List<String> opciones;
        String respuestaCorrecta;

        // Pregunta 1
        pregunta = "1. ¿Cuál es el propósito principal de la internacionalización (i18n) en Flutter?";
        opciones = new ArrayList<>(Arrays.asList(
                "Traducir texto a un idioma específico",
                "Optimizar el rendimiento de la app",
                "Diseñar software adaptable a múltiples idiomas y regiones",
                "Publicar apps en Google Play"
        ));
        respuestaCorrecta = "Diseñar software adaptable a múltiples idiomas y regiones";
        Collections.shuffle(opciones);
        preguntasTestI18n.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 2
        pregunta = "2. ¿Qué proporciona principalmente el paquete `intl` en Flutter?";
        opciones = new ArrayList<>(Arrays.asList(
                "Capacidades de red",
                "Funciones de internacionalización y localización",
                "Widgets de interfaz",
                "Gestión de bases de datos"
        ));
        respuestaCorrecta = "Funciones de internacionalización y localización";
        Collections.shuffle(opciones);
        preguntasTestI18n.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 3
        pregunta = "3. ¿Cómo se instala el paquete `intl` en un proyecto Flutter?";
        opciones = new ArrayList<>(Arrays.asList(
                "`flutter add intl`",
                "`flutter pub add intl`",
                "`dart install intl`",
                "`flutter get intl`"
        ));
        respuestaCorrecta = "`flutter pub add intl`";
        Collections.shuffle(opciones);
        preguntasTestI18n.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 4
        pregunta = "4. ¿Qué clase se usa para formatear fechas en Flutter con el paquete `intl`?";
        opciones = new ArrayList<>(Arrays.asList(
                "`NumberFormat`",
                "`DateFormat`",
                "`Intl`",
                "`BidiFormatter`"
        ));
        respuestaCorrecta = "`DateFormat`";
        Collections.shuffle(opciones);
        preguntasTestI18n.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 5
        pregunta = "5. ¿Cuál es el resultado de `DateFormat('dd-MM-yyyy').format(DateTime(2025, 5, 12))` para el idioma `es_ES`?";
        opciones = new ArrayList<>(Arrays.asList(
                "12-05-2025",
                "05/12/2025",
                "Mayo 12, 2025",
                "2025-05-12"
        ));
        respuestaCorrecta = "12-05-2025";
        Collections.shuffle(opciones);
        preguntasTestI18n.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 6
        pregunta = "6. ¿Qué se debe llamar antes de usar `DateFormat` con un idioma específico?";
        opciones = new ArrayList<>(Arrays.asList(
                "`initializeDateFormatting('es_ES', null)`",
                "`setLocale('es_ES')`",
                "`Intl.setLocale('es_ES')`",
                "`DateFormat.initialize('es_ES')`"
        ));
        respuestaCorrecta = "`initializeDateFormatting('es_ES', null)`";
        Collections.shuffle(opciones);
        preguntasTestI18n.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 7
        pregunta = "7. ¿Cómo se formatea un número como moneda en Flutter para el idioma predeterminado?";
        opciones = new ArrayList<>(Arrays.asList(
                "`NumberFormat.currency().format(123.45)`",
                "`NumberFormat().format(123.45)`",
                "`CurrencyFormat().format(123.45)`",
                "`Intl.currency(123.45)`"
        ));
        respuestaCorrecta = "`NumberFormat.currency().format(123.45)`";
        Collections.shuffle(opciones);
        preguntasTestI18n.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 8
        pregunta = "8. ¿Cuál es el propósito de los archivos `.arb` en la localización de Flutter?";
        opciones = new ArrayList<>(Arrays.asList(
                "Almacenar íconos de la app",
                "Almacenar cadenas traducidas",
                "Definir rutas de la app",
                "Configurar puntos finales de API"
        ));
        respuestaCorrecta = "Almacenar cadenas traducidas";
        Collections.shuffle(opciones);
        preguntasTestI18n.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 9
        pregunta = "9. ¿Cómo se accede a una cadena traducida en Flutter?";
        opciones = new ArrayList<>(Arrays.asList(
                "`AppLocalizations.of(context).stringKey`",
                "`Intl.getString('stringKey')`",
                "`Localizations.get(context, 'stringKey')`",
                "`Translations.of(context).stringKey`"
        ));
        respuestaCorrecta = "`AppLocalizations.of(context).stringKey`";
        Collections.shuffle(opciones);
        preguntasTestI18n.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 10
        pregunta = "10. ¿Qué hace `Intl.defaultLocale = 'es_ES'`?";
        opciones = new ArrayList<>(Arrays.asList(
                "Establece el tema de la app",
                "Establece el idioma predeterminado para el formato",
                "Cambia el idioma del dispositivo",
                "Configura la navegación de la app"
        ));
        respuestaCorrecta = "Establece el idioma predeterminado para el formato";
        Collections.shuffle(opciones);
        preguntasTestI18n.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 11
        pregunta = "11. ¿Cómo se detecta el código de idioma del dispositivo en Flutter?";
        opciones = new ArrayList<>(Arrays.asList(
                "`ui.window.locale.languageCode`",
                "`Intl.getLocale()`",
                "`Locale.getLanguage()`",
                "`Device.locale.language`"
        ));
        respuestaCorrecta = "`ui.window.locale.languageCode`";
        Collections.shuffle(opciones);
        preguntasTestI18n.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 12
        pregunta = "12. ¿Cuál es el propósito de `locale: Locale('es', 'ES')` en `MaterialApp`?";
        opciones = new ArrayList<>(Arrays.asList(
                "Establece el tema de la app",
                "Especifica el idioma y la región de la app",
                "Configura las rutas de la app",
                "Habilita la depuración"
        ));
        respuestaCorrecta = "Especifica el idioma y la región de la app";
        Collections.shuffle(opciones);
        preguntasTestI18n.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 13
        pregunta = "13. ¿Qué widget se usa comúnmente para permitir a los usuarios seleccionar un idioma?";
        opciones = new ArrayList<>(Arrays.asList(
                "`TextField`",
                "`DropdownButton`",
                "`Slider`",
                "`Checkbox`"
        ));
        respuestaCorrecta = "`DropdownButton`";
        Collections.shuffle(opciones);
        preguntasTestI18n.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 14
        pregunta = "14. ¿Cuál es la extensión de los archivos de traducción en Flutter?";
        opciones = new ArrayList<>(Arrays.asList(
                "`.json`",
                "`.arb`",
                "`.xml`",
                "`.yaml`"
        ));
        respuestaCorrecta = "`.arb`";
        Collections.shuffle(opciones);
        preguntasTestI18n.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 15
        pregunta = "15. ¿Qué comando genera clases de localización en Flutter?";
        opciones = new ArrayList<>(Arrays.asList(
                "`flutter gen-l10n`",
                "`flutter pub gen`",
                "`flutter localize`",
                "`flutter intl`"
        ));
        respuestaCorrecta = "`flutter gen-l10n`";
        Collections.shuffle(opciones);
        preguntasTestI18n.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 16
        pregunta = "16. ¿Cuántos idiomas debe soportar la app según los requisitos de la actividad?";
        opciones = new ArrayList<>(Arrays.asList(
                "1",
                "2",
                "3",
                "4"
        ));
        respuestaCorrecta = "3"; // Based on the original context mentioning "al menos tres"
        Collections.shuffle(opciones);
        preguntasTestI18n.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 17
        pregunta = "17. ¿Cuál es el resultado de `NumberFormat('#,##0.00').format(1234.567)` en `es_ES`?";
        opciones = new ArrayList<>(Arrays.asList(
                "1.234,57",
                "1,234.57",
                "1234.567",
                "1.234,567"
        ));
        respuestaCorrecta = "1.234,57";
        Collections.shuffle(opciones);
        preguntasTestI18n.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 18
        pregunta = "18. ¿En qué se centra la localización (l10n)?";
        opciones = new ArrayList<>(Arrays.asList(
                "Diseñar para múltiples idiomas",
                "Adaptar contenido para un mercado específico",
                "Optimizar el tamaño de la app",
                "Proteger las llamadas a la API"
        ));
        respuestaCorrecta = "Adaptar contenido para un mercado específico";
        Collections.shuffle(opciones);
        preguntasTestI18n.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 19
        pregunta = "19. ¿Qué importación se requiere para usar `DateFormat`?";
        opciones = new ArrayList<>(Arrays.asList(
                "`import 'package:flutter/material.dart';`",
                "`import 'package:intl/intl.dart';`",
                "`import 'package:http/http.dart';`",
                "`import 'dart:ui';`"
        ));
        respuestaCorrecta = "`import 'package:intl/intl.dart';`";
        Collections.shuffle(opciones);
        preguntasTestI18n.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 20
        pregunta = "20. ¿Cómo se asegura que la app cargue el idioma predeterminado del dispositivo?";
        opciones = new ArrayList<>(Arrays.asList(
                "Establecer `locale: Locale('en', 'US')`",
                "Usar `Intl.defaultLocale = ui.window.locale.languageCode`", // Though setting locale in MaterialApp based on window.locale is more common
                "Codificar el idioma en `pubspec.yaml`",
                "Usar `AppLocalizations.setLocale()`"
        ));
        respuestaCorrecta = "Usar `Intl.defaultLocale = ui.window.locale.languageCode`";
        Collections.shuffle(opciones);
        preguntasTestI18n.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 21
        pregunta = "21. ¿Cuál es el rol de `AppLocalizations.of(context)`?";
        opciones = new ArrayList<>(Arrays.asList(
                "Obtener datos de la API",
                "Proporcionar acceso a cadenas traducidas",
                "Formatear fechas",
                "Configurar rutas"
        ));
        respuestaCorrecta = "Proporcionar acceso a cadenas traducidas";
        Collections.shuffle(opciones);
        preguntasTestI18n.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 22
        pregunta = "22. ¿Cuál es la forma correcta de formatear una distancia con un decimal en Flutter?";
        opciones = new ArrayList<>(Arrays.asList(
                "`NumberFormat('#,##0.0').format(150000000.57)`",
                "`NumberFormat.currency().format(150000000.57)`",
                "`DateFormat('#,##0.0').format(150000000.57)`",
                "`NumberFormat().format(150000000.57)`"
        ));
        respuestaCorrecta = "`NumberFormat('#,##0.0').format(150000000.57)`";
        Collections.shuffle(opciones);
        preguntasTestI18n.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 23
        pregunta = "23. ¿Qué archivo contiene la configuración de idioma de la app?";
        opciones = new ArrayList<>(Arrays.asList(
                "`AndroidManifest.xml`",
                "`pubspec.yaml`",
                "`main.dart` (donde se configura MaterialApp)",
                "`build.gradle`"
        ));
        respuestaCorrecta = "`main.dart` (donde se configura MaterialApp)";
        Collections.shuffle(opciones);
        preguntasTestI18n.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 24
        pregunta = "24. ¿Cuál es el beneficio de usar un widget selector de idioma genérico?";
        opciones = new ArrayList<>(Arrays.asList(
                "Reduce el tamaño de la app",
                "Reusabilidad en diferentes pantallas",
                "Mejora el rendimiento de la API",
                "Simplifica el enrutamiento"
        ));
        respuestaCorrecta = "Reusabilidad en diferentes pantallas";
        Collections.shuffle(opciones);
        preguntasTestI18n.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 25
        pregunta = "25. ¿Qué ocurre si no se llama a `initializeDateFormatting` para un idioma?";
        opciones = new ArrayList<>(Arrays.asList(
                "La app se bloquea",
                "El formato de fecha usa el idioma predeterminado",
                "Las fechas no se muestran",
                "La app cambia a inglés"
        ));
        respuestaCorrecta = "El formato de fecha usa el idioma predeterminado";
        Collections.shuffle(opciones);
        preguntasTestI18n.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 26
        pregunta = "26. ¿Cómo se especifica un símbolo de moneda personalizado en `NumberFormat`?";
        opciones = new ArrayList<>(Arrays.asList(
                "`NumberFormat.currency(symbol: '€')`",
                "`NumberFormat(symbol: '€')`",
                "`CurrencyFormat('€')`",
                "`NumberFormat.setSymbol('€')`"
        ));
        respuestaCorrecta = "`NumberFormat.currency(symbol: '€')`";
        Collections.shuffle(opciones);
        preguntasTestI18n.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 27
        pregunta = "27. ¿Cuál es el propósito de `numberFormatSymbols` en el paquete `intl`?";
        opciones = new ArrayList<>(Arrays.asList(
                "Define puntos finales de API",
                "Personaliza símbolos de formato de números",
                "Almacena traducciones",
                "Configura íconos de la app"
        ));
        respuestaCorrecta = "Personaliza símbolos de formato de números";
        Collections.shuffle(opciones);
        preguntasTestI18n.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 28
        pregunta = "28. ¿Qué código de idioma representa el español de España?";
        opciones = new ArrayList<>(Arrays.asList(
                "`en_US`",
                "`es_ES`",
                "`fr_FR`",
                "`es_MX`"
        ));
        respuestaCorrecta = "`es_ES`";
        Collections.shuffle(opciones);
        preguntasTestI18n.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 29
        pregunta = "29. ¿Cuál es el comportamiento predeterminado de una app sin localización?";
        opciones = new ArrayList<>(Arrays.asList(
                "Usa el idioma del dispositivo",
                "Usa inglés por defecto",
                "Se bloquea al iniciar",
                "No muestra texto"
        ));
        respuestaCorrecta = "Usa inglés por defecto"; // Usually defaults to 'en' or the first locale listed if any.
        Collections.shuffle(opciones);
        preguntasTestI18n.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 30
        pregunta = "30. ¿Por qué es importante soportar múltiples idiomas en una app?";
        opciones = new ArrayList<>(Arrays.asList(
                "Para reducir el tamaño de la app",
                "Para mejorar el rendimiento",
                "Para llegar a una audiencia global",
                "Para simplificar la depuración"
        ));
        respuestaCorrecta = "Para llegar a una audiencia global";
        Collections.shuffle(opciones);
        preguntasTestI18n.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));
    }

    private void cargarEjerciciosI18n() {
        ejerciciosRellenarI18n = new ArrayList<>();

        // --- Ejercicio I18n 1 ---
        String codigoI18n_1 =
            "import 'package:flutter/material.dart';\n" +
            "import 'package:intl/intl.dart';\n"+
            "// IMPORTANTE: Necesitarías 'package:intl/date_symbol_data_local.dart'\n"+
            "// y llamar a initializeDateFormatting en main() como async.\n\n"+
            "// void main() async { \n" +
            "//   WidgetsFlutterBinding.ensureInitialized();\n"+
            "//   Intl.defaultLocale = 'es_ES';\n" +
            "//   ________ // 1: Llamar a la inicialización de formato\n"+
            "//   runApp(const MyApp());\n" +
            "// }\n\n"+
            "class ProductScreen extends StatelessWidget {\n" +
            "  const ProductScreen({super.key});\n\n" +
            "  @override\n" +
            "  Widget build(BuildContext context) {\n" +
            "    final price = 199.99;\n" +
            "    final dateAdded = DateTime(2025, 5, 12);\n\n" +
            "    // Asumiendo que 'es_ES' está configurado\n"+
            "    final currencyFormatter = ________.________(locale: 'es_ES', symbol: '€'); // 2 y 3\n" +
            "    final dateFormatter = ________('________', 'es_ES'); // 4 y 5\n\n"+
            "    return Scaffold(\n" +
            "      appBar: AppBar(title: const Text('Detalles del Producto')),\n" +
            "      body: Center(\n" +
            "        child: Column(\n" +
            "          mainAxisAlignment: MainAxisAlignment.center,\n" +
            "          children: [\n" +
            "            Text('Precio: ${currencyFormatter.________(price)}'), // 6\n" +
            "            Text('Fecha Agregada: ${dateFormatter.________(dateAdded)}'), // 7\n" +
            "          ],\n" +
            "        ),\n" +
            "      ),\n" +
            "    );\n" +
            "  }\n" +
            "}";
        List<String> sugerenciasI18n_1 = Arrays.asList(
            "NumberFormat", "currency", "DateFormat", "format", "await initializeDateFormatting('es_ES', null);", "dd-MM-yyyy", "format"
        );
        Map<Integer, String> solucionesI18n_1 = new HashMap<>();
        solucionesI18n_1.put(1, "await initializeDateFormatting('es_ES', null);");
        solucionesI18n_1.put(2, "NumberFormat");
        solucionesI18n_1.put(3, "currency");
        solucionesI18n_1.put(4, "DateFormat");
        solucionesI18n_1.put(5, "dd-MM-yyyy");
        solucionesI18n_1.put(6, "format");
        solucionesI18n_1.put(7, "format");
        ejerciciosRellenarI18n.add(new EjercicioRellenarCodigo(
            "Ejercicio I18n 1: Formato de Fecha y Moneda",
            codigoI18n_1,
            sugerenciasI18n_1,
            solucionesI18n_1
        ));

        // --- Ejercicio I18n 2 ---
        String codigoI18n_2 =
            "import 'package:flutter/material.dart';\n" +
            "// Asumiendo que tienes AppLocalizations generadas por flutter gen-l10n\n"+
            "// import 'generated/l10n.dart'; \n"+
            "// import 'package:flutter_localizations/flutter_localizations.dart';\n\n"+
            "class MyAppState extends State<MyApp> {\n" +
            "  Locale _locale = const Locale('en', 'US');\n\n" +
            "  void setLocale(Locale newLocale) {\n" +
            "    setState(() {\n" +
            "      _locale = ________; // 1\n" +
            "    });\n" +
            "  }\n\n" +
            "  @override\n" +
            "  Widget build(BuildContext context) {\n" +
            "    return MaterialApp(\n" +
            "      locale: ________, // 2\n" +
            "      // Para localización real, necesitas:\n"+
            "      // supportedLocales: AppLocalizations.supportedLocales,\n"+
            "      // localizationsDelegates: AppLocalizations.localizationsDelegates,\n"+
            "      home: Scaffold(\n" +
            "        appBar: AppBar(\n" +
            "          title: const Text('Selector de Idioma'), // Debería usar AppLocalizations\n" +
            "          actions: [\n" +
            "            ________<Locale>( // 3\n" +
            "              value: _locale,\n" +
            "              icon: const Icon(Icons.________, color: Colors.white), // 4\n" +
            "              items: const [\n" +
            "                DropdownMenuItem(\n" +
            "                  value: Locale('en', 'US'),\n" +
            "                  child: Text('English'),\n" +
            "                ),\n" +
            "                DropdownMenuItem(\n" +
            "                  value: ________('es', 'ES'), // 5\n" +
            "                  child: Text('Español'),\n" +
            "                ),\n" +
            "              ],\n" +
            "              onChanged: (Locale? newLocale) {\n" +
            "                if (newLocale != null) {\n" +
            "                  ________(newLocale); // 6\n" +
            "                }\n" +
            "              },\n" +
            "            ),\n" +
            "            SizedBox(width: 10)\n"+
            "          ],\n" +
            "        ),\n" +
            "        body: const Center(child: Text('Hola Mundo / Hello World')), // Debería usar AppLocalizations\n"+
            "      ),\n" +
            "    );\n" +
            "  }\n" +
            "}\n\n"+
            "// Dummy MyApp para completar el contexto\n"+
            "class MyApp extends StatefulWidget {\n"+
            " const MyApp({super.key});\n"+
            " @override\n"+
            " MyAppState createState() => MyAppState();\n"+
            "}";
        List<String> sugerenciasI18n_2 = Arrays.asList(
            "newLocale", "_locale", "DropdownButton", "language", "Locale", "setLocale"
        );
        Map<Integer, String> solucionesI18n_2 = new HashMap<>();
        solucionesI18n_2.put(1, "newLocale");
        solucionesI18n_2.put(2, "_locale");
        solucionesI18n_2.put(3, "DropdownButton");
        solucionesI18n_2.put(4, "language");
        solucionesI18n_2.put(5, "Locale");
        solucionesI18n_2.put(6, "setLocale");
        ejerciciosRellenarI18n.add(new EjercicioRellenarCodigo(
            "Ejercicio I18n 2: Implementar Selector de Idioma",
            codigoI18n_2,
            sugerenciasI18n_2,
            solucionesI18n_2
        ));
    }

    private void cargarPreguntasApiRest() {
        preguntasTestApiRest = new ArrayList<>();
        String pregunta;
        List<String> opciones;
        String respuestaCorrecta;

        // Pregunta 1
        pregunta = "1. ¿Qué permite una API REST en una app Flutter?";
        opciones = new ArrayList<>(Arrays.asList(
                "Almacenamiento de datos local",
                "Comunicación con servidores externos",
                "Animaciones de interfaz",
                "Publicación de apps"
        ));
        respuestaCorrecta = "Comunicación con servidores externos";
        Collections.shuffle(opciones);
        preguntasTestApiRest.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 2
        pregunta = "2. ¿Qué formato se usa comúnmente para transmitir datos en APIs REST?";
        opciones = new ArrayList<>(Arrays.asList(
                "XML",
                "JSON",
                "CSV",
                "YAML"
        ));
        respuestaCorrecta = "JSON";
        Collections.shuffle(opciones);
        preguntasTestApiRest.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 3
        pregunta = "3. ¿Qué paquete se usa para solicitudes HTTP en Flutter?";
        opciones = new ArrayList<>(Arrays.asList(
                "`intl`",
                "`http`",
                "`dio`",
                "`flutter_network`"
        ));
        respuestaCorrecta = "`http`";
        Collections.shuffle(opciones);
        preguntasTestApiRest.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 4
        pregunta = "4. ¿Cómo se instala el paquete `http`?";
        opciones = new ArrayList<>(Arrays.asList(
                "`flutter pub add http`",
                "`flutter add http`",
                "`dart install http`",
                "`flutter get http`"
        ));
        respuestaCorrecta = "`flutter pub add http`";
        Collections.shuffle(opciones);
        preguntasTestApiRest.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 5
        pregunta = "5. ¿Qué permiso es necesario para solicitudes HTTP en Android?";
        opciones = new ArrayList<>(Arrays.asList(
                "`android.permission.BLUETOOTH`",
                "`android.permission.INTERNET`",
                "`android.permission.CAMERA`",
                "`android.permission.STORAGE`"
        ));
        respuestaCorrecta = "`android.permission.INTERNET`";
        Collections.shuffle(opciones);
        preguntasTestApiRest.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 6
        pregunta = "6. ¿Qué devuelve `http.get` en Flutter?";
        opciones = new ArrayList<>(Arrays.asList(
                "`Future<String>`",
                "`Future<http.Response>`",
                "`http.Response`",
                "`Future<Map>`"
        ));
        respuestaCorrecta = "`Future<http.Response>`";
        Collections.shuffle(opciones);
        preguntasTestApiRest.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 7
        pregunta = "7. ¿Cómo se parsea JSON en Flutter?";
        opciones = new ArrayList<>(Arrays.asList(
                "Usar `jsonDecode`",
                "Usar `http.parse`",
                "Usar `JsonParser`",
                "Usar `decodeJson`"
        ));
        respuestaCorrecta = "Usar `jsonDecode`";
        Collections.shuffle(opciones);
        preguntasTestApiRest.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 8
        pregunta = "8. ¿Cuál es el propósito de un método factory `fromJson`?";
        opciones = new ArrayList<>(Arrays.asList(
                "Hacer solicitudes HTTP",
                "Convertir JSON a un objeto Dart",
                "Formatear fechas",
                "Almacenar datos localmente"
        ));
        respuestaCorrecta = "Convertir JSON a un objeto Dart";
        Collections.shuffle(opciones);
        preguntasTestApiRest.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 9
        pregunta = "9. ¿Qué código de estado HTTP indica una respuesta exitosa?";
        opciones = new ArrayList<>(Arrays.asList(
                "404",
                "500",
                "200",
                "301"
        ));
        respuestaCorrecta = "200";
        Collections.shuffle(opciones);
        preguntasTestApiRest.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 10
        pregunta = "10. ¿Qué widget se usa para manejar datos asíncronos en Flutter?";
        opciones = new ArrayList<>(Arrays.asList(
                "`StreamBuilder`",
                "`FutureBuilder`",
                "`ListView`",
                "`GridView`"
        ));
        respuestaCorrecta = "`FutureBuilder`";
        Collections.shuffle(opciones);
        preguntasTestApiRest.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 11
        pregunta = "11. ¿Dónde se deben inicializar las llamadas a la API en un StatefulWidget?";
        opciones = new ArrayList<>(Arrays.asList(
                "`build`",
                "`initState`",
                "`dispose`",
                "`setState`"
        ));
        respuestaCorrecta = "`initState`";
        Collections.shuffle(opciones);
        preguntasTestApiRest.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 12
        pregunta = "12. ¿Cuál es el propósito de una clase de servicio en el manejo de APIs?";
        opciones = new ArrayList<>(Arrays.asList(
                "Diseñar componentes de interfaz",
                "Centralizar las llamadas a la API",
                "Gestionar rutas de la app",
                "Formatear números"
        ));
        respuestaCorrecta = "Centralizar las llamadas a la API";
        Collections.shuffle(opciones);
        preguntasTestApiRest.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 13
        pregunta = "13. ¿Qué devuelve `jsonDecode(response.body)`?";
        opciones = new ArrayList<>(Arrays.asList(
                "Una cadena",
                "Un objeto Dart (Map o List)",
                "Una respuesta HTTP",
                "Un Future"
        ));
        respuestaCorrecta = "Un objeto Dart (Map o List)";
        Collections.shuffle(opciones);
        preguntasTestApiRest.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 14
        pregunta = "14. ¿Cuál es la URL de la API de Harry Potter en la actividad?";
        opciones = new ArrayList<>(Arrays.asList(
                "`https://api.harrypotter.com`",
                "`https://hp-api.onrender.com`",
                "`https://jsonplaceholder.typicode.com`",
                "`https://potterapi.com`"
        ));
        respuestaCorrecta = "`https://hp-api.onrender.com`";
        Collections.shuffle(opciones);
        preguntasTestApiRest.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 15
        pregunta = "15. ¿Qué arquitectura se requiere para la app de Harry Potter?";
        opciones = new ArrayList<>(Arrays.asList(
                "MVC",
                "MVVM",
                "Redux",
                "BLoC"
        ));
        respuestaCorrecta = "MVC";
        Collections.shuffle(opciones);
        preguntasTestApiRest.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 16
        pregunta = "16. ¿Cómo se manejan los errores en las llamadas a la API?";
        opciones = new ArrayList<>(Arrays.asList(
                "Ignorarlos",
                "Verificar el código de estado HTTP",
                "Usar solo `try-catch`",
                "Recargar la app"
        ));
        respuestaCorrecta = "Verificar el código de estado HTTP";
        Collections.shuffle(opciones);
        preguntasTestApiRest.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 17
        pregunta = "17. ¿Cuál es el propósito de `snapshot.hasData` en `FutureBuilder`?";
        opciones = new ArrayList<>(Arrays.asList(
                "Verifica errores",
                "Indica si hay datos disponibles",
                "Provoca una reconstrucción",
                "Formatea los datos"
        ));
        respuestaCorrecta = "Indica si hay datos disponibles";
        Collections.shuffle(opciones);
        preguntasTestApiRest.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 18
        pregunta = "18. ¿Qué se debe evitar al obtener datos de la API?";
        opciones = new ArrayList<>(Arrays.asList(
                "Usar clases modelo",
                "Codificar datos de forma fija",
                "Usar `FutureBuilder`",
                "Centralizar servicios"
        ));
        respuestaCorrecta = "Codificar datos de forma fija";
        Collections.shuffle(opciones);
        preguntasTestApiRest.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 19
        pregunta = "19. ¿Cuál es el rol de `routes.dart` en la app de Harry Potter?";
        opciones = new ArrayList<>(Arrays.asList(
                "Almacenar traducciones",
                "Centralizar la navegación",
                "Hacer llamadas a la API",
                "Formatear fechas"
        ));
        respuestaCorrecta = "Centralizar la navegación";
        Collections.shuffle(opciones);
        preguntasTestApiRest.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 20
        pregunta = "20. ¿Qué tipo de pantalla se requiere en la app de Harry Potter?";
        opciones = new ArrayList<>(Arrays.asList(
                "Configuración",
                "Splash",
                "Perfil",
                "Pago"
        ));
        respuestaCorrecta = "Splash";
        Collections.shuffle(opciones);
        preguntasTestApiRest.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 21
        pregunta = "21. ¿Cómo se hace una solicitud HTTP asíncrona?";
        opciones = new ArrayList<>(Arrays.asList(
                "Usar `async` y `await`",
                "Usar `sync`",
                "Usar `Future.delayed`",
                "Usar `Stream`"
        ));
        respuestaCorrecta = "Usar `async` y `await`";
        Collections.shuffle(opciones);
        preguntasTestApiRest.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 22
        pregunta = "22. ¿Qué ocurre si una llamada a la API devuelve un código de estado 404?";
        opciones = new ArrayList<>(Arrays.asList(
                "La solicitud fue exitosa",
                "El recurso no se encontró",
                "El servidor falló",
                "La app se bloquea"
        ));
        respuestaCorrecta = "El recurso no se encontró";
        Collections.shuffle(opciones);
        preguntasTestApiRest.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 23
        pregunta = "23. ¿Cuál es el beneficio de usar clases modelo para datos de API?";
        opciones = new ArrayList<>(Arrays.asList(
                "Reduce el tamaño de la app",
                "Mejora la seguridad de tipos",
                "Simplifica el diseño de la interfaz",
                "Acelera las llamadas a la API"
        ));
        respuestaCorrecta = "Mejora la seguridad de tipos";
        Collections.shuffle(opciones);
        preguntasTestApiRest.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 24
        pregunta = "24. ¿Qué hace `Uri.parse` en una solicitud HTTP?";
        opciones = new ArrayList<>(Arrays.asList(
                "Convierte una cadena a un URI",
                "Parsea datos JSON",
                "Formatea una URL",
                "Codifica datos"
        ));
        respuestaCorrecta = "Convierte una cadena a un URI";
        Collections.shuffle(opciones);
        preguntasTestApiRest.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 25
        pregunta = "25. ¿Qué widget se muestra por defecto en `FutureBuilder` mientras se carga?";
        opciones = new ArrayList<>(Arrays.asList(
                "`Text`",
                "`CircularProgressIndicator`",
                "`Container`",
                "`Icon`"
        ));
        respuestaCorrecta = "`CircularProgressIndicator`"; // Common practice
        Collections.shuffle(opciones);
        preguntasTestApiRest.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 26
        pregunta = "26. ¿Por qué se usa `initState` para las llamadas a la API?";
        opciones = new ArrayList<>(Arrays.asList(
                "Para manejar la entrada del usuario",
                "Para inicializar datos cuando se crea el widget",
                "Para liberar recursos",
                "Para actualizar la interfaz"
        ));
        respuestaCorrecta = "Para inicializar datos cuando se crea el widget";
        Collections.shuffle(opciones);
        preguntasTestApiRest.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 27
        pregunta = "27. ¿Cuál es el propósito de la pantalla de Login en la app de Harry Potter?";
        opciones = new ArrayList<>(Arrays.asList(
                "Mostrar datos de la API",
                "Autenticar usuarios",
                "Seleccionar idiomas",
                "Configurar ajustes"
        ));
        respuestaCorrecta = "Autenticar usuarios"; // Assumed purpose based on name
        Collections.shuffle(opciones);
        preguntasTestApiRest.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 28
        pregunta = "28. ¿Qué debe incluir una clase modelo para datos de API?";
        opciones = new ArrayList<>(Arrays.asList(
                "Widgets de interfaz",
                "Solicitudes HTTP",
                "Propiedades y `fromJson`",
                "Rutas de navegación"
        ));
        respuestaCorrecta = "Propiedades y `fromJson`";
        Collections.shuffle(opciones);
        preguntasTestApiRest.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 29
        pregunta = "29. ¿Cómo se centraliza la navegación en Flutter?";
        opciones = new ArrayList<>(Arrays.asList(
                "Usar `Navigator.push`",
                "Definir rutas en `routes.dart`",
                "Usar `http.get`",
                "Usar `MaterialApp`"
        ));
        respuestaCorrecta = "Definir rutas en `routes.dart`"; // Or defining named routes in MaterialApp
        Collections.shuffle(opciones);
        preguntasTestApiRest.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 30
        pregunta = "30. ¿Por qué es importante el manejo de errores en las llamadas a la API?";
        opciones = new ArrayList<>(Arrays.asList(
                "Para mejorar el rendimiento",
                "Para garantizar una buena experiencia de usuario",
                "Para reducir el tamaño de la app",
                "Para simplificar la codificación"
        ));
        respuestaCorrecta = "Para garantizar una buena experiencia de usuario";
        Collections.shuffle(opciones);
        preguntasTestApiRest.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));
    }

    private void cargarEjerciciosApiRest() {
        ejerciciosRellenarApiRest = new ArrayList<>();

        // --- Ejercicio API REST 1 ---
        String codigoApiRest1 =
            "import 'dart:convert';\n" +
            "import 'package:flutter/material.dart';\n" +
            "import 'package:http/http.dart' as http;\n\n" +
            "class Character {\n" +
            "  final String name;\n" +
            "  const Character({required this.name});\n\n" +
            "  factory Character.fromJson(Map<String, dynamic> json) {\n" +
            "    // Asumiendo que 'name' siempre existe y es String\n"+
            "    return ________(name: json['name']); // 1\n" +
            "  }\n" +
            "}\n\n" +
            "Future<Character> fetchCharacter() async {\n" +
            "  final response = await ________.get(________('https://hp-api.onrender.com/api/characters/students')); // 2 y 3 \n"+
            "  if (response.________ == 200) { // 4\n" +
            "    // La API devuelve una LISTA, tomamos el primero.\n"+
            "    List<dynamic> jsonList = ________(response.body) as List<dynamic>; // 5\n"+
            "    if (jsonList.isNotEmpty) {\n"+
            "        return Character.fromJson(jsonList[0] as Map<String, dynamic>);\n"+
            "    } else {\n"+
            "        throw Exception('Character list is empty');\n"+
            "    }\n"+
            "  } else {\n" +
            "    throw Exception('Fallo al cargar el personaje');\n" +
            "  }\n" +
            "}\n\n" +
            "class CharacterScreenState extends State<CharacterScreen> {\n" +
            "  late Future<Character> futureCharacter;\n\n" +
            "  @override\n" +
            "  void ________() { // 6\n" +
            "    super.initState();\n" +
            "    futureCharacter = fetchCharacter();\n" +
            "  }\n\n" +
            "  @override\n" +
            "  Widget build(BuildContext context) {\n" +
            "    return Scaffold(\n" +
            "      appBar: AppBar(title: const Text('Personaje de Harry Potter')),\n" +
            "      body: Center(\n" +
            "        child: ________<Character>( // 7\n" +
            "          future: futureCharacter,\n" +
            "          builder: (context, snapshot) {\n" +
            "            if (snapshot.connectionState == ________.waiting) { // 8\n"+
            "              return const ________(); // 9\n"+
            "            } else if (snapshot.________) { // 10\n" +
            "              return Text('${snapshot.error}');\n" +
            "            } else if (snapshot.hasData) {\n" +
            "              return Text(snapshot.________!.name); // 11\n" +
            "            } else {\n"+
            "              return const Text('No data');\n"+
            "            }\n"+
            "          },\n" +
            "        ),\n" +
            "      ),\n" +
            "    );\n" +
            "  }\n" +
            "}\n\n"+
            "// Dummy CharacterScreen for context\n"+
            "class CharacterScreen extends StatefulWidget {\n"+
            " const CharacterScreen({super.key});\n"+
            " @override\n"+
            " CharacterScreenState createState() => CharacterScreenState();\n"+
            "}";

        List<String> sugerenciasApiRest1 = Arrays.asList(
            "Character", "http", "Uri.parse", "statusCode", "jsonDecode",
            "initState", "FutureBuilder", "ConnectionState", "CircularProgressIndicator",
            "hasError", "data"
        );
        Map<Integer, String> solucionesApiRest1 = new HashMap<>();
        solucionesApiRest1.put(1, "Character");
        solucionesApiRest1.put(2, "http");
        solucionesApiRest1.put(3, "Uri.parse");
        solucionesApiRest1.put(4, "statusCode");
        solucionesApiRest1.put(5, "jsonDecode");
        solucionesApiRest1.put(6, "initState");
        solucionesApiRest1.put(7, "FutureBuilder");
        solucionesApiRest1.put(8, "ConnectionState");
        solucionesApiRest1.put(9, "CircularProgressIndicator");
        solucionesApiRest1.put(10, "hasError");
        solucionesApiRest1.put(11, "data");
        ejerciciosRellenarApiRest.add(new EjercicioRellenarCodigo(
            "Ejercicio API REST 1: Obtener y Mostrar Datos",
            codigoApiRest1,
            sugerenciasApiRest1,
            solucionesApiRest1
        ));

        // --- Ejercicio API REST 2 ---
        String codigoApiRest2 =
            "import 'dart:convert';\n" +
            "import 'package:http/http.dart' as ________; // 1\n\n" +
            "class Character {\n" +
            "  final String name;\n" +
            "  const Character({required this.name});\n" +
            "  factory Character.fromJson(Map<String, dynamic> json) {\n" +
            "    return Character(name: json['name'] ?? 'Unknown');\n" +
            "  }\n" +
            "}\n\n" +
            "class CharacterService {\n" +
            "  static const String _baseUrl = 'https://hp-api.onrender.com/api';\n\n" +
            "  Future<________<Character>> fetchAllCharacters() ________ { // 2 y 3\n" +
            "    final response = await http.get(________.parse('$_baseUrl/characters')); // 4\n" +
            "    if (response.________ == ________) { // 5 y 6\n" +
            "      final List<dynamic> jsonList = ________(response.body); // 7\n" +
            "      return jsonList.map((json) => Character.________(json as Map<String, dynamic>)).________(); // 8 y 9\n" +
            "    } else {\n" +
            "      throw ________('Fallo al cargar los personajes'); // 10\n" +
            "    }\n" +
            "  }\n" +
            "}";
        List<String> sugerenciasApiRest2 = Arrays.asList(
            "http", "List", "async", "Uri", "statusCode", "200",
            "jsonDecode", "fromJson", "toList", "Exception"
        );
        Map<Integer, String> solucionesApiRest2 = new HashMap<>();
        solucionesApiRest2.put(1, "http");
        solucionesApiRest2.put(2, "List");
        solucionesApiRest2.put(3, "async");
        solucionesApiRest2.put(4, "Uri");
        solucionesApiRest2.put(5, "statusCode");
        solucionesApiRest2.put(6, "200");
        solucionesApiRest2.put(7, "jsonDecode");
        solucionesApiRest2.put(8, "fromJson");
        solucionesApiRest2.put(9, "toList");
        solucionesApiRest2.put(10, "Exception");
        ejerciciosRellenarApiRest.add(new EjercicioRellenarCodigo(
            "Ejercicio API REST 2: Implementar Clase de Servicio",
            codigoApiRest2,
            sugerenciasApiRest2,
            solucionesApiRest2
        ));

    }

    private void cargarPreguntasBuild() {
        preguntasTestBuild = new ArrayList<>();
        String pregunta;
        List<String> opciones;
        String respuestaCorrecta;

        // Pregunta 1
        pregunta = "1. ¿Cuál es el formato moderno requerido por Google Play para enviar apps?";
        opciones = new ArrayList<>(Arrays.asList(
                "APK",
                "AAB",
                "JAR",
                "ZIP"
        ));
        respuestaCorrecta = "AAB";
        Collections.shuffle(opciones);
        preguntasTestBuild.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 2
        pregunta = "2. ¿Cuándo comenzó Google Play a requerir AAB en lugar de APK?";
        opciones = new ArrayList<>(Arrays.asList(
                "Agosto 2020",
                "Agosto 2021",
                "Enero 2022",
                "Marzo 2023"
        ));
        respuestaCorrecta = "Agosto 2021";
        Collections.shuffle(opciones);
        preguntasTestBuild.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 3
        pregunta = "3. ¿Cuál es una ventaja de AAB sobre APK?";
        opciones = new ArrayList<>(Arrays.asList(
                "Mayor tamaño de app",
                "Menor tamaño de descarga",
                "Actualizaciones más lentas",
                "Menos compatibilidad"
        ));
        respuestaCorrecta = "Menor tamaño de descarga";
        Collections.shuffle(opciones);
        preguntasTestBuild.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 4
        pregunta = "4. ¿Qué comando actualiza el SDK de Flutter?";
        opciones = new ArrayList<>(Arrays.asList(
                "`flutter update`",
                "`flutter upgrade`",
                "`flutter install`",
                "`flutter refresh`"
        ));
        respuestaCorrecta = "`flutter upgrade`";
        Collections.shuffle(opciones);
        preguntasTestBuild.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 5
        pregunta = "5. ¿Dónde se define el `applicationId` de la app?";
        opciones = new ArrayList<>(Arrays.asList(
                "`pubspec.yaml`",
                "`AndroidManifest.xml`",
                "`build.gradle`", // Correct
                "`key.properties`"
        ));
        respuestaCorrecta = "`build.gradle`";
        Collections.shuffle(opciones);
        preguntasTestBuild.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 6
        pregunta = "6. ¿Cuál es el propósito de un ícono de app en Flutter?";
        opciones = new ArrayList<>(Arrays.asList(
                "Formatear fechas",
                "Identificar la app visualmente",
                "Hacer llamadas a la API",
                "Firmar la app"
        ));
        respuestaCorrecta = "Identificar la app visualmente";
        Collections.shuffle(opciones);
        preguntasTestBuild.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 7
        pregunta = "7. ¿Qué formato de versionado se recomienda para apps Flutter?";
        opciones = new ArrayList<>(Arrays.asList(
                "`X.Y.Z`", // Referring to versionName, though pubspec uses X.Y.Z+B
                "`X-Y-Z`",
                "`X/Y/Z`",
                "`X.Y`"
        ));
        respuestaCorrecta = "`X.Y.Z`";
        Collections.shuffle(opciones);
        preguntasTestBuild.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 8
        pregunta = "8. ¿Qué comando construye un AAB en Flutter?";
        opciones = new ArrayList<>(Arrays.asList(
                "`flutter build apk`",
                "`flutter build appbundle`",
                "`flutter build release`",
                "`flutter build aab`"
        ));
        respuestaCorrecta = "`flutter build appbundle`";
        Collections.shuffle(opciones);
        preguntasTestBuild.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 9
        pregunta = "9. ¿Dónde se genera el archivo AAB?";
        opciones = new ArrayList<>(Arrays.asList(
                "`[proyecto]/build/app/outputs/apk/release`",
                "`[proyecto]/build/app/outputs/bundle/release`",
                "`[proyecto]/android/app/release`",
                "`[proyecto]/build/release`"
        ));
        respuestaCorrecta = "`[proyecto]/build/app/outputs/bundle/release`";
        Collections.shuffle(opciones);
        preguntasTestBuild.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 10
        pregunta = "10. ¿Para qué se usa un keystore en Flutter?";
        opciones = new ArrayList<>(Arrays.asList(
                "Almacenar traducciones",
                "Firmar la app",
                "Formatear números",
                "Configurar rutas"
        ));
        respuestaCorrecta = "Firmar la app";
        Collections.shuffle(opciones);
        preguntasTestBuild.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 11
        pregunta = "11. ¿Qué comando crea un keystore?";
        opciones = new ArrayList<>(Arrays.asList(
                "`keytool -genkey -v -keystore key.jks`", // Simplified, needs more args usually
                "`flutter create keystore`",
                "`keytool -create -keystore`",
                "`flutter sign app`"
        ));
        respuestaCorrecta = "`keytool -genkey -v -keystore key.jks`";
        Collections.shuffle(opciones);
        preguntasTestBuild.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 12
        pregunta = "12. ¿Dónde se debe almacenar el archivo keystore?";
        opciones = new ArrayList<>(Arrays.asList(
                "En el código fuente de la app",
                "En una ubicación segura y privada",
                "En `pubspec.yaml`",
                "En Google Play Console"
        ));
        respuestaCorrecta = "En una ubicación segura y privada";
        Collections.shuffle(opciones);
        preguntasTestBuild.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 13
        pregunta = "13. ¿Qué archivo referencia el keystore en un proyecto Flutter?";
        opciones = new ArrayList<>(Arrays.asList(
                "`AndroidManifest.xml`",
                "`key.properties`", // Which is then referenced by build.gradle
                "`pubspec.yaml`",
                "`proguard-rules.pro`"
        ));
        respuestaCorrecta = "`key.properties`";
        Collections.shuffle(opciones);
        preguntasTestBuild.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 14
        pregunta = "14. ¿Cuál es el propósito de ProGuard en Flutter?";
        opciones = new ArrayList<>(Arrays.asList(
                "Hacer llamadas a la API",
                "Ofuscar el código", // And minify with R8
                "Formatear fechas",
                "Generar íconos"
        ));
        respuestaCorrecta = "Ofuscar el código";
        Collections.shuffle(opciones);
        preguntasTestBuild.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 15
        pregunta = "15. ¿Qué archivo contiene las reglas de ProGuard?";
        opciones = new ArrayList<>(Arrays.asList(
                "`proguard-rules.pro`",
                "`build.gradle`",
                "`key.properties`",
                "`AndroidManifest.xml`"
        ));
        respuestaCorrecta = "`proguard-rules.pro`";
        Collections.shuffle(opciones);
        preguntasTestBuild.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 16
        pregunta = "16. ¿Cómo se habilita ProGuard en `build.gradle`?";
        opciones = new ArrayList<>(Arrays.asList(
                "Establecer `minifyEnabled true`", // And useProguard true if needed
                "Establecer `signingConfig debug`",
                "Establecer `useProguard false`",
                "Establecer `minifyEnabled false`"
        ));
        respuestaCorrecta = "Establecer `minifyEnabled true`";
        Collections.shuffle(opciones);
        preguntasTestBuild.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 17
        pregunta = "17. ¿Cuál es el costo de una cuenta de desarrollador en Google Play?";
        opciones = new ArrayList<>(Arrays.asList(
                "$10",
                "$25",
                "$50",
                "Gratis"
        ));
        respuestaCorrecta = "$25";
        Collections.shuffle(opciones);
        preguntasTestBuild.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 18
        pregunta = "18. ¿Dónde se sube el AAB en Google Play Console?";
        opciones = new ArrayList<>(Arrays.asList(
                "Lanzamientos de Apps", // Or Production/Testing tracks
                "Listado de Tienda",
                "Clasificación de Contenido",
                "Precios"
        ));
        respuestaCorrecta = "Lanzamientos de Apps";
        Collections.shuffle(opciones);
        preguntasTestBuild.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 19
        pregunta = "19. ¿Qué es el versionado semántico?";
        opciones = new ArrayList<>(Arrays.asList(
                "Mayor.Menor.Parche",
                "Año.Mes.Día",
                "Alpha.Beta.Lanzamiento",
                "Primario.Secundario.Terciario"
        ));
        respuestaCorrecta = "Mayor.Menor.Parche";
        Collections.shuffle(opciones);
        preguntasTestBuild.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 20
        pregunta = "20. ¿Qué representa `versionCode` en `build.gradle`?";
        opciones = new ArrayList<>(Arrays.asList(
                "Nombre de la app",
                "Número de versión interno",
                "Nombre de versión público",
                "Alias del keystore"
        ));
        respuestaCorrecta = "Número de versión interno";
        Collections.shuffle(opciones);
        preguntasTestBuild.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 21
        pregunta = "21. ¿Qué herramienta puede generar íconos de app para diferentes tamaños?";
        opciones = new ArrayList<>(Arrays.asList(
                "`flutter icon`",
                "`https://www.appicon.co/`", // Example external tool
                "`keytool`",
                "`bundletool`"
        ));
        respuestaCorrecta = "`https://www.appicon.co/`"; // Also flutter_launcher_icons package
        Collections.shuffle(opciones);
        preguntasTestBuild.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 22
        pregunta = "22. ¿Por qué es importante la ofuscación de código?";
        opciones = new ArrayList<>(Arrays.asList(
                "Para reducir el tamaño de la app",
                "Para proteger contra ingeniería inversa",
                "Para mejorar el rendimiento",
                "Para simplificar la depuración"
        ));
        respuestaCorrecta = "Para proteger contra ingeniería inversa";
        Collections.shuffle(opciones);
        preguntasTestBuild.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 23
        pregunta = "23. ¿Cuál es el valor predeterminado de `minSdk` en Flutter?";
        opciones = new ArrayList<>(Arrays.asList(
                "`flutter.minSdkVersion`", // Reads from Flutter config
                "16",
                "21", // Common default, but Flutter manages it
                "30"
        ));
        respuestaCorrecta = "`flutter.minSdkVersion`";
        Collections.shuffle(opciones);
        preguntasTestBuild.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 24
        pregunta = "24. ¿Qué pasa si se pierde el keystore?";
        opciones = new ArrayList<>(Arrays.asList(
                "La app aún puede actualizarse",
                "Se debe crear un nuevo keystore, pero las actualizaciones están bloqueadas",
                "La app debe republicarse con un nuevo nombre de paquete", // Or use Play App Signing key reset if enabled
                "La app se bloquea"
        ));
        respuestaCorrecta = "La app debe republicarse con un nuevo nombre de paquete";
        Collections.shuffle(opciones);
        preguntasTestBuild.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 25
        pregunta = "25. ¿Cuál es el propósito de `versionName` en `build.gradle`?";
        opciones = new ArrayList<>(Arrays.asList(
                "Número de versión interno",
                "Versión pública mostrada a los usuarios",
                "Contraseña del keystore",
                "ID de la app"
        ));
        respuestaCorrecta = "Versión pública mostrada a los usuarios";
        Collections.shuffle(opciones);
        preguntasTestBuild.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 26
        pregunta = "26. ¿Qué produce `flutter build appbundle`?";
        opciones = new ArrayList<>(Arrays.asList(
                "`app-release.apk`",
                "`app-release.aab`",
                "`app-debug.aab`",
                "`app-debug.apk`"
        ));
        respuestaCorrecta = "`app-release.aab`";
        Collections.shuffle(opciones);
        preguntasTestBuild.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 27
        pregunta = "27. ¿Qué se requiere para probar un AAB en un dispositivo?";
        opciones = new ArrayList<>(Arrays.asList(
                "`flutter run`",
                "`bundletool`", // Or upload to Play Console internal test track
                "`keytool`",
                "`http`"
        ));
        respuestaCorrecta = "`bundletool`";
        Collections.shuffle(opciones);
        preguntasTestBuild.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 28
        pregunta = "28. ¿Qué debe incluirse en los entregables de la actividad?";
        opciones = new ArrayList<>(Arrays.asList(
                "Un video y documentación",
                "Solo el archivo AAB",
                "Solo el código fuente",
                "Un archivo de traducción"
        ));
        respuestaCorrecta = "Un video y documentación";
        Collections.shuffle(opciones);
        preguntasTestBuild.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 29
        pregunta = "29. ¿Por qué se requieren revisiones periódicas de progreso?";
        opciones = new ArrayList<>(Arrays.asList(
                "Para reducir el tamaño de la app",
                "Para verificar el progreso de aprendizaje",
                "Para generar íconos",
                "Para formatear números"
        ));
        respuestaCorrecta = "Para verificar el progreso de aprendizaje";
        Collections.shuffle(opciones);
        preguntasTestBuild.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));

        // Pregunta 30
        pregunta = "30. ¿Cuál es el beneficio de Play Feature Delivery en AAB?";
        opciones = new ArrayList<>(Arrays.asList(
                "Llamadas a API más rápidas",
                "Funciones modulares de la app",
                "Íconos más pequeños",
                "Enrutamiento simplificado"
        ));
        respuestaCorrecta = "Funciones modulares de la app";
        Collections.shuffle(opciones);
        preguntasTestBuild.add(new PreguntaTest(pregunta, opciones, respuestaCorrecta));
    }


    private void cargarEjerciciosBuild() {
        ejerciciosRellenarBuild = new ArrayList<>();

        // --- Ejercicio Build 1 ---
        String codigoBuild1 =
            "// En android/app/build.gradle\n\n" +
            "def keystoreProperties = new ________() // 1\n" +
            "def keystorePropertiesFile = rootProject.file('________') // 2\n" +
            "if (________.exists()) { // 3\n" +
            "    keystorePropertiesFile.withReader('UTF-8') { reader ->\n"+
            "        ________.load(reader) // 4\n"+
            "    }\n"+
            "}\n\n" +
            "android {\n" +
            "    // ...\n" +
            "    ________ { // 5: Bloque de configuraciones de firma\n" +
            "        release {\n" +
            "            keyAlias keystoreProperties['________'] // 6\n" +
            "            keyPassword keystoreProperties['________'] // 7\n" +
            "            storeFile file(keystoreProperties['________']) // 8\n" +
            "            storePassword keystoreProperties['________'] // 9\n" +
            "        }\n" +
            "    }\n\n" +
            "    buildTypes {\n" +
            "        release {\n" +
            "            signingConfig ________.release // 10: Aplicar la config de firma\n" +
            "            // ... otras configuraciones como minifyEnabled ...\n" +
            "        }\n" +
            "    }\n" +
            "    // ...\n" +
            "}";
        List<String> sugerenciasBuild1 = Arrays.asList(
            "Properties", "key.properties", "keystorePropertiesFile", "keystoreProperties",
            "signingConfigs", "keyAlias", "keyPassword", "storeFile", "storePassword",
            "signingConfigs"
        );
        Map<Integer, String> solucionesBuild1 = new HashMap<>();
        solucionesBuild1.put(1, "Properties");
        solucionesBuild1.put(2, "key.properties");
        solucionesBuild1.put(3, "keystorePropertiesFile");
        solucionesBuild1.put(4, "keystoreProperties");
        solucionesBuild1.put(5, "signingConfigs");
        solucionesBuild1.put(6, "keyAlias");
        solucionesBuild1.put(7, "keyPassword");
        solucionesBuild1.put(8, "storeFile");
        solucionesBuild1.put(9, "storePassword");
        solucionesBuild1.put(10, "signingConfigs");
        ejerciciosRellenarBuild.add(new EjercicioRellenarCodigo(
            "Ejercicio Build 1: Configurar Firma en build.gradle",
            codigoBuild1,
            sugerenciasBuild1,
            solucionesBuild1
        ));

        // --- Ejercicio Build 2 ---
        String codigoBuild2 =
            "// En android/app/proguard-rules.pro\n\n" +
            "# Reglas básicas para mantener clases de Flutter\n" +
            "-keep class io.flutter.app.** { ________; } // 1\n" +
            "-keep class io.flutter.plugin.** { *; }\n" +
            "-keep class io.flutter.util.** { *; }\n" +
            "-keep class io.flutter.view.** { *; }\n" +
            "-keep class io.flutter.** { *; }\n" +
            "-keep class io.flutter.plugins.** { *; }\n\n" +
            "# Para Platform Views (si se usan)\n"+
            "-keep class io.flutter.embedding.android.FlutterActivity { *; }\n"+
            "\n" +
            "# Atributos importantes\n"+
            "-keepattributes ________ // 2\n" +
            "-keepattributes ________ // 3\n\n"+
            "# Añade aquí reglas específicas de tu proyecto o librerías";
        List<String> sugerenciasBuild2 = Arrays.asList(
            "*", "Signature", "Exceptions"
        );
        Map<Integer, String> solucionesBuild2 = new HashMap<>();
        solucionesBuild2.put(1, "*");
        solucionesBuild2.put(2, "Signature");
        solucionesBuild2.put(3, "Exceptions");
        ejerciciosRellenarBuild.add(new EjercicioRellenarCodigo(
            "Ejercicio Build 2: Crear Reglas de ProGuard",
            codigoBuild2,
            sugerenciasBuild2,
            solucionesBuild2
        ));
    }


    // --- Methods to retrieve study materials ---

    // Returns a shuffled list of multiple-choice questions based on the selected topic block.
    public List<PreguntaTest> getPreguntasTest(BloqueTematico bloque) {
        List<PreguntaTest> resultado = new ArrayList<>();
        // Add questions based on the selected block.
        if (bloque == BloqueTematico.I18N_L10N || bloque == BloqueTematico.AMBOS) {
            resultado.addAll(new ArrayList<>(preguntasTestI18n)); // Add a copy
        }
        if (bloque == BloqueTematico.API_REST_JSON || bloque == BloqueTematico.AMBOS) {
            resultado.addAll(new ArrayList<>(preguntasTestApiRest)); // Add a copy
        }
        if (bloque == BloqueTematico.BUILD_APK_AAB || bloque == BloqueTematico.AMBOS) {
            resultado.addAll(new ArrayList<>(preguntasTestBuild)); // Add a copy
        }
        Collections.shuffle(resultado); // Randomize question order.
        return resultado;
    }

    // Returns a shuffled list of fill-in-the-blanks exercises based on the selected topic block.
    public List<EjercicioRellenarCodigo> getEjerciciosRellenarCodigo(BloqueTematico bloque) {
        List<EjercicioRellenarCodigo> resultado = new ArrayList<>();
        // Add exercises based on the selected block.
        if (bloque == BloqueTematico.I18N_L10N || bloque == BloqueTematico.AMBOS) {
            resultado.addAll(new ArrayList<>(ejerciciosRellenarI18n)); // Add a copy
        }
        if (bloque == BloqueTematico.API_REST_JSON || bloque == BloqueTematico.AMBOS) {
            resultado.addAll(new ArrayList<>(ejerciciosRellenarApiRest)); // Add a copy
        }
        if (bloque == BloqueTematico.BUILD_APK_AAB || bloque == BloqueTematico.AMBOS) {
            resultado.addAll(new ArrayList<>(ejerciciosRellenarBuild)); // Add a copy
        }
        Collections.shuffle(resultado); // Randomize exercise order.
        return resultado;
    }
}