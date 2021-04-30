package io.github.snippet0809.wx_official_accounts_sdk.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class Button {

    @JSONField(name = "sub_button")
    private List<Button> subButton;
    private String type;
    private String name;
    private String key;
    private String url;
    @JSONField(name = "media_id")
    private String mediaId;
    private String appid;
    private String pagepath;

    public List<Button> getSubButton() {
        return subButton;
    }

    public Button setSubButton(List<Button> subButton) {
        this.subButton = subButton;
        return this;
    }

    public String getType() {
        return type;
    }

    public Button setType(String type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public Button setName(String name) {
        this.name = name;
        return this;
    }

    public String getKey() {
        return key;
    }

    public Button setKey(String key) {
        this.key = key;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Button setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getMediaId() {
        return mediaId;
    }

    public Button setMediaId(String mediaId) {
        this.mediaId = mediaId;
        return this;
    }

    public String getAppid() {
        return appid;
    }

    public Button setAppid(String appid) {
        this.appid = appid;
        return this;
    }

    public String getPagepath() {
        return pagepath;
    }

    public Button setPagepath(String pagepath) {
        this.pagepath = pagepath;
        return this;
    }
}
