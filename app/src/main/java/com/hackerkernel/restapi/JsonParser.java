package com.hackerkernel.restapi;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonParser {
    public static List<String> Parse(String json){

        try {
            JSONArray jsonArray = new JSONArray(json);
            List<String> contactList = new ArrayList<>();

            for (int i = 0;i<jsonArray.length();i++){

                JSONObject jb = jsonArray.getJSONObject(i);

                contactList.add(jb.getString("name"));
            }

            return contactList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }
}
