package io.github.snippet0809.wx_official_accounts_sdk.pojo.received;

public class EncryptReceivedMsg {

    private String ToUserName;
    private String Encrypt;

    public String getToUserName() {
        return ToUserName;
    }

    public EncryptReceivedMsg setToUserName(String toUserName) {
        ToUserName = toUserName;
        return this;
    }

    public String getEncrypt() {
        return Encrypt;
    }

    public EncryptReceivedMsg setEncrypt(String encrypt) {
        Encrypt = encrypt;
        return this;
    }
}
