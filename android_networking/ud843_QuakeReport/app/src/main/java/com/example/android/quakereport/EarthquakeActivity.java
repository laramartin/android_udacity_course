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
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class EarthquakeActivity extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<List<Earthquake>> {

    public static final String SAMPLE_URL = "http://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&eventtype=earthquake&orderby=time&minmag=6&limit=10";

    ListView earthquakeListView;
    EarthquakeAdapter earthquakeAdapter;
    ArrayList<Earthquake> earthquakes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

//        EarthquakeAsyncTask task = new EarthquakeAsyncTask();
//        task.execute(SAMPLE_URL);

        earthquakeListView = (ListView) findViewById(R.id.list);
//        earthquakeAdapter = new EarthquakeAdapter(this, -1, earthquakes);

//        earthquakeListView.setAdapter(earthquakeAdapter);

        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Earthquake currentEarthquake = earthquakeAdapter.getItem(position);
                String url = currentEarthquake.getUrl();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                EarthquakeActivity.this.startActivity(intent);
            }
        });

        getSupportLoaderManager().initLoader(0, null, this);
    }

    @Override
    public Loader<List<Earthquake>> onCreateLoader(int i, Bundle bundle) {
        return new EarthquakeLoader(EarthquakeActivity.this, SAMPLE_URL);
    }

    @Override
    public void onLoadFinished(Loader<List<Earthquake>> loader, List<Earthquake> data) {
        updateUi(data);
    }

    @Override
    public void onLoaderReset(Loader<List<Earthquake>> loader) {

    }

//    public class EarthquakeAsyncTask extends AsyncTask<String, Void, List<Earthquake>> {
//
//        @Override
//        protected List<Earthquake> doInBackground(String... stringUrl) {
//            URL url = QueryUtils.createUrl(stringUrl[0]);
//            List<Earthquake> earthquakes = new ArrayList<>();
//            try {
//                    String jsonResponse = QueryUtils.makeHttpRequest(url);
//                earthquakes = QueryUtils.extractEarthquakes(jsonResponse);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            return earthquakes;
//        }
//
//        @Override
//        protected void onPostExecute(List<Earthquake> earthquakes) {
//            updateUi(earthquakes);
//        }
//    }

    private void updateUi(List<Earthquake> earthquakes) {
        earthquakeAdapter = new EarthquakeAdapter(this, -1, earthquakes);
        earthquakeListView.setAdapter(earthquakeAdapter);
    }
}
