/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        // Create a fake list of earthquake locations.
        ArrayList<Earthquake> earthquakes = QueryUtils.extractEarthquakes();

       // ArrayList<Earthquake> earthquakes = new ArrayList<>();

//        earthquakes.add(new Earthquake(7.2, "San Francisco", "Feb 2, 2016"));
//        earthquakes.add(new Earthquake(5.1, "London", "July 20, 2015"));
//        earthquakes.add(new Earthquake(3.9, "Tokyo", "Nov 14, 2014"));
//        earthquakes.add(new Earthquake(5.4, "Mexico City", "May 3,2013"));
//        earthquakes.add(new Earthquake(2.8, "Moscow", "Jan 31, 2013"));
//        earthquakes.add(new Earthquake(4.9, "Rio de Janeiro", "Aug 19, 2012"));
//        earthquakes.add(new Earthquake(1.6, "Paris", "Oct 30, 2011"));

//        earthquakes.add(new Earthquake("7.2", "Yelizovo, Russia","Jan 30, 2016"));
//        earthquakes.add(new Earthquake("6.1", "Taron, Papua New Guinea", "Jan 26, 2016"));
//        earthquakes.add(new Earthquake("6.3", "Al Hoceima, Morocco", "Jan 25, 2016"));
//        earthquakes.add(new Earthquake("7.1", "Old Iliamna, Alaska", "Jan 24, 2016"));
//        earthquakes.add(new Earthquake("6.6", "Tomatlan, Mexico", "Jan 21, 2016"));
//        earthquakes.add(new Earthquake("6.7", "Shizunai, Japan", "Jan 14, 2016"));
//        earthquakes.add(new Earthquake("6.1", "Charagua, Bolivia", "Jan 14, 2016"));
//        earthquakes.add(new Earthquake("6.2", "Rumoi, Japan", "Jan 11, 2016"));
//        earthquakes.add(new Earthquake("6.5", "Sarangani, Philippines", "Jan 11, 2016"));
//        earthquakes.add(new Earthquake("6.0", "Pacific-Antarctic Ridge", "Jan 05, 2016"));

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
        //ArrayAdapter<Earthquake> adapter = new ArrayAdapter<Earthquake>(
        //        this, android.R.layout.simple_list_item_1, earthquakes);

        final EarthquakeAdapter earthquakeAdapter = new EarthquakeAdapter(this, -1, earthquakes);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(earthquakeAdapter);

        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Earthquake currentEarthquake = earthquakeAdapter.getItem(position);
                String url = currentEarthquake.getUrl();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                EarthquakeActivity.this.startActivity(intent);
            }
        });
    }
}
