package com.example.testnvs.json;

import com.example.testnvs.enums.ResponseStatusCode;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class DataResponse<T> {
    String message;
    int code;
    T data;
    Date timestamp = new Date();
    String requestId = UUID.randomUUID().toString();

    public void setCodeAndMessage(ResponseStatusCode responseStatusCode) {
        this.message = responseStatusCode.getDescription();
        this.code = responseStatusCode.getValue();
    }
    public DataResponse(ResponseStatusCode responseStatusCode) {
        this.message = responseStatusCode.getDescription();
        this.code = responseStatusCode.getValue();
    }
    public DataResponse() {
    }
}
