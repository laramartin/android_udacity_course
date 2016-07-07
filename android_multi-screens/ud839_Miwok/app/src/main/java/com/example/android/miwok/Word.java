package com.example.android.miwok;


import android.util.Log;

/**
 * Created by Lara on 25/06/2016.
 */
public class Word {

    private String defaultTranslation;
    private String miwokTranslation;
    private int imageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int audioFile;

    public Word(String defaultTranslation, String miwokTranslation, int audioFile){
        this.defaultTranslation = defaultTranslation;
        this.miwokTranslation = miwokTranslation;
        this.audioFile = audioFile;
    }

    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId, int audioFile){
        this.defaultTranslation = defaultTranslation;
        this.miwokTranslation = miwokTranslation;
        this.imageResourceId = imageResourceId;
        this.audioFile = audioFile;
    }

    public String getDefaultTranslation(){

        return defaultTranslation;
    }

    public String getMiwokTranslation(){

        return miwokTranslation;
    }

    public int getImageResourceId(){
        Log.v("getImageResourceId", "imageResourceId: "+ imageResourceId);
        return imageResourceId;
    }

    public boolean hasImage(){
        Log.v("hasImage", "word has image: "+ (imageResourceId != NO_IMAGE_PROVIDED));
        return imageResourceId != NO_IMAGE_PROVIDED;
    }

    public int getAudioFile() {
        return audioFile;
    }
}
