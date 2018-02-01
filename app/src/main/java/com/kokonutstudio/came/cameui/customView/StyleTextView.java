package com.kokonutstudio.came.cameui.customView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.kokonutstudio.came.cameui.FontCache;
import com.kokonutstudio.came.cameui.R;
import com.kokonutstudio.came.cameui.customView.utils.TypeFont;

import static com.kokonutstudio.came.cameui.Constantes.FONT_STYLE_BOLD;
import static com.kokonutstudio.came.cameui.Constantes.FONT_STYLE_ITALIC;
import static com.kokonutstudio.came.cameui.Constantes.FONT_STYLE_REGULAR;
import static com.kokonutstudio.came.cameui.Constantes.FONT_STYLE_TEXTVIEW;
import static com.kokonutstudio.came.cameui.Constantes.FONT_STYLE_TEXTVIEW_DESC;
import static com.kokonutstudio.came.cameui.Constantes.FONT_STYLE_TEXTVIEW_INDICATION;
import static com.kokonutstudio.came.cameui.Constantes.FONT_STYLE_TEXTVIEW_INPUT;
import static com.kokonutstudio.came.cameui.Constantes.FONT_STYLE_TEXTVIEW_INPUTDESC;
import static com.kokonutstudio.came.cameui.Constantes.FONT_STYLE_TEXTVIEW_SUBTITLE;
import static com.kokonutstudio.came.cameui.Constantes.FONT_STYLE_TEXTVIEW_TEXT;
import static com.kokonutstudio.came.cameui.customView.utils.TypeFont.BOLD;
import static com.kokonutstudio.came.cameui.customView.utils.TypeFont.ITALIC;
import static com.kokonutstudio.came.cameui.customView.utils.TypeFont.REGULAR;

/**
 * Created by flima on 29/01/2018.
 */

public class StyleTextView extends AppCompatTextView {
    private TypeFont type;
    private Color color;


    public StyleTextView(Context context) {
        super(context);
        applyFont(context);
    }

    public StyleTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        handlAttrs(context, attrs);
        applyFont(context);
    }

    public StyleTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        handlAttrs(context, attrs);
        applyFont(context);

    }

    private void applyFont(Context context) {
        Typeface customFont = FontCache.getTypeface(FONT_STYLE_TEXTVIEW, context);
        if(type != null){
            switch (type){
                case REGULAR:
                    customFont = FontCache.getTypeface(FONT_STYLE_REGULAR, context);
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
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.StyleTextView);
        String fontName = a.getString(R.styleable.StyleTextView_tipo) ;
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
            }
        }
        a.recycle();
    }


}
