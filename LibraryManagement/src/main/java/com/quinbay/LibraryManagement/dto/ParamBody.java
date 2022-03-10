package com.quinbay.LibraryManagement.dto;

public class ParamBody {


    private int userId;
    private int bookId;

    public ParamBody(){

    }

    public ParamBody(int userId, int bookId) {
        this.userId = userId;
        this.bookId = bookId;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
}
