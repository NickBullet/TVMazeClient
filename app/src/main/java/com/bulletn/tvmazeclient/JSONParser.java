package com.bulletn.tvmazeclient;

import android.os.AsyncTask;
import android.support.annotation.NonNull;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

class JSONParser extends AsyncTask<String, Void, List<Show>>{

    @Override
    protected List<Show> doInBackground(String... params) {
        String url = "http://api.tvmaze.com/search/shows?q=" + params[0];
        String strJson = getJSON(url);
        List<Show> lShow = new ArrayList<>();
        try {
            Object obj = new org.json.simple.parser.JSONParser().parse(strJson);
            JSONArray jo = (JSONArray) obj;
            for (Object ob1: jo){
                JSONObject job1 = (JSONObject) ob1;
                double rating = 0;
                if (((JSONObject)((JSONObject) job1.get("show")).get("rating")).get("average")!= null){
                    rating = Double.valueOf((((JSONObject) ((JSONObject) job1.get("show"))
                            .get("rating"))
                            .get("average"))
                            .toString());
                }
                String img = "";
                if (((JSONObject) job1.get("show")).get("image") != null) {
                    if (((JSONObject) ((JSONObject) job1.get("show")).get("image")).get("medium") != null) {
                        img = (String) ((JSONObject) ((JSONObject) job1.get("show"))
                                .get("image"))
                                .get("medium");
                    }
                }
                String name = "";
                if (((JSONObject) job1.get("show")).get("name") != null)
                {
                    name = (String) ((JSONObject) job1.get("show"))
                            .get("name");
                }
                JSONArray genresArr = new JSONArray();
                if (((JSONObject) job1.get("show")).get("genres") != null)
                {
                    genresArr = (JSONArray) ((JSONObject) job1.get("show"))
                            .get("genres");
                }
                StringBuffer genres = new StringBuffer();
                if (genresArr != null){
                    for (Object o : genresArr){
                        genres.append(o.toString());
                    }
                }
                long id = 0;
                if (((JSONObject) job1.get("show")).get("id") != null)
                {
                    id = Long.valueOf((((JSONObject) job1.get("show"))
                            .get("id")).toString());
                }
                lShow.add(new Show(img, name, rating, genres.toString(), id, url, true));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return lShow;
    }

    @Override
    protected void onPostExecute(List<Show> shows) {
        super.onPostExecute(shows);
    }

    @NonNull
    private String getJSON(String urlToRead){
        StringBuffer jsonCode = new StringBuffer();
        try {
            URL url = new URL(urlToRead);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(url.openStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null)
                jsonCode.append(inputLine);
            in.close();
        }
        catch (MalformedURLException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return jsonCode.toString();
    }
}
