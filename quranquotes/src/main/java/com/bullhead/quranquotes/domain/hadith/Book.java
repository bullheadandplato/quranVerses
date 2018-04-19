package com.bullhead.quranquotes.domain.hadith;

import java.io.Serializable;
import java.util.List;

public class Book implements Serializable{
    private String name;
    private List<Hadith> hadiths;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Hadith> getHadiths() {
        return hadiths;
    }

    public void setHadiths(List<Hadith> hadiths) {
        this.hadiths = hadiths;
    }
}
