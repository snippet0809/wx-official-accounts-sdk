package io.github.snippet0809.wx_official_accounts_sdk.pojo.received.event.button;

/**
 * 扫码推事件的事件推送
 */
public class ScanCodeEvent extends ClickEvent {

    /**
     * 扫描信息
     */
    private ScanCodeInfo ScanCodeInfo;

    public ScanCodeEvent.ScanCodeInfo getScanCodeInfo() {
        return ScanCodeInfo;
    }

    public ScanCodeEvent setScanCodeInfo(ScanCodeEvent.ScanCodeInfo scanCodeInfo) {
        ScanCodeInfo = scanCodeInfo;
        return this;
    }

    public static class ScanCodeInfo {

        /**
         * 扫描类型，一般是qrcode
         */
        private String ScanType;

        /**
         * 扫描结果，即二维码对应的字符串信息
         */
        private String ScanResult;

        public String getScanType() {
            return ScanType;
        }

        public ScanCodeInfo setScanType(String scanType) {
            ScanType = scanType;
            return this;
        }

        public String getScanResult() {
            return ScanResult;
        }

        public ScanCodeInfo setScanResult(String scanResult) {
            ScanResult = scanResult;
            return this;
        }
    }

}
