package io.github.snippet0809.wx_official_accounts_sdk.pojo.received.base_msg;

public class ReceivedTextMsg extends ReceivedBaseMsg {

    private String Content;

    public String getContent() {
        return Content;
    }

    public ReceivedTextMsg setContent(String content) {
        Content = content;
        return this;
    }
}
