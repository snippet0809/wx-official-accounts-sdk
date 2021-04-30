package io.github.snippet0809.wx_official_accounts_sdk.pojo.WxApiResEntity;

public class SendTemplateMsgResEntity extends BaseWxApiResEntity{

    private String msgid;

    public String getMsgid() {
        return msgid;
    }

    public SendTemplateMsgResEntity setMsgid(String msgid) {
        this.msgid = msgid;
        return this;
    }
}
