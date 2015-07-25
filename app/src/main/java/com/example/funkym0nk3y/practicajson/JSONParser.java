package com.example.funkym0nk3y.practicajson;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by FunkyM0nk3y on 7/25/15.
 */
public class JSONParser {

    InputStream iStream = null;
    JSONArray jarray = null;
    String json = "";

    public JSONParser() { };

    public JSONArray getJSONFromUrl(String url) {
        jarray = null;
        StringBuilder builder = new StringBuilder();
        HttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        try {
            HttpResponse response = client.execute(httpGet);
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if (statusCode == 200) {
                HttpEntity entity = response.getEntity();
                InputStream content = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(content));
                String line;
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }
            } else {
                Log.e("JSON Parser", "Failed to download file, status = " + statusCode);
            }
        } catch (ClientProtocolException e) {
            Log.e("JSON Parser", e.toString());
        } catch (IOException e) {
            Log.e("JSON Parser", e.toString());
        }
        // Parse String to JSON object
        try {
            jarray = new JSONArray( builder.toString());
        } catch (JSONException e) {
            Log.e("JSON Parser", e.toString());
        }
        return jarray;
    }
}
