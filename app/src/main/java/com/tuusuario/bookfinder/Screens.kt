sealed class Screen(val route: String) {
    object Search : Screen("search") {
        // Podemos agregar parámetros si necesitamos navegar con datos
        fun createRoute() = route
    }

    object Favorites : Screen("favorites") {
        fun createRoute() = route
    }

    // Ejemplo de cómo agregar una pantalla con parámetros:
    object Details : Screen("details/{bookId}") {
        fun createRoute(bookId: String) = "details/$bookId"
    }
}