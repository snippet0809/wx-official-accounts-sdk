# wx-official-accounts-sdk

## 一、导入依赖

#### 1、添加Github Packages仓库

```xml

<repositories>
    <repository>
        <id>github</id>
        <url>https://maven.pkg.github.com/snippet0809/wx-official-accounts-sdk</url>
    </repository>
</repositories>
```

注意，若在~/.m2/setting.xml中配置了&lt;mirrorOf>*<mirrorOf&gt;的镜像，会被误伤的

#### 2、导入jar包

```xml

<dependency>
    <groupId>io.github.snippet0809</groupId>
    <artifactId>wx-official-accounts-sdk</artifactId>
    <version>${wx-official-accounts-sdk.version}</version>
</dependency>
```

#### 3、配置Github Token

当前即使从Github Packages下载public包，依然需要token（Github官方说以后可能会更新，
详见https://github.community/t/npm-install-from-github-leads-to-401-gpr-npm-registry-for-public-packages-really-needs-realm-token/2877），
故需要在maven的setting.xml（默认路径为~/.m2/setting.xml或IntelliJ IDEA右键项目 -> maven -> Open 'setting.xml'）中添加github认证配置

```xml

<servers>
    <server>
        <id>github</id>
        <username>USERNAME</username>
        <password>TOKEN</password>
    </server>
</servers>

```

## 二、使用

API列表：

基本功能：
- WxClient.verifySign(String signature, String... strings)              验证签名
- WxClient.createButton(List<Button&gt; buttonList)                     创建自定义按钮
- WxClient.sendTemplateMsg(SendTemplateMsgParam sendTemplateMsgParam)   发送模板消息

消息处理：
- WxClient.parseEncryptXml(String msgSign, String timestamp, String nonce, String encryptXml)   将密文XML解析成Bean并验签
- WxClient.<T extends ReceivedMsg> T encryptToEntity(String encrypt, Class<T> tClass)           将密文字符串解析成ReceivedMsg或其子类
- WxClient.replyEntityToXml(ReplyMsg replyMsg)                                                  将回复的消息转为xml格式 

网页授权：
- WxClient.getJsapiTicket()                                             获取jsapi_ticket
- WxClient.getUserInfo(String code)                                     获取微信用户信息
- WxClient.getJsSdkConfig(String url)                                   为前端传来的URL签名
