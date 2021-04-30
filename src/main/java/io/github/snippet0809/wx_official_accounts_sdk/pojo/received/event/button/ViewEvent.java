package io.github.snippet0809.wx_official_accounts_sdk.pojo.received.event.button;

/**
 * VIEW:点击菜单跳转链接时的事件推送
 * view_miniprogram:点击菜单跳转小程序的事件推送
 */
public class ViewEvent extends ClickEvent {

    /**
     * 指菜单ID，如果是个性化菜单，则可以通过这个字段，知道是哪个规则的菜单被点击了
     */
    private String MenuId;

    public String getMenuId() {
        return MenuId;
    }

    public ViewEvent setMenuId(String menuId) {
        MenuId = menuId;
        return this;
    }
}
