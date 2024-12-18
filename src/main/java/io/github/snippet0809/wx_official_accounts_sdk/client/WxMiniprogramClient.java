package io.github.snippet0809.wx_official_accounts_sdk.client;

import com.alibaba.fastjson.JSONObject;
import io.github.snippet0809.wx_official_accounts_sdk.WxHttpClient;
import io.github.snippet0809.wx_official_accounts_sdk.constant.WxApi;
import io.github.snippet0809.wx_official_accounts_sdk.exception.WxApiException;
import io.github.snippet0809.wx_official_accounts_sdk.pojo.WxApiResEntity.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WxMiniprogramClient {

    private final String appId;
    private final String appSecret;

    public WxMiniprogramClient(String appId, String appSecret) {
        this.appId = appId;
        this.appSecret = appSecret;
    }

    public Code2Session code2Session(String code) throws WxApiException, IOException {
        Map<String, String> map = new HashMap<>();
        map.put("appid", appId);
        map.put("secret", appSecret);
        map.put("js_code", code);
        map.put("grant_type", "authorization_code");
        return WxHttpClient.get(WxApi.CODE2SESSION, map, Code2Session.class);
    }

    public AccessToken getAccessToken() throws IOException, WxApiException {
        Map<String, String> map = new HashMap<>();
        map.put("grant_type", "client_credential");
        map.put("appid", appId);
        map.put("secret", appSecret);
        String result = WxHttpClient.get(WxApi.GET_ACCESS_TOKEN_, map);
        AccessToken accessToken = JSONObject.parseObject(result, AccessToken.class);
        if (accessToken.getAccessToken() != null) {
            return accessToken;
        }
        BaseWxApiResEntity baseWxApiResEntity = JSONObject.parseObject(result, BaseWxApiResEntity.class);
        throw new WxApiException(baseWxApiResEntity.getErrcode(), baseWxApiResEntity.getErrmsg());
    }

    public GetPhoneNumberResult getPhoneNumber(String accessToken, String code) throws WxApiException, IOException {
        Map<String, String> queryMap = new HashMap<>();
        queryMap.put("access_token", accessToken);
        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("code", code);
        return WxHttpClient.post(WxApi.GET_PHONE_NUMBER, queryMap, bodyMap, GetPhoneNumberResult.class);
    }
}
