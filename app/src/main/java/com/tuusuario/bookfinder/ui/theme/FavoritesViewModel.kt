@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val repository: BookRepository
) : ViewModel() {
    var favorites by mutableStateOf<List<Book>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    init {
        loadFavorites()
    }

    fun loadFavorites() {
        viewModelScope.launch {
            isLoading = true
            favorites = repository.getFavoriteBooks()
            isLoading = false
        }
    }

    fun removeFavorite(bookId: String) {
        viewModelScope.launch {
            repository.removeFavorite(bookId)
            favorites = favorites.filter { it.id != bookId }
        }
    }
}@Composable
fun SearchScreen(
    navController: NavController,
    viewModel: SearchViewModel = hiltViewModel()
) {
    // Observamos cambios en el estado
    val searchQuery by viewModel.searchQuery.collectAsState()
    val books by viewModel.books.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Buscador de Libros") },
                actions = {
                    // Botón para ir a favoritos
                    IconButton(
                        onClick = { navController.navigate(Screen.Favorites.route) }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "Favoritos",
                            tint = MaterialTheme.colorScheme.primary
                        )
                        // Notificación de cantidad (opcional)
                        BadgedBox(
                            badge = {
                                val favoritesCount by remember {
                                    derivedStateOf { books.count { it.isFavorite } }
                                }
                                if (favoritesCount > 0) {
                                    Badge {
                                        Text(favoritesCount.toString())
                                    }
                                }
                            }
                        ) {}
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Campo de búsqueda
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { viewModel.updateSearchQuery(it) },
                label = { Text("Título, autor o ISBN") },
                modifier = Modifier.fillMaxWidth(),
                trailingIcon = {
                    if (searchQuery.isNotBlank()) {
                        IconButton(onClick = { viewModel.updateSearchQuery("") }) {
                            Icon(Icons.Default.Close, "Limpiar")
                        }
                    }
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Search
                ),
                keyboardActions = KeyboardActions(
                    onSearch = { viewModel.searchBooks() }
                ),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Botón de búsqueda
            Button(
                onClick = { viewModel.searchBooks() },
                modifier = Modifier.fillMaxWidth(),
                enabled = !isLoading && searchQuery.isNotBlank()
            ) {
                if (isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(20.dp),
                        color = MaterialTheme.colorScheme.onPrimary,
                        strokeWidth = 2.dp
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Buscando...")
                } else {
                    Text("Buscar Libros")
                }
            }

            // Mensajes de error
            errorMessage?.let { message ->
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = message,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Resultados
            when {
                isLoading -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }

                books.isNotEmpty() -> {
                    BookList(
                        books = books,
                        onFavoriteClick = { viewModel.toggleFavorite(it) },
                        onBookClick = { /* Navegar a detalles si es necesario */ }
                    )
                }

                searchQuery.isNotBlank() -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("No se encontraron resultados")
                    }
                }

                else -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Buscar",
                                modifier = Modifier.size(48.dp)
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            Text("Ingresa un término para buscar libros")
                        }
                    }
                }
            }
        }
    }
}