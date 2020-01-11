package com.bubu0218.restapi;


import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@RequiredArgsConstructor
public abstract class ApiResponse<T> {
    @NonNull public T data;
    protected List<String> errors;
}
