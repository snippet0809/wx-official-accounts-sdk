package io.github.snippet0809.wx_official_accounts_sdk.auth.aes;

import java.util.ArrayList;

class ByteGroup {

    ArrayList<Byte> byteContainer = new ArrayList<>();

    byte[] toBytes() {
        byte[] bytes = new byte[byteContainer.size()];
        for (int i = 0; i < byteContainer.size(); i++) {
            bytes[i] = byteContainer.get(i);
        }
        return bytes;
    }

    void addBytes(byte[] bytes) {
        for (byte b : bytes) {
            byteContainer.add(b);
        }
    }

    int size() {
        return byteContainer.size();
    }
}
