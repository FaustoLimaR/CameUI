package com.kokonutstudio.came.cameui.customView;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatEditText;
import android.text.Spannable;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.TextView;

import com.kokonutstudio.came.cameui.FontCache;

import static com.kokonutstudio.came.cameui.Constantes.FONT_STYLE_EDITTEXT;

/**
 * Created by flima on 29/12/2018.
 */

public class StyleEdittext extends AppCompatEditText {

    public static final String ANDROID_SCHEMA = "http://schemas.android.com/apk/res/android";
    private MovementMethod movementMethod = new MovementMethod() {
        @Override
        public void initialize(TextView textView, Spannable spannable) {

        }

        @Override
        public boolean onKeyDown(TextView textView, Spannable spannable, int i, KeyEvent keyEvent) {
            return false;
        }

        @Override
        public boolean onKeyUp(TextView textView, Spannable spannable, int i, KeyEvent keyEvent) {
            return false;
        }

        @Override
        public boolean onKeyOther(TextView textView, Spannable spannable, KeyEvent keyEvent) {
            return false;
        }

        @Override
        public void onTakeFocus(TextView textView, Spannable spannable, int i) {

        }

        @Override
        public boolean onTrackballEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            return false;
        }

        @Override
        public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            return false;
        }

        @Override
        public boolean onGenericMotionEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            return false;
        }

        @Override
        public boolean canSelectArbitrarily() {
            return false;
        }
    };

    public StyleEdittext(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        //setMovementMethod(movementMethod);
        customFont(context, attrs);
        init();

    }

    public StyleEdittext(Context context, AttributeSet attrs) {
        super(context, attrs);
        //setMovementMethod(movementMethod);
        customFont(context, attrs);
        init();

    }

    public StyleEdittext(Context context) {
        super(context);
        customFont(context, null);
        init();
    }

    private void customFont(Context context, AttributeSet attrs) {
        int textStyle = attrs.getAttributeIntValue(ANDROID_SCHEMA, "textStyle", 0);

        Typeface customFont = FontCache.getTypeface(FONT_STYLE_EDITTEXT, context);
        setTypeface(customFont);
    }

    private Typeface selectTypeface(Context context, int textStyle) {

        switch (textStyle) {
            case 1: // bold
                return FontCache.getTypeface(FONT_STYLE_EDITTEXT, context);

            case 2: // italic
                return FontCache.getTypeface(FONT_STYLE_EDITTEXT, context);

            case 0: // regular
            default:
                return FontCache.getTypeface(FONT_STYLE_EDITTEXT, context);
        }
    }

    private void init() {
        this.setCustomSelectionActionModeCallback(new ActionModeCallBack());
    }

    private class ActionModeCallBack implements ActionMode.Callback {
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            return false;
        }

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {

        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }
    }

    public void setTextCaps(boolean allCaps){
        super.setAllCaps(allCaps);
    }

}
