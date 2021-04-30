package io.github.snippet0809.wx_official_accounts_sdk.pojo.received.base_msg;


import io.github.snippet0809.wx_official_accounts_sdk.pojo.received.ReceivedMsg;

public class ReceivedBaseMsg extends ReceivedMsg {

    private String MsgId;

    public String getMsgId() {
        return MsgId;
    }

    public ReceivedBaseMsg setMsgId(String msgId) {
        MsgId = msgId;
        return this;
    }
}
