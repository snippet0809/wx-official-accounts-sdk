package io.github.snippet0809.wx_official_accounts_sdk.pojo.reply;

public class ReplyImageMsg extends ReplyMsg {

    /*
    <xml>
        <ToUserName><![CDATA[toUser]]></ToUserName>
        <FromUserName><![CDATA[fromUser]]></FromUserName>
        <CreateTime>12345678</CreateTime>
        <MsgType><![CDATA[image]]></MsgType>
        <Image>
            <MediaId><![CDATA[media_id]]></MediaId>
        </Image>
    </xml>
     */

    private Media image;

    public Media getImage() {
        return image;
    }

    public ReplyImageMsg setImage(Media image) {
        this.image = image;
        return this;
    }
}
