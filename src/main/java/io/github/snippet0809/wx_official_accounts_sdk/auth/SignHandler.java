package io.github.snippet0809.wx_official_accounts_sdk.auth;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Arrays;

public class SignHandler {

    private final String token;

    public SignHandler(String token) {
        this.token = token;
    }


    /**
     * 验证签名
     */
    public boolean verifySign(String signature, String... strings) {
        strings = Arrays.copyOf(strings, strings.length + 1);
        strings[strings.length - 1] = token;
        Arrays.sort(strings);
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strings) {
            stringBuilder.append(str);
        }
        String sign = DigestUtils.sha1Hex(stringBuilder.toString());
        return sign.equals(signature);
    }

    /**
     * 生成签名
     */
    public String generateSign(String... strings) {
        strings = Arrays.copyOf(strings, strings.length + 1);
        strings[strings.length - 1] = token;
        Arrays.sort(strings);
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : strings) {
            stringBuilder.append(s);
        }
        return DigestUtils.sha1Hex(stringBuilder.toString());
    }
}
