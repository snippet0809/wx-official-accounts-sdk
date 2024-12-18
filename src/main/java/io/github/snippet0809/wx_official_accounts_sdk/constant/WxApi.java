package io.github.snippet0809.wx_official_accounts_sdk.constant;

public interface WxApi {

    String GET_ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    String GET_AUTH_ACCESS_TOKEN = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";


    String CREATE_BUTTON = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
    String GET_JSAPI_TICKET = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
    String SEND_TEMPLATE_MSG = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";


    String GET_USER_INFO = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";


    String CODE2SESSION = "https://api.weixin.qq.com/sns/jscode2session";
    String GET_ACCESS_TOKEN_ = "https://api.weixin.qq.com/cgi-bin/token";
    String GET_PHONE_NUMBER = "https://api.weixin.qq.com/wxa/business/getuserphonenumber";
}
