package com.example.ibensdkdemo.ui;

import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;

import com.example.ibensdkdemo.R;
import com.samton.ibensdk_common.IBenSDK;
import com.samton.ibensdk_common.data.TempFaceBean;
import com.samton.ibensdk_common.factory.IBenCheckTempFactory;

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
 * 测温测试类
 */
public class TempActivity extends AppCompatActivity {
    private SurfaceView mCheckFaceColor;
    private SurfaceView mCheckFaceTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);
        mCheckFaceColor = findViewById(R.id.check_face_color);
        mCheckFaceTemp = findViewById(R.id.check_face_temp);
        mCheckFaceColor.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {

            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });
        mCheckFaceTemp.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {

            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });

        //开始登录测温设备
        IBenSDK.getInstance().getCheckTempFactory().loginDevice(mCheckFaceColor, mCheckFaceTemp, new IBenCheckTempFactory.CheckTempCallBack() {
            /**
             * 登录成功回调
             */
            @Override
            public void onSuccess() {

            }

            /**
             * 登录失败回调
             * @param errorMsg 失败信息
             */
            @Override
            public void onFail(String errorMsg) {

            }

            /**
             * 温度报警回调
             */
            @Override
            public void tempAlarm() {

            }

            /**
             * 人脸抓拍回调
             * @param bean 人脸数据实体类
             */
            @Override
            public void tempFace(TempFaceBean bean) {
                runOnUiThread(()-> Toast.makeText(TempActivity.this, bean.toString(), Toast.LENGTH_SHORT).show());
            }
        });
        // 设置报警温度
        IBenSDK.getInstance().getCheckTempFactory().transmitXmlCommand(37.8f);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 退出登录
        IBenSDK.getInstance().getCheckTempFactory().logoutDevice();
    }
}
