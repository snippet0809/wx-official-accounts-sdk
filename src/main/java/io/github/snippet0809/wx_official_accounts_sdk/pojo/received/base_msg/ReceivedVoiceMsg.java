package io.github.snippet0809.wx_official_accounts_sdk.pojo.received.base_msg;

public class ReceivedVoiceMsg extends ReceivedBaseMsg {

    private String MediaId;
    private String Format;
    private String Recognition;

    public String getMediaId() {
        return MediaId;
    }

    public ReceivedVoiceMsg setMediaId(String mediaId) {
        MediaId = mediaId;
        return this;
    }

    public String getFormat() {
        return Format;
    }

    public ReceivedVoiceMsg setFormat(String format) {
        Format = format;
        return this;
    }

    public String getRecognition() {
        return Recognition;
    }

    public ReceivedVoiceMsg setRecognition(String recognition) {
        Recognition = recognition;
        return this;
    }
}
