package com.example.funkym0nk3y.practicajson;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

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


public class ConsultaJsonActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_json);
    }

    public DetalleFichaTecnica(String detalle, String imgAnverso, String imgReverso) {
        this.detalle = detalle;
        this.imgAnverso = imgAnverso;
        this.imgReverso = imgReverso;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getImgAnverso() {
        return imgAnverso;
    }

    public void setImgAnverso(String imgAnverso) {
        this.imgAnverso = imgAnverso;
    }

    public String getImgReverso() {
        return imgReverso;
    }

    public void setImgReverso(String imgReverso) {
        this.imgReverso = imgReverso;
    }

    @Override
    public String toString() {
        return "DetalleFichaTecnica{" + "detalle=" + detalle + ", imgAnverso=" + imgAnverso + ", imgReverso=" + imgReverso + '}';
    }
}

}
