package com.yx.auth.testpackage;

import org.apache.commons.codec.binary.Base64;

import static java.nio.charset.StandardCharsets.UTF_8;

public class TestMain2 {
    public static void main(String[] args) {
        String encode = new String(Base64.encodeBase64("kk".getBytes(UTF_8)), UTF_8);
        String decode = new String(Base64.decodeBase64(encode), UTF_8);
        System.out.println("");
    }
}
