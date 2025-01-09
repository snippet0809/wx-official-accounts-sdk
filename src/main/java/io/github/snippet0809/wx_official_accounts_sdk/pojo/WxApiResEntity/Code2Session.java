package io.github.snippet0809.wx_official_accounts_sdk.pojo.WxApiResEntity;

import com.alibaba.fastjson.annotation.JSONField;

public class Code2Session extends BaseWxApiResEntity {

    @JSONField(name = "session_key")
    private String sessionKey;
    @JSONField(name = "expires_in")
    private Integer expiresIn;
    private String unionid;
    private String openid;

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }
}
