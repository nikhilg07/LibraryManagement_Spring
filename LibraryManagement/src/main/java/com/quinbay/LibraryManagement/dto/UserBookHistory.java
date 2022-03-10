package com.quinbay.LibraryManagement.dto;

import java.io.Serializable;

public class UserBookHistory implements Serializable {

    private Integer userId;
    private Integer bookId;
    private String startDate;
    private String endDate;

    public UserBookHistory(){

    }

    public UserBookHistory(Integer userId, Integer bookId, String startDate, String endDate) {
        this.userId = userId;
        this.bookId = bookId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
