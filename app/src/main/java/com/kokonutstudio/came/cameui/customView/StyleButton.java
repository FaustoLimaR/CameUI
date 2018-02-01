package com.kokonutstudio.came.cameui.customView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.View;

import com.kokonutstudio.came.cameui.FontCache;
import com.kokonutstudio.came.cameui.R;
import com.kokonutstudio.came.cameui.customView.utils.TypeFont;

import static com.kokonutstudio.came.cameui.Constantes.FONT_CUSTOM_EDITTEXT_LABEL;
import static com.kokonutstudio.came.cameui.Constantes.FONT_STYLE_BOLD;
import static com.kokonutstudio.came.cameui.Constantes.FONT_STYLE_ITALIC;
import static com.kokonutstudio.came.cameui.Constantes.FONT_STYLE_REGULAR;
import static com.kokonutstudio.came.cameui.Constantes.FONT_STYLE_TEXTVIEW;
import static com.kokonutstudio.came.cameui.customView.utils.TypeFont.BOLD;
import static com.kokonutstudio.came.cameui.customView.utils.TypeFont.ITALIC;
import static com.kokonutstudio.came.cameui.customView.utils.TypeFont.REGULAR;

/**
 * Created by flima on 15/05/2017.
 */
public class StyleButton extends AppCompatButton implements View.OnClickListener{

    public static final String ANDROID_SCHEMA = "http://schemas.android.com/apk/res/android";
    private OnClickListener mClickListener;
    private boolean interceptor;

    private TypeFont type;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public StyleButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        super.setOnClickListener(this);
        handlAttrs(context, attrs);
        applyFont(context);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public StyleButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        super.setOnClickListener(this);
        handlAttrs(context, attrs);
        applyFont(context);

    }

    private void init(Context context, AttributeSet attrs) {
    }

    private void applyFont(Context context) {
        Typeface customFont = FontCache.getTypeface(FONT_STYLE_TEXTVIEW, context);
        if(type != null){
            switch (type){
                case REGULAR:
                    customFont = FontCache.getTypeface(FONT_CUSTOM_EDITTEXT_LABEL, context);
                    break;
                case BOLD:
                    customFont = FontCache.getTypeface(FONT_STYLE_BOLD, context);
                    break;
                case ITALIC:
                    customFont = FontCache.getTypeface(FONT_STYLE_ITALIC, context);
                    break;

            }
        }
        setTypeface(customFont);
    }

    private void handlAttrs(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.StyleButton);
        String fontName = a.getString(R.styleable.StyleButton_tipoBtn) ;
        if (fontName != null) {
            switch (fontName){
                case "0":
                    type = REGULAR;
                    break;
                case "1":
                    type = BOLD;
                    break;
                case "2":
                    type = ITALIC;
                    break;

                    default:
                        type = REGULAR;
                        break;
            }
        }
        a.recycle();
    }

    public void enableButton() {
        setClickable(false);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                setClickable(true);
            }
        }, 1500);
    }
    @Override
    public void setOnClickListener(OnClickListener l) {
        this.mClickListener = l;
    }

    @Override
    public void onClick(View view) {
        if (mClickListener != null) {
            mClickListener.onClick(this);
            if (interceptor) enableButton();
        }
    }
}
