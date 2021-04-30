package io.github.snippet0809.wx_official_accounts_sdk.exception;

public class WxApiException extends Exception {

    private Integer errcode;
    private String errmsg;

    public WxApiException(int errcode, String errmsg) {
        super(errmsg);
        this.errcode = errcode;
        this.errmsg = errmsg;
    }

    public Integer getErrcode() {
        return errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public WxApiException setErrcode(Integer errcode) {
        this.errcode = errcode;
        return this;
    }

    public WxApiException setErrmsg(String errmsg) {
        this.errmsg = errmsg;
        return this;
    }
}
