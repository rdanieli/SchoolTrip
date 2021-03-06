package com.eng.framework.authz;

import java.util.Base64;

import org.apache.commons.lang3.StringUtils;

public class BasicAuthCredentials {

  private static final char SEMI_COLON = ':';
  private static final int BASIC_AUTH_PREFIX_LENGTH = "Basic ".length();

  private String username;
  private String password;
  
  private static class NullAuthCredentials extends BasicAuthCredentials {

    private NullAuthCredentials() {
      super(null, null);
    }
    
    @Override
    public boolean isValid() {
      return true;
    }
    
    @Override
    public boolean isNull() {
      return true;
    }
  }
  
  private static final BasicAuthCredentials NULL_CREDENTIALS = new NullAuthCredentials();
  private static final BasicAuthCredentials INVALID_CREDENTIALS = new BasicAuthCredentials(null, null);
  
  public static BasicAuthCredentials createCredentialsFromHeader(final String authorizationHeader) {
    if (authorizationHeader == null) {
      return NULL_CREDENTIALS;
    }

    if (authorizationHeader.length() < BASIC_AUTH_PREFIX_LENGTH) {
      return INVALID_CREDENTIALS;
    }

    String authPart = authorizationHeader.substring(BASIC_AUTH_PREFIX_LENGTH);
    String userpass = new String(Base64.getDecoder().decode(authPart.getBytes()));
    int index = userpass.indexOf(SEMI_COLON);
    if (index < 1) {
      return INVALID_CREDENTIALS;
    }
    String name = userpass.substring(0, index);
    String pass = userpass.substring(index + 1);
    return new BasicAuthCredentials(name, pass);
  }

  /**
   * Create a credential with the given username and password.
   * 
   * @param username
   * @param password
   */
  public BasicAuthCredentials(String username, String password) {
    super();
    this.username = username;
    this.password = password;
  }

  /**
   * @return {@code true} if this is a valid credential
   */
  public boolean isValid() {
    return !StringUtils.isBlank(username) && !StringUtils.isBlank(password);
  }
  
  public boolean isNull() {
    return false;
  }
  
  /**
   * Get the username.
   * @return the username or null if the username was not found
   */
  public String getUsername() {
    return username;
  }

  /**
   * Get the password.
   * @return the password or null if the password was not found
   */
  public String getPassword() {
    return password;
  }

  @Override
  public String toString() {
    return "UserPassCredentials [username=" + username + "]";
  }

  /**
   * Construct and return the Base64 encoded Basic Auth header value for this credential.
   * @return the header value suitable for insertion into an HTTP request
   */
  public String getAuthorizationHeaderValue() {
    String result = null;
    if (!StringUtils.isBlank(username) && !StringUtils.isBlank(password)) {
      String value = username + ":" + password;
      result = "Basic " + new String(Base64.getEncoder().encode(value.getBytes())) ;
    }
    return result;
  }

}