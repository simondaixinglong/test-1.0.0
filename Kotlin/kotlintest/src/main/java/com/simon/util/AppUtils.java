package com.simon.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2017/9/14 14:42
 */

public class AppUtils {

    /**
     * dp to px
     * @param dp
     * @param cxt
     * @return
     */
    public static int dp2px(int dp, Context cxt) {
        float scale = cxt.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);    }


    /**
     * sp to px
     * @param sp
     * @param cxt
     * @return
     */
    public static int sp2px(int sp, Context cxt) {
        float scale = cxt.getResources().getDisplayMetrics().scaledDensity;
        return (int) (sp * scale + 0.5f);    }


    /**
     * 获得屏幕像素
     * @param context
     * @return
     */
    public static DisplayMetrics getScreenMetrics(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        return dm;
    }


    /**
     * 获取应用签名信息
     * @param packageName
     * @return
     */
    public static int getSinature(Context cxt, String packageName){

        PackageManager packageManager = cxt.getPackageManager();
        PackageInfo pi = null;
        int sig = 0;

        try {
            pi = packageManager.getPackageInfo(packageName, PackageManager.GET_SIGNATURES);
            Signature[] signatures = pi.signatures;
            sig = signatures[0].hashCode();
        } catch (PackageManager.NameNotFoundException e) {
            sig = 0;
            e.printStackTrace();
        }

        return sig;
    }

}

















