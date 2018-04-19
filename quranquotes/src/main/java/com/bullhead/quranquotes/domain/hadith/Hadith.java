package com.bullhead.quranquotes.domain.hadith;

import java.io.Serializable;

public class Hadith implements Serializable{
    private String info;
    private String by;
    private String text;
    private int volumeNo;
    private int bookNo;
    private int hadithNo;

    public int getVolumeNo() {
        return volumeNo;
    }

    public void setVolumeNo(int volumeNo) {
        this.volumeNo = volumeNo;
    }

    public int getBookNo() {
        return bookNo;
    }

    public void setBookNo(int bookNo) {
        this.bookNo = bookNo;
    }

    public int getHadithNo() {
        return hadithNo;
    }

    public void setHadithNo(int hadithNo) {
        this.hadithNo = hadithNo;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
