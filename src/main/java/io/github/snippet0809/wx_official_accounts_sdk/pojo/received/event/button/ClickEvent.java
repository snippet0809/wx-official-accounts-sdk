package io.github.snippet0809.wx_official_accounts_sdk.pojo.received.event.button;

import io.github.snippet0809.wx_official_accounts_sdk.pojo.received.event.BaseEvent;

public class ClickEvent extends BaseEvent {

    private String EventKey;

    public String getEventKey() {
        return EventKey;
    }

    public ClickEvent setEventKey(String eventKey) {
        EventKey = eventKey;
        return this;
    }
}
