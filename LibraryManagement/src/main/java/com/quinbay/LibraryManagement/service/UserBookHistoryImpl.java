package com.quinbay.LibraryManagement.service;

import com.quinbay.LibraryManagement.dto.Book;
import com.quinbay.LibraryManagement.dto.User;
import com.quinbay.LibraryManagement.entity.BookEntity;
import com.quinbay.LibraryManagement.entity.UserBookHistoryEntity;
import com.quinbay.LibraryManagement.entity.UserEntity;
import com.quinbay.LibraryManagement.repository.BookRepository;
import com.quinbay.LibraryManagement.repository.UserBookHistoryRepository;
import com.quinbay.LibraryManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class UserBookHistoryImpl implements UserBookHistory {

    @Autowired
    UserBookHistoryRepository userBookHistoryRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public User bestReader(){

        Iterable<UserBookHistoryEntity>list = userBookHistoryRepository.findAll();
        HashMap<Integer,Integer>mp = new HashMap<>();

        for(UserBookHistoryEntity x:list){
            if (mp.containsKey( x.getUserId()))
                mp.put(x.getUserId(), mp.get(x.getUserId()) + 1);
            else
                mp.put(x.getUserId(), 1);

        }
        Set<Map.Entry<Integer, Integer>> entrySet = mp.entrySet();
        int maxCount = 0;

        int maxId = 0;

        for (Map.Entry<Integer, Integer> entry : entrySet)
        {
            if (entry.getValue() > maxCount)
            {
                maxCount = entry.getValue();

                maxId = entry.getKey();
            }
        }

        User user = new User();

        Iterable<UserEntity> users = userRepository.findAll();

        for (UserEntity i : users) {
            if (i.getId() == maxId) {
                user.setId(i.getId());
                user.setName(i.getName());
                user.setAddress(i.getAddress());
                user.setPhoneNumber(i.getPhoneNumber());
            }
        }

        return user;


    }


    @Override
    public Book popular()
    {
        Iterable<UserBookHistoryEntity>list =  userBookHistoryRepository.findAll();



        HashMap<Integer,Integer>mp = new HashMap<>();

        for(UserBookHistoryEntity x: list){
            if (mp.containsKey( x.getBookId() ))
                mp.put(x.getBookId(), mp.get(x.getBookId()) + 1);
            else
                mp.put(x.getBookId(), 1);

        }
//        Integer max = Collections.max(mp.values());
//        System.out.println(max);

        Set<Map.Entry<Integer, Integer>> entrySet = mp.entrySet();

        int maxCount = 0;

        int maxId = 0;

        for (Map.Entry<Integer, Integer> entry : entrySet)
        {
            if (entry.getValue() > maxCount)
            {
                maxCount = entry.getValue();

                maxId = entry.getKey();
            }
        }

        Book book = new Book();

        Iterable<BookEntity> books = bookRepository.findAll();

        for (BookEntity i : books) {
            if (i.getId() == maxId) {
                book.setId(i.getId());
                book.setName(i.getName());
                book.setWriter(i.getWriter());
                book.setSummary(i.getSummary());
                book.setCategory(i.getCategory());
            }
        }

        return book;

    }


    @Override
    public void issueBook(int userId, int bookId){


        LocalDate myObj = LocalDate.now(); // Create a date object

        UserBookHistoryEntity userBookHistoryEntity = new UserBookHistoryEntity(userId,bookId,myObj.toString(),null);


        userBookHistoryRepository.save(userBookHistoryEntity);


    }

    @Override
    public void returnBook(int userId,int bookId){

       Iterable<UserBookHistoryEntity>userBookHistorylist = userBookHistoryRepository.findAll();

       for(UserBookHistoryEntity x  :userBookHistorylist)
       {
           if( (x.getBookId()==bookId && x.getUserId() == userId) && x.getEndDate()==null){
               LocalDate myObj = LocalDate.now(); // Create a date object
               x.setEndDate(myObj.toString());

               userBookHistoryRepository.save(x);

           }

       }








}





}

