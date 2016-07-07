package com.example.android.miwok;

import android.app.Activity;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Lara on 25/06/2016.
 */
public class WordAdapter extends ArrayAdapter<Word> {

    private int colorResourceId;

    /** Handles playback of all the sound files */
    private MediaPlayer audio;

    private MediaPlayer.OnCompletionListener completionListener = new MediaPlayer.OnCompletionListener() {
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    public WordAdapter(Activity context, ArrayList<Word> word, int color){

        super(context, 0, word);
        colorResourceId = color;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Word currentWord = getItem(position);
        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        TextView defaultTranslationTextView = (TextView)
                listItemView.findViewById(R.id.default_translation);
        defaultTranslationTextView.setText(currentWord.getDefaultTranslation());

        TextView miwokTranslationTextView = (TextView)
                listItemView.findViewById(R.id.miwok_translation);
        miwokTranslationTextView.setText(currentWord.getMiwokTranslation());

        ImageView iconView = (ImageView)
                listItemView.findViewById(R.id.image_view);

        if (currentWord.hasImage()){
            iconView.setImageResource(currentWord.getImageResourceId());
            iconView.setVisibility(View.VISIBLE);
        } else {
            iconView.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), colorResourceId);
        textContainer.setBackgroundColor(color);

        listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                releaseMediaPlayer();
                audio = MediaPlayer.create(getContext(), currentWord.getAudioFile());
                audio.start();
                audio.setOnCompletionListener(completionListener);
            }

        });

        return listItemView;
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (audio != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            audio.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            audio = null;
        }
    }


}
