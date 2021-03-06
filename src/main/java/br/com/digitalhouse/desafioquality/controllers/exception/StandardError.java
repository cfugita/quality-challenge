package br.com.digitalhouse.desafioquality.controllers.exception;

import java.io.Serializable;
import java.util.Date;

public class StandardError implements Serializable {

    private static final long serialVersionUID = 1L;

    private Date timeStamp;
    private Integer status;
    private String error;
    private String message;

    public StandardError(Date timeStamp, Integer status, String error, String message) {
        this.timeStamp = timeStamp;
        this.status = status;
        this.error = error;
        this.message = message;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}