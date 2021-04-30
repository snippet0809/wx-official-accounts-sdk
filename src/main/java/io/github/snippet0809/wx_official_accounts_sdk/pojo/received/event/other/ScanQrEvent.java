package io.github.snippet0809.wx_official_accounts_sdk.pojo.received.event.other;

import io.github.snippet0809.wx_official_accounts_sdk.pojo.received.event.BaseEvent;

public class ScanQrEvent extends BaseEvent {

    private String EventKey;
    private String Ticket;

    public String getEventKey() {
        return EventKey;
    }

    public ScanQrEvent setEventKey(String eventKey) {
        EventKey = eventKey;
        return this;
    }

    public String getTicket() {
        return Ticket;
    }

    public ScanQrEvent setTicket(String ticket) {
        Ticket = ticket;
        return this;
    }
}
