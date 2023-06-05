package com.project.bookshifter.book;

public record BookRequestDTO(
        Long id,
        String name,
        String author,
        String image,
        String publisher,
        Integer quantity,
        double price,
        String category,
        String description) {
}
