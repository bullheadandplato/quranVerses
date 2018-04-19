package com.bullhead.quranquotes;

import android.content.Context;
import android.content.res.AssetManager;
import android.support.annotation.NonNull;

import com.bullhead.quranquotes.domain.hadith.Book;
import com.bullhead.quranquotes.domain.hadith.Hadith;
import com.bullhead.quranquotes.domain.hadith.Volume;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

public class HadithQuote {
    private final Volume[] volumes;
    private final AssetManager assetManager;
    private static HadithQuote instance;
    private final int volumeCount;
    private HadithQuote(Context context){
        assetManager=context.getAssets();
        volumes=getVolumes();
        volumeCount=volumes.length;

    }
    @NonNull
    private Volume[] getVolumes(){
        String json=getJson("sahih_bukhari.json");
        return new Gson().fromJson(json,Volume[].class);
    }
    public Hadith getRandomHadith(){
        int randomVolume=new Random().nextInt(volumeCount);
        Volume volume=volumes[randomVolume];
        int randomBook=new Random().nextInt(volume.getBooks().size());
        Book book=volume.getBooks().get(randomBook);
        int randomHadith=new Random().nextInt(book.getHadiths().size());
        Hadith hadith= book.getHadiths().get(randomHadith);
        hadith.setBookNo(randomBook);
        hadith.setHadithNo(randomHadith);
        hadith.setVolumeNo(randomVolume);
        return hadith;
    }

    public Hadith getHadith(int volumeNo,int bookNo,int hadithNo){
        if (volumeNo>=volumeCount){
            return GenericHadith();
        }
        Volume volume=volumes[volumeNo];
        if (bookNo>=volume.getBooks().size()){
            return GenericHadith();
        }
        Book book=volume.getBooks().get(bookNo);
        if (hadithNo>=book.getHadiths().size()){
            return GenericHadith();
        }
        Hadith hadith=book.getHadiths().get(hadithNo);
        hadith.setVolumeNo(volumeNo);
        hadith.setBookNo(bookNo);
        hadith.setHadithNo(hadithNo);
        return hadith;
    }

    private Hadith GenericHadith() {
        Hadith hadith=new Hadith();
        hadith.setHadithNo(1);
        hadith.setBookNo(1);
        hadith.setVolumeNo(1);
        hadith.setBy("Narrated Abu Huraira");
        hadith.setInfo("Sahih al-Bukhari 5645");
        hadith.setText("If Allah desires to do good to someone, He afflicts him with trials.");
        return hadith;
    }

    public static HadithQuote getInstance(Context context) {
        if (instance==null){
            instance=new HadithQuote(context);
        }
        return instance;
    }

    @NonNull
    private String getJson(String fileName) {
        InputStream stream;
        try {
            stream = assetManager.open(fileName);

            BufferedReader r = new BufferedReader(new InputStreamReader(stream));
            StringBuilder total = new StringBuilder();
            String line;
            while ((line = r.readLine()) != null) {
                total.append(line).append('\n');
            }
            return total.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "{}";
        }
    }
}
