package com.xtsmm.android.androidvolley;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.xtsmm.library.android.json.OnEventListener;
import com.xtsmm.library.android.json.xJson;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JSONArray JsonArray = new JSONArray();
        JSONObject JsonObject = new JSONObject();
        try {
            JsonObject.put("User-Agent", "xTechSoftware");
            JsonObject.put("header", "xTechSoftware");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonArray.put(JsonObject);
        new xJson(MainActivity.this).request("get", "https://cdn.xtsmm.com/android/json/test.json", JsonArray, new OnEventListener<String>() {
            @Override
            public void onSuccess(String json) {
                Log.d("xTechLog", json);
            }
            @Override
            public void onFailure(Exception e) {
                Log.d("xTechLog", e.toString());
            }
        });
    }
}