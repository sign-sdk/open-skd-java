package com.sfjswl.util;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

public class SftcwlSignature {

    public static String sign(String params, Long devId, String secret) throws IOException {
        if(devId == null || secret == null){
            throw new RuntimeException("数据传入格式有误，请参照顺丰同城开放平台文档规范传入");
        }
        StringBuilder sb = new StringBuilder(params);
        sb.append("&" + devId + "&" + secret);
        return SftcwlUtils.MD5andBase64(sb.toString());
    }

    public static CheckResult checkSign(HttpServletRequest request, Long devId , String secret) throws IOException {
        CheckResult result = new CheckResult();
        if(devId == null || secret == null){
            return result;
        }
        String sign = request.getParameter("sign");
        String body = SftcwlUtils.getRequestParam(request);
        boolean valid = checkSignInternal(body, devId, secret, sign);
        result.setSuccess(valid);
        result.setRequestBody(body);
        return result;
    }

    private static Boolean checkSignInternal(String params, Long devId, String secret, String sourceSign) throws IOException {
        StringBuilder sb = new StringBuilder(params);
        sb.append("&" + devId + "&" + secret);
        String productSign = SftcwlUtils.MD5andBase64(sb.toString());
        return sourceSign.equals(productSign);
    }
}
