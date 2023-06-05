// Caso haja adição de algum atributo na classe Book, é necessário alterar todos os arquivos DTO desse diretório, adicionando as linhas para chamada do novo atributo

package com.project.bookshifter.book;

import jakarta.persistence.*;
import lombok.*;

// Cria automaticamente a tabela no banco de dados!
@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String image;
    private String author;
    private String publisher;
    private int quantity;
    private double price;
    private String category;
    private String description;

    public Book(BookRequestDTO data){
        this.name = data.name();
        this.image = data.image();
        this.author = data.author();
        this.publisher = data.publisher();
        this.quantity = data.quantity();
        this.price = data.price();
        this.category = data.category();
        this.description = data.description();
    }


}
