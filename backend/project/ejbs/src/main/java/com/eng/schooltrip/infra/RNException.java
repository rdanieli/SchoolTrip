package com.eng.schooltrip.infra;

public class RNException extends RuntimeException {
	public RNException() { super(); }
  public RNException(String message) { super(message); }
  public RNException(String message, Throwable cause) { super(message, cause); }
  public RNException(Throwable cause) { super(cause); }

}
