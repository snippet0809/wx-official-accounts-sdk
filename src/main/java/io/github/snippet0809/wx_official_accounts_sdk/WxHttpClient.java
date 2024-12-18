package io.github.snippet0809.wx_official_accounts_sdk;

import com.alibaba.fastjson.JSONObject;
import io.github.snippet0809.wx_official_accounts_sdk.exception.WxApiException;
import io.github.snippet0809.wx_official_accounts_sdk.pojo.WxApiResEntity.BaseWxApiResEntity;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class WxHttpClient {

    private static final CloseableHttpClient httpClient = HttpClients.createDefault();

    public static <T extends BaseWxApiResEntity> T get(String url, Class<T> tClass) throws IOException, WxApiException {
        return get(url, null, tClass);
    }

    public static <T extends BaseWxApiResEntity> T get(String url, Map<String, String> queryParams, Class<T> tClass) throws IOException, WxApiException {
        String res = get(url, queryParams);
        T t = JSONObject.parseObject(res, tClass);
        if (t.getErrcode() != BaseWxApiResEntity.OK) {
            throw new WxApiException(t.getErrcode(), t.getErrmsg());
        }
        return t;
    }

    public static <T extends BaseWxApiResEntity> T post(String url, Map<String, Object> bodyParams, Class<T> tClass) throws WxApiException, IOException {
        return post(url, null, bodyParams, tClass);
    }

    public static <T extends BaseWxApiResEntity> T post(String url, Map<String, String> queryParams, Map<String, Object> bodyParams, Class<T> tClass) throws WxApiException, IOException {
        String res = post(url, queryParams, bodyParams);
        T t = JSONObject.parseObject(res, tClass);
        if (t.getErrcode() != BaseWxApiResEntity.OK) {
            throw new WxApiException(t.getErrcode(), t.getErrmsg());
        }
        return t;
    }

    public static String get(String url, Map<String, String> queryParams) throws IOException {
        if (queryParams != null && !queryParams.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder("?");
            queryParams.keySet().forEach(key -> stringBuilder.append(key).append("=").append(queryParams.get(key)).append("&"));
            url = url + stringBuilder.substring(0, stringBuilder.length() - 1);
        }
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = httpClient.execute(httpGet);
        HttpEntity httpEntity = response.getEntity();
        return EntityUtils.toString(httpEntity, StandardCharsets.UTF_8);
    }

    public static String post(String url, Map<String, String> queryParams, Map<String, Object> bodyParams) throws IOException {
        if (queryParams != null && !queryParams.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder("?");
            queryParams.keySet().forEach(key -> stringBuilder.append(key).append("=").append(queryParams.get(key)).append("&"));
            url = url + stringBuilder.substring(0, stringBuilder.length() - 1);
        }
        HttpPost httpPost = new HttpPost(url);
        if (bodyParams != null && !bodyParams.isEmpty()) {
            httpPost.setEntity(new StringEntity(JSONObject.toJSONString(bodyParams), StandardCharsets.UTF_8));
        }
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = httpClient.execute(httpPost);
        HttpEntity httpEntity = response.getEntity();
        return EntityUtils.toString(httpEntity, StandardCharsets.UTF_8);
    }
}
