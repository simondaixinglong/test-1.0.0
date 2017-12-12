package com.maizi.util;

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2017/10/26 09:36
 */

public class JNIUtil {

    static {
        System.loadLibrary("Hello");
    }


    public static native String getCrt();

    public static native String getEncryptPassword();

}
