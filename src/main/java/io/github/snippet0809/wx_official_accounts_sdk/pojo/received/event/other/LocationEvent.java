package io.github.snippet0809.wx_official_accounts_sdk.pojo.received.event.other;

import io.github.snippet0809.wx_official_accounts_sdk.pojo.received.event.BaseEvent;

public class LocationEvent extends BaseEvent {

    private String Latitude;
    private String Longitude;
    private String Precision;

    public String getLatitude() {
        return Latitude;
    }

    public LocationEvent setLatitude(String latitude) {
        Latitude = latitude;
        return this;
    }

    public String getLongitude() {
        return Longitude;
    }

    public LocationEvent setLongitude(String longitude) {
        Longitude = longitude;
        return this;
    }

    public String getPrecision() {
        return Precision;
    }

    public LocationEvent setPrecision(String precision) {
        Precision = precision;
        return this;
    }
}
