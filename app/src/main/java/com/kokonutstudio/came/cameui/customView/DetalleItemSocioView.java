package com.kokonutstudio.came.cameui.customView;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.kokonutstudio.came.cameui.FontCache;
import com.kokonutstudio.came.cameui.R;

import static com.kokonutstudio.came.cameui.Constantes.FONT_CUSTOM_EDITTEXT;
import static com.kokonutstudio.came.cameui.Constantes.FONT_CUSTOM_EDITTEXT_LABEL;

/**
 * Created by flima on 15/05/2017.
 */

public class DetalleItemSocioView extends LinearLayout {

    LinearLayout layoutContainer;

    StyleTextView valorItem;
    StyleTextView tituloItem;

    public DetalleItemSocioView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public DetalleItemSocioView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public DetalleItemSocioView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        View.inflate(context, R.layout.detalle_socio_detalle_item, this);
        //Obtenemoslas referencias a los distintos controles
        layoutContainer = (LinearLayout) findViewById(R.id.layoutContenedorItem);
        valorItem = (StyleTextView) findViewById(R.id.textViewValorItem);
        tituloItem = (StyleTextView) findViewById(R.id.textViewTituloItem);

        if (attrs != null) {
           /* TypedArray typedArray = context.getTheme().obtainStyledAttributes(
                    attrs,
                    R.styleable.CustomEditText,
                    0, 0);*/

            try {


            } catch (Exception e) {
                Log.e(context.getPackageName(), "Error loading attributes:" + e.getMessage());
            } finally {
                //typedArray.recycle();
            }

        }

        Typeface customTitleFont = FontCache.getTypeface(FONT_CUSTOM_EDITTEXT_LABEL, context);
        tituloItem.setTypeface(customTitleFont);

        Typeface customValueFont = FontCache.getTypeface(FONT_CUSTOM_EDITTEXT, context);
        valorItem.setTypeface(customValueFont);
    }


    public void setHintValor(String txt) {
        valorItem.setHint(txt);
    }

    public void setTituloItem(String txt) {
        tituloItem.setText(txt);
        tituloItem.setVisibility(!txt.isEmpty() ? VISIBLE: GONE);
    }


    public String getTextValor() {
        return valorItem.getText().toString().trim();
    }


}
