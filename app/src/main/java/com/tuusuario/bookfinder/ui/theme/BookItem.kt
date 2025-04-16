@Composable
fun BookItem(
    book: Book,
    onFavoriteClick: (Book) -> Unit,
    onBookClick: (Book) -> Unit = {},
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.clickable { onBookClick(book) },
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Portada del libro (si está disponible)
            AsyncImage(
                model = book.coverId?.let {
                    "https://covers.openlibrary.org/b/id/$it-S.jpg"
                },
                contentDescription = "Portada de ${book.title}",
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(4.dp)),
                error = painterResource(id = R.drawable.ic_book_placeholder),
                placeholder = painterResource(id = R.drawable.ic_book_placeholder)
            )

            Spacer(modifier = Modifier.width(16.dp))

            // Información del libro
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = book.title,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(4.dp))

                if (book.authorName.isNotEmpty()) {
                    Text(
                        text = "Por: ${book.authorName.joinToString()}",
                        style = MaterialTheme.typography.bodySmall,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                book.firstPublishYear?.let { year ->
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Publicado: $year",
                        style = MaterialTheme.typography.labelSmall
                    )
                }
            }

            // Botón de favoritos
            IconButton(
                onClick = { onFavoriteClick(book) },
                modifier = Modifier.size(48.dp)
            ) {
                Icon(
                    imageVector = if (book.isFavorite) {
                        Icons.Filled.Favorite
                    } else {
                        Icons.Outlined.Favorite
                    },
                    contentDescription = if (book.isFavorite) {
                        "Quitar de favoritos"
                    } else {
                        "Añadir a favoritos"
                    },
                    tint = if (book.isFavorite) {
                        MaterialTheme.colorScheme.error
                    } else {
                        MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                    }
                )
            }
        }
    }
}