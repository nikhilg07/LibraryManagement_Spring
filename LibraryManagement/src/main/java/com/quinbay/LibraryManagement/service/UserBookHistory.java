package com.quinbay.LibraryManagement.service;

import com.quinbay.LibraryManagement.dto.Book;
import com.quinbay.LibraryManagement.dto.User;
import org.springframework.stereotype.Service;

@Service
public interface UserBookHistory {

    void issueBook(int userId,int bookId);

    void returnBook(int userId,int bookId);

    Book popular();

    User bestReader();




}
