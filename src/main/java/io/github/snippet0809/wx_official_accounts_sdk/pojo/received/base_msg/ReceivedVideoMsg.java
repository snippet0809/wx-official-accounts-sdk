package io.github.snippet0809.wx_official_accounts_sdk.pojo.received.base_msg;

/**
 * video：视频消息
 * shortvideo：小视频消息
 */
public class ReceivedVideoMsg extends ReceivedBaseMsg {

    private String MediaId;
    private String ThumbMediaId;

    public String getMediaId() {
        return MediaId;
    }

    public ReceivedVideoMsg setMediaId(String mediaId) {
        MediaId = mediaId;
        return this;
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public ReceivedVideoMsg setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
        return this;
    }
}
