package io.github.snippet0809.wx_official_accounts_sdk.pojo.reply;

public class ReplyVoiceMsg extends ReplyMsg {

    private Media voice;

    public Media getVoice() {
        return voice;
    }

    public ReplyVoiceMsg setVoice(Media voice) {
        this.voice = voice;
        return this;
    }
}
