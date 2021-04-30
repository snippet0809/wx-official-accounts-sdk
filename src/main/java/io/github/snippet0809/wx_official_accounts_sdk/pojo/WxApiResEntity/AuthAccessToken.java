package io.github.snippet0809.wx_official_accounts_sdk.pojo.WxApiResEntity;

public class AuthAccessToken {

    private String access_token;
    private Integer expires_in;
    private String refresh_token;
    private String openid;
    private String scope;

    public String getAccess_token() {
        return access_token;
    }

    public AuthAccessToken setAccess_token(String access_token) {
        this.access_token = access_token;
        return this;
    }

    public Integer getExpires_in() {
        return expires_in;
    }

    public AuthAccessToken setExpires_in(Integer expires_in) {
        this.expires_in = expires_in;
        return this;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public AuthAccessToken setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
        return this;
    }

    public String getOpenid() {
        return openid;
    }

    public AuthAccessToken setOpenid(String openid) {
        this.openid = openid;
        return this;
    }

    public String getScope() {
        return scope;
    }

    public AuthAccessToken setScope(String scope) {
        this.scope = scope;
        return this;
    }
}
