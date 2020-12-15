package com.example.ibensdkdemo.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ibensdkdemo.R;
import com.samton.ibensdk_common.IBenSDK;

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
 * 手臂动作与唤醒测试类
 */
public class ActionActivity extends AppCompatActivity {
    private EditText mAngleEt;
    private TextView mWakeTv;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);
        mAngleEt = findViewById(R.id.angle_et);
        mWakeTv = findViewById(R.id.wake_type);
        // 开启监听唤醒功能
        IBenSDK.getInstance().getActionFactory().addWakeCallBack(this, (type, angle) -> {
            // IWakeCallBack.LEFT_ARM 左臂唤醒,IWakeCallBack.RIGHT_ARM 右臂唤醒,IWakeCallBack.VOICE 语音唤醒
            mWakeTv.setText("当前唤醒方式是" + type + ",唤醒角度为" + angle);
        });
    }

    @Override
    protected void onDestroy() {
        // 关闭监听唤醒
        IBenSDK.getInstance().getActionFactory().removeWakeCallBack(this);
        super.onDestroy();
    }

    /**
     * 头部转动
     */
    public void onHead(View view) {
        //获取头部转动角度
        IBenSDK.getInstance().getActionFactory().getHeadAngle();
        //设置头部转动角度(左为负数、右为正数)
        IBenSDK.getInstance().getActionFactory().headAction(getAngle());
    }

    /**
     * 左臂抬起
     */
    public void onLeftArm(View view) {
        //获取左臂当前抬起角度
        IBenSDK.getInstance().getActionFactory().getLeftArmAngle();
        //设置左臂抬起角度
        IBenSDK.getInstance().getActionFactory().leftArm(getAngle());
    }

    /**
     * 右臂抬起
     */
    public void onRightArm(View view) {
        //获取右臂当前抬起角度
        IBenSDK.getInstance().getActionFactory().getRightArmAngle();
        //设置右臂抬起角度
        IBenSDK.getInstance().getActionFactory().rightArm(getAngle());
    }

    /**
     * 获取角度信息
     *
     * @return 角度信息
     */
    private int getAngle() {
        int angle = 0;
        try {
            angle = Integer.parseInt(mAngleEt.getText().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return angle;
    }
}
