package com.tuusuario.bookfinder.navigation

sealed class Screen(val route: String) {
    object GitaliasScreen : Screen("gitlab")
    object TakePhotoScreen: Screen("takephoto")
    object MenuScreen: Screen("menu")
    object LoginScreen: Screen("login")
    object MoviesScreen: Screen("libros")
    object MovieDetailScreen: Screen("libroDetail")
    object CounterScreen: Screen("counter")
}