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
        // Copied directly from the first user prompt, formatted as PreguntaTest objects
        preguntasTestI18n.add(new PreguntaTest(
            "1. ¿Cuál es el propósito principal de la internacionalización (i18n) en Flutter?",
            Arrays.asList(
                "Traducir texto a un idioma específico",
                "Diseñar software adaptable a múltiples idiomas y regiones",
                "Optimizar el rendimiento de la app",
                "Publicar apps en Google Play"
            ),
            "Diseñar software adaptable a múltiples idiomas y regiones"
        ));
        preguntasTestI18n.add(new PreguntaTest(
            "2. ¿Qué proporciona principalmente el paquete `intl` en Flutter?",
            Arrays.asList(
                "Capacidades de red",
                "Funciones de internacionalización y localización",
                "Widgets de interfaz",
                "Gestión de bases de datos"
            ),
            "Funciones de internacionalización y localización"
        ));
        preguntasTestI18n.add(new PreguntaTest(
            "3. ¿Cómo se instala el paquete `intl` en un proyecto Flutter?",
            Arrays.asList(
                "`flutter add intl`",
                "`flutter pub add intl`",
                "`dart install intl`",
                "`flutter get intl`"
            ),
            "`flutter pub add intl`"
        ));
        preguntasTestI18n.add(new PreguntaTest(
            "4. ¿Qué clase se usa para formatear fechas en Flutter con el paquete `intl`?",
            Arrays.asList(
                "`NumberFormat`",
                "`DateFormat`",
                "`Intl`",
                "`BidiFormatter`"
            ),
            "`DateFormat`"
        ));
        preguntasTestI18n.add(new PreguntaTest(
            "5. ¿Cuál es el resultado de `DateFormat('dd-MM-yyyy').format(DateTime(2025, 5, 12))` para el idioma `es_ES`?",
            Arrays.asList(
                "12-05-2025",
                "05/12/2025",
                "Mayo 12, 2025",
                "2025-05-12"
            ),
            "12-05-2025"
        ));
        preguntasTestI18n.add(new PreguntaTest(
            "6. ¿Qué se debe llamar antes de usar `DateFormat` con un idioma específico?",
            Arrays.asList(
                "`initializeDateFormatting('es_ES', null)`",
                "`setLocale('es_ES')`",
                "`Intl.setLocale('es_ES')`",
                "`DateFormat.initialize('es_ES')`"
            ),
            "`initializeDateFormatting('es_ES', null)`"
        ));
        preguntasTestI18n.add(new PreguntaTest(
            "7. ¿Cómo se formatea un número como moneda en Flutter para el idioma predeterminado?",
            Arrays.asList(
                "`NumberFormat.currency().format(123.45)`",
                "`NumberFormat().format(123.45)`",
                "`CurrencyFormat().format(123.45)`",
                "`Intl.currency(123.45)`"
            ),
            "`NumberFormat.currency().format(123.45)`"
        ));
        preguntasTestI18n.add(new PreguntaTest(
            "8. ¿Cuál es el propósito de los archivos `.arb` en la localización de Flutter?",
            Arrays.asList(
                "Almacenar íconos de la app",
                "Almacenar cadenas traducidas",
                "Definir rutas de la app",
                "Configurar puntos finales de API"
            ),
            "Almacenar cadenas traducidas"
        ));
        preguntasTestI18n.add(new PreguntaTest(
            "9. ¿Cómo se accede a una cadena traducida en Flutter?",
            Arrays.asList(
                "`AppLocalizations.of(context).stringKey`",
                "`Intl.getString('stringKey')`",
                "`Localizations.get(context, 'stringKey')`",
                "`Translations.of(context).stringKey`"
            ),
            "`AppLocalizations.of(context).stringKey`"
        ));
        preguntasTestI18n.add(new PreguntaTest(
            "10. ¿Qué hace `Intl.defaultLocale = 'es_ES'`?",
            Arrays.asList(
                "Establece el tema de la app",
                "Establece el idioma predeterminado para el formato",
                "Cambia el idioma del dispositivo",
                "Configura la navegación de la app"
            ),
            "Establece el idioma predeterminado para el formato"
        ));
        preguntasTestI18n.add(new PreguntaTest(
            "11. ¿Cómo se detecta el código de idioma del dispositivo en Flutter?",
            Arrays.asList(
                "`ui.window.locale.languageCode`",
                "`Intl.getLocale()`",
                "`Locale.getLanguage()`",
                "`Device.locale.language`"
            ),
            "`ui.window.locale.languageCode`"
        ));
        preguntasTestI18n.add(new PreguntaTest(
            "12. ¿Cuál es el propósito de `locale: Locale('es', 'ES')` en `MaterialApp`?",
            Arrays.asList(
                "Establece el tema de la app",
                "Especifica el idioma y la región de la app",
                "Configura las rutas de la app",
                "Habilita la depuración"
            ),
            "Especifica el idioma y la región de la app"
        ));
        preguntasTestI18n.add(new PreguntaTest(
            "13. ¿Qué widget se usa comúnmente para permitir a los usuarios seleccionar un idioma?",
            Arrays.asList(
                "`TextField`",
                "`DropdownButton`",
                "`Slider`",
                "`Checkbox`"
            ),
            "`DropdownButton`"
        ));
        preguntasTestI18n.add(new PreguntaTest(
            "14. ¿Cuál es la extensión de los archivos de traducción en Flutter?",
            Arrays.asList(
                "`.json`",
                "`.arb`",
                "`.xml`",
                "`.yaml`"
            ),
            "`.arb`"
        ));
        preguntasTestI18n.add(new PreguntaTest(
            "15. ¿Qué comando genera clases de localización en Flutter?",
            Arrays.asList(
                "`flutter gen-l10n`",
                "`flutter pub gen`",
                "`flutter localize`",
                "`flutter intl`"
            ),
            "`flutter gen-l10n`"
        ));
        preguntasTestI18n.add(new PreguntaTest(
            "16. ¿Cuántos idiomas debe soportar la app según los requisitos de la actividad?",
            Arrays.asList(
                "1",
                "2",
                "3",
                "4"
            ),
            "3" // Based on the original context mentioning "al menos tres"
        ));
        preguntasTestI18n.add(new PreguntaTest(
            "17. ¿Cuál es el resultado de `NumberFormat('#,##0.00').format(1234.567)` en `es_ES`?",
            Arrays.asList(
                "1.234,57",
                "1,234.57",
                "1234.567",
                "1.234,567"
            ),
            "1.234,57"
        ));
        preguntasTestI18n.add(new PreguntaTest(
            "18. ¿En qué se centra la localización (l10n)?",
            Arrays.asList(
                "Diseñar para múltiples idiomas",
                "Adaptar contenido para un mercado específico",
                "Optimizar el tamaño de la app",
                "Proteger las llamadas a la API"
            ),
            "Adaptar contenido para un mercado específico"
        ));
        preguntasTestI18n.add(new PreguntaTest(
            "19. ¿Qué importación se requiere para usar `DateFormat`?",
            Arrays.asList(
                "`import 'package:flutter/material.dart';`",
                "`import 'package:intl/intl.dart';`",
                "`import 'package:http/http.dart';`",
                "`import 'dart:ui';`"
            ),
            "`import 'package:intl/intl.dart';`"
        ));
        preguntasTestI18n.add(new PreguntaTest(
            "20. ¿Cómo se asegura que la app cargue el idioma predeterminado del dispositivo?",
            Arrays.asList(
                "Establecer `locale: Locale('en', 'US')`",
                "Usar `Intl.defaultLocale = ui.window.locale.languageCode`", // Though setting locale in MaterialApp based on window.locale is more common
                "Codificar el idioma en `pubspec.yaml`",
                "Usar `AppLocalizations.setLocale()`"
            ),
            "Usar `Intl.defaultLocale = ui.window.locale.languageCode`"
        ));
         preguntasTestI18n.add(new PreguntaTest(
             "21. ¿Cuál es el rol de `AppLocalizations.of(context)`?",
             Arrays.asList(
                 "Obtener datos de la API",
                 "Proporcionar acceso a cadenas traducidas",
                 "Formatear fechas",
                 "Configurar rutas"
             ),
             "Proporcionar acceso a cadenas traducidas"
         ));
         preguntasTestI18n.add(new PreguntaTest(
             "22. ¿Cuál es la forma correcta de formatear una distancia con un decimal en Flutter?",
             Arrays.asList(
                 "`NumberFormat('#,##0.0').format(150000000.57)`",
                 "`NumberFormat.currency().format(150000000.57)`",
                 "`DateFormat('#,##0.0').format(150000000.57)`",
                 "`NumberFormat().format(150000000.57)`"
             ),
             "`NumberFormat('#,##0.0').format(150000000.57)`"
         ));
         preguntasTestI18n.add(new PreguntaTest(
             "23. ¿Qué archivo contiene la configuración de idioma de la app?",
             Arrays.asList(
                 "`AndroidManifest.xml`",
                 "`pubspec.yaml`",
                 "`main.dart` (donde se configura MaterialApp)",
                 "`build.gradle`"
             ),
             "`main.dart` (donde se configura MaterialApp)"
         ));
         preguntasTestI18n.add(new PreguntaTest(
             "24. ¿Cuál es el beneficio de usar un widget selector de idioma genérico?",
             Arrays.asList(
                 "Reduce el tamaño de la app",
                 "Reusabilidad en diferentes pantallas",
                 "Mejora el rendimiento de la API",
                 "Simplifica el enrutamiento"
             ),
             "Reusabilidad en diferentes pantallas"
         ));
         preguntasTestI18n.add(new PreguntaTest(
             "25. ¿Qué ocurre si no se llama a `initializeDateFormatting` para un idioma?",
             Arrays.asList(
                 "La app se bloquea",
                 "El formato de fecha usa el idioma predeterminado",
                 "Las fechas no se muestran",
                 "La app cambia a inglés"
             ),
             "El formato de fecha usa el idioma predeterminado"
         ));
         preguntasTestI18n.add(new PreguntaTest(
             "26. ¿Cómo se especifica un símbolo de moneda personalizado en `NumberFormat`?",
             Arrays.asList(
                 "`NumberFormat.currency(symbol: '€')`",
                 "`NumberFormat(symbol: '€')`",
                 "`CurrencyFormat('€')`",
                 "`NumberFormat.setSymbol('€')`"
             ),
             "`NumberFormat.currency(symbol: '€')`"
         ));
         preguntasTestI18n.add(new PreguntaTest(
             "27. ¿Cuál es el propósito de `numberFormatSymbols` en el paquete `intl`?",
             Arrays.asList(
                 "Define puntos finales de API",
                 "Personaliza símbolos de formato de números",
                 "Almacena traducciones",
                 "Configura íconos de la app"
             ),
             "Personaliza símbolos de formato de números"
         ));
         preguntasTestI18n.add(new PreguntaTest(
             "28. ¿Qué código de idioma representa el español de España?",
             Arrays.asList(
                 "`en_US`",
                 "`es_ES`",
                 "`fr_FR`",
                 "`es_MX`"
             ),
             "`es_ES`"
         ));
         preguntasTestI18n.add(new PreguntaTest(
             "29. ¿Cuál es el comportamiento predeterminado de una app sin localización?",
             Arrays.asList(
                 "Usa el idioma del dispositivo",
                 "Usa inglés por defecto",
                 "Se bloquea al iniciar",
                 "No muestra texto"
             ),
             "Usa inglés por defecto" // Usually defaults to 'en' or the first locale listed if any.
         ));
         preguntasTestI18n.add(new PreguntaTest(
             "30. ¿Por qué es importante soportar múltiples idiomas en una app?",
             Arrays.asList(
                 "Para reducir el tamaño de la app",
                 "Para mejorar el rendimiento",
                 "Para llegar a una audiencia global",
                 "Para simplificar la depuración"
             ),
             "Para llegar a una audiencia global"
         ));
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
            "           SizedBox(width: 10)\n"+
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
        // Copied directly from the first user prompt, formatted as PreguntaTest objects
        preguntasTestApiRest.add(new PreguntaTest(
            "1. ¿Qué permite una API REST en una app Flutter?",
            Arrays.asList(
                "Almacenamiento de datos local",
                "Comunicación con servidores externos",
                "Animaciones de interfaz",
                "Publicación de apps"
            ),
            "Comunicación con servidores externos"
        ));
        preguntasTestApiRest.add(new PreguntaTest(
            "2. ¿Qué formato se usa comúnmente para transmitir datos en APIs REST?",
            Arrays.asList(
                "XML",
                "JSON",
                "CSV",
                "YAML"
            ),
            "JSON"
        ));
        preguntasTestApiRest.add(new PreguntaTest(
            "3. ¿Qué paquete se usa para solicitudes HTTP en Flutter?",
            Arrays.asList(
                "`intl`",
                "`http`",
                "`dio`",
                "`flutter_network`"
            ),
            "`http`"
        ));
        preguntasTestApiRest.add(new PreguntaTest(
            "4. ¿Cómo se instala el paquete `http`?",
            Arrays.asList(
                "`flutter pub add http`",
                "`flutter add http`",
                "`dart install http`",
                "`flutter get http`"
            ),
            "`flutter pub add http`"
        ));
        preguntasTestApiRest.add(new PreguntaTest(
            "5. ¿Qué permiso es necesario para solicitudes HTTP en Android?",
            Arrays.asList(
                "`android.permission.BLUETOOTH`",
                "`android.permission.INTERNET`",
                "`android.permission.CAMERA`",
                "`android.permission.STORAGE`"
            ),
            "`android.permission.INTERNET`"
        ));
        preguntasTestApiRest.add(new PreguntaTest(
            "6. ¿Qué devuelve `http.get` en Flutter?",
            Arrays.asList(
                "`Future<String>`",
                "`Future<http.Response>`",
                "`http.Response`",
                "`Future<Map>`"
            ),
            "`Future<http.Response>`"
        ));
        preguntasTestApiRest.add(new PreguntaTest(
            "7. ¿Cómo se parsea JSON en Flutter?",
            Arrays.asList(
                "Usar `jsonDecode`",
                "Usar `http.parse`",
                "Usar `JsonParser`",
                "Usar `decodeJson`"
            ),
            "Usar `jsonDecode`"
        ));
        preguntasTestApiRest.add(new PreguntaTest(
            "8. ¿Cuál es el propósito de un método factory `fromJson`?",
            Arrays.asList(
                "Hacer solicitudes HTTP",
                "Convertir JSON a un objeto Dart",
                "Formatear fechas",
                "Almacenar datos localmente"
            ),
            "Convertir JSON a un objeto Dart"
        ));
        preguntasTestApiRest.add(new PreguntaTest(
            "9. ¿Qué código de estado HTTP indica una respuesta exitosa?",
            Arrays.asList(
                "404",
                "500",
                "200",
                "301"
            ),
            "200"
        ));
        preguntasTestApiRest.add(new PreguntaTest(
            "10. ¿Qué widget se usa para manejar datos asíncronos en Flutter?",
            Arrays.asList(
                "`StreamBuilder`",
                "`FutureBuilder`",
                "`ListView`",
                "`GridView`"
            ),
            "`FutureBuilder`"
        ));
        preguntasTestApiRest.add(new PreguntaTest(
            "11. ¿Dónde se deben inicializar las llamadas a la API en un StatefulWidget?",
            Arrays.asList(
                "`build`",
                "`initState`",
                "`dispose`",
                "`setState`"
            ),
            "`initState`"
        ));
        preguntasTestApiRest.add(new PreguntaTest(
            "12. ¿Cuál es el propósito de una clase de servicio en el manejo de APIs?",
            Arrays.asList(
                "Diseñar componentes de interfaz",
                "Centralizar las llamadas a la API",
                "Gestionar rutas de la app",
                "Formatear números"
            ),
            "Centralizar las llamadas a la API"
        ));
        preguntasTestApiRest.add(new PreguntaTest(
            "13. ¿Qué devuelve `jsonDecode(response.body)`?",
            Arrays.asList(
                "Una cadena",
                "Un objeto Dart (Map o List)",
                "Una respuesta HTTP",
                "Un Future"
            ),
            "Un objeto Dart (Map o List)"
        ));
        preguntasTestApiRest.add(new PreguntaTest(
            "14. ¿Cuál es la URL de la API de Harry Potter en la actividad?",
            Arrays.asList(
                "`https://api.harrypotter.com`",
                "`https://hp-api.onrender.com`", // Note: Corrected from prompt which missed final `/` in notes but had it in activity.
                "`https://jsonplaceholder.typicode.com`",
                "`https://potterapi.com`"
            ),
            "`https://hp-api.onrender.com`"
        ));
        preguntasTestApiRest.add(new PreguntaTest(
            "15. ¿Qué arquitectura se requiere para la app de Harry Potter?",
            Arrays.asList(
                "MVC",
                "MVVM",
                "Redux",
                "BLoC"
            ),
            "MVC"
        ));
        preguntasTestApiRest.add(new PreguntaTest(
            "16. ¿Cómo se manejan los errores en las llamadas a la API?",
            Arrays.asList(
                "Ignorarlos",
                "Verificar el código de estado HTTP",
                "Usar solo `try-catch`",
                "Recargar la app"
            ),
            "Verificar el código de estado HTTP"
        ));
        preguntasTestApiRest.add(new PreguntaTest(
            "17. ¿Cuál es el propósito de `snapshot.hasData` en `FutureBuilder`?",
            Arrays.asList(
                "Verifica errores",
                "Indica si hay datos disponibles",
                "Provoca una reconstrucción",
                "Formatea los datos"
            ),
            "Indica si hay datos disponibles"
        ));
        preguntasTestApiRest.add(new PreguntaTest(
            "18. ¿Qué se debe evitar al obtener datos de la API?",
            Arrays.asList(
                "Usar clases modelo",
                "Codificar datos de forma fija",
                "Usar `FutureBuilder`",
                "Centralizar servicios"
            ),
            "Codificar datos de forma fija"
        ));
        preguntasTestApiRest.add(new PreguntaTest(
            "19. ¿Cuál es el rol de `routes.dart` en la app de Harry Potter?",
            Arrays.asList(
                "Almacenar traducciones",
                "Centralizar la navegación",
                "Hacer llamadas a la API",
                "Formatear fechas"
            ),
            "Centralizar la navegación"
        ));
        preguntasTestApiRest.add(new PreguntaTest(
            "20. ¿Qué tipo de pantalla se requiere en la app de Harry Potter?",
            Arrays.asList(
                "Configuración",
                "Splash",
                "Perfil",
                "Pago"
            ),
            "Splash"
        ));
         preguntasTestApiRest.add(new PreguntaTest(
             "21. ¿Cómo se hace una solicitud HTTP asíncrona?",
             Arrays.asList(
                 "Usar `async` y `await`",
                 "Usar `sync`",
                 "Usar `Future.delayed`",
                 "Usar `Stream`"
             ),
             "Usar `async` y `await`"
         ));
         preguntasTestApiRest.add(new PreguntaTest(
             "22. ¿Qué ocurre si una llamada a la API devuelve un código de estado 404?",
             Arrays.asList(
                 "La solicitud fue exitosa",
                 "El recurso no se encontró",
                 "El servidor falló",
                 "La app se bloquea"
             ),
             "El recurso no se encontró"
         ));
         preguntasTestApiRest.add(new PreguntaTest(
             "23. ¿Cuál es el beneficio de usar clases modelo para datos de API?",
             Arrays.asList(
                 "Reduce el tamaño de la app",
                 "Mejora la seguridad de tipos",
                 "Simplifica el diseño de la interfaz",
                 "Acelera las llamadas a la API"
             ),
             "Mejora la seguridad de tipos"
         ));
         preguntasTestApiRest.add(new PreguntaTest(
             "24. ¿Qué hace `Uri.parse` en una solicitud HTTP?",
             Arrays.asList(
                 "Convierte una cadena a un URI",
                 "Parsea datos JSON",
                 "Formatea una URL",
                 "Codifica datos"
             ),
             "Convierte una cadena a un URI"
         ));
         preguntasTestApiRest.add(new PreguntaTest(
             "25. ¿Qué widget se muestra por defecto en `FutureBuilder` mientras se carga?",
             Arrays.asList(
                 "`Text`",
                 "`CircularProgressIndicator`",
                 "`Container`",
                 "`Icon`"
             ),
             "`CircularProgressIndicator`" // Common practice
         ));
         preguntasTestApiRest.add(new PreguntaTest(
             "26. ¿Por qué se usa `initState` para las llamadas a la API?",
             Arrays.asList(
                 "Para manejar la entrada del usuario",
                 "Para inicializar datos cuando se crea el widget",
                 "Para liberar recursos",
                 "Para actualizar la interfaz"
             ),
             "Para inicializar datos cuando se crea el widget"
         ));
         preguntasTestApiRest.add(new PreguntaTest(
             "27. ¿Cuál es el propósito de la pantalla de Login en la app de Harry Potter?",
             Arrays.asList(
                 "Mostrar datos de la API",
                 "Autenticar usuarios",
                 "Seleccionar idiomas",
                 "Configurar ajustes"
             ),
             "Autenticar usuarios" // Assumed purpose based on name
         ));
         preguntasTestApiRest.add(new PreguntaTest(
             "28. ¿Qué debe incluir una clase modelo para datos de API?",
             Arrays.asList(
                 "Widgets de interfaz",
                 "Solicitudes HTTP",
                 "Propiedades y `fromJson`",
                 "Rutas de navegación"
             ),
             "Propiedades y `fromJson`"
         ));
         preguntasTestApiRest.add(new PreguntaTest(
             "29. ¿Cómo se centraliza la navegación en Flutter?",
             Arrays.asList(
                 "Usar `Navigator.push`",
                 "Definir rutas en `routes.dart`",
                 "Usar `http.get`",
                 "Usar `MaterialApp`"
             ),
             "Definir rutas en `routes.dart`" // Or defining named routes in MaterialApp
         ));
         preguntasTestApiRest.add(new PreguntaTest(
             "30. ¿Por qué es importante el manejo de errores en las llamadas a la API?",
             Arrays.asList(
                 "Para mejorar el rendimiento",
                 "Para garantizar una buena experiencia de usuario",
                 "Para reducir el tamaño de la app",
                 "Para simplificar la codificación"
             ),
             "Para garantizar una buena experiencia de usuario"
         ));
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
        // Copied directly from the first user prompt, formatted as PreguntaTest objects
        preguntasTestBuild.add(new PreguntaTest(
            "1. ¿Cuál es el formato moderno requerido por Google Play para enviar apps?",
            Arrays.asList(
                "APK",
                "AAB",
                "JAR",
                "ZIP"
            ),
            "AAB"
        ));
        preguntasTestBuild.add(new PreguntaTest(
            "2. ¿Cuándo comenzó Google Play a requerir AAB en lugar de APK?",
            Arrays.asList(
                "Agosto 2020",
                "Agosto 2021",
                "Enero 2022",
                "Marzo 2023"
            ),
            "Agosto 2021"
        ));
         preguntasTestBuild.add(new PreguntaTest(
             "3. ¿Cuál es una ventaja de AAB sobre APK?",
             Arrays.asList(
                 "Mayor tamaño de app",
                 "Menor tamaño de descarga",
                 "Actualizaciones más lentas",
                 "Menos compatibilidad"
             ),
             "Menor tamaño de descarga"
         ));
         preguntasTestBuild.add(new PreguntaTest(
             "4. ¿Qué comando actualiza el SDK de Flutter?",
             Arrays.asList(
                 "`flutter update`",
                 "`flutter upgrade`",
                 "`flutter install`",
                 "`flutter refresh`"
             ),
             "`flutter upgrade`"
         ));
         preguntasTestBuild.add(new PreguntaTest(
             "5. ¿Dónde se define el `applicationId` de la app?",
             Arrays.asList(
                 "`pubspec.yaml`",
                 "`AndroidManifest.xml`",
                 "`build.gradle`",
                 "`key.properties`"
             ),
             "`build.gradle`"
         ));
         preguntasTestBuild.add(new PreguntaTest(
             "6. ¿Cuál es el propósito de un ícono de app en Flutter?",
             Arrays.asList(
                 "Formatear fechas",
                 "Identificar la app visualmente",
                 "Hacer llamadas a la API",
                 "Firmar la app"
             ),
             "Identificar la app visualmente"
         ));
         preguntasTestBuild.add(new PreguntaTest(
             "7. ¿Qué formato de versionado se recomienda para apps Flutter?",
             Arrays.asList(
                 "`X.Y.Z`",
                 "`X-Y-Z`",
                 "`X/Y/Z`",
                 "`X.Y`"
             ),
             "`X.Y.Z`" // Referring to versionName, though pubspec uses X.Y.Z+B
         ));
         preguntasTestBuild.add(new PreguntaTest(
             "8. ¿Qué comando construye un AAB en Flutter?",
             Arrays.asList(
                 "`flutter build apk`",
                 "`flutter build appbundle`",
                 "`flutter build release`",
                 "`flutter build aab`"
             ),
             "`flutter build appbundle`"
         ));
         preguntasTestBuild.add(new PreguntaTest(
             "9. ¿Dónde se genera el archivo AAB?",
             Arrays.asList(
                 "`[proyecto]/build/app/outputs/apk/release`",
                 "`[proyecto]/build/app/outputs/bundle/release`",
                 "`[proyecto]/android/app/release`",
                 "`[proyecto]/build/release`"
             ),
             "`[proyecto]/build/app/outputs/bundle/release`"
         ));
         preguntasTestBuild.add(new PreguntaTest(
             "10. ¿Para qué se usa un keystore en Flutter?",
             Arrays.asList(
                 "Almacenar traducciones",
                 "Firmar la app",
                 "Formatear números",
                 "Configurar rutas"
             ),
             "Firmar la app"
         ));
         preguntasTestBuild.add(new PreguntaTest(
             "11. ¿Qué comando crea un keystore?",
             Arrays.asList(
                 "`keytool -genkey -v -keystore key.jks`", // Simplified, needs more args usually
                 "`flutter create keystore`",
                 "`keytool -create -keystore`",
                 "`flutter sign app`"
             ),
             "`keytool -genkey -v -keystore key.jks`"
         ));
         preguntasTestBuild.add(new PreguntaTest(
             "12. ¿Dónde se debe almacenar el archivo keystore?",
             Arrays.asList(
                 "En el código fuente de la app",
                 "En una ubicación segura y privada",
                 "En `pubspec.yaml`",
                 "En Google Play Console"
             ),
             "En una ubicación segura y privada"
         ));
         preguntasTestBuild.add(new PreguntaTest(
             "13. ¿Qué archivo referencia el keystore en un proyecto Flutter?",
             Arrays.asList(
                 "`AndroidManifest.xml`",
                 "`key.properties`",
                 "`pubspec.yaml`",
                 "`proguard-rules.pro`"
             ),
             "`key.properties`" // Which is then referenced by build.gradle
         ));
         preguntasTestBuild.add(new PreguntaTest(
             "14. ¿Cuál es el propósito de ProGuard en Flutter?",
             Arrays.asList(
                 "Hacer llamadas a la API",
                 "Ofuscar el código", // And minify with R8
                 "Formatear fechas",
                 "Generar íconos"
             ),
             "Ofuscar el código"
         ));
         preguntasTestBuild.add(new PreguntaTest(
             "15. ¿Qué archivo contiene las reglas de ProGuard?",
             Arrays.asList(
                 "`proguard-rules.pro`",
                 "`build.gradle`",
                 "`key.properties`",
                 "`AndroidManifest.xml`"
             ),
             "`proguard-rules.pro`"
         ));
         preguntasTestBuild.add(new PreguntaTest(
             "16. ¿Cómo se habilita ProGuard en `build.gradle`?",
             Arrays.asList(
                 "Establecer `minifyEnabled true`", // And useProguard true if needed
                 "Establecer `signingConfig debug`",
                 "Establecer `useProguard false`",
                 "Establecer `minifyEnabled false`"
             ),
             "Establecer `minifyEnabled true`"
         ));
         preguntasTestBuild.add(new PreguntaTest(
             "17. ¿Cuál es el costo de una cuenta de desarrollador en Google Play?",
             Arrays.asList(
                 "$10",
                 "$25",
                 "$50",
                 "Gratis"
             ),
             "$25"
         ));
         preguntasTestBuild.add(new PreguntaTest(
             "18. ¿Dónde se sube el AAB en Google Play Console?",
             Arrays.asList(
                 "Lanzamientos de Apps",
                 "Listado de Tienda",
                 "Clasificación de Contenido",
                 "Precios"
             ),
             "Lanzamientos de Apps" // Or Production/Testing tracks
         ));
         preguntasTestBuild.add(new PreguntaTest(
             "19. ¿Qué es el versionado semántico?",
             Arrays.asList(
                 "Mayor.Menor.Parche",
                 "Año.Mes.Día",
                 "Alpha.Beta.Lanzamiento",
                 "Primario.Secundario.Terciario"
             ),
             "Mayor.Menor.Parche"
         ));
         preguntasTestBuild.add(new PreguntaTest(
             "20. ¿Qué representa `versionCode` en `build.gradle`?",
             Arrays.asList(
                 "Nombre de la app",
                 "Número de versión interno",
                 "Nombre de versión público",
                 "Alias del keystore"
             ),
             "Número de versión interno"
         ));
         preguntasTestBuild.add(new PreguntaTest(
             "21. ¿Qué herramienta puede generar íconos de app para diferentes tamaños?",
             Arrays.asList(
                 "`flutter icon`",
                 "`https://www.appicon.co/`", // Example external tool
                 "`keytool`",
                 "`bundletool`"
             ),
             "`https://www.appicon.co/`" // Also flutter_launcher_icons package
         ));
         preguntasTestBuild.add(new PreguntaTest(
             "22. ¿Por qué es importante la ofuscación de código?",
             Arrays.asList(
                 "Para reducir el tamaño de la app",
                 "Para proteger contra ingeniería inversa",
                 "Para mejorar el rendimiento",
                 "Para simplificar la depuración"
             ),
             "Para proteger contra ingeniería inversa"
         ));
         preguntasTestBuild.add(new PreguntaTest(
             "23. ¿Cuál es el valor predeterminado de `minSdk` en Flutter?",
             Arrays.asList(
                 "`flutter.minSdkVersion`", // Reads from Flutter config
                 "16",
                 "21", // Common default, but Flutter manages it
                 "30"
             ),
             "`flutter.minSdkVersion`"
         ));
         preguntasTestBuild.add(new PreguntaTest(
             "24. ¿Qué pasa si se pierde el keystore?",
             Arrays.asList(
                 "La app aún puede actualizarse",
                 "Se debe crear un nuevo keystore, pero las actualizaciones están bloqueadas",
                 "La app debe republicarse con un nuevo nombre de paquete", // Or use Play App Signing key reset if enabled
                 "La app se bloquea"
             ),
             "La app debe republicarse con un nuevo nombre de paquete"
         ));
         preguntasTestBuild.add(new PreguntaTest(
             "25. ¿Cuál es el propósito de `versionName` en `build.gradle`?",
             Arrays.asList(
                 "Número de versión interno",
                 "Versión pública mostrada a los usuarios",
                 "Contraseña del keystore",
                 "ID de la app"
             ),
             "Versión pública mostrada a los usuarios"
         ));
         preguntasTestBuild.add(new PreguntaTest(
             "26. ¿Qué produce `flutter build appbundle`?",
             Arrays.asList(
                 "`app-release.apk`",
                 "`app-release.aab`",
                 "`app-debug.aab`",
                 "`app-debug.apk`"
             ),
             "`app-release.aab`"
         ));
         preguntasTestBuild.add(new PreguntaTest(
             "27. ¿Qué se requiere para probar un AAB en un dispositivo?",
             Arrays.asList(
                 "`flutter run`",
                 "`bundletool`", // Or upload to Play Console internal test track
                 "`keytool`",
                 "`http`"
             ),
             "`bundletool`"
         ));
         preguntasTestBuild.add(new PreguntaTest(
             "28. ¿Qué debe incluirse en los entregables de la actividad?",
             Arrays.asList(
                 "Un video y documentación",
                 "Solo el archivo AAB",
                 "Solo el código fuente",
                 "Un archivo de traducción"
             ),
             "Un video y documentación"
         ));
         preguntasTestBuild.add(new PreguntaTest(
             "29. ¿Por qué se requieren revisiones periódicas de progreso?",
             Arrays.asList(
                 "Para reducir el tamaño de la app",
                 "Para verificar el progreso de aprendizaje",
                 "Para generar íconos",
                 "Para formatear números"
             ),
             "Para verificar el progreso de aprendizaje"
         ));
         preguntasTestBuild.add(new PreguntaTest(
             "30. ¿Cuál es el beneficio de Play Feature Delivery en AAB?",
             Arrays.asList(
                 "Llamadas a API más rápidas",
                 "Funciones modulares de la app",
                 "Íconos más pequeños",
                 "Enrutamiento simplificado"
             ),
             "Funciones modulares de la app"
         ));
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
            "       ________.load(reader) // 4\n"+
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
            resultado.addAll(new ArrayList<>(preguntasTestI18n)); // Add a copy to allow shuffling
        }
        if (bloque == BloqueTematico.API_REST_JSON || bloque == BloqueTematico.AMBOS) {
            resultado.addAll(new ArrayList<>(preguntasTestApiRest));
        }
        if (bloque == BloqueTematico.BUILD_APK_AAB || bloque == BloqueTematico.AMBOS) {
            resultado.addAll(new ArrayList<>(preguntasTestBuild));
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
            resultado.addAll(new ArrayList<>(ejerciciosRellenarApiRest));
        }
        if (bloque == BloqueTematico.BUILD_APK_AAB || bloque == BloqueTematico.AMBOS) {
            resultado.addAll(new ArrayList<>(ejerciciosRellenarBuild));
        }
        Collections.shuffle(resultado); // Randomize exercise order.
        return resultado;
    }
}