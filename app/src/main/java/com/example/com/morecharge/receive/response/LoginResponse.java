package com.example.com.morecharge.receive.response;

/**
 * Created by 71033 on 2018/11/23.
 */
public class LoginResponse {


    /**
     * access_token : 5f0b5253-efd8-4f39-8a96-ff8ee151178c
     * token_type : bearer
     * refresh_token : 030b4ba3-ef2a-4ff2-9422-418d889e5212
     * expires_in : 40315
     * scope : app
     * license : made by jcloud
     */

    private String access_token;
    private String token_type;
    private String refresh_token;
    private int expires_in;
    private String scope;
    private String license;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }
}
