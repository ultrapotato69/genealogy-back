package com.example.genealogyback.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

@RestController
public class ParentsControllerImpl implements ParentsApi {


    private final NativeWebRequest nativeWebRequest;

    public ParentsControllerImpl(NativeWebRequest nativeWebRequest) {
        this.nativeWebRequest = nativeWebRequest;
    }


    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(nativeWebRequest);
    }
}
