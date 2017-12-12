//
// Created by simondai on 2017/10/26.
//

#include <jni.h>

JNIEXPORT jstring JNICALL Java_com_maizi_util_JNIUtil_getCrt(JNIEnv *env, jobject instance) {

    // TODO
    const char *returnValue = "-----BEGIN CERTIFICATE-----\n"
            "MIIDcjCCAloCCQDuzTwAh7JJEzANBgkqhkiG9w0BAQsFADB7MQswCQYDVQQGEwJD\n"
            "TjERMA8GA1UECAwIc2hhbmdoYWkxETAPBgNVBAcMCHNoYW5naGFpMQ4wDAYDVQQK\n"
            "DAVtYWl6aTENMAsGA1UECwwEdGVzdDENMAsGA1UEAwwEdGVzdDEYMBYGCSqGSIb3\n"
            "DQEJARYJYUAxNjMuY29tMB4XDTE3MTAyNTEyMTEyOVoXDTE4MTAyNTEyMTEyOVow\n"
            "ezELMAkGA1UEBhMCQ04xETAPBgNVBAgMCHNoYW5naGFpMREwDwYDVQQHDAhzaGFu\n"
            "Z2hhaTEOMAwGA1UECgwFbWFpemkxDTALBgNVBAsMBHRlc3QxDTALBgNVBAMMBHRl\n"
            "c3QxGDAWBgkqhkiG9w0BCQEWCWFAMTYzLmNvbTCCASIwDQYJKoZIhvcNAQEBBQAD\n"
            "ggEPADCCAQoCggEBAMHqd5KmOb0EhjNr5l5GjE4XNwx4H5MkdwSCFpvTcktFSXI5\n"
            "xHcXWdHmv2q8R47HlhPAj90gQ84gwRE5kzt9bnQSwCR560GXN0Jr68iWWD9TKDYd\n"
            "IXEZGiBbz9tR5qV5wOyCDFUnaeHfD+Z1BJSsYzxMZqYCSHnYUtIu/PhRVqV3xKOy\n"
            "vaMTczhAisVQU/52FqE3nGRt9tavEOo7KQIBqhaKCp5UsUL8fKSvVdeO/tPdW2LI\n"
            "KrOhCdalY5svt0IbU3soMsUoFg3hPMzVrtxHEWAiwnPf4oo1wIqgSQUrYhAbJKOt\n"
            "7vIqT9jodumoS+b1Rt2uOMlQUTjmMpbufCmzgTMCAwEAATANBgkqhkiG9w0BAQsF\n"
            "AAOCAQEAQ41HMlMfWjppAIZ5ddggAOLTPrx7Gs/ouIEqIsU7rwisTaR1TwTiKVCJ\n"
            "um7KEADnkdlb1iv+4AGTBrZEBkeNI61uJuUMU/lJWl3HM2sn48xg0RF8guQuuQRo\n"
            "Ijn5JPWjCzl7KZlchmTSqcJZcj8pUg9ld2YYb6y5hDEt+3lzbmoaggj7kVJGFP4T\n"
            "y+c3l50+NrAI2jwuFROn7xnvkh0JvZGedw3gU9yGok5SFGiHlb/4jXbdqOEU20nJ\n"
            "ZUk6MWIm/NFJZTZm7Gwe3YGrpZobUVNGSKuLmmaLZmSpIU7ZRcSqxzfg4dvoeQwp\n"
            "coPPROWvQhmcyYiMDUMKQzLdvRYyXQ==\n"
            "-----END CERTIFICATE-----";
    return (*env)->NewStringUTF(env, returnValue);
}


JNIEXPORT jstring JNICALL
Java_com_maizi_util_JNIUtil_getEncryptPassword(JNIEnv *env, jobject instance) {

    // TODO
    const char *returnValue = "123456";
    return (*env)->NewStringUTF(env, returnValue);
}