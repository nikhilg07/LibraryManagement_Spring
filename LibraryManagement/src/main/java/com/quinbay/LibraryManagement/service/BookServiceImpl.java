package com.quinbay.LibraryManagement.service;

import com.quinbay.LibraryManagement.dto.Book;
import com.quinbay.LibraryManagement.entity.BookEntity;
import com.quinbay.LibraryManagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks(){
        Iterable<BookEntity> bookEntityList = bookRepository.findAll();
        List<Book> userResponseList = new ArrayList<>();

        for (BookEntity bookEntity : bookEntityList) {
            Book book = new Book(bookEntity.getId(), bookEntity.getName(),bookEntity.getWriter(),bookEntity.getSummary(),bookEntity.getCategory());
            userResponseList.add(book);
        }

        return userResponseList;

    }


    @Override
    public void addBook(Book book) {
        BookEntity bookEntity = new BookEntity(book.getId(),book.getName(),book.getWriter(),book.getSummary(),book.getCategory());
        bookRepository.save(bookEntity);
    }
}
