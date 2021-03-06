# Android-GOT-App
GOT App desarrollada en Kotlin para enseñanza en FPGS de DAM.

## Versión 1.0 (Kotlin & RecyclerView) -> commit f6fbc654026b6d9f46337a02bdd5b5e886dae438
En esta versión aprenderás:
- División de un proyecto en paquetes: activities, adapters, utils, entidades, objetos de acceso a datos.
- Creación de clases en Kotlin: clase Personaje (Character).
- Enlazado de vistas sin findViewById (con ViewBinding).
- Creación de un RecyclerView de personajes y un Adapter personalizado.
- Carga de imágenes disponibles en internet mediante la biblioteca "Picasso".
- Imágenes redondeadas usando ShapeableImageView.

## Versión 1.1 -> commit 67825bf5b63757d1c3186914fa7e50ef7afe651a
En esta versión repasarás:
- Como iniciar nuevas activities.
- Como "Matar" o "finalizar" activities (volver a la anterior).
- Creación de formularios con TextInputLayout.
- Realizar modificaciones sobre la barra superior (Toolbar/ActionBar):
    - Cambiar el título de una pantalla (setTitle) o en el manifest.
    - Añadido de botones a la barra superior (optionsMenu).
- Creación de diálogos con AlertDialog.

## Versión 1.2 (extracción de recursos) -> commit bb50a462836e304ec98495c88e30cc63d562f28e
- Extracción de strings y dimensiones a los ficheros correspondientes.

## Versión 1.3 (mejoras de código) -> commit 7cb009dc9e85bd9ec9f71539f290a8b74a1d9260
En esta versión:
- Mejoramos el comportamiento del Mock con una lista global de personajes. Simulamos una base de datos real en una clase MockData y accedemos a todo desde el DAO.
- Creamos nuestra propia clase que hereda de Application (con su propio ciclo de vida) para inicializar la lista de personajes abrir la app.
- Mostramos una imagen de tipo "no image" si la URL no es válida (o si no hay conexión a internet o similar) y un placeholder mientras se descarga
- Separamos el añadido del personaje de su detalle/edición (pero reutilizando el mismo layout, sin duplicar código)
- Añadimos funcionalidad de scroll a la pantalla de detalle/añadido de personajes para que sea más usable cuando se ve el teclado.

## Versión 1.4 (funcionalidad completa de CRUD sobre datos mockeados) -> commit 8bd2a2267cc4fb42272f4876c59af740f7bc13aa
- En esta versión se muestra como añadir funcionalidad de creación, eliminación y modificación de datos todavía sobre elementos mockeados.

## Versión 1.5 (Obtención de películas de un API Rest)
- Ahora las películas se obtienen de internet (contra thronesapi.com utilizando la librería Retrofit)
- Mejora en el manejo de clicks sobre la lista de personajes (ahora se hace desde la activity y no desde el adapter utilizando una interfaz)