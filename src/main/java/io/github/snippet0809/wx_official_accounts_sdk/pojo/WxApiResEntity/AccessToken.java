package io.github.snippet0809.wx_official_accounts_sdk.pojo.WxApiResEntity;

import com.alibaba.fastjson.annotation.JSONField;

public class AccessToken {

    @JSONField(name = "access_token")
    private String accessToken;
    @JSONField(name = "expires_in")
    private Integer expiresIn;

    public String getAccessToken() {
        return accessToken;
    }

    public AccessToken setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public AccessToken setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
        return this;
    }
}
