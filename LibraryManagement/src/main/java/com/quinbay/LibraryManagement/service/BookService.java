package com.quinbay.LibraryManagement.service;

import com.quinbay.LibraryManagement.dto.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();
    void addBook(Book book);

}
