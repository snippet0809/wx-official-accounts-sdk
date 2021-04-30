package io.github.snippet0809.wx_official_accounts_sdk.pojo.received.base_msg;

public class ReceivedLocationMsg extends ReceivedBaseMsg {

    private String Location_X;
    private String Location_Y;
    private String Scale;
    private String Label;

    public String getLocation_X() {
        return Location_X;
    }

    public ReceivedLocationMsg setLocation_X(String location_X) {
        Location_X = location_X;
        return this;
    }

    public String getLocation_Y() {
        return Location_Y;
    }

    public ReceivedLocationMsg setLocation_Y(String location_Y) {
        Location_Y = location_Y;
        return this;
    }

    public String getScale() {
        return Scale;
    }

    public ReceivedLocationMsg setScale(String scale) {
        Scale = scale;
        return this;
    }

    public String getLabel() {
        return Label;
    }

    public ReceivedLocationMsg setLabel(String label) {
        Label = label;
        return this;
    }
}
