package com.quinbay.LibraryManagement.entity;

//Books
//        --id
//        --name
//        --writer
//        --summary
//        --category
//

import javax.persistence.*;

@Entity
@Table(name = "books")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String writer;
    private String summary;
    private String category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BookEntity(){

    }


    public BookEntity(int id, String name, String writer, String summary, String category) {
        this.id = id;

        this.name = name;
        this.writer = writer;
        this.summary = summary;
        this.category = category;
    }
}
