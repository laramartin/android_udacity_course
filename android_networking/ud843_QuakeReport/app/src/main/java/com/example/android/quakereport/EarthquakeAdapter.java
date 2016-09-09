package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Lara on 04/09/2016.
 */
public class EarthquakeAdapter extends ArrayAdapter<Earthquake>{

    public EarthquakeAdapter(Context context, int resource, List<Earthquake> objects) {
        super(context, resource, objects);
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);

        switch (magnitudeFloor){
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Earthquake currentEarthquake = getItem(position);
        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_list_item, parent, false);
        }

        TextView magnitudeTextView = (TextView)
                listItemView.findViewById(R.id.magnitudeTextView);
        TextView locationOffsetTextView = (TextView)
                listItemView.findViewById(R.id.locationOffsetTextView);
        TextView primaryLocationTextView = (TextView)
                listItemView.findViewById(R.id.primaryLocationTextView);
        TextView dayOfDateTextView = (TextView)
                listItemView.findViewById(R.id.dayOfDateTextView);
        TextView hoursOfDateTextView = (TextView)
                listItemView.findViewById(R.id.hoursOfDateTextView);


        Date dateObject = new Date(currentEarthquake.getDate());
        SimpleDateFormat dayOfDateFormatter = new SimpleDateFormat("MMM DD, yyyy");
        SimpleDateFormat hoursOfDateFormatter = new SimpleDateFormat("h:mm a");
        String formattedDay = dayOfDateFormatter.format(dateObject);
        String formattedHours = hoursOfDateFormatter.format(dateObject);

        DecimalFormat formatter = new DecimalFormat("0.0");
        String magnitude = formatter.format(currentEarthquake.getMagnitude());
        
        dayOfDateTextView.setText(formattedDay);
        hoursOfDateTextView.setText(formattedHours);
        magnitudeTextView.setText(magnitude);

        String originalLocation = currentEarthquake.getLocation();
        String primaryLocation;
        String locationOffset;
        String pattern = " of ";

        if (originalLocation.contains(pattern)) {
            String[] splitLocation = originalLocation.split(" of ");
            locationOffset = splitLocation[0].concat(pattern);
            primaryLocation = splitLocation[1];
        } else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = originalLocation;
        }

        locationOffsetTextView.setText(locationOffset);
        primaryLocationTextView.setText(primaryLocation);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        return listItemView;
    }

}
