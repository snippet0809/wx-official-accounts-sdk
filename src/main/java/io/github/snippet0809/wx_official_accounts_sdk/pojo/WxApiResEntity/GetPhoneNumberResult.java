package io.github.snippet0809.wx_official_accounts_sdk.pojo.WxApiResEntity;

import com.alibaba.fastjson.annotation.JSONField;

public class GetPhoneNumberResult extends BaseWxApiResEntity {

    @JSONField(name = "phone_info")
    private PhoneInfo phoneInfo;

    public PhoneInfo getPhoneInfo() {
        return phoneInfo;
    }

    public void setPhoneInfo(PhoneInfo phoneInfo) {
        this.phoneInfo = phoneInfo;
    }

    public static class PhoneInfo {
        private String phoneNumber;
        private String purePhoneNumber;
        private String countryCode;
        private Watermark watermark;

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public Watermark getWatermark() {
            return watermark;
        }

        public void setWatermark(Watermark watermark) {
            this.watermark = watermark;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }

        public String getPurePhoneNumber() {
            return purePhoneNumber;
        }

        public void setPurePhoneNumber(String purePhoneNumber) {
            this.purePhoneNumber = purePhoneNumber;
        }
    }


    public static class Watermark {
        private Long timestamp;
        private String appid;

        public Long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Long timestamp) {
            this.timestamp = timestamp;
        }

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }
    }

}
