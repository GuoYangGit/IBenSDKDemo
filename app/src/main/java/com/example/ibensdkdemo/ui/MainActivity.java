package com.example.ibensdkdemo.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.ibensdkdemo.R;
import com.samton.camerautils.face.FaceManager;
import com.samton.ibensdk_common.IBenSDK;
import com.samton.ibensdk_common.utils.SPUtils;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 进行机器人激活
        IBenSDK.getInstance()
                .activeRobot()
                .subscribe(result -> SPUtils.getInstance().put("initBean", result),
                        throwable -> Toast.makeText(this, "激活失败:" + throwable.getMessage(), Toast.LENGTH_SHORT).show());
        // 进行face激活
        FaceManager.getInstance()
                .initFace(this.getApplication(), R.raw.megviifacepp_0_5_2_model, new FaceManager.FaceCheckLicense() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onFail(String fail) {

                    }
                });
    }

    public void onAction(View view) {
        startActivity(new Intent(this, ActionActivity.class));
    }

    public void onIDCard(View view) {
        startActivity(new Intent(this, IDCardActivity.class));
    }

    public void onLight(View view) {
        startActivity(new Intent(this, LightActivity.class));
    }

    public void onPrint(View view) {
        startActivity(new Intent(this, PrintActivity.class));
    }

    public void onVoice(View view) {
        startActivity(new Intent(this, VoiceActivity.class));
    }

    public void onFace(View view) {
        startActivity(new Intent(this, FaceActivity.class));
    }

    public void onTemp(View view) {
        startActivity(new Intent(this, TempActivity.class));
    }

    public void onDisinfect(View view) {
        startActivity(new Intent(this, DisinfectActivity.class));
    }

    public void onMap(View view) {
        startActivity(new Intent(this, MapActivity.class));
    }
}