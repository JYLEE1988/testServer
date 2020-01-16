package com.bubu0218.restapi.push;

import com.bubu0218.restapi.ApiResponse;
import lombok.Builder;

import java.util.List;

public class PushItemResponse extends ApiResponse<PushItem> {

    @Builder
    public PushItemResponse(final PushItem push, final List<String> errors) {
        super(push);
        this.setErrors(errors);
    }
}


