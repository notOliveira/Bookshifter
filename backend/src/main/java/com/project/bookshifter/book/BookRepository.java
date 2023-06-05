// Não é necessário mexer!

package com.project.bookshifter.book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository
        extends JpaRepository<Book, Long> {
}
