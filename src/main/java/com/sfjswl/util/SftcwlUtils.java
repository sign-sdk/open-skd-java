package com.sfjswl.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.servlet.http.HttpServletRequest;

public class SftcwlUtils {

    public static String MD5andBase64(String data) throws IOException {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e.toString());
        }
        byte[] md5 = md.digest(data.getBytes(StandardCharsets.UTF_8));
        int i;
        StringBuffer buf = new StringBuffer("");
        for (int offset = 0; offset < md5.length; offset++) {
            i = md5[offset];
            if (i < 0) {
                i += 256;
            }
            if (i < 16) {
                buf.append("0");
            }
            buf.append(Integer.toHexString(i));
        }
        return Base64.getEncoder().encodeToString(buf.toString().getBytes(StandardCharsets.UTF_8));
    }

    public static String getRequestParam(HttpServletRequest request) {
        StringBuffer data = new StringBuffer();
        String line = null;
        BufferedReader reader = null;
        try {
            reader=new BufferedReader(new InputStreamReader(request.getInputStream(), StandardCharsets.UTF_8));
            while (null != (line = reader.readLine())) {
                data.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e.toString());
        }
        return data.toString();
    }
}
