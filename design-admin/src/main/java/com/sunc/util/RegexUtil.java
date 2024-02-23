package com.sunc.util;

public class RegexUtil {
    //验证email格式
    public static boolean checkEmail(String email){
        String regex = "\\w+@\\w+(\\.\\w+)+";
        return email.matches(regex);
    }

    //验证手机号码格式
    public static boolean checkPhone(String phone){
        //^ 代表起始
        //$ 代表结束
        //String regex = "^(\\+\\d{1,2}\\s?)?1?\\-?\\.?\\(?\\d{3}\\)?[\\-\\.]?\\d{3}[\\-\\.]?\\d{4}$\n";
        //匹配13到19的手机号码
        String regex = "^1[3-9]\\d{9}$";
        return phone.matches(regex);
    }



}
