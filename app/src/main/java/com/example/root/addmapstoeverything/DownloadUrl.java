package com.example.root.addmapstoeverything;

import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by root on 2/10/17.
 */

public class DownloadUrl {
    String data = "";

    public String readUrl(String strUrl) throws IOException {

        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(strUrl);

            // Creating an http connection to communicate with url
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setConnectTimeout(10000);
            urlConnection.setReadTimeout(10000);
            urlConnection.setInstanceFollowRedirects(true);


            // Connecting to url
            urlConnection.connect();
            if(urlConnection.getResponseCode()==HttpURLConnection.HTTP_OK) {
                iStream = urlConnection.getInputStream();
                // Reading data from url


                BufferedReader br = new BufferedReader(new InputStreamReader(iStream));

                StringBuffer sb = new StringBuffer();

                String line = "";
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }

                data = sb.toString();

                Log.d("downloadUrl", data);

                br.close();
                iStream.close();
                urlConnection.disconnect();
            }

        } catch (Exception e) {
            Log.d("Exception", e.toString());
        } finally {
            iStream.close();
            urlConnection.disconnect();
        }
        return data;
    }

}