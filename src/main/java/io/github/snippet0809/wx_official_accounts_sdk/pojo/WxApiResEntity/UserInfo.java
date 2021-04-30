package io.github.snippet0809.wx_official_accounts_sdk.pojo.WxApiResEntity;

import java.util.List;

public class UserInfo {

    private String openid;
    private String nickname;
    private Integer sex;
    private String province;
    private String city;
    private String country;
    private String headimgurl;
    private List<String> privilege;
    private String unionid;

    public String getOpenid() {
        return openid;
    }

    public UserInfo setOpenid(String openid) {
        this.openid = openid;
        return this;
    }

    public String getNickname() {
        return nickname;
    }

    public UserInfo setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public Integer getSex() {
        return sex;
    }

    public UserInfo setSex(Integer sex) {
        this.sex = sex;
        return this;
    }

    public String getProvince() {
        return province;
    }

    public UserInfo setProvince(String province) {
        this.province = province;
        return this;
    }

    public String getCity() {
        return city;
    }

    public UserInfo setCity(String city) {
        this.city = city;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public UserInfo setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public UserInfo setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
        return this;
    }

    public List<String> getPrivilege() {
        return privilege;
    }

    public UserInfo setPrivilege(List<String> privilege) {
        this.privilege = privilege;
        return this;
    }

    public String getUnionid() {
        return unionid;
    }

    public UserInfo setUnionid(String unionid) {
        this.unionid = unionid;
        return this;
    }
}
