package com.ikon.crudredis.controller;

import com.ikon.crudredis.model.*;
import com.ikon.crudredis.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public BaseResponse<List<Book>> getAll() {
        List<Book> books = new ArrayList<>();

        bookRepository.findAll().forEach(books::add);

        return new BaseResponse<>(
                "success",
                "Here's all the books",
                books
        );
    }

    @GetMapping("/{id}")
    public Book getOneBook(@PathVariable("id") Long id) {
        Optional<Book> book = bookRepository.findById(id);

        if(book.isEmpty()) {
            return null;
        }
        return book.get();

    }

    @PostMapping
    public BaseResponse<Book> createBook(@RequestBody BookRequest request) {
        UUID uuid = UUID.randomUUID();

        Book book = new Book(
                uuid.toString(),
                request.getIsbn(),
                request.getJudul(),
                request.getPenulis(),
                request.getKategori(),
                request.getDeskripsi()
        );

        Book createdBook = bookRepository.save(book);

        return new BaseResponse<>(
                "success",
                "book created",
                createdBook
        );
    }

    @PutMapping("/{id}")
    public BaseResponse<Book> updateBook(@PathVariable("id") Long bookId ,@RequestBody BookRequest request) {
        Optional<Book> bookTemp = bookRepository.findById(bookId);

        if(bookTemp.isEmpty()) {
            return null;
        }

        Book book = new Book(
                bookId.toString(),
                request.getIsbn(),
                request.getJudul(),
                request.getPenulis(),
                request.getKategori(),
                request.getDeskripsi()
        );

        Book createdBook = bookRepository.save(book);

        return new BaseResponse<>(
                "success",
                "book updated",
                createdBook
        );
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") Long id) {
        bookRepository.deleteById(id);
    }

}
