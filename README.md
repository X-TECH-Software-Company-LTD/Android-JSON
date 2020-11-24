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
        public void onSuccess(String object) {
            Log.d("xTechLog", object);
        }
        @Override
        public void onFailure(Exception e) {
            Log.d("xTechLog", e.toString());
        }
    });
```
If you do not want to add headers JSON Arry , you can replace it with null .

