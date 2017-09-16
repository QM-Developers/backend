package com.qm.backend.util;


public class TokenUtil
{
    private static final String privateKey = "djfksldkfjalewiorjf";

    public static String getToken()
    {
//        return CryptographyUtil.md5(data, privateKey)+System.currentTimeMillis();
        return IDGeneratorUtil.generator()+System.currentTimeMillis();
    }


    public static boolean validToken(String token, String data)
    {
        String confirm = getToken();
        if (confirm.equals(token))
            return true;
        else
            return false;
    }
}
