package com.example.android.miwok;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Lara on 25/06/2016.
 */
public class WordAdapter extends ArrayAdapter<Word> {

    private int colorResourceId;


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

        return listItemView;
    }
}
