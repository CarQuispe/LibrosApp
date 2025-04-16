@Composable
fun BookList(
    books: List<Book>,
    onFavoriteClick: (Book) -> Unit,
    onBookClick: (Book) -> Unit = {}
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(
            items = books,
            key = { it.id } // Importante para optimización
        ) { book ->
            BookItem(
                book = book,
                onFavoriteClick = onFavoriteClick,
                onBookClick = onBookClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .animateItemPlacement() // Animación al reordenar
            )
        }
    }
}