package com.bubu0218.restapi.push;

import com.bubu0218.restapi.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/push")
public class PushItemController {

    @Autowired
    private PushItemService pushItemService;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public @ResponseBody PushItemResponse get(@PathVariable(value="id") String id) {
        List<String> errors = new ArrayList<>();
        PushItem pushItem = null;
        try {
            pushItem = pushItemService.get(id);
        } catch (final Exception e) {
            errors.add(e.getMessage());
        }
        return PushItemAdapter.toPushItemResponse(pushItem, errors);
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<PushItemResponse> getAll() {
        List<String> errors = new ArrayList<>();
        List<PushItem> pushItems = pushItemService.getAll();
        List<PushItemResponse> toDoItemResponses = new ArrayList<>();
        pushItems.stream().forEach(pushItem -> {
            toDoItemResponses.add(PushItemAdapter.toPushItemResponse(pushItem, errors));
        });
        return toDoItemResponses;
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody PushItemResponse create(@RequestBody final PushItemRequest pushItemRequest) {
        List<String> errors = new ArrayList<>();
        PushItem pushItem = PushItemAdapter.toPushItem(pushItemRequest);
        System.out.println(pushItemRequest.getToken());
        try {
            pushItem = pushItemService.create(pushItem);
        } catch (final Exception e) {
            errors.add(e.getMessage());
            e.printStackTrace();
        }
        return PushItemAdapter.toPushItemResponse(pushItem, errors);
    }
}