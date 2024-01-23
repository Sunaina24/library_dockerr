package com.example.Library.Management.service;
import com.example.Library.Management.model.Book;
import com.example.Library.Management.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {


    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }


    public Book findById(Long id) {
        return bookRepository.findById(id).get();
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public void update(Book book){
        bookRepository.save(book);
    }

//    public void addBook(Book book) {
//        // Update totalCopies and copiesBorrowed
//        book.setTotalCopies(book.getTotalCopies());
//        book.setCopiesBorrowed(book.getCopiesBorrowed());
//        bookRepository.save(book);
//    }
public void addBook(Book book) {
    bookRepository.save(book);
}

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}