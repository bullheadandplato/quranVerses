package com.bullhead.quranquotes.views;

import android.content.Context;
import android.util.AttributeSet;

import com.bullhead.quranquotes.HadithQuote;

public class RandomHadithView extends HadithView{
    public RandomHadithView(Context context) {
        super(context);
    }

    public RandomHadithView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RandomHadithView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setText() {
        currentHadith= HadithQuote.getInstance(getContext()).getRandomHadith();
        textView.setText(currentHadith.getText());
        infoTextView.setText(currentHadith.getInfo());
    }
}
