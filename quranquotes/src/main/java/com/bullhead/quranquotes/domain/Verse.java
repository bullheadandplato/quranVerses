package com.bullhead.quranquotes.domain;

import java.io.Serializable;

/**
 * Created by bullhead on 3/14/18.
 */

public class Verse implements Serializable {
    private int number;
    private String arabic;
    private String english;
    private Surah surah;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getArabic() {
        return arabic;
    }

    public void setArabic(String arabic) {
        this.arabic = arabic;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public Surah getSurah() {
        return surah;
    }

    public void setSurah(Surah surah) {
        this.surah = surah;
    }
}
