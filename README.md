# Cobro de casilleros

Ejercicio de Programación Aplicada en Java Swing, con arquitectura MVC. JDK 8 o posterior, sin dependencias externas.

## Ejecutar en Eclipse

1. Descarga el repositorio con **Code > Download ZIP** y extrae el archivo.
2. Abre **File > Import > General > Existing Projects into Workspace**.
3. Selecciona la carpeta del proyecto `PracticaCasilleros` y pulsa **Finish**.
4. Abre `src/controlador/ControladorCasillero.java` y selecciona **Run As > Java Application**.

## MVC paso a paso

- `modelo`: contiene datos, reglas y validaciones del problema.
- `vista`: construye la ventana y sus componentes Swing.
- `controlador`: atiende los botones, obtiene los datos y actualiza los resultados.

Empieza leyendo el modelo, continúa con la vista y termina con el controlador. Su método `main` inicia la aplicación.

## Pruebas automáticas

La clase `pruebas.PruebasModelo` contiene pruebas sin bibliotecas adicionales. En Eclipse, ejecútala con **Run As > Java Application**. Si una comprobación falla, lanza `AssertionError`.

Los datos se mantienen solamente durante la sesión. No se usan base de datos, archivos de datos ni conexiones de red.
