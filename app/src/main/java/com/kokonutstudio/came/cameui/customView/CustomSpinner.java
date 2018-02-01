package com.kokonutstudio.came.cameui.customView;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatSpinner;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.kokonutstudio.came.cameui.R;


/**
 * Created by flima on 15/05/2017.
 */

public class CustomSpinner extends LinearLayout {

    AppCompatSpinner spnValue;


    public CustomSpinner(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CustomSpinner(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomSpinner(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        View.inflate(context, R.layout.custom_spinner_layout, this);

        //Obtenemoslas referencias a los distintos control
        spnValue = (AppCompatSpinner) findViewById(R.id.spnSpinner);

        if (attrs != null) {
        /*    TypedArray typedArray = context.getTheme().obtainStyledAttributes(
                    attrs,
                    R.styleable.CustomEditText,
                    0, 0);
            try {

            } catch (Exception e) {
                Log.e(context.getPackageName(), "Error loading attributes:" + e.getMessage());
            } finally {
                typedArray.recycle();
            }*/
        }
    }

}
