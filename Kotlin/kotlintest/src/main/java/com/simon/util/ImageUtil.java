package com.simon.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2017/12/13 14:39
 */

public class ImageUtil {


    public static Bitmap ratio(String filePath, int pixelH, int piexlW) {

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;//只加载宽高，不加载图片，不耗内存

        //Bitmap.Config.RGB_8888 4个字节
        options.inPreferredConfig = Bitmap.Config.RGB_565;//两个字节

        BitmapFactory.decodeFile(filePath, options);//预加载
        int originalWidth = options.outWidth;
        int originalHeight = options.outHeight;

        options.inSampleSize = getSampleSize(originalWidth, originalHeight, piexlW, pixelH);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(filePath, options);
    }

    private static int getSampleSize(int originalWidth, int originalHeight, int piexlW, int pixelH) {

        int sampleSize = 1;
        if (originalWidth > originalHeight && originalWidth > piexlW) {
            sampleSize = originalWidth / piexlW;
        } else if (originalWidth < originalHeight && originalHeight > pixelH) {
            sampleSize = originalHeight / pixelH;
        }

        if (sampleSize <= 0) {
            sampleSize = 1;
        }
        return sampleSize;
    }

}
