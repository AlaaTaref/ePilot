package com.epilot.exception;

public class ResponseError {
	  private String message;
	  
	  public ResponseError(Exception e) {
	    this.message = e.getMessage();
	  }
	  
	  public ResponseError(String msg) {
		    this.message = msg;
		  }
	  
	  public String getMessage() {
	    return this.message;
	  }
}
