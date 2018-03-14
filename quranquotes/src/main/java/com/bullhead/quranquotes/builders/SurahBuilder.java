package com.bullhead.quranquotes.builders;

import com.bullhead.quranquotes.domain.Surah;
import com.bullhead.quranquotes.domain.SurahType;

/**
 * Created by bullhead on 3/14/18.
 */

public final class SurahBuilder {
    private Surah surah;

    public SurahBuilder() {
        surah = new Surah();
    }

    public SurahBuilder title(String title) {
        this.surah.setTitle(title);
        return this;
    }

    public SurahBuilder index(int index) {
        this.surah.setIndex(index);
        return this;
    }

    public SurahBuilder type(SurahType type) {
        this.surah.setType(type);
        return this;
    }

    public SurahBuilder ayyats(int ayyats) {
        this.surah.setTotalAyyat(ayyats);
        return this;
    }

    public Surah build() {
        return this.surah;
    }

}
