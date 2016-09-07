package com.example.android.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

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

        magnitudeTextView.setText(currentEarthquake.getMagnitude());
        dayOfDateTextView.setText(formattedDay);
        hoursOfDateTextView.setText(formattedHours);

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

        return listItemView;
    }

}
