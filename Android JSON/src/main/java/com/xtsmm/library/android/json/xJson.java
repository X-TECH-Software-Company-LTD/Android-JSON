package com.xtsmm.library.android.json;

import android.app.Activity;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class xJson {
    private Activity activity;
    public xJson(Activity activity) {
        this.activity = activity;
    }
    public void request(String method, String url, JSONArray headers, OnEventListener callback){
        Map<String, String>  params = new HashMap<String, String>();
        if(headers==null){ params = null ;}else {
            Map<String, String> finalParams1 = params;
            xEach(headers, new OnEachArray() {
                @Override
                public void getObject(JSONObject object) {
                    Iterator<String> iter = object.keys();
                    while (iter.hasNext()) {
                        String key = iter.next();
                        try {
                            finalParams1.put(key, object.getString(key));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override
                public void getArray(JSONArray arr) {

                }
            });
        }
        Map<String, String> finalParams = params;
        int requestMethod=Request.Method.GET;
        if(method.toUpperCase()=="GET" || method=="get"){
            requestMethod=Request.Method.GET;
        }
        else if(method.toUpperCase()=="DELETE" || method=="delete"){
            requestMethod=Request.Method.DELETE;
        }
        else if(method.toUpperCase()=="HEAD" || method=="head"){
            requestMethod=Request.Method.HEAD;
        }
        else if(method.toUpperCase()=="OPTIONS" || method=="options"){
            requestMethod=Request.Method.OPTIONS;
        }
        else if(method.toUpperCase()=="PATCH" || method=="patch"){
            requestMethod=Request.Method.PATCH;
        }
        else if(method.toUpperCase()=="POST" || method=="post"){
            requestMethod=Request.Method.POST;
        }
        else if(method.toUpperCase()=="PUT" || method=="put"){
            requestMethod=Request.Method.PUT;
        }
        else if(method.toUpperCase()=="TRACE" || method=="trace"){
            requestMethod=Request.Method.TRACE;
        }

        StringRequest jsonObjectRequest = new StringRequest
                (requestMethod, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        callback.onSuccess(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        callback.onFailure(error);
                    }
                })
                {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    return finalParams;
                }};

        RequestQueue requestQueue = Volley.newRequestQueue(activity);
        requestQueue.add(jsonObjectRequest);

    }

    public void xEach(JSONArray arr,OnEachArray callback) {
        for (int i=0; i<arr.length(); i++) {

            try {
                callback.getObject(arr.getJSONObject(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }

            try {
                callback.getArray(arr.getJSONArray(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

}
