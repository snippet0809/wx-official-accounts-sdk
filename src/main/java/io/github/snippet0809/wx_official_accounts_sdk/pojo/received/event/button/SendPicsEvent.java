package io.github.snippet0809.wx_official_accounts_sdk.pojo.received.event.button;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.List;

/**
 * pic_sysphoto：弹出系统拍照发图的事件推送
 * pic_photo_or_album：弹出拍照或者相册发图的事件推送
 * pic_weixin：弹出微信相册发图器的事件推送
 */
public class SendPicsEvent extends ClickEvent {

    /* xml示例
    <xml>
        <ToUserName><![CDATA[gh_e136c6e50636]]></ToUserName>
        <FromUserName><![CDATA[oMgHVjngRipVsoxg6TuX3vz6glDg]]></FromUserName>
        <CreateTime>1408090816</CreateTime>
        <MsgType><![CDATA[event]]></MsgType>
        <Event><![CDATA[pic_weixin]]></Event>
        <EventKey><![CDATA[6]]></EventKey>
        <SendPicsInfo>
            <Count>1</Count>
            <PicList>
                <item>
                    <PicMd5Sum><![CDATA[5a75aaca956d97be686719218f275c6b]]></PicMd5Sum>
                </item>
            </PicList>
        </SendPicsInfo>
    </xml>
     */

    /**
     * 发送的图片信息
     */
    private SendPicsInfo sendPicsInfo;

    public SendPicsInfo getSendPicsInfo() {
        return sendPicsInfo;
    }

    public SendPicsEvent setSendPicsInfo(SendPicsInfo sendPicsInfo) {
        this.sendPicsInfo = sendPicsInfo;
        return this;
    }


    public static class SendPicsInfo {

        /**
         * 图片数量
         */
        private String Count;

        /**
         * 图片列表
         */
        private List<PicInfo> PicList;

        public String getCount() {
            return Count;
        }

        public SendPicsInfo setCount(String count) {
            Count = count;
            return this;
        }

        public List<PicInfo> getPicList() {
            return PicList;
        }

        public SendPicsInfo setPicList(List<PicInfo> picList) {
            PicList = picList;
            return this;
        }
    }


    @XStreamAlias(value = "item")
    public static class PicInfo {

        /**
         * 图片的MD5值，开发者若需要，可用于验证接收到图片
         */
        private String PicMd5Sum;

        public String getPicMd5Sum() {
            return PicMd5Sum;
        }

        public PicInfo setPicMd5Sum(String picMd5Sum) {
            PicMd5Sum = picMd5Sum;
            return this;
        }
    }
}
