package io.github.snippet0809.wx_official_accounts_sdk.auth;

import com.alibaba.fastjson.JSONObject;
import io.github.snippet0809.wx_official_accounts_sdk.constant.WxApi;
import io.github.snippet0809.wx_official_accounts_sdk.exception.WxApiException;
import io.github.snippet0809.wx_official_accounts_sdk.pojo.WxApiResEntity.AccessToken;
import io.github.snippet0809.wx_official_accounts_sdk.pojo.WxApiResEntity.AuthAccessToken;
import io.github.snippet0809.wx_official_accounts_sdk.pojo.WxApiResEntity.BaseWxApiResEntity;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class AccessTokenProducer {

    private final String appId;
    private final String appSecret;

    public AccessTokenProducer(String appId, String appSecret) {
        this.appId = appId;
        this.appSecret = appSecret;
    }

    public String getAppId() {
        return appId;
    }

    /**
     * 获取ACCESS_TOKEN
     */
    public AccessToken getAccessToken() throws IOException, WxApiException {
        String url = WxApi.GET_ACCESS_TOKEN.replace("APPID", appId).replace("APPSECRET", appSecret);
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        CloseableHttpResponse response = closeableHttpClient.execute(httpGet);
        HttpEntity httpEntity = response.getEntity();
        String res = EntityUtils.toString(httpEntity, StandardCharsets.UTF_8);
        AccessToken accessToken = JSONObject.parseObject(res, AccessToken.class);
        if (accessToken.getAccessToken() != null) {
            return accessToken;
        }
        BaseWxApiResEntity baseWxApiResEntity = JSONObject.parseObject(res, BaseWxApiResEntity.class);
        throw new WxApiException(baseWxApiResEntity.getErrcode(), baseWxApiResEntity.getErrmsg());
    }

    public AuthAccessToken getAuthAccessToken(String code) throws IOException, WxApiException {
        String url = WxApi.GET_AUTH_ACCESS_TOKEN.replace("APPID", appId).replace("SECRET", appSecret).replace("CODE", code);
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        CloseableHttpResponse response = closeableHttpClient.execute(httpGet);
        HttpEntity httpEntity = response.getEntity();
        String res = EntityUtils.toString(httpEntity, StandardCharsets.UTF_8);
        AuthAccessToken authAccessToken = JSONObject.parseObject(res, AuthAccessToken.class);
        if (authAccessToken.getAccess_token() != null) {
            return authAccessToken;
        }
        BaseWxApiResEntity baseWxApiResEntity = JSONObject.parseObject(res, BaseWxApiResEntity.class);
        throw new WxApiException(baseWxApiResEntity.getErrcode(), baseWxApiResEntity.getErrmsg());
    }
}