@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: BookRepository
) : ViewModel() {
    // Estado de la búsqueda
    var searchQuery by mutableStateOf("")
        private set

    // Resultados de libros
    var books by mutableStateOf<List<Book>>(emptyList())
        private set

    // Estado de carga
    var isLoading by mutableStateOf(false)
        private set

    // Mensajes de error
    var errorMessage by mutableStateOf<String?>(null)
        private set

    // Función para buscar libros
    fun searchBooks() {
        // Validación básica
        if (searchQuery.isBlank()) {
            errorMessage = "Por favor ingresa un término de búsqueda"
            return
        }

        viewModelScope.launch {
            try {
                isLoading = true
                errorMessage = null
                books = repository.searchBooks(searchQuery)
            } catch (e: Exception) {
                errorMessage = "Error al buscar libros: ${e.localizedMessage}"
                books = emptyList()
            } finally {
                isLoading = false
            }
        }
    }

    // Función para actualizar la query
    fun updateSearchQuery(query: String) {
        searchQuery = query
    }

    // Función para manejar favoritos
    fun toggleFavorite(book: Book) {
        viewModelScope.launch {
            try {
                val isFavorite = repository.getFavoriteBooks()
                    .any { it.id == book.id }

                if (isFavorite) {
                    repository.removeFavorite(book.id)
                } else {
                    repository.addFavorite(book)
                }

                // Actualizamos la lista local si es necesario
                books = books.map {
                    if (it.id == book.id) {
                        it.copy(isFavorite = !isFavorite)
                    } else {
                        it
                    }
                }
            } catch (e: Exception) {
                errorMessage = "Error al actualizar favoritos"
            }
        }
    }
}