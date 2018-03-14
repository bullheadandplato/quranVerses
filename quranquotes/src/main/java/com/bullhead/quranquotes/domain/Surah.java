package com.bullhead.quranquotes.domain;

import java.io.Serializable;

/**
 * Created by bullhead on 3/14/18.
 */

public class Surah implements Serializable {
    private String place;
    private SurahType type;
    private String title;
    private int count;
    private int index;

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public SurahType getType() {
        return type;
    }

    public void setType(SurahType type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTotalAyyat() {
        return count;
    }

    public void setTotalAyyat(int totalAyyat) {
        this.count = totalAyyat;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
