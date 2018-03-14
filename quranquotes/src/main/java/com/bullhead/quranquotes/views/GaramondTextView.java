package com.bullhead.quranquotes.views;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by bullhead on 3/14/18.
 */

public class GaramondTextView extends AppCompatTextView {
    public GaramondTextView(Context context) {
        super(context);
        setTypeface();
    }

    public GaramondTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeface();
    }

    public GaramondTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypeface();
    }

    private void setTypeface() {
        setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/Garamond.ttf"));
    }
}
