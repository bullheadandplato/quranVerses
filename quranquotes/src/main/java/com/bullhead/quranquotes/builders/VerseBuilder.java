package com.bullhead.quranquotes.builders;

import com.bullhead.quranquotes.domain.Surah;
import com.bullhead.quranquotes.domain.Verse;

/**
 * Created by bullhead on 3/14/18.
 */

public final class VerseBuilder {
    private final Verse verse;

    public VerseBuilder() {
        this.verse = new Verse();
    }

    public VerseBuilder number(int number) {
        this.verse.setNumber(number);
        return this;
    }

    public VerseBuilder english(String english) {
        this.verse.setEnglish(english);
        return this;
    }

    public VerseBuilder arabic(String arabic) {
        this.verse.setArabic(arabic);
        return this;
    }

    public VerseBuilder surah(Surah surah) {
        this.verse.setSurah(surah);
        return this;
    }

    public Verse build() {
        return this.verse;
    }
}
