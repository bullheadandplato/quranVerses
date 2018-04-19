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

import com.bullhead.quranquotes.HadithQuote;
import com.bullhead.quranquotes.R;
import com.bullhead.quranquotes.domain.hadith.Hadith;
import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

public class HadithOfDayView extends RelativeLayout{
    private TextView textView;
    private TextView infoTextView;
    private Hadith currentHadith;

    public Hadith getCurrentHadith() {
        return currentHadith;
    }

    private SharedPreferences sharedPreferences;

    public HadithOfDayView(Context context) {
        super(context);
    }

    public HadithOfDayView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public HadithOfDayView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }
    private void init(Context context,AttributeSet attributeSet){
        sharedPreferences=context.getSharedPreferences("hadith_od_day",Context.MODE_PRIVATE);
        LayoutInflater.from(context).inflate(R.layout.quran_verse_view,this,true);
        textView = findViewById(R.id.tvVerse);
        infoTextView = findViewById(R.id.tvSurahName);
        TypedArray attributes = context.obtainStyledAttributes(attributeSet, R.styleable.HadithOfDayView);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,
                attributes.getDimension(R.styleable.HadithOfDayView_hadithTextSize, 20));
        textView.setTextColor(attributes.getColor(R.styleable.HadithOfDayView_hadithTextColor, Color.BLACK));
        infoTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP,
                attributes.getDimension(R.styleable.HadithOfDayView_infoTextSize, 12));
        infoTextView.setTextColor(attributes.getColor(R.styleable.HadithOfDayView_infoTextColor, Color.LTGRAY));
        attributes.recycle();
        setText();
    }

    private void setText() {
        long savedTime=sharedPreferences.getLong("time",-1);
        long currentTime=System.currentTimeMillis();
        long oneDay= TimeUnit.DAYS.toMillis(1);
        if (savedTime<=(currentTime-oneDay) || currentTime<= (savedTime-oneDay)){
            currentHadith= HadithQuote.getInstance(getContext()).getRandomHadith();
            sharedPreferences.edit()
                    .putString("hadith",new Gson().toJson(currentHadith))
                    .putLong("time",currentTime)
                    .apply();
        }else{
            currentHadith=new Gson().fromJson(sharedPreferences.getString("hadith",null),Hadith.class);
        }
        textView.setText(currentHadith.getText());
        infoTextView.setText(currentHadith.getInfo());
    }
}
