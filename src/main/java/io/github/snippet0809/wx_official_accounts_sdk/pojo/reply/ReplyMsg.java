package io.github.snippet0809.wx_official_accounts_sdk.pojo.reply;

import com.thoughtworks.xstream.XStream;
import io.github.snippet0809.wx_official_accounts_sdk.pojo.BaseMsg;

public class ReplyMsg extends BaseMsg {

    public String toXml() {
        XStream xStream = new XStream();
        xStream.autodetectAnnotations(true);
        xStream.allowTypes(new Class[]{this.getClass()});
        xStream.alias("xml", this.getClass());
        return xStream.toXML(this);
    }
}
