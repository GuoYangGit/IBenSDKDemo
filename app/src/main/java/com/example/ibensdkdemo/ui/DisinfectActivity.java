package com.example.ibensdkdemo.ui;

import android.os.Bundle;
import android.view.View;

import com.example.ibensdkdemo.R;
import com.samton.ibensdk_common.IBenSDK;
import com.samton.ibensdk_common.utils.LogUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import androidx.appcompat.app.AppCompatActivity;

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
 * Created by guoyang on 2020/5/11.
 * github https://github.com/GuoYangGit
 * QQ:352391291
 * 消毒测试类
 */
public class DisinfectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disinfect);
        IBenSDK.getInstance().getDisinfectFactory().getSolution(result -> {
            String trim = result.trim();
            String CONTAIN_DIGIT_REGEX = ".*[0-9].*";
            if (!trim.matches(CONTAIN_DIGIT_REGEX)) {
                LogUtils.e("监听溶液返回数据有问题");
                return;
            }
            int i = disposeData(trim);
            i = i > 300 ? 0 : i;
            //0-5为低、
            LogUtils.e("监听溶液值为：" + i);
        });
    }

    private int disposeData(String data) {
        String[] split = data.split("[}]");
        int ing = 0;
        for (String s : split) {
            int anInt = getInt(s);
            if (ing < anInt) ing = anInt;
        }
        return ing;
    }

    private int getInt(String s) {
        String regEx = "[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(s);
        String s1 = m.replaceAll("");
        if (s1 == null || s1.equals("")) {
            return 1;
        }
        return Integer.parseInt(s1);
    }

    /**
     * 开始消毒
     *
     * @param view
     */
    public void startDisinfect(View view) {
        IBenSDK.getInstance().getDisinfectFactory().startDisinfect();
    }

    /**
     * 停止消毒
     *
     * @param view
     */
    public void stopDisinfect(View view) {
        IBenSDK.getInstance().getDisinfectFactory().stopDisinfect();
    }

    /**
     * 开启紫灯
     *
     * @param view
     */
    public void openLamp(View view) {
        IBenSDK.getInstance().getDisinfectFactory().openUltravioletLamp();
    }

    /**
     * 关闭紫灯
     *
     * @param view
     */
    public void closeLamp(View view) {
        IBenSDK.getInstance().getDisinfectFactory().closeUltravioletLamp();
    }

    /**
     * 开启升降杆
     *
     * @param view
     */
    public void upLifter(View view) {
        IBenSDK.getInstance().getDisinfectFactory().upLifter();
    }

    /**
     * 降落升降杆
     *
     * @param view
     */
    public void downLifter(View view) {
        IBenSDK.getInstance().getDisinfectFactory().downLifter();
    }
}