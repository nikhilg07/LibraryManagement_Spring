package com.quinbay.LibraryManagement.controller;

import com.quinbay.LibraryManagement.dto.ParamBody;
import com.quinbay.LibraryManagement.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import com.quinbay.LibraryManagement.dto.Book;
import com.quinbay.LibraryManagement.service.BookService;
import com.quinbay.LibraryManagement.service.UserBookHistory;
import com.quinbay.LibraryManagement.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    BookService bookService;

    @Autowired
    UserService userService;

    @Autowired
    UserBookHistory userBookHistory;

    @GetMapping(value = "/book" , produces = "application/json")
    public List<Book> getBooks(){
        return bookService.getAllBooks();
    }

    @PostMapping(value = "/addBook" , consumes = "application/json")
    public void addBook(@RequestBody @Valid Book book){
        bookService.addBook(book);
    }

    @GetMapping(value = "/user" , produces = "application/json")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }

    @PostMapping(value = "/addUser" , consumes = "application/json")
    public void addUser(@RequestBody @Valid User user){
        userService.addUser(user);
    }


    @PostMapping(value = "/issueBook" , consumes = "application/json")
    public void issueBook(@RequestBody @Valid ParamBody paramBody){
        userBookHistory.issueBook(paramBody.getUserId(), paramBody.getBookId());
    }


    @PostMapping(value = "/returnBook" , consumes = "application/json")
    public void returnBook(@RequestBody @Valid ParamBody paramBody){
        userBookHistory.returnBook(paramBody.getUserId(),paramBody.getBookId());
    }


    @GetMapping(value = "/popularBook")
    public Book popular(){
     return userBookHistory.popular();
    }

    @GetMapping(value = "/bestReader")
    public User bestReader(){
        return userBookHistory.bestReader();
    }






}
