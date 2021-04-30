package io.github.snippet0809.wx_official_accounts_sdk.auth.aes;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Random;

public class AesEncryptor {

    private final byte[] aesKey;
    private final String appId;

    public AesEncryptor(String encodingAesKey, String appId) {
        if (encodingAesKey.length() != 43) {
            throw new RuntimeException("传入的encodingAesKey不是43位");
        }
        this.appId = appId;
        this.aesKey = Base64.decodeBase64(encodingAesKey + "=");
    }


    /**
     * 对明文进行加密.
     */
    public String encrypt(String text) {
        // 一、randomStr + networkBytesOrder + text + appid
        byte[] randomStrBytes = getRandomStr().getBytes(StandardCharsets.UTF_8);
        byte[] textBytes = text.getBytes(StandardCharsets.UTF_8);
        byte[] networkBytesOrder = getNetworkBytesOrder(textBytes.length);
        byte[] appidBytes = appId.getBytes(StandardCharsets.UTF_8);
        ByteGroup byteCollector = new ByteGroup();
        byteCollector.addBytes(randomStrBytes);
        byteCollector.addBytes(networkBytesOrder);
        byteCollector.addBytes(textBytes);
        byteCollector.addBytes(appidBytes);
        // 二、使用PKCS7对明文进行补位填充，获得最终的字节流
        byte[] padBytes = PKCS7Encoder.encode(byteCollector.size());
        byteCollector.addBytes(padBytes);
        byte[] unencrypted = byteCollector.toBytes();
        // 三、加密
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            SecretKeySpec keySpec = new SecretKeySpec(aesKey, "AES");
            IvParameterSpec iv = new IvParameterSpec(aesKey, 0, 16);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, iv);
            byte[] encrypted = cipher.doFinal(unencrypted);
            return new Base64().encodeToString(encrypted);
        } catch (Exception e) {
            throw new RuntimeException("AES加密失败");
        }
    }

    /**
     * 对密文进行解密.
     */
    public String decrypt(String text) {
        String xmlContent, appidInCypher;
        try {
            // 一、算法/模式/填充方式
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            SecretKeySpec key_spec = new SecretKeySpec(aesKey, "AES");
            // 二、用aesKey的前16位当初始向量
            IvParameterSpec iv = new IvParameterSpec(Arrays.copyOfRange(aesKey, 0, 16));
            cipher.init(Cipher.DECRYPT_MODE, key_spec, iv);
            // 三、先使用BASE64对密文进行解码，然后解密
            byte[] encrypted = Base64.decodeBase64(text);
            byte[] original = cipher.doFinal(encrypted);
            // 四、去除补位字符、分离16位随机字符串,网络字节序和AppId
            byte[] bytes = PKCS7Encoder.decode(original);
            byte[] networkOrder = Arrays.copyOfRange(bytes, 16, 20);
            int xmlLength = recoverNetworkBytesOrder(networkOrder);
            xmlContent = new String(Arrays.copyOfRange(bytes, 20, 20 + xmlLength), StandardCharsets.UTF_8);
            appidInCypher = new String(Arrays.copyOfRange(bytes, 20 + xmlLength, bytes.length), StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException("AES解密失败");
        }
        // appid不相同的情况
        if (!appidInCypher.equals(appId)) {
            throw new RuntimeException("AES解密分离出的appid和当前appid不一致");
        }
        return xmlContent;
    }


    /**
     * 生成4个字节的网络字节序
     */
    private static byte[] getNetworkBytesOrder(int sourceNumber) {
        byte[] orderBytes = new byte[4];
        orderBytes[3] = (byte) (sourceNumber & 0xFF);
        orderBytes[2] = (byte) (sourceNumber >> 8 & 0xFF);
        orderBytes[1] = (byte) (sourceNumber >> 16 & 0xFF);
        orderBytes[0] = (byte) (sourceNumber >> 24 & 0xFF);
        return orderBytes;
    }

    /**
     * 还原4个字节的网络字节序
     */
    private static int recoverNetworkBytesOrder(byte[] orderBytes) {
        int sourceNumber = 0;
        for (int i = 0; i < 4; i++) {
            sourceNumber <<= 8;
            sourceNumber |= orderBytes[i] & 0xff;
        }
        return sourceNumber;
    }

    /**
     * 随机生成16位字符串
     */
    private static String getRandomStr() {
        String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}