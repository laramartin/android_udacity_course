package com.example.android.quakereport;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lara on 18/09/2016.
 */
public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    String stringUrl;

    public EarthquakeLoader(Context context, String stringUrl) {
        super(context);
        this.stringUrl = stringUrl;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public List<Earthquake> loadInBackground() {
        URL url = QueryUtils.createUrl(stringUrl);
        List<Earthquake> earthquakes = new ArrayList<>();
        try {
            String jsonResponse = QueryUtils.makeHttpRequest(url);
            earthquakes = QueryUtils.extractEarthquakes(jsonResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return earthquakes;
    }
}
