package com.myspringboot.springbootfirst.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long authId;
    private String fName;
    private String lName;
    private String genre;

    @JsonBackReference
    @OneToOne(mappedBy = "author")
    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Author() {
    }

    public Author(long authId, String fName, String lName, String genre) {
        this.authId = authId;
        this.fName = fName;
        this.lName = lName;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Author [authId=" + authId + ", fName=" + fName + ", lName=" + lName + ", genre=" + genre + "]";
    }

    public long getAuthId() {
        return authId;
    }

    public void setAuthId(long authId) {
        this.authId = authId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}
