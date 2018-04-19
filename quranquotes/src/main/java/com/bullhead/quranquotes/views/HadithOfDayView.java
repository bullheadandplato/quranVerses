package com.bullhead.quranquotes.views;

import android.content.Context;
import android.util.AttributeSet;

import com.bullhead.quranquotes.HadithQuote;
import com.bullhead.quranquotes.domain.hadith.Hadith;
import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

public class HadithOfDayView extends HadithView{

    public HadithOfDayView(Context context) {
        super(context);
    }

    public HadithOfDayView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HadithOfDayView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setText() {
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
