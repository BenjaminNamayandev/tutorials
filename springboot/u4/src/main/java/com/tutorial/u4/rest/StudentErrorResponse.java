package com.tutorial.u4.rest;

/* this is just the POJO for our error response, meaning that this class is what will be converted to the displayed json*/

public class StudentErrorResponse {
  private int status;
  private String message;
  private long timeStamp;

  public StudentErrorResponse() {
    // no arg constructor
  }

  public StudentErrorResponse(int status, String message, long timeStamp) {
    this.status = status;
    this.message = message;
    this.timeStamp = timeStamp;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public long getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(long timeStamp) {
    this.timeStamp = timeStamp;
  }
}
