# Android-JSON
to get / post / put / delete json with headers and user agents
``` Using Google Android Volley ```


## Import Library to Gradle

1 - Download "Android JSON.zip" and place inside your "projectName/" folder .

https://cdn.xtsmm.com/android/libraries/Android%20JSON.zip


2 - Add Library at App gradle

```
dependencies {
    implementation project(path: ':Android JSON')
}
```

## Usage
You can set headers , user-agent , etc ..
```
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
```

You can set any header like 
 
``` JsonObject.put("my-header", "my-value"); ```

you can use multiple linses.

If you do not want to add headers , you can replace it with null .

``` new xJson(MainActivity.this).request("get", "https://cdn.xtsmm.com/android/json/test.json", JsonArray, new OnEventListener<String>() { ... ```
