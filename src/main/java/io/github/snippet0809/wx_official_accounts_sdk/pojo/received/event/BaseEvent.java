package io.github.snippet0809.wx_official_accounts_sdk.pojo.received.event;


import io.github.snippet0809.wx_official_accounts_sdk.pojo.received.ReceivedMsg;

public class BaseEvent extends ReceivedMsg {

    public static final String SUBSCRIBE = "subscribe";     // 订阅事件

    private String Event;

    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        this.Event = event;
    }
}
