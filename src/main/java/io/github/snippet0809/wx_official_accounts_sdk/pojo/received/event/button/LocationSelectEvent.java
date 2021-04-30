package io.github.snippet0809.wx_official_accounts_sdk.pojo.received.event.button;

/**
 * location_select：弹出地理位置选择器的事件推送
 */
public class LocationSelectEvent extends ClickEvent {

    private SendLocationInfo sendLocationInfo;

    public SendLocationInfo getSendLocationInfo() {
        return sendLocationInfo;
    }

    public LocationSelectEvent setSendLocationInfo(SendLocationInfo sendLocationInfo) {
        this.sendLocationInfo = sendLocationInfo;
        return this;
    }

    public static class SendLocationInfo {
        private String Location_X;
        private String Location_Y;
        private String Scale;
        private String Label;
        private String Poiname;

        public String getLocation_X() {
            return Location_X;
        }

        public SendLocationInfo setLocation_X(String location_X) {
            Location_X = location_X;
            return this;
        }

        public String getLocation_Y() {
            return Location_Y;
        }

        public SendLocationInfo setLocation_Y(String location_Y) {
            Location_Y = location_Y;
            return this;
        }

        public String getScale() {
            return Scale;
        }

        public SendLocationInfo setScale(String scale) {
            Scale = scale;
            return this;
        }

        public String getLabel() {
            return Label;
        }

        public SendLocationInfo setLabel(String label) {
            Label = label;
            return this;
        }

        public String getPoiname() {
            return Poiname;
        }

        public SendLocationInfo setPoiname(String poiname) {
            Poiname = poiname;
            return this;
        }
    }
}
