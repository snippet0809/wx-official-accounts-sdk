# wx-official-accounts-sdk

## 使用

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
