package io.github.snippet0809.wx_official_accounts_sdk.pojo.received.base_msg;


public class ReceivedImageMsg extends ReceivedBaseMsg {

    private String PicUrl;
    private String MediaId;

    public String getPicUrl() {
        return PicUrl;
    }

    public ReceivedImageMsg setPicUrl(String picUrl) {
        PicUrl = picUrl;
        return this;
    }

    public String getMediaId() {
        return MediaId;
    }

    public ReceivedImageMsg setMediaId(String mediaId) {
        MediaId = mediaId;
        return this;
    }
}
