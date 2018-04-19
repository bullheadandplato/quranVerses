package com.bullhead.quranquotes.domain.hadith;

import java.io.Serializable;
import java.util.List;

public class Volume implements Serializable{
    private String name;
    private List<Book> books;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
