package com.iqmsoft.model;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class RequestModel {

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", shape = JsonFormat.Shape.STRING)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime timestamp;

    private HttpStatus httpStatus;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int httpStatusCode;

    private String method;

    private String message;

    public RequestModel() {
        timestamp = LocalDateTime.now();
        httpStatus = HttpStatus.OK;
        httpStatusCode = httpStatus.value();
        method = null;
        message = null;
    }

    public RequestModel(HttpStatus httpStatus, String method, String message) {
        this();

        this.httpStatus = httpStatus;
        this.httpStatusCode = httpStatus.value();
        this.method = method;
        this.message = message;
    }

    
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

   
    public int getHttpStatusCode() {
        return httpStatusCode;
    }

   
    public String getMethod() {
        return method;
    }

    public String getMessage() {
        return message;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        this.httpStatusCode = httpStatus.value();
    }

   
    public void setMethod(String method) {
        this.method = method;
    }

  
    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return "[ Request Model timestamp=" + timestamp + ", httpStatus=" + httpStatus + ", httpStatusCode="
                + httpStatusCode + ", method=" + method + ", message=" + message + "]";
    }

}
