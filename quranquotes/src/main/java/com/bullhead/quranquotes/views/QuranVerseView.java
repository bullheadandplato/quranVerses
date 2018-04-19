package com.bullhead.quranquotes.views;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bullhead.quranquotes.QuranQuote;
import com.bullhead.quranquotes.R;
import com.bullhead.quranquotes.domain.Verse;

import java.util.Locale;

/**
 * Created by bullhead on 3/14/18.
 */

public class QuranVerseView extends RelativeLayout {
    private TextView tvVerse;
    private TextView tvSurahName;
    private Verse currentVerse;

    public Verse getCurrentVerse() {
        return currentVerse;
    }

    public QuranVerseView(Context context) {
        super(context);
    }

    private void init(Context context, AttributeSet attributeSet) {
        LayoutInflater.from(getContext()).inflate(R.layout.quran_verse_view, this, true);
        tvVerse = findViewById(R.id.tvVerse);
        tvSurahName = findViewById(R.id.tvSurahName);
        TypedArray attributes = context.obtainStyledAttributes(attributeSet, R.styleable.QuranVerseView);
        tvVerse.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                attributes.getDimension(R.styleable.QuranVerseView_verseTextSize, 20));
        tvVerse.setTextColor(attributes.getColor(R.styleable.QuranVerseView_verseTextColor, Color.BLACK));
        tvSurahName.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                attributes.getDimension(R.styleable.QuranVerseView_surahNameTextSize, 12));
        tvSurahName.setTextColor(attributes.getColor(R.styleable.QuranVerseView_surahNameTextColor, Color.LTGRAY));
        attributes.recycle();
    }

    private void setText() {
        if (tvVerse == null || tvSurahName == null) {
            return;
        }
        currentVerse = QuranQuote.getInstance(getContext()).getRandomVerse();
        if (!Resources.getSystem().getConfiguration().locale.getLanguage().equals(Locale.ENGLISH.getLanguage())) {
            tvVerse.setText(getContext().getString(R.string.splash_verse, currentVerse.getArabic()));
        } else {
            tvVerse.setText(getContext().getString(R.string.splash_verse, currentVerse.getEnglish()));
        }
        tvSurahName.setText(getContext().getString(R.string.splash_surah_ref, currentVerse.getSurah().getTitle(), currentVerse.getNumber()));
    }

    public QuranVerseView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
        setText();
    }

    public QuranVerseView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
        setText();
    }


}
