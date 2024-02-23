package com.sunc.util;

public class SecureUtil {
    /**
     * 数据脱敏
     * @return
     */
    public String mask(String message,int start,int end,char maskChar){
        if(message == null || message.isEmpty() || end > message.length() - 1 || start < 0 || start > end){
            return message;
        }
        char[] chars = message.toCharArray();
        for (int i = start; i <= end; i++) {
            chars[i] = maskChar;
        }
        return new String(chars);
    }

    /**
     * 数据加密SHA
     */

}
