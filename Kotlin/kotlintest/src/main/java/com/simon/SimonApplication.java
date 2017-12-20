package com.simon;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2017/10/24 16:26
 */

public class SimonApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

//        initFeedBack();
    }

    private void initFeedBack() {

//        MZFeedbackApp.init(this, new MZFeedbackApp.InitializeCallback() {
//
//            @Override
//            public void goToCustomerService() {
//                // 跳转至本地客服
//            }
//
//            @Override
//            public void closeShake() {
//                // 关闭摇一摇
//                MZFeedbackApp.setIsOpenSensor(false);
//            }
//
//            @Override
//            public Integer getBizCode() {
//                // 业务线代码 0: nono, 1: mxd, 2: unifi, 3: dfd, 4: csyy, 5: maiya, 6: bld
//                return 0;
//            }
//
//            @Override
//            public String getJWT() {
//                // 获取JWT
////                if (!BaseApplication.mLoginState) {
//                    return "";
////                }
////                return SPUtils.getString(ConstantValue.KEY_JWT, "", true);
//            }
//
//            @Override
//            public List<Class<? extends Activity>> getNoShakingActivities() {
//                // 禁止启动摇一摇Activity黑名单
//                List <Class<? extends Activity>> list = new ArrayList<>();
////                list.add(GuideActivity.class);
////                list.add(SplashGIFActivity.class);
////                list.add(SplashFromNet.class);
//                return list;
//            }
//        });
//
//// 请求域名 e.g.  https://m.nonobank.com
////        MZFeedbackApp.setServerAddress(NetConstantValue.BASE_HOST);
//// 七牛空间名(不同app bucket可能不同，默认是“app-shake”)
//        MZFeedbackApp.setBucket("app-shake");

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

}
