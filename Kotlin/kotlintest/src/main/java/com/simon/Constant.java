package com.simon;

import android.os.Environment;

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2017/12/26 15:50
 */

public class Constant {

    public static final String BASE_FILE_PATH = Environment.getExternalStorageDirectory().getAbsolutePath();//SD卡根目录
    public static final String DATE_BASE_FILE = BASE_FILE_PATH + "/simon";//APP下载保存文件的根目录
    public static final String BASE_FILE = DATE_BASE_FILE + "/file";//保存文件的目录


}
