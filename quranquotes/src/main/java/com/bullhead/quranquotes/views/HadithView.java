package com.bullhead.quranquotes.views;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bullhead.quranquotes.R;
import com.bullhead.quranquotes.domain.hadith.Hadith;

public abstract class HadithView extends RelativeLayout{
    protected TextView textView;
    protected TextView infoTextView;
    protected Hadith currentHadith;

    public Hadith getCurrentHadith() {
        return currentHadith;
    }

    protected SharedPreferences sharedPreferences;

    public HadithView(Context context) {
        super(context);
    }

    public HadithView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public HadithView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }
    private void init(Context context,AttributeSet attributeSet){
        sharedPreferences=context.getSharedPreferences("hadith_od_day",Context.MODE_PRIVATE);
        LayoutInflater.from(context).inflate(R.layout.quran_verse_view,this,true);
        textView = findViewById(R.id.tvVerse);
        infoTextView = findViewById(R.id.tvSurahName);
        TypedArray attributes = context.obtainStyledAttributes(attributeSet, R.styleable.HadithView);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                attributes.getDimension(R.styleable.HadithView_hadithTextSize, 30));
        textView.setTextColor(attributes.getColor(R.styleable.HadithView_hadithTextColor, Color.BLACK));
        infoTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                attributes.getDimension(R.styleable.HadithView_infoTextSize, 30));
        infoTextView.setTextColor(attributes.getColor(R.styleable.HadithView_infoTextColor, Color.LTGRAY));
        attributes.recycle();
        setText();
    }
    public abstract void setText();

}
