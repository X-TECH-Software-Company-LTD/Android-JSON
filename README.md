# Android-JSON
to get / post / put / delete / options / trace / head / patch / json with headers and user agents
``` Using Google Android Volley ```


## Import Library to Gradle

1 - Download "Android JSON.zip" , extract and place inside your "projectName/" folder .

https://cdn.xtsmm.com/android/libraries/Android%20JSON.zip


2 - Import Module

```
File -> New -> Import Module -> select Downloaded "Android JSON" Folder
```

3 - Add to App Gradle (path : Folder Name)

```
implementation(project(path: ':Android JSON'))
```

## Usage
You can set headers , user-agent , etc ..
```
                JSONArray headerJArray = new JSONArray();
                JSONObject headerJObject = new JSONObject();
                try {
                    headerJObject.put("User-Agent", "xTechSoftware");
                    headerJObject.put("header", "xTechSoftware");

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                headerJArray.put(headerJObject);

                JSONArray bodyJArray = new JSONArray();
                JSONObject bodyJObject = new JSONObject();
                try {
                    bodyJObject.put("username", "xTechUser");
                    bodyJObject.put("password", "123ok");

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                bodyJArray.put(bodyJObject);
                new xJson(MainActivity.this).request("post", "https://cdn.xtsmm.com/android/json/test.json", headerJArray,bodyJArray, new OnEventListener<String>() {
                    @Override
                    public void onSuccess(String json) {
                        Log.d("xTechLog", json);
                    }
                    @Override
                    public void onFailure(Exception e) {
                        Log.d("xTechLog", e.toString());
                    }
                });
```

You can put any post body  
 
``` bodyJObject.put("username", "xTechUser"); ```

You can put any header  
 
``` headerJObject.put("User-Agent", "xTechSoftware"); ```


you can use multiple linses.

If you do not want to add headers , you can replace it with null .

``` 
new xJson(MainActivity.this).request("get", "https://cdn.xtsmm.com/android/json/test.json", null, null,new OnEventListener<String>() {
    ... 
```
