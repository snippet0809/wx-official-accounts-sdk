package io.github.snippet0809.wx_official_accounts_sdk.pojo.received.base_msg;

public class ReceivedLinkMsg extends ReceivedBaseMsg {

    private String Title;
    private String Description;
    private String Url;

    public String getTitle() {
        return Title;
    }

    public ReceivedLinkMsg setTitle(String title) {
        Title = title;
        return this;
    }

    public String getDescription() {
        return Description;
    }

    public ReceivedLinkMsg setDescription(String description) {
        Description = description;
        return this;
    }

    public String getUrl() {
        return Url;
    }

    public ReceivedLinkMsg setUrl(String url) {
        Url = url;
        return this;
    }
}
