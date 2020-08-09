package com.rubix.mongo.exception;

import java.util.Date;

/*Returns the Error details to the  ExceptionHandler whenever there is failure in connection*/


public class ErrorDetails {
 private Date timestamp;
 private String message;
 private String details;

 public ErrorDetails(Date timestamp, String message, String details) {
  super();
  this.timestamp = timestamp;
  this.message = message;
  this.details = details;
 }

 /**
 * @return
 */
public Date getTimestamp() {
  return timestamp;
 }

 /**
 * @return
 */
public String getMessage() {
  return message;
 }

 /**
 * @return
 */
public String getDetails() {
  return details;
 }
}
