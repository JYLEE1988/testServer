package com.bubu0218.restapi.push;

import java.util.List;

public class PushItemAdapter {
    public static PushItemResponse toPushItemResponse(final PushItem pushItem, final List<String> errors) {
        return PushItemResponse.builder().push(pushItem).errors(errors).build();
    }

    public static PushItem toPushItem(final PushItemRequest pushItemRequest) {
        if(pushItemRequest == null) {
            return null;
        }
        return PushItem.builder()
                .token(pushItemRequest.getToken())
                .build();
    }

}
