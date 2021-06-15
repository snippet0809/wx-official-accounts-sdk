package io.github.snippet0809.wx_official_accounts_sdk.client;

import com.alibaba.fastjson.JSONObject;
import com.thoughtworks.xstream.XStream;
import io.github.snippet0809.wx_official_accounts_sdk.auth.AccessTokenProducer;
import io.github.snippet0809.wx_official_accounts_sdk.auth.SignHandler;
import io.github.snippet0809.wx_official_accounts_sdk.auth.aes.AesEncryptor;
import io.github.snippet0809.wx_official_accounts_sdk.constant.WxApi;
import io.github.snippet0809.wx_official_accounts_sdk.exception.WxApiException;
import io.github.snippet0809.wx_official_accounts_sdk.pojo.Button;
import io.github.snippet0809.wx_official_accounts_sdk.pojo.SendTemplateMsgParam;
import io.github.snippet0809.wx_official_accounts_sdk.pojo.WxApiResEntity.*;
import io.github.snippet0809.wx_official_accounts_sdk.pojo.received.EncryptReceivedMsg;
import io.github.snippet0809.wx_official_accounts_sdk.pojo.received.ReceivedMsg;
import io.github.snippet0809.wx_official_accounts_sdk.pojo.reply.ReplyMsg;
import org.apache.commons.codec.digest.DigestUtils;
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
import java.util.*;

public class WxClient {

    private final SignHandler signHandler;
    private final AccessTokenProducer accessTokenProducer;
    private AesEncryptor aesEncryptor;


    public WxClient(SignHandler signHandler, AccessTokenProducer accessTokenProducer) {
        this.signHandler = signHandler;
        this.accessTokenProducer = accessTokenProducer;
    }

    public WxClient(SignHandler signHandler, AccessTokenProducer accessTokenProducer, AesEncryptor aesEncryptor) {
        this.signHandler = signHandler;
        this.accessTokenProducer = accessTokenProducer;
        this.aesEncryptor = aesEncryptor;
    }


    /**
     * 签名-验证签名
     */
    public boolean verifySign(String signature, String... strings) {
        return signHandler.verifySign(signature, strings);
    }


    /**
     * 基本功能-创建自定义按钮
     */
    public BaseWxApiResEntity createButton(List<Button> buttonList) throws WxApiException, IOException {
        String url = WxApi.CREATE_BUTTON.replace("ACCESS_TOKEN", accessTokenProducer.getAccessToken().getAccessToken());
        HttpPost httpPost = new HttpPost(url);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("button", buttonList);
        httpPost.setEntity(new StringEntity(jsonObject.toJSONString(), StandardCharsets.UTF_8));
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = httpClient.execute(httpPost);
        HttpEntity httpEntity = response.getEntity();
        String entity = httpEntity != null ? EntityUtils.toString(httpEntity, StandardCharsets.UTF_8) : "";
        return JSONObject.parseObject(entity, BaseWxApiResEntity.class);
    }

    /**
     * 基本功能-获取jsapi_ticket
     */
    public JsapiTicket getJsapiTicket() throws WxApiException, IOException {
        String url = WxApi.GET_JSAPI_TICKET.replace("ACCESS_TOKEN", accessTokenProducer.getAccessToken().getAccessToken());
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = httpClient.execute(httpGet);
        HttpEntity httpEntity = response.getEntity();
        String entity = httpEntity != null ? EntityUtils.toString(httpEntity, StandardCharsets.UTF_8) : "";
        return JSONObject.parseObject(entity, JsapiTicket.class);
    }

    /**
     * 基本功能-发送模板消息
     */
    public SendTemplateMsgResEntity sendTemplateMsg(SendTemplateMsgParam sendTemplateMsgParam) throws WxApiException, IOException {
        String url = WxApi.SEND_TEMPLATE_MSG.replace("ACCESS_TOKEN", accessTokenProducer.getAccessToken().getAccessToken());
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(new StringEntity(JSONObject.toJSONString(sendTemplateMsgParam), StandardCharsets.UTF_8));
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = httpClient.execute(httpPost);
        HttpEntity httpEntity = response.getEntity();
        String entity = httpEntity != null ? EntityUtils.toString(httpEntity, StandardCharsets.UTF_8) : "";
        return JSONObject.parseObject(entity, SendTemplateMsgResEntity.class);
    }


    /**
     * 网页授权-获取用户信息
     */
    public UserInfo getUserInfo(String code) throws WxApiException, IOException {
        AuthAccessToken authAccessToken = accessTokenProducer.getAuthAccessToken(code);
        String url = WxApi.GET_USER_INFO.replace("ACCESS_TOKEN", authAccessToken.getAccess_token()).replace("OPENID", authAccessToken.getOpenid());
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = httpClient.execute(httpGet);
        HttpEntity httpEntity = response.getEntity();
        String entity = httpEntity != null ? EntityUtils.toString(httpEntity, StandardCharsets.UTF_8) : "";
        return JSONObject.parseObject(entity, UserInfo.class);
    }

    /**
     * 网页授权-为URL加签
     */
    public Map<String, String> getJsSdkConfig(String url) throws IOException, WxApiException {
        // 一、字典排序
        String jsapiTicket = getJsapiTicket().getTicket();
        String timestamp = String.valueOf(System.currentTimeMillis() / 1000), noncestr = String.valueOf(new Random().nextLong());
        SortedMap<String, String> map = new TreeMap<>();
        map.put("jsapi_ticket", jsapiTicket);
        map.put("url", url);
        map.put("noncestr", noncestr);
        map.put("timestamp", timestamp);
        // 二、构建字符串后sha1加密
        StringBuilder sb = new StringBuilder();
        for (String key : map.keySet()) {
            String value = String.valueOf(map.get(key));
            sb.append(key).append("=").append(value).append("&");
        }
        String str = sb.substring(0, sb.length() - 1);
        String sign = DigestUtils.sha1Hex(str);
        // 三、封装数据
        map.put("appId", accessTokenProducer.getAppId());
        map.put("signature", sign);
        map.remove("jsapi_ticket");
        map.remove("url");
        return map;
    }


    /**
     * 消息处理-将密文XML转为密文实体消息
     */
    public EncryptReceivedMsg parseEncryptXml(String msgSign, String timestamp, String nonce, String encryptXml) {
        XStream xStream = new XStream();
        xStream.ignoreUnknownElements();
        xStream.autodetectAnnotations(true);
        xStream.allowTypes(new Class[]{EncryptReceivedMsg.class});
        xStream.alias("xml", EncryptReceivedMsg.class);
        EncryptReceivedMsg encryptReceivedMsg = (EncryptReceivedMsg) xStream.fromXML(encryptXml);
        String encrypt = encryptReceivedMsg.getEncrypt();
        boolean signIsRight = verifySign(msgSign, timestamp, nonce, encrypt);
        if (!signIsRight) {
            throw new RuntimeException("签名有误");
        }
        return encryptReceivedMsg;
    }

    /**
     * 消息处理-将密文字符串转为明文实体消息
     */
    public <T extends ReceivedMsg> T encryptToEntity(String encrypt, Class<T> tClass) {
        String xml = aesEncryptor.decrypt(encrypt);
        XStream xStream = new XStream();
        xStream.ignoreUnknownElements();
        xStream.autodetectAnnotations(true);
        xStream.allowTypes(new Class[]{tClass});
        xStream.alias("xml", tClass);
        @SuppressWarnings("unchecked") T t = (T) xStream.fromXML(xml);
        return t;
    }

    /**
     * 消息处理-将回复的消息转为xml格式
     */
    public String replyEntityToXml(ReplyMsg replyMsg) {
        // 情况一：不回应
        if (replyMsg == null) {
            return "success";
        }
        // 情况二：回复明文
        String plainXml = replyMsg.toXml();
        if (aesEncryptor == null) {
            return replyMsg.toXml();
        }
        // 情况三：回复密文
        String encryptText = aesEncryptor.encrypt(plainXml);
        String timestamp = String.valueOf(System.currentTimeMillis()), nonce = String.valueOf(new Random().nextLong());
        String sign = signHandler.generateSign(encryptText, timestamp, nonce);
        String format = "<xml>\n" + "<Encrypt><![CDATA[%1$s]]></Encrypt>\n"
                + "<MsgSignature><![CDATA[%2$s]]></MsgSignature>\n"
                + "<TimeStamp>%3$s</TimeStamp>\n" + "<Nonce><![CDATA[%4$s]]></Nonce>\n" + "</xml>";
        return String.format(format, encryptText, sign, timestamp, nonce);
    }
}
