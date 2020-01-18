package com.bubu0218.restapi.fcm.service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AndroidPushPeriodicNotifications {
    public static String PeriodicNotificationJson(List<String> tokens) throws JSONException {
        LocalDate localDate = LocalDate.now();

        String sampleData[] = {
                //"fKjPrZPaQ28:APA91bGfxEurP_I36BgZuE3XJ-MwYx7Hb_ceKSgxsaeyGTor0hQ__8UVEuw1wt0kJyF279KcGHn3MF4-C80uRN1PtNl51CeUmhTT_vy4Cuo_7FT6CuT6iLZ5dgE-GQytmph103oRUegR"
                "ejicz2N2gdw:APA91bEvgAV3zsMw0OJWJSlbcaJ-Z49_-2W1QWlzEY_HYzhqWcnazucZE_ywCgRd0PdYOT0fA0cwgjfjUyJZeFVNjL85X6FoPJLuIf-ITI8KU3yIxpA4Bmji223T1ItUYPa_C8kbkGcY"
        };

        JSONObject body = new JSONObject();

        List<String> tokenlist = new ArrayList<String>();

//        for(int i=0; i<sampleData.length; i++){
//            tokenlist.add(sampleData[i]);
//        }
        tokenlist = tokens;

        JSONArray array = new JSONArray();

        for(int i=0; i<tokenlist.size(); i++) {
            array.put(tokenlist.get(i));
        }

        body.put("registration_ids", array);

        JSONObject notification = new JSONObject();
        notification.put("title","hello!");
        notification.put("body","Today is "+localDate.getDayOfWeek().name()+"!");

        body.put("notification", notification);

        System.out.println(body.toString());

        return body.toString();
    }
}