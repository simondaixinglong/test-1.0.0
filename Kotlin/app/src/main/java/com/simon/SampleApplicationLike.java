package com.simon;

/**
 * Description:     SampleApplicationLike这个类是Application的代理类，
 *                  以前所有在Application的实现必须要全部拷贝到这里，在onCreate方法调用SDK的初始化方法，
 *                  在onBaseContextAttached中调用Beta.installTinker(this);。
 * Author:          simondai
 * Version:         V1.0
 * Date:            2017/12/15 13:29
 */

//public class SampleApplicationLike extends DefaultApplicationLike {
//
//    public SampleApplicationLike(Application application, int tinkerFlags, boolean tinkerLoadVerifyFlag, long applicationStartElapsedTime, long applicationStartMillisTime, Intent tinkerResultIntent) {
//        super(application, tinkerFlags, tinkerLoadVerifyFlag, applicationStartElapsedTime, applicationStartMillisTime, tinkerResultIntent);
//    }
//
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//
//        Bugly.init(getApplication(), "01e58683b9", false);
//
//    }
//
//    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
//    @Override
//    public void onBaseContextAttached(Context base) {
//        super.onBaseContextAttached(base);
//
//        // you must install multiDex whatever tinker is installed!
//        MultiDex.install(base);
//
//        // 安装tinker
//        // TinkerManager.installTinker(this); 替换成下面Bugly提供的方法
//        Beta.installTinker(this);
//    }
//
//
//    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
//    public void registerActivityLifecycleCallback(Application.ActivityLifecycleCallbacks callbacks) {
//        getApplication().registerActivityLifecycleCallbacks(callbacks);
//    }
//}
