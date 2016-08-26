package com.maxwell.androidwarehouse2.utils;

import android.graphics.Typeface;
import android.widget.TextView;

/**
 * Created by lbais on 15/09/2015.
 */
public class FontManger {

    public static void changeFontTo(FontTypeEnum fontTypeEnum, TextView textView){

        if(textView!=null) {
            String ttfName = fontTypeEnum.getFontTypeName();
            Typeface myTypeface = Typeface.createFromAsset(textView.getContext().getAssets(), "fonts/" + ttfName);
            textView.setTypeface(myTypeface);
        }
    }

    public enum FontTypeEnum {

        MUSEO_SANS_300("museosans300.ttf"), MUSEO_SANS_700("museosans700.ttf"), MUSEO_SANS_900("museosans900.ttf");

        private String fontTypeName;

        FontTypeEnum(String viewTypeId){
            this.fontTypeName = viewTypeId;
        }

        public String getFontTypeName() {
            return fontTypeName;
        }

        public static FontTypeEnum getEnum(String value){
            for (FontTypeEnum e : FontTypeEnum.values()){
                if (e.getFontTypeName() == value){
                    return e;
                }
            }

            throw new RuntimeException("El parametro value no corresponde que ningun valor de los enums: " + value);
        }
    }

}
