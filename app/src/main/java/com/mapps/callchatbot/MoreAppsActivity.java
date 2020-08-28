package com.mapps.callchatbot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.mapps.callchatbot.adapters.AppsListAdapter;
import com.mapps.callchatbot.model.Application;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MoreAppsActivity extends AppCompatActivity {

    List<Application> appsList = new ArrayList();;
    ListView listView;
    private AppsListAdapter appsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_apps);

        parseJSON();

        listView = findViewById(R.id.more_apps_list);

        appsAdapter = new AppsListAdapter(getBaseContext(),appsList);
        listView.setAdapter(appsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String url = "https://play.google.com/store/apps/details?id=" + appsList.get(position).getAppPackageName();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

    }


    public void parseJSON() {

        JSONArray entries = null;
        String jsonString = null;
        try {
            InputStream is = getAssets().open("json/apps.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            jsonString = new String(buffer, "UTF-8");

            try {
                entries = new JSONArray(jsonString);
                for (int i = 0; i < entries.length(); i++) {
                    JSONObject app = entries.getJSONObject(i);
                    String appName = app.getString("app_name");
                    String appPackageName = app.getString("app_package_name");
                    String appIconName = app.getString("app_icon");
                    Application appObject = new Application(appName,appPackageName,appIconName);
                    appsList.add(appObject);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException fileNotFoundException) {
            Log.i("JSON", "File not found");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
