package com.example.android.miwok;

/**
 * Created by Lara on 25/06/2016.
 */
public class Word {

    String defaultTranslation;
    String miwokTranslation;

    public Word(String defaultTranslation, String miwokTranslation){
        this.defaultTranslation = defaultTranslation;
        this.miwokTranslation = miwokTranslation;
    }

    public String getDefaultTranslation(){
        return defaultTranslation;
    }

    public String getMiwokTranslation(){

        return miwokTranslation;
    }

}
