@Composable
fun AppNavigation() {
    // 1. Creamos el controlador de navegación
    val navController = rememberNavController()

    // 2. Configuramos el tema de la app
    BookFinderAppTheme {
        // 3. Scaffold para estructura básica (opcional)
        Scaffold { paddingValues ->
            // 4. Configuramos el NavHost
            NavHost(
                navController = navController,
                startDestination = Screen.Search.route,
                modifier = Modifier.padding(paddingValues)
            ) {
                // Pantalla de Búsqueda
                composable(
                    route = Screen.Search.route
                ) {
                    SearchScreen(
                        navController = navController,
                        // Inyección automática del ViewModel con Hilt
                        viewModel = hiltViewModel()
                    )
                }

                // Pantalla de Favoritos
                composable(
                    route = Screen.Favorites.route
                ) {
                    FavoritesScreen(
                        viewModel = hiltViewModel()
                    )
                }

                /* Ejemplo de pantalla con parámetros:
                composable(
                    route = Screen.Details.route,
                    arguments = listOf(
                        navArgument("bookId") {
                            type = NavType.StringType
                        }
                    )
                ) { backStackEntry ->
                    val bookId = backStackEntry.arguments?.getString("bookId") ?: ""
                    DetailsScreen(bookId = bookId)
                }
                */
            }
        }
    }
}