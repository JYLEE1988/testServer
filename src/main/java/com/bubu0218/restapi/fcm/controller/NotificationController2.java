package com.bubu0218.restapi.fcm.controller;

import com.bubu0218.restapi.fcm.service.AndroidPushNotificationsService;
import com.bubu0218.restapi.fcm.service.AndroidPushPeriodicNotifications;
import com.bubu0218.restapi.push.PushItem;
import com.bubu0218.restapi.push.PushItemService;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class NotificationController2 {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AndroidPushNotificationsService androidPushNotificationsService;

    @Autowired
    private PushItemService pushItemService;

    //@Scheduled(fixedRate = 10000) //10초 > 실제 서버 동작 시 1000*60*60*24 ( 24시간 )
    //@GetMapping(value = "/send/{id}")
    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<String> send(@RequestBody PushItem item) throws JSONException, InterruptedException  {
        List<String> list = new ArrayList<String>();

        String token = pushItemService.send(item.getDeviceId()).get(0).getToken();
        System.out.println("token >> " + token);
        list.add(token);

        String notifications = AndroidPushPeriodicNotifications.PeriodicNotificationJson(list);

        HttpEntity<String> request = new HttpEntity<>(notifications);

        CompletableFuture<String> pushNotification = androidPushNotificationsService.send(request);
        CompletableFuture.allOf(pushNotification).join();

        try{
            String firebaseResponse = pushNotification.get();
            return new ResponseEntity<>(firebaseResponse, HttpStatus.OK);
        }
        catch (InterruptedException e){
            logger.debug("got interrupted!");
            throw new InterruptedException();
        }
        catch (ExecutionException e){
            logger.debug("execution error!");
        }

        return new ResponseEntity<>("Push Notification ERROR!", HttpStatus.BAD_REQUEST);
    }
}
