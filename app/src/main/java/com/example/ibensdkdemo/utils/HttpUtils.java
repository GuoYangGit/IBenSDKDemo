package com.example.ibensdkdemo.utils;
/***
 * You may think you know what the following code does.
 * But you dont. Trust me.
 * Fiddle with it, and youll spend many a sleepless
 * night cursing the moment you thought youd be clever
 * enough to "optimize" the code below.
 * Now close this file and go play with something else.
 */

import com.example.ibensdkdemo.bean.RouseBean;
import com.samton.ibensdk_common.AppConfig;
import com.samton.ibensdk_common.net.IBenRxHttp;

import java.io.File;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

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
 * Created by guoyang on 2020/11/23.
 * github https://github.com/GuoYangGit
 * QQ:352391291
 */
public class HttpUtils {
    /**
     * 主动唤醒数据
     */
    private static final String RECOGNITION_FACE = "faceinfo/activeInteractionNew";

    /**
     * 主动唤醒人脸检测接口  ignoreRepeatFace是否忽略重复人脸，0：否，1：是
     */
    public static Observable<RouseBean> recognitionFace(File file) {
        return IBenRxHttp.postForm(RECOGNITION_FACE)
                .add("robotUuid", AppConfig.ROBOT_APPID)
                .add("ignoreRepeatFace", "1")
                .addFile("fimage", file)
                .asClass(RouseBean.class)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
