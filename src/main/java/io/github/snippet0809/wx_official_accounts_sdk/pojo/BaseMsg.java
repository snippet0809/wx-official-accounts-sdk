package io.github.snippet0809.wx_official_accounts_sdk.pojo;

public class BaseMsg {

    public static final String MSG_TYPE_TEXT = "text";       // 文本消息
    public static final String MSG_TYPE_EVENT = "event";     // 事件消息

    protected String ToUserName;
    protected String FromUserName;
    protected String CreateTime;
    protected String MsgType;

    public String getToUserName() {
        return ToUserName;
    }

    public BaseMsg setToUserName(String toUserName) {
        ToUserName = toUserName;
        return this;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public BaseMsg setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
        return this;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public BaseMsg setCreateTime(String createTime) {
        CreateTime = createTime;
        return this;
    }

    public String getMsgType() {
        return MsgType;
    }

    public BaseMsg setMsgType(String msgType) {
        MsgType = msgType;
        return this;
    }
}
