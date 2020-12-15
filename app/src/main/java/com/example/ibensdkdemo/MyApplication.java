package com.example.ibensdkdemo;
/***
 * You may think you know what the following code does.
 * But you dont. Trust me.
 * Fiddle with it, and youll spend many a sleepless
 * night cursing the moment you thought youd be clever
 * enough to "optimize" the code below.
 * Now close this file and go play with something else.
 */

import android.app.Application;

import com.samton.ibensdk_common.IBenSDK;

/***
 *
 *   █████▒█    ██  ▄████▄   ██ ▄█▀       ██████╗ ██╗   ██╗ ██████╗
 * ▓██   ▒ ██  ▓██▒▒██▀ ▀█   ██▄█▒        ██╔══██╗██║   ██║██╔════╝
 * ▒████ ░▓██  ▒██░▒▓█    ▄ ▓███▄░        ██████╔╝██║   ██║██║  ███╗
 * ░▓█▒  ░▓▓█  ░██░▒▓▓▄ ▄██▒▓██ █▄        ██╔══██╗██║   ██║██║   ██║
 * ░▒█░   ▒▒█████▓ ▒ ▓███▀ ░▒██▒ █▄       ██████╔╝╚██████╔╝╚██████╔╝
 *  ▒ ░   ░▒▓▒ ▒ ▒ ░ ░▒ ▒  ░▒ ▒▒ ▓▒       ╚═════╝  ╚═════╝  ╚═════╝
 *  ░     ░░▒░ ░ ░   ░  ▒   ░ ░▒ ▒░
 *  ░ ░    ░░░ ░ ░ ░        ░ ░░ ░
 *           ░     ░ ░      ░  ░
 *
 * Created by guoyang on 2020/5/19.
 * github https://github.com/GuoYangGit
 * QQ:352391291
 */
public class MyApplication extends Application {
    //是否是debug模式
    private static final boolean DEBUG = false;
    //机器人ID
    private static final String APP_KEY = "这里是机器人id，具体请联系相关人员";
    //BaseUrl
    private static final String BASE_URL = DEBUG ? "http://47.99.175.26:7080/XiaoBenManager/" : "http://kf.ibenrobot.com/";
    //QAUrl
    private static final String QA_URL = DEBUG ? "http://47.99.175.26:7080/" : "http://kf.ibenrobot.com/";

    @Override
    public void onCreate() {
        super.onCreate();
        // 进行sdk初始化工作
        IBenSDK.init(DEBUG,this)
                .setAppKey(APP_KEY) // 设置AppKey
                .setType("rk3399l")
                .setBaseUrl(BASE_URL) // 设置BaseUrl
                .setQAUrl(QA_URL); // 设置QA问答地址
    }
}
