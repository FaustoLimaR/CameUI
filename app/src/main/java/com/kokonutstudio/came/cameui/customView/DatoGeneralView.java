package com.kokonutstudio.came.cameui.customView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.kokonutstudio.came.cameui.FontCache;
import com.kokonutstudio.came.cameui.R;

import butterknife.ButterKnife;

import static com.kokonutstudio.came.cameui.Constantes.FONT_CUSTOM_EDITTEXT;
import static com.kokonutstudio.came.cameui.Constantes.FONT_CUSTOM_EDITTEXT_LABEL;
import static com.kokonutstudio.came.cameui.Constantes.FONT_STYLE_BOLD;

/**
 * Created by flima on 15/05/2017.
 */

public class DatoGeneralView extends LinearLayout {

    LinearLayout layoutContainer;
    StyleTextView etiquetaDatoGeneral;
    StyleTextView valorDatoGeneral;
    ImageView imageDatoGeneral;

    private boolean hasIcon;
    private boolean hasLabel;
    private boolean hasValue;
    private String txtEtiqueta = "";
    private String tipoEtiqueta = "";
    private String tipoValor= "";
    private String formato = "";
    private int colorLabel;
    private int idResIconDefault;
    private int idResBackgroundEtiqueta;
    private int idResBackgroundValor;
    private String gravityValor;

    public DatoGeneralView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public DatoGeneralView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public DatoGeneralView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        View.inflate(context, R.layout.dato_item_view, this);
        //Obtenemoslas referencias a los distintos controles
        layoutContainer = findViewById(R.id.layoutDatoGeneral);
        etiquetaDatoGeneral = findViewById(R.id.tvEtiquetaDato);
        valorDatoGeneral = findViewById(R.id.tvValorDato);
        imageDatoGeneral =  findViewById(R.id.imageDatoGeneral);

        if (attrs != null) {
            TypedArray typedArray = context.getTheme().obtainStyledAttributes(
                    attrs,
                    R.styleable.DatoGeneralStyle,
                    0, 0);

            try {

                txtEtiqueta = typedArray.getString(R.styleable.DatoGeneralStyle_label);
                colorLabel = typedArray.getInteger(R.styleable.DatoGeneralStyle_labelColor,R.color.black);
                hasIcon = typedArray.getBoolean(R.styleable.DatoGeneralStyle_hasIcon,false);
                hasLabel = typedArray.getBoolean(R.styleable.DatoGeneralStyle_hasLabel,true);
                hasValue = typedArray.getBoolean(R.styleable.DatoGeneralStyle_hasValue,true);
                tipoEtiqueta = typedArray.getString(R.styleable.DatoGeneralStyle_tipoEtiqueta);
                tipoValor = typedArray.getString(R.styleable.DatoGeneralStyle_tipoValor);
                formato = typedArray.getString(R.styleable.DatoGeneralStyle_formato);
                idResIconDefault =   typedArray.getResourceId(R.styleable.DatoGeneralStyle_defaultIcon,0);
                idResBackgroundEtiqueta =   typedArray.getResourceId(R.styleable.DatoGeneralStyle_backgroundEtiqueta,0);
                idResBackgroundValor =   typedArray.getResourceId(R.styleable.DatoGeneralStyle_backgroundValor,0);
                gravityValor =   typedArray.getString(R.styleable.DatoGeneralStyle_gravityValor);
            } catch (Exception e) {
                Log.e(context.getPackageName(), "Error loading attributes:" + e.getMessage());
            } finally {
                typedArray.recycle();
            }

        }

        imageDatoGeneral.setImageResource(hasIcon && idResIconDefault > 0 ? idResIconDefault : 0);
        imageDatoGeneral.setVisibility(hasIcon ? VISIBLE : GONE);

        if(idResBackgroundEtiqueta > 0)
            etiquetaDatoGeneral.setBackgroundResource(idResBackgroundEtiqueta);

        if(idResBackgroundValor > 0)
            valorDatoGeneral.setBackgroundResource(idResBackgroundValor);



        if(tipoEtiqueta!=null){
            etiquetaDatoGeneral.setTypeface(FontCache.getTypeface(getFontType(tipoEtiqueta), context));
        }

        if(tipoValor != null){
            valorDatoGeneral.setTypeface(FontCache.getTypeface(getFontType(tipoValor), context));
        }

        if(gravityValor != null){
            valorDatoGeneral.setGravity(getGravityValor(gravityValor));

        }


        etiquetaDatoGeneral.setVisibility(hasLabel ? VISIBLE : GONE);
        valorDatoGeneral.setVisibility(hasValue  ? VISIBLE : GONE);

        if(txtEtiqueta!= null && !txtEtiqueta.isEmpty()){
            etiquetaDatoGeneral.setText(txtEtiqueta);
        }
    }


    public void setEtiquetaDatoGeneral(String txt) {
        etiquetaDatoGeneral.setText(txt);
        etiquetaDatoGeneral.setVisibility(!txt.isEmpty() ? VISIBLE: GONE);
    }


    public String getTextValor() {
        return valorDatoGeneral.getText().toString().trim();
    }



    private String getFontType(String tipo){
        switch (tipo){
            case "0":
                return FONT_CUSTOM_EDITTEXT_LABEL;
            case "1":
                return FONT_STYLE_BOLD;
            case "2":
                return FONT_CUSTOM_EDITTEXT_LABEL;
            default:
                return FONT_CUSTOM_EDITTEXT_LABEL;
        }
    }

    private int getGravityValor(String gravity){
        switch (gravity){
            case "0":
                return Gravity.LEFT;
            case "1":
                return Gravity.RIGHT;
            default:
                return Gravity.LEFT;
        }
    }

}
