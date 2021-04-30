package io.github.snippet0809.wx_official_accounts_sdk.pojo.WxApiResEntity;

public class JsapiTicket extends BaseWxApiResEntity {

    private String ticket;
    private Integer expires_in;

    public JsapiTicket setTicket(String ticket) {
        this.ticket = ticket;
        return this;
    }

    public JsapiTicket setExpires_in(Integer expires_in) {
        this.expires_in = expires_in;
        return this;
    }

    public String getTicket() {
        return ticket;
    }

    public Integer getExpires_in() {
        return expires_in;
    }
}
