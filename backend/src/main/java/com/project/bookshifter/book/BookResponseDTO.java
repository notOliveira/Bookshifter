package com.project.bookshifter.book;

public record BookResponseDTO(
        Long id,
        String name,
        String image,
        String author,
        String publisher,
        Integer quantity,
        double price,
        String category,
        String description
) {
    public BookResponseDTO(Book book){
        this(
                book.getId(),
                book.getName(),
                book.getImage(),
                book.getAuthor(),
                book.getPublisher(),
                book.getQuantity(),
                book.getPrice(),
                book.getCategory(),
                book.getDescription()
        );
    }
}
