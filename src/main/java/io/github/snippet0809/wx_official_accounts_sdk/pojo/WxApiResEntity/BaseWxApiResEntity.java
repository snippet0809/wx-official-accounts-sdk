package io.github.snippet0809.wx_official_accounts_sdk.pojo.WxApiResEntity;

public class BaseWxApiResEntity {

    public static final int OK = 0;

    private Integer errcode;
    private String errmsg;

    public Integer getErrcode() {
        return errcode;
    }

    public BaseWxApiResEntity setErrcode(Integer errcode) {
        this.errcode = errcode;
        return this;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public BaseWxApiResEntity setErrmsg(String errmsg) {
        this.errmsg = errmsg;
        return this;
    }
}
