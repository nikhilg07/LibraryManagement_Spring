package com.quinbay.LibraryManagement.entity;
import javax.persistence.*;

@Entity
@Table(name = "history")
public class UserBookHistoryEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
private int userId;
private int bookId;
private String startDate;
private String endDate;

    public UserBookHistoryEntity(){

    }

    public UserBookHistoryEntity(int userId, int bookId, String startDate, String endDate) {
        this.userId = userId;
        this.bookId = bookId;
        this.startDate = startDate;
        this.endDate = endDate;
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
