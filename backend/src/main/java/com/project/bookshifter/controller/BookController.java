package com.project.bookshifter.controller;

import com.project.bookshifter.book.Book;
import com.project.bookshifter.book.BookRepository;
import com.project.bookshifter.book.BookRequestDTO;
import com.project.bookshifter.book.BookResponseDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*") // Habilita a leitura do CORS de todas as portas
@RequestMapping("book")
//@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class}) // Desabilita a página de erros
public class BookController {

    @Autowired
    private BookRepository repository;

    // GET ALL method
    @GetMapping
    public List<BookResponseDTO> getAll(){
        List<BookResponseDTO> bookList = repository.findAll().stream().map(BookResponseDTO::new).toList();
        return bookList;
    }

    // GET method
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Livro com ID "+ id + " não encontrado"));
        return ResponseEntity.ok(book);
    }

    // POST method
    @PostMapping("/new")
    public ResponseEntity<Book> saveBook(@RequestBody BookRequestDTO data){
        Book book = new Book(data);

        if (book.getPrice() < 0) {
            return new ResponseEntity("O preço não pode ser negativo.", HttpStatus.UNPROCESSABLE_ENTITY);
        } else if (book.getQuantity() < 0) {
            return new ResponseEntity("A quantidade não pode ser negativa.", HttpStatus.UNPROCESSABLE_ENTITY);
        } else {
            Book bookjson = repository.save(book);

            return new ResponseEntity<Book>(bookjson, HttpStatus.CREATED);
        }
    }

    // DELETE method
    @DeleteMapping(path ={"/delete/{id}"})
    public ResponseEntity<Book> deleteBook(@PathVariable Long id) {
        Book book = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Livro com o ID " + id + " não encontrado"));

        Map<String, Boolean> response = new HashMap<>();
        repository.delete(book);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    // PUT method
    @PutMapping("/update/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable long id,
                                           @RequestBody Book book) {
        Book bookDB = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Livro com o ID " + id + " não encontrado"));

        // Fazendo com que os valores que não sejam enviados pela API não se transformem em nulos
        if (book.getName() == null) {;
        } else {bookDB.setName(book.getName());
        }

        if (book.getName() == null) {;
        } else {bookDB.setName(book.getName());
        }

        if (book.getImage() == null) {;
        } else {bookDB.setImage(book.getImage());
        }

        if (book.getAuthor() == null) {;
        } else {bookDB.setAuthor(book.getAuthor());
        }

        if (book.getPublisher() == null) {;
        } else {bookDB.setPublisher(book.getPublisher());
        }

        if (book.getCategory() == null) {;
        } else {bookDB.setCategory(book.getCategory());
        }

        if (book.getDescription() == null) {;
        } else {bookDB.setDescription(book.getDescription());
        }

        if (book.getPrice() < 0) {
            return new ResponseEntity("O preço não pode ser negativo.", HttpStatus.UNPROCESSABLE_ENTITY);
        } else {bookDB.setPrice(book.getPrice());
        }

        if (book.getQuantity() < 0) {
            return new ResponseEntity("A quantidade não pode ser negativa.",
                    HttpStatus.UNPROCESSABLE_ENTITY);
        } else {bookDB.setQuantity(book.getQuantity());
        }

        Book updated = repository.save(bookDB);

        return new ResponseEntity<Book>(updated, HttpStatus.OK);
    }
}
