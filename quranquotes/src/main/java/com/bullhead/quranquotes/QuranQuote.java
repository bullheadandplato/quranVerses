package com.bullhead.quranquotes;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;

import com.bullhead.quranquotes.builders.SurahBuilder;
import com.bullhead.quranquotes.builders.VerseBuilder;
import com.bullhead.quranquotes.domain.Surah;
import com.bullhead.quranquotes.domain.SurahType;
import com.bullhead.quranquotes.domain.Verse;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Created by bullhead on 3/14/18.
 */

public class QuranQuote {
    private static final int UPPER_BOUND = 115;
    private final AssetManager assetManager;
    private static QuranQuote instance;
    private final Surah[] surahs;
    private final static String VERSE_BASE_PATH = "surah/surah_";
    private final static String VERSE_TRANSLATION_BASE_PATH = "translation/en/en_translation_";
    private final static String VERSE_NUMBER = "verse_";
    private static final String DEMO_JSON = "{}";

    private QuranQuote(Context context) {
        assetManager = context.getAssets();
        this.surahs = getSurahs();
    }

    private Surah[] getSurahs() {
        String json = getJson("surah.json");
        return new Gson().fromJson(json, Surah[].class);
    }

    public static QuranQuote getInstance(Context context) {
        if (instance == null) {
            instance = new QuranQuote(context);
        }
        return instance;
    }

    @SuppressLint("DefaultLocale")
    public Verse getRandomVerse() {
        if (surahs.length == 0) {
            return initVerse();
        }
        int random = new Random().nextInt(UPPER_BOUND);
        if (random == 0) {
            random = 1;
        }

        String fileNameArabic = VERSE_BASE_PATH + random + ".json";
        String fileNameEnglish = VERSE_TRANSLATION_BASE_PATH + random + ".json";
        String jsonArabic = getJson(fileNameArabic);
        String jsonEnglish = getJson(fileNameEnglish);
        if (jsonArabic.equals(DEMO_JSON) || jsonEnglish.equals(DEMO_JSON)) {
            return initVerse();
        }
        try {
            JSONObject rootArabic = new JSONObject(jsonArabic);
            JSONObject rootEnglish = new JSONObject(jsonEnglish);
            JSONObject verseArabic = rootArabic.getJSONObject("verse");
            JSONObject verseEnglish = rootEnglish.getJSONObject("verse");

            int count = rootArabic.getInt("count") + 1;
            int randomVerse = new Random().nextInt(count);
            if (randomVerse == 0 || randomVerse == 1) {
                randomVerse = 2;
            }
            String verseKey = VERSE_NUMBER + randomVerse;
            return new VerseBuilder()
                    .arabic(verseArabic.getString(verseKey))
                    .english(verseEnglish.getString(verseKey))
                    .surah(surahs[random - 1])
                    .number(randomVerse)
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            return initVerse();
        }
    }

    private Verse initVerse() {
        return new VerseBuilder()
                .arabic("بِسْمِ اللَّهِ الرَّحْمَٰنِ الرَّحِيمِ")
                .english("In the name of Allah, the beneficent the merciful")
                .number(0)
                .surah(new SurahBuilder().index(0).title("Al-Fatiha").ayyats(7).type(SurahType.MAKKIYAH).build())
                .build();
    }

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
            return DEMO_JSON;
        }
    }
}
