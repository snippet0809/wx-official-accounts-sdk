package io.github.snippet0809.wx_official_accounts_sdk.pojo.reply;

public class ReplyVideoMsg extends ReplyMsg {

    private Media video;

    public Media getVideo() {
        return video;
    }

    public ReplyVideoMsg setVideo(Media video) {
        this.video = video;
        return this;
    }
}
