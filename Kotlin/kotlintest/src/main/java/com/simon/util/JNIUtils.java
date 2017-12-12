package com.simon.util;

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2017/10/26 09:30
 */

public class JNIUtils {

    static {
        System.loadLibrary("Hello");
    }


    public native String getCrtEncode();

    public native String getEncryPassWord();

}
