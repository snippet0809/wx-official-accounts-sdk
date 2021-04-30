package io.github.snippet0809.wx_official_accounts_sdk.pojo;

import java.util.Map;

public class SendTemplateMsgParam {

    private String touser;
    private String template_id;
    private String url;
    private MiniProgram miniprogram;
    private Map<String, Map<String, String>> data;

    public String getTouser() {
        return touser;
    }

    public SendTemplateMsgParam setTouser(String touser) {
        this.touser = touser;
        return this;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public SendTemplateMsgParam setTemplate_id(String template_id) {
        this.template_id = template_id;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public SendTemplateMsgParam setUrl(String url) {
        this.url = url;
        return this;
    }

    public MiniProgram getMiniprogram() {
        return miniprogram;
    }

    public SendTemplateMsgParam setMiniprogram(MiniProgram miniprogram) {
        this.miniprogram = miniprogram;
        return this;
    }

    public Map<String, Map<String, String>> getData() {
        return data;
    }

    public SendTemplateMsgParam setData(Map<String, Map<String, String>> data) {
        this.data = data;
        return this;
    }

    public static class MiniProgram {
        private String appid;
        private String pagepath;

        public String getAppid() {
            return appid;
        }

        public MiniProgram setAppid(String appid) {
            this.appid = appid;
            return this;
        }

        public String getPagepath() {
            return pagepath;
        }

        public MiniProgram setPagepath(String pagepath) {
            this.pagepath = pagepath;
            return this;
        }
    }
}

